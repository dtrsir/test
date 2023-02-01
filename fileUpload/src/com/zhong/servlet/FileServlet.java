package com.zhong.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "file.do")
public class FileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg = null;

        //判断表单是普通表单还是带上传文件的表单
        if (!ServletFileUpload.isMultipartContent(request)) {
            return;
        }

        //创建文件上传的路径，这里为了避免直接从外部访问到上传目录，所有把上传目录放在了web-inf下
        String realPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File realFile = new File(realPath);
        if (!realFile.exists()) {
            realFile.mkdir();
        }

        //缓存，把超过了预期大小的文件放在一个临时的目录里。超过预期时间就删除掉，或者提醒用户转存为永久文件
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tmpFile = new File(tmpPath);
        if (!tmpFile.exists()) {
            tmpFile.mkdir();
        }

        //创建DiskFileItemFactory上传对象，处理文件上传路径和上传大小
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //设置它的缓冲区也就是它本身的临时文件区,以下两句可以不用写，因为它本身有默认值
        diskFileItemFactory.setSizeThreshold(1024 * 1024);//1M
        diskFileItemFactory.setRepository(tmpFile);//临时文件保存区，参数是一个file对象’

        //创建ServletFileUpload
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        //创建文件上传进度监听器
        servletFileUpload.setProgressListener(new ProgressListener() {
            @Override
            //pBytesRead : 已上传文件大小
            //pContentLength : 总文件大小
            public void update(long pBytesRead, long pContentLength, int pItems) {
                System.out.println("总大小："+pContentLength+"已上传："+pBytesRead);
            }
        });

        //处理乱码
        servletFileUpload.setHeaderEncoding("UTF-8");
        //设置单个文件的最大值
        servletFileUpload.setFileSizeMax(1024*1024*10);
        //设置总共能够上传的文件大小
        servletFileUpload.setSizeMax(1024*1024*10);



        //处理上传的文件
        try {
            //解析前端请求，封装成FileItem对象，需要从servletFileUpload中获取携带参数request
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                //判断上传的文件是普通表单还是文件表单
                if (fileItem.isFormField()) {
                    //获得前端控件中的name
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");//处理乱码
                    System.out.println(name + ":" + value);//后台日志输出
                }else {//如果是文件表单
                    String name = fileItem.getName();
                    //处理不合法文件名
                    if (name.trim().equals("")||name==null) {
                        continue;
                    }
                    //获得上传的文件名
                    String fileName = name.substring(name.lastIndexOf("/") + 1);
                    //获得文件的后缀名
                    String fileExtName = name.substring(name.lastIndexOf(".") + 1);

                    //可以使用UUID来生成唯一的识别码来作为文件名
                    //UUID实现了序列化接口，这是由于网络传输中的东西都需要被序列化
                    String uuid = UUID.randomUUID().toString();

                    //文件存放路径
                    String realPath1 = realFile+"/"+uuid;
                    //给每个文件创建一个对应的文件夹
                    File realPathFile = new File(realPath1);
                    if (realPathFile.exists()) {
                        realPathFile.mkdir();
                    }

                    //文件传输部分
                    //获得文件上传的流
                    InputStream inputStream = fileItem.getInputStream();

                    //创建一个文件输出的流
                    FileOutputStream fileOutputStream = new FileOutputStream(realPath1 + "/" + fileName);

                    //创建缓冲区
                    byte[] buffer = new byte[1024*1024];

                    //判断是否读取完毕
                    int len = 0;
                    //判断是否大于0，大于0说明还有数据
                    while ((len=inputStream.read(buffer))>0) {
                        fileOutputStream.write(buffer,0,len);
                    }
                    fileOutputStream.close();
                    inputStream.close();

                    msg = "文件上传成功";
                    fileItem.delete();//清除临时文件




                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg",msg);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

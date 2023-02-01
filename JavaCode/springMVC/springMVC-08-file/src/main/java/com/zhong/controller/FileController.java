package com.zhong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileController {

    /*方式一*/
    //@RequestParam("file")这个注解是将表单提交的数据中的name为“file”的数据封装成一个CommonsMultipartFile对象
    //如果过批量上传则把CommonsMultipartFile类型改为CommonsMultipartFile[]
    @RequestMapping("upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        //获取上传的文件名
        String uploadFileName = file.getOriginalFilename();

        //如果上传的文件名为空，返回首页
        if ("".equals(uploadFileName)) {
            return "redirect:index.jsp";
        }
        System.out.println("上传文件名:"+uploadFileName);

        //上传保存路径设置
        String Path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在，则创建该路径
        File realPath = new File(Path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址:"+realPath);

        InputStream inputStream = file.getInputStream();//文件输入流
        FileOutputStream fileOutputStream = new FileOutputStream(new File(realPath, uploadFileName));//文件输出流

        //读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len=inputStream.read(buffer))!=-1) {
            fileOutputStream.write(buffer, 0, len);
            fileOutputStream.flush();
        }
        fileOutputStream.close();
        inputStream.close();
        return "redirect:/index.jsp";

    }

    /*方式二*/
    @RequestMapping("/upload2")
    public String upload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        //上传保存路径设置
        String Path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在，则创建该路径
        File realPath = new File(Path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址:"+realPath);

        //通过CommonsMultipartFile内部封装好的方法直接写文件
        file.transferTo(new File(realPath+"/"+file.getOriginalFilename()));

        return "redirect:/index.jsp";
    }

    /*文件下载*/
    @RequestMapping(value = "/download")
    public String download(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //要下载的图片地址
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "image-20220904090444409.png";

        //设置响应头
        response.reset();//设置页面不缓存，清空buffer
        response.setCharacterEncoding("UTF-8");//设置编码
        response.setContentType("multipart/form-data");//二进制传输数据

        response.setHeader("Content-Disposition", "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path, fileName);
        //读取文件
        FileInputStream fileInputStream = new FileInputStream(file);
        //写出文件
        ServletOutputStream outputStream = response.getOutputStream();

        //读取写出
        int index = 0;
        byte[] buffer = new byte[1024];
        while ((index=fileInputStream.read(buffer))!=-1) {
            outputStream.write(buffer, 0, index);
            outputStream.flush();
        }
        outputStream.close();
        fileInputStream.close();
        return null;



    }
}

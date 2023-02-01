package com.zhong;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class Maildemo01 {

    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        //配置
        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");//设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol","smtp");//设置邮件发送协议
        prop.setProperty("mail.smtp.auth","true");//需要验证用户名和密码

        //QQ邮箱还需要加上SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable",true);
        prop.put("mail.smtp.ssl.socketFactory",sf);

        //1.创建定义整个应用程序需要的环境信息session对象、

        //QQ邮箱需要，其他邮箱不用
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人的用户名和授权码
                return new PasswordAuthentication("992683167@qq.com","jktlqktssfdobcgd");
            }
        });

        //开启Session的debug模式，查看程序发送Email的运行状态
        session.setDebug(true);

        //2.通过session获得transport对象
        Transport transport = session.getTransport();

        //3.使用邮箱用户名和授权码连接上邮件服务器
        transport.connect("smtp.qq.com","992683167@qq.com","jktlqktssfdobcgd");

        //4.创建邮件
        MimeMessage message = new MimeMessage(session);

        //指明邮件的发件人
        message.setFrom(new InternetAddress("992683167@qq.com"));

        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("992683167@qq.com"));

        //邮件的标题
        message.setSubject("纯文本邮件");

        /*简单邮件
        //邮件正文
        message.setContent("hello,world!","text/html;charset=utf-8");
        */

        /**
         * 复杂邮件
         * */
        //准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        //图片需要经过数据处理
        DataHandler dataHandler = new DataHandler(new FileDataSource("E:\\壁纸\\1.png"));
        image.setDataHandler(dataHandler);//在image中放入数据化的图片
        image.setContentID("1.png");//设置图片id，方便后面使用

        //
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("图片<img src='cid:1.png'>邮件", "text/html;charset=utf-8");

        //描述数据关系
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.setSubType("related");

        //设置到消息中保存修改
        message.setContent(mimeMultipart);
        message.saveChanges();


        //5.发送邮件
        transport.sendMessage(message, message.getAllRecipients());

        //关闭连接
        transport.close();


    }
}

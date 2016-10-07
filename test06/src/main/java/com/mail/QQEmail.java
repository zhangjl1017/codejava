package com.mail;

/**
 * Created by zjladmin on 2016/9/21.
 */
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class QQEmail {
    public static void main(String[] args){

            //发件人邮箱
            String from = "ithlw@qq.com";//自己设置
            //收件人邮箱
            String to = "1767993649@qq.com";//自己设置
            //获取系统属性
            Properties properties = System.getProperties();
            //设置邮件的服务器
            properties.setProperty("mail.transport.protocol","smtp");
            properties.setProperty("mail.smtp.host","smtp.qq.com");
            //设置邮件需要密码
            properties.setProperty("mail.smtp.auth","true");
            properties.setProperty("mail.smtp.port","587");
            properties.setProperty("mail.smtp.debug","true");
            //properties.setProperty("mail.smtp.auth",true);
            //建立邮件会话
            Session session = Session.getDefaultInstance(properties, new Authenticator(){
                public PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("ithlw@qq.com", "buzhidao51983299"); // 发件人的帐号和密码
                }
            });
            try{
                // 创建MimeMessage 对象
                MimeMessage message = new MimeMessage(session);
                // 增加发件人
                message.setFrom(new InternetAddress(from));
                // 增加收件人
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(to));
                //主题
                message.setSubject("这是标题");
                //正文
                message.setText("hello,world");
                //发送
                Transport.send(message);
                System.out.println("已发送");
            }catch (MessagingException mex) {
                mex.printStackTrace();
            }

    }
}

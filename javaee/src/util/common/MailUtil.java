package util.common;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 一点教程网 - http://www.yiidian.com
 */
public class MailUtil {

  //实现邮件发送的方法
  public static void sendMsg(String to, String subject, String content) throws Exception {
    //发件人账户和密码（需自行修改）
    String username = "xxx@sina.cn";
    String pass = "xxx";

    //一、连接邮箱服务器
    Properties props = new Properties();
    props.setProperty("mail.smtp.host", "smtp.sina.cn");  //设置主机地址（需自行修改）   smtp.qq.com    smtp.126.com

    props.setProperty("mail.smtp.auth", "true");//认证
    //2.产生一个用于邮件发送的Session对象
    Session session = Session.getInstance(props);

    //二、创建邮件对象，设置邮件的参数
    //3.产生一个邮件的消息对象
    MimeMessage message = new MimeMessage(session);

    //4.设置消息的发送者
    Address fromAddr = new InternetAddress(username);
    message.setFrom(fromAddr);

    //5.设置消息的接收者
    Address toAddr = new InternetAddress(to);
    //TO 直接发送  CC抄送    BCC密送
    message.setRecipient(MimeMessage.RecipientType.TO, toAddr);

    //6.设置主题
    message.setSubject(subject);
    //7.设置正文
    //设置邮件内容类型
    message.setContent(content,"text/html;charset=utf-8");


    //三、设置账户信息，进行发送
    //8.准备发送，得到火箭
    Transport transport = session.getTransport("smtp");
    //9.设置火箭的发射目标
    transport.connect("smtp.sina.cn", username, pass);
    //10.发送
    transport.sendMessage(message, message.getAllRecipients());

    //11.关闭
    transport.close();
  }
}
package github.com.fcukcpp.Utils.Communication;

import github.com.fcukcpp.Utils.LoadProperties.LoadPropertyUtils;
import github.com.fcukcpp.Utils.Network.NetworkConfig;
import org.apache.commons.mail.HtmlEmail;

import java.util.Date;

public class Mail_Utils {
    /**
     * 发送邮件
     * @param subject
     * @param message
     * @param information
     */
    public  static  void SendEmail(String subject,String message,String information)
    {

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(LoadPropertyUtils.Getemail("mail.host"));
            email.setCharset(LoadPropertyUtils.Getemail("mail.encoding"));
            email.addTo(LoadPropertyUtils.Getemail("mail.to"));
            email.setSSLOnConnect(false);

            email.setSmtpPort(Integer.parseInt(LoadPropertyUtils.Getemail("mail.smtp.port")));
            email.setFrom(LoadPropertyUtils.Getemail("mail.from"),LoadPropertyUtils.Getemail("mail.nickname"));
            email.setAuthentication(LoadPropertyUtils.Getemail("mail.username"),LoadPropertyUtils.Getemail("mail.password"));
            email.setSubject(subject);

            email.setMsg("登录地址:"+ NetworkConfig.Getipaddres(information)+"<br>"+new Date()+"<br>"+message);
            email.send();

        }catch (Exception e){


        }


    }


}

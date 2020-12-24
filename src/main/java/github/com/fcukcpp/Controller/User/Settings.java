package github.com.fcukcpp.Controller.User;/*
作者Crying711
日期:2020/12/23
时间:21:42
*/

import github.com.fcukcpp.Controller.VerificationCode.VerificationCode;
import github.com.fcukcpp.Pojo.Signin;
import github.com.fcukcpp.Pojo.User;
import github.com.fcukcpp.Pojo.WebsideConfig;
import github.com.fcukcpp.Service.Websideation;
import github.com.fcukcpp.Service.impl.Websideationimpl;
import github.com.fcukcpp.Utils.Encryption.MD5Location;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping( value = "/Settings")
public class Settings
{
ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
    Logger logger= Logger.getLogger(Settings.class);
@RequestMapping(value = "/Signin",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
@ResponseBody
public  String Signin(Signin signin, HttpServletRequest request)
{

    String code = signin.getCode();
    String password = MD5Location.getMd5(signin.getPassword());
    Websideationimpl webation = ac.getBean("webation", Websideationimpl.class);
    HttpSession session = request.getSession();
    if (session.getAttribute("code").equals(code))
    {
        User login = webation.Login(signin.getUsername());

        if (login!=null)
        {

            String username = login.getUsername();
            String password1 = login.getPassword();
            if (username.equals(signin.getUsername()))
            {

                if (password.equals(password1))
                {
                    session.setAttribute("user",username);
                    session.setAttribute("pass",password1);
                    logger.info("Login successful: "+username +"IPaddr: "+request.getRemoteAddr());
                        return "1";
                }else
                    {
                        return  "0";
                    }
            }
        }else
            {
                return  "0";
            }
    }else
        {

            return  "2";
        }


    return  "0";

}

    @RequestMapping(value = "/Modify",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
public   String ChangePassword(HttpServletRequest request, @RequestParam(value = "password") String password,@RequestParam(value = "oldpassword")String oldpasswprd) throws IOException {
    Websideationimpl webation = ac.getBean("webation", Websideationimpl.class);

    HttpSession session = request.getSession();
    String pass = (String)session.getAttribute("pass");
    String user = (String)session.getAttribute("user");
    if (MD5Location.getMd5(oldpasswprd).equals(pass))
    {
        webation.ChangePassword(password,user);
        return "1";
    }else
        {
            return "0";
        }

}



@RequestMapping(value = "/ClearCookie",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
@ResponseBody
public   String clearconfig(HttpServletRequest request, HttpServletResponse response) throws IOException
{
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie: cookies)
    { cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
    request.getSession().setAttribute("user","");
    return "1";
}

@RequestMapping(value = "/Config",method =RequestMethod.POST,produces = "application/json; charset=utf-8")
@ResponseBody
public WebsideConfig Config(WebsideConfig websideConfig,HttpServletRequest request)
{

return websideConfig;
}









}

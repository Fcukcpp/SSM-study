package github.com.fcukcpp.Controller.User;/*
作者Crying711
日期:2020/12/22
时间:22:22
*/


import github.com.fcukcpp.Pojo.Datatable;
import github.com.fcukcpp.Pojo.Layuidata;
//import github.com.fcukcpp.Service.impl.UseroperationImpl;
import github.com.fcukcpp.Service.impl.UseroperationImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
//
@Component
@RequestMapping(value = "/User")
public class User
{
    ApplicationContext      ac = new ClassPathXmlApplicationContext("Bean.xml");



@RequestMapping(value = "/FindAll", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
@ResponseBody
public Layuidata  Findall() throws IOException {
    Layuidata laydata = ac.getBean("users", Layuidata.class);
    UseroperationImpl useration= ac.getBean("Useration", UseroperationImpl.class);
    List<Datatable> findall = useration.Findall();
    laydata.setData(findall);
    return laydata;
}



@RequestMapping(value = "/Fuzzy",produces = "application/json; charset=utf-8",method = RequestMethod.POST)
@ResponseBody
public  Layuidata Fuzzy(@RequestParam("Keyword") String Keyword) throws IOException {
    Layuidata laydata = ac.getBean("users", Layuidata.class);
    UseroperationImpl useration= ac.getBean("Useration", UseroperationImpl.class);
    List<Datatable> findall = useration.FuzzyUser(Keyword);
    laydata.setData(findall);

    return  laydata;
}
@RequestMapping(value = "/Save",produces = "application/json; charset=utf-8",method = RequestMethod.POST)
@ResponseBody
public String  Save(github.com.fcukcpp.Pojo.User user) throws IOException {
    UseroperationImpl useration= ac.getBean("Useration", UseroperationImpl.class);
    System.out.println(user.getUsername());
    boolean saveuser = useration.Saveuser(user);
    if (saveuser==true)
    {

    return  "1";
    }else
        {
            return "0";

        }


}



}

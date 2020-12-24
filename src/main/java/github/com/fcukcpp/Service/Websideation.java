package github.com.fcukcpp.Service;/*
作者Crying711
日期:2020/12/23
时间:22:05
*/

import github.com.fcukcpp.Pojo.Article;
import github.com.fcukcpp.Pojo.Signin;
import github.com.fcukcpp.Pojo.User;

import java.io.IOException;

public interface Websideation
{


public User Login(String username);

public  void ChangePassword(String password,String username) throws IOException;

public  void Addarticle(Article article) throws IOException;

}

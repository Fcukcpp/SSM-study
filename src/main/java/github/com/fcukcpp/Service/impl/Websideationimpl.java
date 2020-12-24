package github.com.fcukcpp.Service.impl;/*
作者Crying711
日期:2020/12/23
时间:22:05
*/

import github.com.fcukcpp.Dao.IUserDao;
import github.com.fcukcpp.Pojo.Article;
import github.com.fcukcpp.Pojo.Signin;
import github.com.fcukcpp.Pojo.User;
import github.com.fcukcpp.Service.Websideation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Websideationimpl implements Websideation
{

    private InputStream in = Resources.getResourceAsStream("Mybatis.xml");
    private SqlSession sqlSession =  new SqlSessionFactoryBuilder().build(in).openSession();
    private IUserDao userDao =sqlSession.getMapper(IUserDao.class);

    public Websideationimpl() throws IOException {
    }

    public User Login(String username) {
        User user = new User();
        user.setUsername(username);
        User isuser = userDao.QuerySingin(user);
        sqlSession.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  isuser;


    }

    public void ChangePassword(String password,String username) throws IOException {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        userDao.updatePas(user);
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }



    public  void  Addarticle(Article article) throws IOException
    {
        userDao.Addarticle(article);
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

}

package github.com.fcukcpp.Service.impl;/*
作者Crying711
日期:2020/12/23
时间:15:28
*/

import github.com.fcukcpp.Dao.IUserDao;
import github.com.fcukcpp.Pojo.Datatable;
import github.com.fcukcpp.Pojo.User;
import github.com.fcukcpp.Service.Useroperation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UseroperationImpl implements Useroperation
{

    private InputStream in = Resources.getResourceAsStream("Mybatis.xml");
    private SqlSession sqlSession =  new SqlSessionFactoryBuilder().build(in).openSession();
    private IUserDao userDao =sqlSession.getMapper(IUserDao.class);

    public UseroperationImpl() throws IOException {
    }

    public List<Datatable> Findall() throws IOException
    {
        List<Datatable> list = userDao.FindAll();
        System.out.println(list);
        in.close();
        sqlSession.close();
        return  list;
    }

    public List<Datatable> FuzzyUser(String naem) throws IOException
    {
        List<Datatable> fuzzyquery = userDao.Fuzzyquery("%" + naem+ "%");

        in.close();
        sqlSession.close();
        return  fuzzyquery;

    }

    public boolean Saveuser(User user) throws IOException {
        String username = user.getUsername();
        if (username!=null&&!username.equals(""))
        {
            String Isuser = userDao.IsUser(username);
            if (Isuser != null)
            {
                userDao.SaveUser(user);
                sqlSession.commit();
                in.close();
                sqlSession.close();

                return true;
            }else
                {
                    return  false;
                }
        }

        return  false;


    }
}

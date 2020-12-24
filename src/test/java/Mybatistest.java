import github.com.fcukcpp.Dao.IUserDao;
import github.com.fcukcpp.Utils.Encryption.MD5Location;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Mybatistest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    public Mybatistest() throws IOException {
    }


    @Before
public void   Start() throws IOException {
    in  = Resources.getResourceAsStream("Mybatis.xml");
    sqlSession=    new SqlSessionFactoryBuilder().build(in).openSession();
    userDao= sqlSession.getMapper(IUserDao.class);
}

@Test
public void isuser()

{


    String s = userDao.IsUser("毛泽");
    System.out.println(s);

}
@Test

public  void FindALl(){

    System.out.println(MD5Location.getMd5("cryhnh22."));


}



@After
public  void Stop() throws IOException {
    sqlSession.commit();
    in.close();
    sqlSession.close();

}


}

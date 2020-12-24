package github.com.fcukcpp.Dao;/*
作者Crying711
日期:2020/12/22
时间:19:53
*/

import github.com.fcukcpp.Pojo.Article;
import github.com.fcukcpp.Pojo.Datatable;
import github.com.fcukcpp.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
//@Repository("userDao")
public interface IUserDao
{

    @Select("select id,username,super,status,create_time,update_time,delete_time from blog_admin where username like #{name}")
    public List<Datatable> Fuzzyquery(@Param("name")String username);

    @Select("  select id,username,super,status,create_time,update_time,delete_time from blog_admin")
    public  List<Datatable>  FindAll();


    @Insert("    insert into blog_admin (username,password,super,create_time)values (#{username},#{password},#{super},#{create_time})")
    public  void SaveUser(User user);

    @Select("select username  from blog_admin where username = #{name};")
    public  String IsUser(@Param("name")String username);


    @Select("select username,password from blog_admin where username = #{username};")
    public User QuerySingin(User user);

    @Update("update blog_admin set password=#{password},update_time=#{update_time} where username=#{username};")
    public  void updatePas(User user);


    @Insert("    insert into blog_article (title, top, content, state, u_id, tag, category_id, `read`, pic, create_time)values (#{title},#{top},#{content},#{state},#{u_id},#{tag},#{category_id},#{read},#{pic},#{create_time});")
    public  void Addarticle(Article article);









}

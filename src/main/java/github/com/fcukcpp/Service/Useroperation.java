package github.com.fcukcpp.Service;/*
作者Crying711
日期:2020/12/23
时间:15:26
*/

import github.com.fcukcpp.Pojo.Datatable;
import github.com.fcukcpp.Pojo.User;

import java.io.IOException;
import java.util.List;

public interface Useroperation
{


    public  List<Datatable> Findall() throws IOException;


    public  List<Datatable>   FuzzyUser(String name) throws IOException;


    public  boolean Saveuser(User user) throws IOException;









}

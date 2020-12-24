package github.com.fcukcpp.Pojo;/*
作者Crying711
日期:11/5/2020
时间:2:13 PM
*/

import java.util.List;

/**
 * layui 数据表单数据pojo类  用户列表
 */
public class Layuidata {


    private  int code;
    private  String msg;
    private  int count;
    private  List data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Layuidata(int code, String msg, int count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Layuidata{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}

package github.com.fcukcpp.Pojo;/*
作者Crying711
日期:11/1/2020
时间:7:59 PM
*/
/**
 * 用户信息类
 */

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private Integer Super;
    private Integer id;
    private    Integer status;
    private long create_time;
    private  long update_time;
    private  long delete_time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSuper() {
        return Super;
    }

    public void setSuper(Integer aSuper) {
        Super = aSuper;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public long getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(long delete_time) {
        this.delete_time = delete_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Super=" + Super +
                ", id=" + id +
                ", status=" + status +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", delete_time=" + delete_time +
                '}';
    }

    public User() {
    }

    public User(String username, String password, Integer aSuper, Integer id, Integer status, long create_time, long update_time, long delete_time) {
        this.username = username;
        this.password = password;
        Super = aSuper;
        this.id = id;
        this.status = status;
        this.create_time = create_time;
        this.update_time = update_time;
        this.delete_time = delete_time;
    }
}
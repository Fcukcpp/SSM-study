package github.com.fcukcpp.Pojo;/*
作者Crying711
日期:2020/12/23
时间:21:45
*/

public class Signin {
private  String username;
private  String password;
private  String code;

    @Override
    public String toString() {
        return "Signin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Signin() {
    }

    public Signin(String username, String password, String code) {
        this.username = username;
        this.password = password;
        this.code = code;
    }
}

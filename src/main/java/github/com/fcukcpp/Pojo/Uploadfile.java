package github.com.fcukcpp.Pojo;/*
作者Crying711
日期:11/4/2020
时间:9:39 PM
*/


/**
 * layui 上传文件数据格式   pojo类
 */
public class Uploadfile
{
   private int code;
    private  String url;

    @Override
    public String toString() {
        return "uploadfile{" +
                "code=" + code +
                ", url='" + url + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Uploadfile() {
    }

    public Uploadfile(int code, String url) {
        this.code = code;
        this.url = url;
    }
}

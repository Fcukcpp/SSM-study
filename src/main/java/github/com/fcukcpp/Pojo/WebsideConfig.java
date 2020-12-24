package github.com.fcukcpp.Pojo;/*
作者Crying711
日期:11/4/2020
时间:3:39 PM
*/


/**
 * 网站配置信息 pojo
 */
public class WebsideConfig
{

private  String name;
private  String title;
private  String keyword;
private  String describe;
private  String copyright;
private  String RecordNo;
private  String close;
private  String Closeprompt;

    public WebsideConfig() {
    }

    public WebsideConfig(String name, String title, String keyword, String describe, String copyright, String recordNo, String close, String closeprompt) {
        this.name = name;
        this.title = title;
        this.keyword = keyword;
        this.describe = describe;
        this.copyright = copyright;
        RecordNo = recordNo;
        this.close = close;
        Closeprompt = closeprompt;
    }


    @Override
    public String toString() {
        return "WebsideConfig{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", keyword='" + keyword + '\'' +
                ", describe='" + describe + '\'' +
                ", copyright='" + copyright + '\'' +
                ", RecordNo='" + RecordNo + '\'' +
                ", close=" + close +
                ", Closeprompt='" + Closeprompt + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getRecordNo() {
        return RecordNo;
    }

    public void setRecordNo(String recordNo) {
        RecordNo = recordNo;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getCloseprompt() {
        return Closeprompt;
    }

    public void setCloseprompt(String closeprompt) {
        Closeprompt = closeprompt;
    }
}

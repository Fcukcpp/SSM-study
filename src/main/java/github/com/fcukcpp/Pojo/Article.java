package github.com.fcukcpp.Pojo;/*
作者Crying711
日期:11/6/2020
时间:2:27 PM
*/


/**
 *  文章 pojo类
 */

public class Article {

    private  Integer id;
    private  String title;
    private   int top;
    private  String content;

    private  int state;
    private  int u_id;
    private  String tag;
    private   int  category_id;
    private   int read;
    private  String pic;
    private  long create_time;
    private   long update_time;
    private  long  delete_time;

    public Article() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

    public Article(Integer id, String title, int top, String content, int state, int u_id, String tag, int category_id, int read, String pic, long create_time, long update_time, long delete_time) {
        this.id = id;
        this.title = title;
        this.top = top;
        this.content = content;
        this.state = state;
        this.u_id = u_id;
        this.tag = tag;
        this.category_id = category_id;
        this.read = read;
        this.pic = pic;
        this.create_time = create_time;
        this.update_time = update_time;
        this.delete_time = delete_time;
    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", top=" + top +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", u_id=" + u_id +
                ", tag='" + tag + '\'' +
                ", category_id=" + category_id +
                ", read=" + read +
                ", pic='" + pic + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", delete_time=" + delete_time +
                '}';
    }
}

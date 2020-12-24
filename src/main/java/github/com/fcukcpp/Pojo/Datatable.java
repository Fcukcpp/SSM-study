package github.com.fcukcpp.Pojo;/*
作者Crying711
日期:11/5/2020
时间:2:30 PM
*/

/**
 * layui 数据表单数据pojo类  用户列表
 */
public class Datatable {
    private Integer id;
    private String username;
    private Integer Super;
    private   Integer status;
    private     String create_time;
    private  String update_time;
    private  String delete_time;

    @Override
    public String toString() {
        return "Datatable{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", Super=" + Super +
                ", status=" + status +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", delete_time='" + delete_time + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSuper() {
        return Super;
    }

    public void setSuper(Integer aSuper) {
        Super = aSuper;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(String delete_time) {
        this.delete_time = delete_time;
    }

    public Datatable(Integer id, String username, Integer aSuper, Integer status, String create_time, String update_time, String delete_time) {
        this.id = id;
        this.username = username;
        Super = aSuper;
        this.status = status;
        this.create_time = create_time;
        this.update_time = update_time;
        this.delete_time = delete_time;
    }
}

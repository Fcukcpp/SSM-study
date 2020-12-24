package github.com.fcukcpp.Controller.Articlemanagement;/*
作者Crying711
日期:2020/12/22
时间:22:06
*/

import github.com.fcukcpp.Pojo.Uploadfile;
import github.com.fcukcpp.Service.impl.Websideationimpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/Acticle")
public class Article
{

    ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");



    @RequestMapping(value = "/Add",method = RequestMethod.POST)
    @ResponseBody
    public  String Addarticle(github.com.fcukcpp.Pojo.Article article) throws IOException {
        Websideationimpl webation = ac.getBean("webation", Websideationimpl.class);

        if (article!=null)
        {
            article.setCategory_id(1);
            article.setCreate_time(new Date().getTime()/1000);
            webation.Addarticle(article);
            return  "success";
        }
        else
            {
                return  "fail";
            }
    }


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Uploadfile Uploadimg(HttpServletRequest request ,MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传...");

        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }

        // 说明上传文件项
        // 获取上传文件的名称
        System.out.println(upload.getOriginalFilename());
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        // 完成文件上传
        upload.transferTo(new File(path,filename));

        return  new Uploadfile(1,"/uploads/"+filename);


    }










}

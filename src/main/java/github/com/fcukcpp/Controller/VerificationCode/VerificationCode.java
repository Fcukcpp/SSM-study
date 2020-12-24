package github.com.fcukcpp.Controller.VerificationCode;/*
作者Crying711
日期:2020/12/22
时间:20:07
*/

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/VerificationCode")
//@SessionAttributes(value = "code",types = String.class)
public class VerificationCode
{  Logger logger= Logger.getLogger(VerificationCode.class);

    @RequestMapping(value = "/Response",method = RequestMethod.GET)
    public boolean Responsecode(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {

        BufferedImage bufferedImage = new BufferedImage(100,40,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = bufferedImage.getGraphics();
        String code ="";
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,100,100);
        g.setColor(Color.MAGENTA);
        g.drawRect(0,0,100-1,100-1);
        String var = "QWERTYUIPASDFGHJKLZXCVBNM123456789";
        for (int i = 1; i <= 4; i++)
        {
            int len = new Random().nextInt(var.length());
            char a = var.charAt(len);
            int x = 100/5*i;
            code+=a;
            g.drawString(a+"",x,25);
        }

        logger.info("ip:  "+request.getRemoteAddr()+"code:  "+code);
        request.getSession().setAttribute("code",code.toString());
//        model.addAttribute("code",code.toString());
        g.setColor(Color.green);
        g.drawLine(1,1,30,30);
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
        return true;
    }


    /**
     *  使用Spring mvc responsebody 响应数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/Getcode",method = RequestMethod.POST)
    @ResponseBody
    public  String Getcode(HttpServletRequest request)
    {


            String code = (String) request.getSession().getAttribute("code");
//          String code =(String)mode.get("code");
            logger.info("ip:  "+request.getRemoteAddr()+"GETcode:  "+code);
            return code;



    }









}

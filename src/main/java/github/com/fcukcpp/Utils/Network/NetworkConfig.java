package github.com.fcukcpp.Utils.Network;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkConfig {
    /**
     * 获取ip地址 归属地
     * @param ip
     * @return
     * @throws IOException
     */
    public  static  String Getipaddres(String ip) throws IOException {
        Document document = null;
        try {
            document = Jsoup.parse(new URL("https://www.so.com/s?ie=utf-8&fr=none&src=360sou_newhome&nlpv=basesc&q="+ip),5000);

        }catch (Exception e)
        {
            return  "Query failed";
        }
        String url = null;
        Elements element = document.getElementsByClass("mh-detail");
        for (Element e:element
        ) {
            url = e.getElementsByTag("span").text();

        }
        if (url==null)
        {
            return  "操作频繁";
        }
        return  url;
    }

    public static String Getip(String url) throws UnknownHostException {
        InetAddress addr = InetAddress.getByName(url);
        return  addr.getHostAddress();
    }

    public  static  String    Getnetworkdelayed(String url) throws IOException {

        int maxTime=0;
        String maxtimeString = "暂无数据";
        String Ip = Getip(url);
        Process p=Runtime.getRuntime().exec("ping "+Ip+" -n 1");
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        StringBuilder sb=new StringBuilder();
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        p.getInputStream().close();
        String[] mes=sb.toString().split(" +");
        String timeString = "响应超时";
        for (int i = 0; i < mes.length; i++) {
            if (mes[i].startsWith("TTL=")) {
                timeString = mes[i-1].replaceAll(mes[i-1].split("(?:(<*+\\d+ms))")[0], "");
                Pattern pat = Pattern.compile("\\D+");
                Matcher m = pat.matcher(timeString);
                int time = Integer.valueOf(m.replaceAll("").trim());
                if (time > maxTime) {
                    maxTime = time;
                    maxtimeString = timeString;
                }
            }
        }

        if (maxTime == 0) {
            return "响应超时";
        }
        return maxtimeString;

    }


}

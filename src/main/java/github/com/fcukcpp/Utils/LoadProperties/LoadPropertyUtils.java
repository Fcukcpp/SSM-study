package github.com.fcukcpp.Utils.LoadProperties;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LoadPropertyUtils {
    /**
     * 加载配置文件
     * @param key
     * @return
     */
    public  static  String Getemail(String key){
    String value = "";
    Locale locale = Locale.getDefault();
    try {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mail", locale);
        value =resourceBundle.getString(key);
    }catch (MissingResourceException mre)
    {
        value ="";

    }
    return  value;



}


}

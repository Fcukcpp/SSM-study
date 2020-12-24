package github.com.fcukcpp.Utils.Encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Location {
    /**
     * 字符串转md5
     * @param pInput
     * @return
     */
    public static String getMd5(String pInput) {
        try {
            MessageDigest lDigest = MessageDigest.getInstance("MD5");
            lDigest.update(pInput.getBytes());
            BigInteger lHashInt = new BigInteger(1, lDigest.digest());
            return String.format("%1$032X", lHashInt).toLowerCase();
        } catch (NoSuchAlgorithmException lException) {
            throw new RuntimeException(lException);
        }
    }


}
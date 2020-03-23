package com.partTime.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by MAIBENBEN on 2019/6/11.
 */

public class MD5Utils {
    /**
     * MD5加密算法
     */
    public  static String md5(String text){
        MessageDigest digest=null;
        try
        {
            digest= MessageDigest.getInstance("md5");
            byte[] result=digest.digest(text.getBytes());
            StringBuilder sb=new StringBuilder();
            for (byte b: result){
                int number=b & 0xff;
                String hex= Integer.toHexString(number);
                if (hex.length()==1){
                    sb.append("0" + hex);

                }else {
                    sb.append(hex);
                }
            }
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return "";
        }
        return "";
    }
}

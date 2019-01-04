package com.huido.fangassist.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class CryptoUtils {

    public static final String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String cryptoPasswd(String pwd, String salt)  {

        String password = pwd + salt;

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");

            md.update(password.getBytes());

            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            return  sb.toString();

        }catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;
    }


    public static  String  getRandomString(int min ,int max) {
        //6 -12位之间
        int strLength = new Random().nextInt(max -min)+ min;

        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i <strLength ;i++) {
            sb.append(saltChars.charAt(new Random() .nextInt(saltChars.length())));
        }
        return sb.toString();
    }

    public static String getSalt() {
        return getRandomString(6,12);
    }


}

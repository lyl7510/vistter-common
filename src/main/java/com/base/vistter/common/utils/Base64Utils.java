package com.base.vistter.common.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

public class Base64Utils {

    private static BASE64Encoder base64Encoder = new BASE64Encoder();

    /**加密*/
    public static String encode(String str){
        try {
            return base64Encoder.encode(str.getBytes("utf-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }

}

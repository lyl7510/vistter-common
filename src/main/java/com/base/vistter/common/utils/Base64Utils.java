package com.base.vistter.common.utils;

import org.apache.commons.codec.binary.Base64;


public class Base64Utils {

    private static Base64 base64 = new Base64();

    /**
     * 加密
     */
    public static String encode(String str) {
        return base64.encodeToString(str.getBytes());
    }

}

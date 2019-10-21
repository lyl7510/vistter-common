package com.base.vistter.common.bean;

import java.util.Map;


public class SystemContextHolder {

    private static final ThreadLocal<Map> sessionVariable = new ThreadLocal<Map>();

    public static Map getSessionContext() {
        return sessionVariable.get();
    }

    public static void setSessionContext(Map map) {
        sessionVariable.set(map);
    }
}

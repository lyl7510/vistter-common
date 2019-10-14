package com.base.vistter.utils;

import org.apache.commons.collections.MapUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class SessionUtils {

    public static final String SecurityUser = "SecurityUser";

    public static final String UserId = "ID";

    public static final String RoleId = "BASE_ROLE_ID";

    public static final String DepartId = "BASE_DEPART_ID";

    public static final String ProjectCode = "PROJECT_CODE";

    public static String getSession(HttpServletRequest request, String key) {
        Map sessionMap = (Map) request.getSession().getAttribute(SecurityUser);
        if (sessionMap == null) {
            return null;
        }
        return MapUtils.getString(sessionMap, key);
    }

    public static String getLoginUserId(HttpServletRequest request) {
        return getSession(request, UserId);
    }

    public static String getRoleId(HttpServletRequest request) {
        return getSession(request, RoleId);
    }

    public static String getDepartId(HttpServletRequest request) {
        return getSession(request, DepartId);
    }

    public static String getProjectCode(HttpServletRequest request) {
        return getSession(request, ProjectCode);
    }

    public static Map getSession(HttpServletRequest request) {
        return (Map) request.getSession().getAttribute(SecurityUser);
    }

    public static void setSession(HttpServletRequest request, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(SecurityUser, value);
    }

}

package com.base.vistter.component;

import com.base.vistter.bean.SystemContextHolder;
import com.base.vistter.utils.SessionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RequestHandlerInterceptor implements HandlerInterceptor {

    public static final Logger logger = LogManager.getLogger(RequestHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map userMap = SessionUtils.getSession(request);
        if(userMap == null){
            logger.error("会话超时，请重新登录");
        }
        logger.info("拦截器会话参数" , userMap);
        SystemContextHolder.setSessionContext(userMap);
        return true;
    }
}

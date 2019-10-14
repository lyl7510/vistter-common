package com.base.vistter.component;

import com.base.vistter.bean.SystemContextHolder;
import com.base.vistter.utils.SessionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class RequestHandlerInterceptor implements HandlerInterceptor {

    public static final Logger logger = LogManager.getLogger(RequestHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入参数设置拦截器");
        Map userMap = SessionUtils.getSession(request);
        logger.info("拦截器所有参数" , userMap);
        SystemContextHolder.setSessionContext(userMap);
        return true;
    }
}

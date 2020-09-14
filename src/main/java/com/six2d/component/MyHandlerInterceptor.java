package com.six2d.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

public class MyHandlerInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(MyHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();

        HttpSession session = request.getSession();
        Object token = session.getAttribute("token");
        if (token == null || token.equals("")) {
            logger.info("Method({}) is no access rights!");
            //request.getRequestDispatcher("login.html").forward(request, response);
            return true;
        } else {
            return true;
        }
    }
}

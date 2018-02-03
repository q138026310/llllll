package com.dlts.hrms.web.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dlts.hrms.cm.App;

public class HandlerInterceptorAdapter implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {

        if (checkUri(request.getRequestURI())) {
            return true;
        }

        Object obj = request.getSession().getAttribute("user");
        if (obj == null) {
            response.getWriter().print("{\"result\":\"1\"}");
            return false;
        }

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {}


    private boolean checkUri(String uri) {
        for (int i = 0; i < App.FILTER_URLS.length; i++) {
            if (uri.contains(App.FILTER_URLS[i])) {
                return true;
            }
        }
        return false;
    }

}

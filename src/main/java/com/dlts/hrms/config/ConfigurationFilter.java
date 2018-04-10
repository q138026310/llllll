package com.dlts.hrms.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationFilter {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());// 添加过滤器
        registration.addUrlPatterns("/*");// 设置过滤路径，/*所有路径
        registration.addInitParameter("name", "alue");// 添加默认参数
        registration.setName("MyFilter");// 设置优先级
        registration.setOrder(1);// 设置优先级
        return registration;
    }

    public class MyFilter implements Filter {
        @Override
        public void destroy() {}

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

            if (FilterBusiness.isChain(req, resp)) {

                req.setAttribute("abc","789");

                chain.doFilter(request, response);
            } else {
                PrintWriter out = resp.getWriter();
                out.print("{\"result\":2,errorMsg:\"not login\"}");
                out.close();
            }

        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {}
    }
}

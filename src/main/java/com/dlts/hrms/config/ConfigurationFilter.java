package com.dlts.hrms.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlts.hrms.domain.cm.SecretKey;
import com.dlts.hrms.domain.po.login.LoginPo;
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

            //resp.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8848");
            //resp.setHeader("Access-Control-Allow-Credentials","true");

            if (FilterBusiness.isChain(req, resp)) {

                HrmsRequestWrapper hrmsRequestWrapper = new HrmsRequestWrapper(req);
                Map<String, String[]> parameterMap = new HashMap<>(hrmsRequestWrapper.getParameterMap());
                Long[] data = getData(req);
                parameterMap.put("customerId",new String[]{String.valueOf(data[0])});
                parameterMap.put("loginUserId",new String[]{String.valueOf(data[1])});
                if(parameterMap.get("status")==null){
                    parameterMap.put("status",new String[]{"1"});
                }
                hrmsRequestWrapper.setParameterMap(parameterMap);
                chain.doFilter(hrmsRequestWrapper, response);
            } else {
                PrintWriter out = resp.getWriter();
                out.print("{\"result\":2,errorMsg:\"not login\"}");
                out.close();
            }

        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {}

        private Long[] getData(HttpServletRequest req){
            Long[] data = new Long[2];

            HttpSession session = req.getSession();
            if( session != null ){
                Object obj = session.getAttribute(SecretKey.user);
                if( obj != null ){
                    LoginPo login = (LoginPo)obj;
                    data[0] = login.getUser().getCustomerId();
                    data[1] = login.getUser().getId();
                }
            }


            return data;
        }
    }
}

package com.dlts.hrms.config;

import com.dlts.hrms.domain.cm.SecretKey;
import com.dlts.hrms.domain.po.login.LoginPo;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestParamFilter extends OncePerRequestFilter {

    private static final String[] POSTFIXS = new String[]{".js",".css",".html",".woff",".woff2",".ttf",".png",".jpg",".gif",".ico"};

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req;

        if(FilterBusiness.isChain(request)){
            if( RequestParamFilter.isStatic(request.getRequestURI()) ){
                req = request;
            }else{
                req = getNewRequest(request);
            }
            chain.doFilter(req,response);
        }else{
            response.sendRedirect("/login.html");
        }

    }

    private HttpServletRequest getNewRequest(HttpServletRequest request){
        HttpSession session = request.getSession();

        Object loginPObj = session.getAttribute(SecretKey.USER);
        if( loginPObj==null ){
            return request;
        }else{
            LoginPo loginPo = (LoginPo) loginPObj;
            Map<String, String[]> newParameterMap = new HashMap<String, String[]>(request.getParameterMap());
            newParameterMap.put("loginUserId", new String[] { String.valueOf(loginPo.getUser().getId()) });
            newParameterMap.put("customerId", new String[] { String.valueOf(loginPo.getUser().getCustomerId()) });
            HrmsRequestWrapper newRequest = new HrmsRequestWrapper(request);
            newRequest.setParameterMap(newParameterMap);
            return newRequest;
        }
    }

    private static boolean isStatic(String uri){
        for (int i = 0; i < POSTFIXS.length; i++) {
            if(uri.endsWith(POSTFIXS[i])){
                return true;
            }
        }
        return false;
    }
}

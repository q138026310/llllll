package com.dlts.hrms.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.SecretKey;
import com.dlts.hrms.domain.po.login.LoginPo;
import org.apache.commons.lang3.StringUtils;

public class FilterBusiness {

    private static final String[] RELEASE_URLS =
            new String[] {"/static/", "/html/", "/templates/", "index/login"};

    /**
     * check cookie and token
     * 
     * @param request
     * @param response
     * @return
     */
    public static boolean isChain(HttpServletRequest request, HttpServletResponse response) {

       /* int a = 1;
        int b = 1;
        if( a==b ){
            return true;
        }*/

        String requestUri = request.getRequestURI();

        if (isReleaseUrl(requestUri)) {
            return true;
        }

        String cookie = request.getHeader(SecretKey.cookie);
        if( StringUtils.isBlank(cookie) ){
            return false;
        }

        String cookieToken = getToken(cookie);
        if( StringUtils.isBlank(cookieToken) ){
            return false;
        }

        HttpSession session = request.getSession();
        if (session != null) {
            Object obj = session.getAttribute(SecretKey.user);
            if (obj != null ) {
                String sessionToken = ((LoginPo) obj).getToken();
                return sessionToken.equals(cookieToken);
            }
        }

        return false;
    }

    private static boolean isReleaseUrl(String requestUrl) {
        for (int i = 0; i < RELEASE_URLS.length; i++) {
            if (requestUrl.contains(RELEASE_URLS[i])) {
                return true;
            }
        }
        return false;
    }

    private static String getToken(String requestCookie){

        String token = null;
        String[] cookies = requestCookie.split(GlobalConstant.Symbol.SEMICOLON);

        if( cookies.length > 1 ){
            for(  String cookie : cookies ){
                String[] ck = cookie.split(GlobalConstant.Symbol.EQUAL);

                if( ck.length == 2 && ck[0].equals(SecretKey.token) ){
                    token = ck[1].trim();
                    break;
                }
            }
        }

        return token;
    }

}

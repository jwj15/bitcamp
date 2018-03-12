package java100.app.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AjaxAccessOriginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request, 
            HttpServletResponse response,
            Object handler)
            throws Exception {
        
        response.setHeader("Access-Control-Allow-Origin", "*");
        
        return true;
    }
}

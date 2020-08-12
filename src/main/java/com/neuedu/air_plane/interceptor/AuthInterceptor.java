package com.neuedu.air_plane.interceptor;

import com.neuedu.air_plane.model.Manager;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        if(session!=null){
            Manager manager = (Manager) session.getAttribute("user");
            if(manager!=null){
                return true;
            }
        }

        response.setStatus(401);

        return false;
    }
}

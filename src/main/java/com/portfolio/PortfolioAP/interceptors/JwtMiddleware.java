package com.portfolio.PortfolioAP.interceptors;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.portfolio.PortfolioAP.errorHandler.exceptions.TokenNotProvided;
import com.portfolio.PortfolioAP.services.JwtService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtMiddleware implements HandlerInterceptor {

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DecodedJWT credentials = null;
        String jwt = request.getHeader("Authorization");
        if(jwt == null){
            response.sendError(401, "Token not provided.");
            return false;
        }
        try{
            credentials = this.jwtService.verify(jwt);
        }catch (TokenExpiredException e){
            response.sendError(401, "Provided token is expired.");
            return false;
        }
        request.setAttribute("user_id", credentials.getClaim("sub"));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}

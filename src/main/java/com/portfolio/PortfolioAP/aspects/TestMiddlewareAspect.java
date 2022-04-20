package com.portfolio.PortfolioAP.aspects;

import com.portfolio.PortfolioAP.models.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestMiddlewareAspect {

    @Around("@annotation(TestMiddleware)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        var params = joinPoint.getArgs();
        User u = (User) params[0];
        System.out.println(u.getNombre());
        return proceed;
    }

}



package com.portfolio.PortfolioAP.errorHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return this.handle(request, response, (HttpErrorException) ex);
    }

    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, HttpErrorException ex) {
        try {
            response.sendError(ex.getStatus());
            String accept = request.getHeader(HttpHeaders.ACCEPT);
            return new ModelAndView(accept);
        } catch (Exception handlerException) {
            logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", handlerException);
        }
        return null;
    }

}

package com.portfolio.PortfolioAP.errorHandler.exceptions;

import com.portfolio.PortfolioAP.errorHandler.HttpErrorException;

public class NotFoundException extends HttpErrorException {

    public NotFoundException(String message){
        super(message, 404);
    }
}

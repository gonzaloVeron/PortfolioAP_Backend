package com.portfolio.PortfolioAP.errorHandler.exceptions;

import com.portfolio.PortfolioAP.errorHandler.HttpErrorException;

public class EducationNotFoundException extends HttpErrorException {

    public EducationNotFoundException(String message){
        super(message, 404);
    }
}

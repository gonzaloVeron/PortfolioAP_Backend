package com.portfolio.PortfolioAP.errorHandler.exceptions;

import com.portfolio.PortfolioAP.errorHandler.HttpErrorException;

public class MissingDataException extends HttpErrorException {

    public MissingDataException(String message, int status){
        super(message, status);
    }
}

package com.portfolio.PortfolioAP.errorHandler.exceptions;

import com.portfolio.PortfolioAP.errorHandler.HttpErrorException;

public class TokenNotProvided extends HttpErrorException {

    public TokenNotProvided(String message, int status){
        super(message, status);
    }
}

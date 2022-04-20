package com.portfolio.PortfolioAP.errorHandler.exceptions;

import com.portfolio.PortfolioAP.errorHandler.HttpErrorException;

public class InvalidCredentials extends HttpErrorException {

    public InvalidCredentials(){
        super("Invalid credentials", 400);
    }
}

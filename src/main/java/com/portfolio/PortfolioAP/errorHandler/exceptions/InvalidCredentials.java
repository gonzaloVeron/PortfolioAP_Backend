package com.portfolio.PortfolioAP.errorHandler.exceptions;

import com.portfolio.PortfolioAP.errorHandler.HttpErrorException;

import java.util.function.Supplier;

public class InvalidCredentials extends HttpErrorException {

    public InvalidCredentials(){
        super("Invalid credentials", 400);
    }

}

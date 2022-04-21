package com.portfolio.PortfolioAP.errorHandler;

public class HttpErrorException extends Exception {

    private int status;

    public HttpErrorException(String message, int status){
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}

package com.portfolio.PortfolioAP.errorHandler.exceptions;

import java.util.function.Supplier;

public class InvalidCredentialsSupplier implements Supplier<InvalidCredentials> {

    @Override
    public InvalidCredentials get() {
        return new InvalidCredentials();
    }
}

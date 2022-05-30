package com.portfolio.PortfolioAP.errorHandler.exceptions;

import java.util.function.Supplier;

public class UserNotFoundExceptionSupplier implements Supplier<UserNotFoundException> {

    @Override
    public UserNotFoundException get() {
        return new UserNotFoundException("The requested user was not found");
    }
}

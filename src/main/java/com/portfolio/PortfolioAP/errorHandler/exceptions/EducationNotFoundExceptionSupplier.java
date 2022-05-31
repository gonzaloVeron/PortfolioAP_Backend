package com.portfolio.PortfolioAP.errorHandler.exceptions;

import java.util.function.Supplier;

public class EducationNotFoundExceptionSupplier implements Supplier<EducationNotFoundException> {

    @Override
    public EducationNotFoundException get() {
        return new EducationNotFoundException("The requested education was not found");
    }
}

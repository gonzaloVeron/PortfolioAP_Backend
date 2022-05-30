package com.portfolio.PortfolioAP.errorHandler.exceptions;

import java.util.function.Supplier;

public class WorkExperienceNotFoundExceptionSupplier implements Supplier<WorkExperienceNotFoundException> {

    @Override
    public WorkExperienceNotFoundException get() {
        return new WorkExperienceNotFoundException("The requested work experience was not found");
    }
}

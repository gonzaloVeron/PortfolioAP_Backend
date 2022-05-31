package com.portfolio.PortfolioAP.errorHandler.exceptions;

import java.util.function.Supplier;

public class ProjectNotfoundExceptionSupplier implements Supplier<ProjectNotfoundException> {

    @Override
    public ProjectNotfoundException get() {
        return new ProjectNotfoundException("The requested project was not found");
    }

}

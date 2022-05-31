package com.portfolio.PortfolioAP.errorHandler.exceptions;

import java.util.function.Supplier;

public class SkillNotFoundExceptionSupplier implements Supplier<SkillNotFoundException> {

    @Override
    public SkillNotFoundException get() {
        return new SkillNotFoundException("The requested skill was not found");
    }
}

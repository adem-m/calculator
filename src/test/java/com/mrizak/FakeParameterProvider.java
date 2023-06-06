package com.mrizak;

import java.util.List;

public class FakeParameterProvider implements ParameterProvider {
    @Override
    public Parameters getParameters() {
        return new Parameters(List.of(1, 2, 3, 4), Operator.TIMES);
    }
}

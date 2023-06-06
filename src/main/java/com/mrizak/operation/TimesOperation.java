package com.mrizak.operation;

class TimesOperation implements Operation {
    @Override
    public Output apply(Input input) {
        return new Output(input.a() * input.b());
    }
}

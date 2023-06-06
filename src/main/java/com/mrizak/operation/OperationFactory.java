package com.mrizak.operation;

import com.mrizak.Operator;

public class OperationFactory {
    public static Operation createOperation(Operator operator) {
        return switch (operator) {
            case PLUS -> new PlusOperation();
            case MINUS -> new MinusOperation();
            case TIMES -> new TimesOperation();
        };
    }
}

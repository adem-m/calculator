package com.mrizak;

import com.mrizak.operation.Input;
import com.mrizak.operation.Output;

public class StepByStepCalculator {
    private final CalculatorInput input;
    private final OutputWriter outputWriter;

    public StepByStepCalculator(CalculatorInput input, OutputWriter outputWriter) {
        this.input = input;
        this.outputWriter = outputWriter;
    }

    public void calculate() {
        if (input.numbers().size() < 2) {
            return;
        }
        int result = input.numbers().get(0);
        for (int i = 1; i < input.numbers().size(); i++) {
            Integer a = input.numbers().get(i);
            Output output = input.operation().apply(new Input(result, a));
            outputWriter.write(output.result().toString());
            result = output.result();
        }
    }
}

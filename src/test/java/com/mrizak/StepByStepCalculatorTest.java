package com.mrizak;

import com.mrizak.operation.OperationFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class StepByStepCalculatorTest {
    private OutputWriter outputWriter;

    @Before
    public void setUp() {
        outputWriter = Mockito.mock(OutputWriter.class);
    }

    @Test
    public void shouldAdd123Correctly() {
        StepByStepCalculator calculator = new StepByStepCalculator(
                new CalculatorInput(List.of(1, 2, 3), OperationFactory.createOperation(Operator.PLUS)),
                outputWriter
        );
        calculator.calculate();

        Mockito.verify(outputWriter).write("3");
        Mockito.verify(outputWriter).write("6");
    }

    @Test
    public void shouldSubtract123Correctly() {
        StepByStepCalculator calculator = new StepByStepCalculator(
                new CalculatorInput(List.of(1, 2, 3), OperationFactory.createOperation(Operator.MINUS)),
                outputWriter
        );
        calculator.calculate();

        Mockito.verify(outputWriter).write("-1");
        Mockito.verify(outputWriter).write("-4");
    }
}
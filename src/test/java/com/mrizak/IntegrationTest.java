package com.mrizak;

import com.mrizak.operation.Operation;
import com.mrizak.operation.OperationFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IntegrationTest {
    private ParameterProvider parameterProvider;
    private OutputWriter outputWriter;

    @Before
    public void setUp() {
        parameterProvider = new FakeParameterProvider();
        outputWriter = Mockito.mock(OutputWriter.class);
    }

    @Test
    public void integrationTest() {
        Parameters parameters = parameterProvider.getParameters();
        Operation operation = OperationFactory.createOperation(parameters.operator());
        StepByStepCalculator calculator = new StepByStepCalculator(
                new CalculatorInput(parameters.values(), operation),
                outputWriter
        );
        calculator.calculate();

        Mockito.verify(outputWriter).write("2");
        Mockito.verify(outputWriter).write("6");
        Mockito.verify(outputWriter).write("24");
    }
}

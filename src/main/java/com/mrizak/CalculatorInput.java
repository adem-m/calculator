package com.mrizak;

import com.mrizak.operation.Operation;

import java.util.List;

public record CalculatorInput(List<Integer> numbers, Operation operation) {
}

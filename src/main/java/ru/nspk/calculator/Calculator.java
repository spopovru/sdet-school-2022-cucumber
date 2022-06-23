package ru.nspk.calculator;

public class Calculator {

    private Integer argument1 = null;
    private Integer argument2 = null;
    private Integer result = null;

    public static Calculator create() {
        return new Calculator();
    }

    // Getters and setters

    public Calculator setArgument1(Integer arg) {
        argument1 = arg;
        return this;
    }

    public Calculator setArgument2(Integer arg) {
        argument2 = arg;
        return this;
    }

    public Integer getResult() {
        return result;
    }

    // Operations

    public Calculator executeAddition() {
        result = argument1 + argument2;
        return this;
    }

    public Calculator executeSubtraction() {
        result = argument1 - argument2;
        return this;
    }

    public Calculator executeMultiplication() {
        result = argument1 * argument2;
        return this;
    }

    public Calculator executeDivision() {
        result = argument1 / argument2;
        return this;
    }

}

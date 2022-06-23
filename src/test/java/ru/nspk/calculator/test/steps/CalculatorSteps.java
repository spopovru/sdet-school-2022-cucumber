package ru.nspk.calculator.test.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.nspk.calculator.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorSteps {

    private Calculator calculator;

    @Пусть("^инициализирован новый калькулятор$")
    public void initializeNewCalculator() {
        calculator = Calculator.create();
    }

    @Пусть("^первый аргумент равен (-?\\d+)")
    public void setArgument1(Integer arg) {
        calculator.setArgument1(arg);
    }

    @Пусть("^второй аргумент равен (-?\\d+)$")
    public void setArgument2(Integer arg) {
        calculator.setArgument2(arg);
    }

    @Когда("^выполнена операция сложения$")
    public void executeAddition() {
        calculator.executeAddition();
    }

    @Когда("^выполнена операция вычитания$")
    public void executeSubtraction() {
        calculator.executeSubtraction();
    }

    @Когда("^выполнена операция умножения$")
    public void executeMultiplication() {
        calculator.executeMultiplication();
    }

    @Когда("^выполнена операция деления$")
    public void executeDivision() {
        calculator.executeDivision();
    }

    @Тогда("^результат равен (-?\\d+)$")
    public void checkResult(Integer result) {
        assertEquals(result, calculator.getResult());
    }

    @Тогда("^операция деления приводит к ошибке$")
    public void divisionThrowException() {
        assertThrows(Exception.class, () -> {
            calculator.executeDivision();
        });
    }

}

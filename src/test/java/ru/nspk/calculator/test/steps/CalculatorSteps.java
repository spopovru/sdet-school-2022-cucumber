package ru.nspk.calculator.test.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.nspk.calculator.Calculator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorSteps {

    private Calculator calculator;
    private List<List<Integer>> argsList;

    @Пусть("инициализирован новый калькулятор")
    public void initializeNewCalculator() {
        calculator = Calculator.create();
    }

    @Пусть("первый аргумент равен {int}")
    public void setArgument1(Integer arg) {
        calculator.setArgument1(arg);
    }

    @Пусть("второй аргумент равен {int}")
    public void setArgument2(Integer arg) {
        calculator.setArgument2(arg);
    }

    @Пусть("инициализирован набор агрументов")
    public void initializeArguments(DataTable dataTable) {
        argsList = dataTable.asLists(Integer.class);
    }

    @Когда("выполнена операция сложения")
    public void executeAddition() {
        calculator.executeAddition();
    }

    @Когда("выполнена операция вычитания")
    public void executeSubtraction() {
        calculator.executeSubtraction();
    }

    @Когда("выполнена операция умножения")
    public void executeMultiplication() {
        calculator.executeMultiplication();
    }

    @Когда("выполнена операция деления")
    public void executeDivision() {
        calculator.executeDivision();
    }

    @Тогда("результат равен {int}")
    public void checkResult(Integer result) {
        assertEquals(result, calculator.getResult());
    }

    @Тогда("операция деления приводит к ошибке")
    public void divisionThrowException() {
        assertThrows(Exception.class, () -> {
            calculator.executeDivision();
        });
    }

    @Тогда("сложение аргументов даёт результат {int}")
    public void executeAdditionOnListOfArgumentsAndCheckResult(Integer result) {
        for (List<Integer> item: argsList) {
            calculator.setArgument1(item.get(0));
            calculator.setArgument2(item.get(1));
            calculator.executeAddition();
            assertEquals(result, calculator.getResult());
        }
    }

}

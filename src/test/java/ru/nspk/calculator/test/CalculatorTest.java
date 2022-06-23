package ru.nspk.calculator.test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "ru.nspk.calculator.test.steps" }
)
public class CalculatorTest extends AbstractTestNGCucumberTests {

}

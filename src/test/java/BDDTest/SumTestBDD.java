package BDDTest;

import Programm.Calc;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class SumTestBDD {
    private double firstNumber;
    private double secondNumber;

    private Calc calc = Calc.getInstance();
    private double result;

    @Given("a $firstNumber and $secondNumber")
    public void getFirstNumber(double firstNumber, double secondNumber)
    {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @When("user call method $grid")
    public void Sum(String grid)
    {
        switch(grid)
        {
            case "sum":
                result = calc.sum(firstNumber, secondNumber);
                break;
            case "div":
                result = calc.divide(firstNumber, secondNumber);
                break;
            case "mul":
                result = calc.multiply(firstNumber, secondNumber);
                break;
            case "sub":
                result = calc.subtract(firstNumber, secondNumber);
        }
    }
    @Then("get the $result of two numbers")
    public void trueResult(double result)
    {
        Assert.assertTrue( this.result == result);
    }
}

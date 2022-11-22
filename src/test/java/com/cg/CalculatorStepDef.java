package com.cg;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class CalculatorStepDef {
	Calculator c;
	Integer actualResult;

	@Given("user us accessing calculator")
	public void user_us_accessing_calculator() {

		c = new Calculator();
	}

	@When("user entres {int} and {int}")
	public void user_entres_and(Integer a, Integer b) {
		actualResult = c.add(a, b);
	}

	@Then("addition function should return {int} as resultss")
	public void addition_function_should_return_as_resultss(Integer expectedResult) {

		Assert.assertEquals(expectedResult, actualResult);
	}
}

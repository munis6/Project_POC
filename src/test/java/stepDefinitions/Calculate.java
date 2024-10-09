package stepDefinitions;



import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Calculate {
	
	private int number;
	
	private int result;
	
	@Given("I have a number {int}")
	public void i_have_a_number(int num) {
	    number=num;
	}

	@When("I add {int} to it")
	public void i_add_to_it(int addend) {
	   result=number+addend;
	}

	@Then("the result should be {int}")
	public void the_result_should_be(int expectedResult ) {
	   Assert.assertEquals(expectedResult,result);
	   System.out.println("This test is a pass");
	}


}

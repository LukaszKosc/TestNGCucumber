package stepdefs.api;

import cucumber.api.java.en.Given;

public class ApiStepDefinitions {
    @Given("^I call api with \"([^\"]*)\"$")
    public void i_call_api_with(String val) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("api test body: " + val);
    }

//    @Given("^I also call api with {int}$")
    public void i_also_call_api_with(String val) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("api test body: " + val);
    }
}

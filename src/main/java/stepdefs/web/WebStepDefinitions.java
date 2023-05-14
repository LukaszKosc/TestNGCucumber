package stepdefs.web;

import com.base.tests.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class WebStepDefinitions {

    public WebStepDefinitions(){
        homePage = new HomePage();
    }
    private HomePage homePage;
    @Given("I am on Google page")
    public void i_am_on_google_page() {
        homePage.openURL("https://www.google.com");
    }
    @When("^I search for \"(.*)\"$")
    public void i_give_consent(String value) {
        homePage.searchFor(value);
        homePage.clickSearchButton();
    }

    @When("^I should load the results page$")
    public void i_should_load_the_results_page() {
        homePage.waitForPageToLoad();
    }

    @And("^I give consent$")
    public void i_give_consent() {
        homePage.giveConsent();
    }
    @Given("^Closing browser$")
    public void closing_browser() {
        homePage.tearDown();
    }
}

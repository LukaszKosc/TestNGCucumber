package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



/**
 * Created by thilinaga on 7/3/2017.
 */
public class ServiceHooks {

    @Before
    public void initializeTest(Scenario scenario){
        // Code to setup initial configurations
        System.out.println("before running test?");
        System.out.println("Nazwa: " + scenario.getName());
        System.out.println("Id: " + scenario.getId());
    }

    @After
    public void cleanupTest(Scenario scenario) {
        System.out.println("after running test?");
        System.out.println("Scenario name: " + scenario.getName());
        System.out.println("Status: " + scenario.getStatus());


        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
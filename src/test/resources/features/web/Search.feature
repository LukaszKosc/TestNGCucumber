Feature: Search on Google

        Scenario: Search for cat on Google
                Given I am on Google page
                And I give consent
                When I search for "cat"
                Then I should load the results page
                Then Closing browser


        Scenario: Search again on google
                Given I am on Google page
                And I give consent
                When I search for "dog"
                Then I should load the results page
                Then Closing browser
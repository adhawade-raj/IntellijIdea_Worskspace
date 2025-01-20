package com.qa.test.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FromFillSteps {

    @Given("User is navigated to Form filling page")
    public void user_is_navigated_to_form_filling_page() {
        System.out.println("Navigated to form filling page");
    }

    @When("User sets Name in nameField")
    public void user_sets_name_in_name_field() {
        System.out.println("Name set in name field");
    }

    @When("User selects country from dropdown")
    public void user_selects_country_from_dropdown() {
        System.out.println("Country selected from dropdown");
    }

    @When("User selects gender from dropdown")
    public void user_selects_gender_from_dropdown() {
        System.out.println("Gender selected from dropdown");
    }

    @Then("user clicks on lets shop button")
    public void user_clicks_on_lets_shop_button() {
        System.out.println("Clicked on 'Let's Shop' button");
    }
}

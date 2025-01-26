package com.qa.test.steps;

import com.qa.test.implementation.Registration;
import com.qa.utils.AndroidUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Inject;

public class RegistrationSteps {

    @Inject
    Registration registration;

    @Given("the user navigates to the registration form")
    public void the_user_navigates_to_the_registration_form() {
        Injector injector = Guice.createInjector();
        registration = injector.getInstance(Registration.class);
    }

    @When("the user selects {string} from the country dropdown")
    public void the_user_selects_from_the_country_dropdown(String string) {
        registration.setCountrySelection(string);
    }

    @When("the user enters {string} as the name")
    public void the_user_enters_as_the_name(String string) {
        registration.setNameField(string);

    }

    @When("the user selects {string} from the gender dropdown")
    public void the_user_selects_from_the_gender_dropdown(String string) {
        registration.setGender(string);
    }
    @Then("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        registration.submitButton();
    }
    @Then("the user is redirected to the {string} page")
    public void the_user_is_redirected_to_the_products_page(String pageName) {
        String title = registration.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, pageName);
    }
    @Then("user gets error message {string}")
    public void user_gets_error_messege_please_enter_your_name(String errorMsg) {
    String actualMessage = registration.getToastMessage();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, errorMsg);
    }





}

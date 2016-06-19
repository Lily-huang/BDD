package com.mengli.jbehave.step;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;

/**
 * Created by mlhuang on 6/19/16.
 */
public class TestLoginStep {

    @Given("a system onState $state")
    public void onState(@Named("state") String state)
    {
        System.out.println("-----------"+state);
        Assert.assertEquals(state,"login");
    }

    @When("I click $button")
    public void click(@Named("button") String button)
    {
        System.out.println("------------"+button);
        Assert.assertEquals(button,"edit");
    }

    @Then("print $message")
    public void print(@Named("message") String message)
    {
        System.out.println("-------------"+message);
        Assert.assertEquals(message,"please edit now");
    }
}

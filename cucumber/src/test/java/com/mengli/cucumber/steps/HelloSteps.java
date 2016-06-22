package com.mengli.cucumber.steps;

import com.mengli.apps.hello.HelloMsg;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;

import java.util.Objects;

/**
 * Created by mlhuang on 6/22/16.
 */
public class HelloSteps {
    private String name;
    HelloMsg helloMsg;

    @Given("^the hello input \"([^\"]*)\"$")
    public void the_input(String input){
        name=input;
    }

    @When("^The hello Method is called$")
    public void The_Method_is_called(){
        helloMsg=new HelloMsg();
    }

    @Then("^the hello output should be \"([^\"]*)\"$")
    public void the_output_should_be(String output){
        String msg=helloMsg.getMsg(name);
        MatcherAssert.assertThat("not match "+msg, Objects.equals(msg,output));
    }
}

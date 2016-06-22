package com.mengli.cucumber.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mlhuang on 6/22/16.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"classpath:*/Hello.feature"},
        glue = {"com.mengli.cucumber"}
)
public class RunSearchTest {
}

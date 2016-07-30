package com.mengli.cucumber.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mlhuang on 6/22/16.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",},
//        strict = false,monochrome = true,dryRun=true,
        features = {"classpath:com/test/feature"},
        glue = {"com.mengli.cucumber.steps"}
)
public class CucumberIT {
}

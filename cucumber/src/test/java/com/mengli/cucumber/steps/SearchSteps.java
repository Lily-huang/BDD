package com.mengli.cucumber.steps;

import com.mengli.cucumber.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by mlhuang on 6/22/16.
 */
public class SearchSteps {
    WebDriver driver;
    WebElement searchInputField;
    SearchPage searchPage=new SearchPage();

    public SearchSteps(){
        driver=new FirefoxDriver();
        this.driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        PageFactory.initElements(this.driver, searchPage);
    }

    @Given("^The search is Hello World$")
    public void The_search_is_Hello_World(){
        searchInputField= searchPage.getSearchInput();
        searchInputField.sendKeys("Hello World");
    }

    @When("^The Search is performed$")
    public void The_Search_is_performed(){
        searchInputField.submit();
    }

    @Then("^The browser title should have Hello World$")
    public void The_browser_title_should_have_Hello_World(){
        (new WebDriverWait(driver, 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("hello world");
            }
        });
        assertThat("Browser title",driver.getTitle(),containsString("Hello World"));
        driver.quit();
    }
}

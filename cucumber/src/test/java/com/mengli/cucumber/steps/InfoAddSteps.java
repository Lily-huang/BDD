package com.mengli.cucumber.steps;

import com.mengli.cucumber.model.Staff;
import com.mengli.cucumber.pages.InfoAddPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by mlhuang on 6/23/16.
 */
public class InfoAddSteps {
    WebDriver driver;
    WebElement nameInputField;
    WebElement ageInputField;
    WebElement idInputField;
    InfoAddPage infoAddPage=new InfoAddPage();
    Staff staff;

    public InfoAddSteps(){
        driver=new FirefoxDriver();
        this.driver.manage().window().maximize();
        driver.get("http://localhost:7001/staff/add");
        PageFactory.initElements(this.driver, infoAddPage);
    }

    @Given("^the following staffs info$")
    public void the_following_staffs_info(List<Staff> staffs){
//        System.out.println("*****"+ staffs.getGherkinRows());
//        System.out.println("*****"+ staffs.get(1).getName());
        Staff staff=staffs.get(0);

        nameInputField=infoAddPage.getNameInput();
        nameInputField.sendKeys(staff.getName());
        ageInputField=infoAddPage.getAgeInput();
        ageInputField.sendKeys(staff.getAge()+"");
        idInputField=infoAddPage.getIdInput();
        idInputField.sendKeys(staff.getId());
    }

    @When("^The info is submitted$")
    public void The_info_is_submitted(){
        nameInputField.submit();//任一提交即可
    }

    @Then("^the info output should be \"([^\"]*)\"$")
    public void the_info_output_should_be_output(String output){
        System.out.println("------"+output);
        (new WebDriverWait(driver, 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().toLowerCase().contains("/staff/info");
            }
        });
        assertThat("Page info",driver.getPageSource(),containsString(output));
        driver.quit();
    }
}

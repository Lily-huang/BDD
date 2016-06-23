package com.mengli.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by mlhuang on 6/23/16.
 */
public class InfoAddPage {

    @FindBy(how = How.NAME,using = "name")
    private WebElement nameInput;

    @FindBy(how = How.NAME,using = "age")
    private WebElement ageInput;

    @FindBy(how = How.NAME,using = "staffNo")
    private WebElement idInput;

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getIdInput() {
        return idInput;
    }

    public WebElement getAgeInput() {
        return ageInput;
    }
}

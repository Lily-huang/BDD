package com.mengli.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by mlhuang on 6/22/16.
 */
public class SearchPage {

    @FindBy(how = How.CSS,using = "#kw")
    private WebElement searchInput;

    public WebElement getSearchInput() {
        return searchInput;
    }
}

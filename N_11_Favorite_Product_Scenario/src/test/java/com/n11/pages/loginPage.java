package com.n11.pages;

import com.n11.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    public loginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='facebook_large medium facebookBtn  btnLogin']")
    public WebElement loginViaFacebook;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement userNameInFacebook;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordInFacebook;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginButtonInFacebook;

    @FindBy(xpath = "//a[@class='menuLink user']")
    public WebElement loggedAccount;

}

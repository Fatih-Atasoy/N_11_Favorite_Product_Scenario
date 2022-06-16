package com.n11.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.n11.pages.loginPage;
import com.n11.pages.mainPage;
import com.n11.pages.productPage;
import com.n11.utulities.BrowserUtils;
import com.n11.utulities.ConfigurationReader;
import com.n11.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class n11 {
    mainPage mainPage = new mainPage();
    loginPage loginPage = new loginPage();
    productPage productPage = new productPage();
    Actions action = new Actions(Driver.getDriver());

    @Test(priority = 1)
    public void goMainPageAndVerify() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.verifyTitle(ConfigurationReader.getProperty("firstenterypagetitle"));
    }

    @Test(priority = 2)
    public void loginPage() {
        mainPage.signInButton.click();
        String mainWindow = Driver.getDriver().getWindowHandle();
        loginPage.loginViaFacebook.click();

        BrowserUtils.waitForVisibilityOf(loginPage.userNameInFacebook);
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
        }
        for (String username : ConfigurationReader.getProperty("username").split("")) {
            loginPage.userNameInFacebook.sendKeys(username);
        }

        for (String password : ConfigurationReader.getProperty("password").split("")) {
            loginPage.passwordInFacebook.sendKeys(password);
        }

        loginPage.loginButtonInFacebook.click();
      Driver.getDriver().switchTo().window(mainWindow);
        BrowserUtils.waitForVisibilityOf(loginPage.loggedAccount);
        BrowserUtils.verifyAccount(loginPage.loggedAccount);
    }

    @Test(priority = 3)
    public void setProductPage() {
        productPage.searchBox.sendKeys(ConfigurationReader.getProperty("searchkeyword"));
        productPage.searchButton.click();
        BrowserUtils.verifyAllProduct(productPage.productsAfterSearch);
    }

    @Test(priority = 4)
    public void goSecondPage() {
        productPage.goSecondPageLink.click();
        BrowserUtils.verifyTitle(ConfigurationReader.getProperty("afterearchsecondpagetitle"));
        productPage.addFavoriteThirhtProductOfSecondPage.click();
        action.moveToElement(productPage.myAccount).perform();
        BrowserUtils.waitForVisibilityOf(productPage.myFavoritesAndLists);
        action.moveToElement(productPage.myFavoritesAndLists).click().perform();
        productPage.myFavorites.click();
        BrowserUtils.verifyTitle(ConfigurationReader.getProperty("myFavoritesPageTitle"));
        productPage.deleteButtonInMyFavorite.click();
        BrowserUtils.waitForVisibilityOf(productPage.alertAfterDeleted);
        productPage.alertAfterDeleted.click();
        BrowserUtils.waitForVisibilityOf(productPage.emptyFavorite);
        Assert.assertTrue(productPage.emptyFavorite.isDisplayed());
    }

    @Test(priority = 5)
    public void signOutFromAccount() {
        action.moveToElement(productPage.myAccount).perform();
        action.moveToElement(productPage.signOutButton).click().perform();
        BrowserUtils.verifyTitle(ConfigurationReader.getProperty("titleAfterSignOut"));
    }


    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}

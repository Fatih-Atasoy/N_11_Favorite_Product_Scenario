package com.n11.utulities;


import com.n11.pages.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {


    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }


    public static void verifyTitle(String expectedTitle) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

    }

    public static void verifyAccount(WebElement element) {
        Assert.assertEquals(element.getText(), ConfigurationReader.getProperty("accountname"));
    }

    public static void verifyAllProduct(List<WebElement> productsAfterSearch) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigurationReader.getProperty("verifysearchkeyword")));

        for (WebElement productAfterSearch : productsAfterSearch) {
            Assert.assertTrue(productAfterSearch.getText().contains(ConfigurationReader.getProperty("verifysearchkeyword")));
        }
    }

    public static void waitForInvisibilityOf(WebElement webElement) {
      //  Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
      //  Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static void waitForVisibilityOf(WebElement webElement) {
      //  Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(webElement));
     //   Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

}

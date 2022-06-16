package com.n11.pages;

import com.n11.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productPage {
    public productPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='searchData']")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@class='searchBtn']")
    public WebElement searchButton;

    @FindBy(xpath = "//li[@class='column ']//h3")
    public List<WebElement> productsAfterSearch;

    @FindBy(xpath = "//a[.='2']")
    public WebElement goSecondPageLink;

    @FindBy(xpath = "(//span[@title='Favorilere ekle'])[3]")
    public WebElement addFavoriteThirhtProductOfSecondPage;

    @FindBy(xpath = "//a[.='Favorilerim / Listelerim']")
    public WebElement myFavoritesAndLists;

    @FindBy(xpath = "(//h4[@class='listItemTitle'])[1]")
    public WebElement myFavorites;
    @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement myAccount;

    @FindBy(xpath = "//span[.='Sil']")
    public WebElement deleteButtonInMyFavorite;

    @FindBy(xpath = "//span[.='Tamam']")
    public WebElement alertAfterDeleted;

    @FindBy(xpath = "//div[.='İzlediğiniz bir ürün bulunmamaktadır.']")
    public WebElement emptyFavorite;

    @FindBy(xpath = "//a[@class='logoutBtn']")
    public WebElement signOutButton;


}

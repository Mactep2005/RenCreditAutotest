package ru.appline.rencredit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardsPage {
    WebDriver driver;

    public CardsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[contains(text(),'Заполнить заявку')]")
    public WebElement cards;


    public RequestNewCardPage goToRequestNewCardPage() {
        cards.click();
        return new RequestNewCardPage(driver);
    }
}

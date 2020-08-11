package ru.appline.rencredit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='footer__nav-item']/a[contains(text(),'Вклады')]")
    public WebElement deposits;

    @FindBy(xpath="//div[@class='footer__nav-item']/a[contains(text(),'Карты')]")
    public WebElement cards;

    public DepositPage goToDepositPage() throws InterruptedException {
        deposits.click();
     //   Thread.sleep(1000);
    return new DepositPage(driver);
    }

    public CardsPage goToCardsPage() {
        cards.click();
        return new CardsPage(driver);
    }
}

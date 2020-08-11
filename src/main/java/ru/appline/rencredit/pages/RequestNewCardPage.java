package ru.appline.rencredit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RequestNewCardPage {
    WebDriver driver;
    public RequestNewCardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id='t2']")
    public WebElement name;
    @FindBy(xpath="//*[@id='t1']")
    public WebElement secondName;
    @FindBy(xpath="//*[@id='t3']")
    public WebElement surName;
    @FindBy(xpath="//label[contains(text(),'Нет отчества')]")
    public WebElement noSurName;
    @FindBy(xpath="//*[@id='t4']")
    public WebElement phone;
    @FindBy(xpath = "//select[@name='CreditRegion']")
    private WebElement office;


    public void fillFormRequest(String sname, String ssecondName, String ssurname, String sphone, int ioffice) throws InterruptedException {
        Thread.sleep(2000);
        name.sendKeys(sname);
        secondName.sendKeys(ssecondName);
        surName.sendKeys(ssurname);
        phone.sendKeys(sphone);
    //    noSurName.click();
        Select select = new Select(office);
        select.selectByIndex(ioffice);
    }

}

package ru.appline.rencredit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;

public class DepositPage {
    WebDriver driver;
    public DepositPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form//span[contains(text(),'В отделении банка')]")
    private WebElement inOffice;

    @FindBy(xpath = "//select[@name='period']")
    private WebElement period;

    public void changeDepositPage() throws InterruptedException {
        Thread.sleep(2000);
        inOffice.click();
        Select select = new Select(period);
        select.selectByIndex(0);
    }
    public void saveDoc(String URL, String file) {
     //   FileUtils.copyURLToFile(new URL(URL), file);
    }
}

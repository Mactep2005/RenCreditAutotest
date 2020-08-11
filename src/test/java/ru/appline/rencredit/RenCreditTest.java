package ru.appline.rencredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import ru.appline.rencredit.pages.DepositPage;
import ru.appline.rencredit.pages.MainPage;
import ru.appline.rencredit.steps.MainSteps;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class RenCreditTest {

    protected static WebDriver driver;
    MainPage mainPage;
    DepositPage depositPage;

    @BeforeClass
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void testRenCredit() throws InterruptedException, SQLException {
        driver.get("https://www.rencredit.ru/");
        mainPage = new MainPage(driver);
        long begin;
        long end;

        SQLDatabaseConnection connection = new SQLDatabaseConnection("localhost","1433","logs","nologin","1234");
        boolean connect = connection.connect();

        begin = System.currentTimeMillis();
        MainSteps mySteps = new MainSteps(driver, mainPage);
        end = System.currentTimeMillis();
        if(connect) connection.execute("INSERT INTO autotestlog(begin_time,end_time, step_name) " +
                "VALUES("+new java.sql.Date(begin)+","+new java.sql.Date(end)+",'Открытие начальной страницы');");

        begin = System.currentTimeMillis();
        mySteps.goToDepositPage();
        end = System.currentTimeMillis();
        if(connect) connection.execute("INSERT INTO autotestlog(begin_time,end_time, step_name) " +
                "VALUES("+new java.sql.Date(begin)+","+new java.sql.Date(end)+",'Открытие страницы Вклады');");

        begin = System.currentTimeMillis();
        mySteps.changeDepositPage();
        if(connect) connection.execute("INSERT INTO autotestlog(begin_time,end_time, step_name) " +
                "VALUES("+new java.sql.Date(begin)+","+new java.sql.Date(end)+",'Выолнены изменения на Cтранице Вклады');");

        if(connect) connection.quit();
    }

    @Test
    public void testRenCreditCard() throws InterruptedException {
        driver.get("https://www.rencredit.ru/");
        mainPage = new MainPage(driver);
        MainSteps mySteps = new MainSteps(driver, mainPage);
        getDriver().get("https://www.rencredit.ru/");
        mySteps.goToCardsPage();
        mySteps.goRequestNewCardPage();
        mySteps.fillFormrequest();
    }

    //@AfterClass
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

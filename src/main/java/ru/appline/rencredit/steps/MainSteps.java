package ru.appline.rencredit.steps;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.appline.rencredit.pages.CardsPage;
import ru.appline.rencredit.pages.DepositPage;
import ru.appline.rencredit.pages.MainPage;
import ru.appline.rencredit.pages.RequestNewCardPage;

public class MainSteps {
    WebDriver driver;
    MainPage mainPage;
    DepositPage depositPage;
    CardsPage cardsPage;
    RequestNewCardPage requestNewCardPage;

    public MainSteps(WebDriver driver, MainPage mainPage) {
        this.driver = driver;
        this.mainPage = mainPage;
        PageFactory.initElements(driver, this);
    }

    @Epic("Проверка страницы 'Вклады'")
    @Step("выполнен переход на страницу 'Вклады'")
    public DepositPage goToDepositPage() throws InterruptedException {
        depositPage = mainPage.goToDepositPage();
        return depositPage;
    }

    @Epic("Проверка страницы 'Вклады'")
    @Step("Внесены изменения на странице 'Вклады'")
    public void changeDepositPage() throws InterruptedException {
        depositPage.changeDepositPage();
    }

    @Epic("Проверка страницы 'Карты'")
    @Step("Выполнен переход на страницу 'Карты'")
    public CardsPage goToCardsPage() {
        cardsPage = mainPage.goToCardsPage();
        return cardsPage;
    }

    @Epic("Проверка страницы 'Карты'")
    @Step("Выполнен переход на страницу оформления карты")
    public RequestNewCardPage goRequestNewCardPage() {
        requestNewCardPage = cardsPage.goToRequestNewCardPage();
        return requestNewCardPage;
    }

    @Epic("Проверка страницы 'Карты'")
    @Step("Внесены изменения на странице 'Заявка на получение карты'")
    public void fillFormrequest() throws InterruptedException {
        requestNewCardPage.fillFormRequest("Тест","Тестовый","Тестович","9995555555",328 );
    }
}

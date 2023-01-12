package pageObject;

import basic.Registration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;

    //Кнопка "Войти в аккаунт
    private final By enterAccountButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    //Кнопка "Войти в аккаунт"
    private final By personalRoomButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    //Кнопка "Конструктор"
    private final By constructionButton = By.xpath(".//p[text() = 'Конструктор']");

    //Кнопка "Оформить заказ"
    private final By takeOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    //Текст "Соберите бургер"
    private final By makeBurgerText = By.xpath(".//h1[text() = 'Соберите бургер']");

    //Логотип "Stellar burger"
    private final By clickLogo = By.className("AppHeader_header__logo__2D0X2");

    //Ссылка на "Булки"
    private final By linkBuns = By.xpath(".//span[text() = 'Булки']");

    //h2 "Булки"
    private final By textBuns = By.xpath(".//h2[text() = 'Булки']");

    //Ссылка на "Соусы"
    private final By linkSouse = By.xpath(".//span[text() = 'Соусы']");

    //h2 "Cоусы"
    private final By textSouse = By.xpath(".//h2[text() = 'Соусы']");

    //Ссылка на "Начинки"
    private final By linkFills = By.xpath(".//span[text() = 'Начинки']");

    //h2 "Cоусы"
    private final By textFills = By.xpath(".//h2[text() = 'Начинки']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEnterAccountButton() {
        driver.findElement(enterAccountButton).click();
    }

    public void clickPersonalRoomButton() {
        driver.findElement(personalRoomButton).click();
    }

    public void clickConstructionButton() {
        driver.findElement(constructionButton).click();
    }

    public boolean takeOrderButtonIsDisplayed() {
        return driver.findElement(takeOrderButton).isDisplayed();
    }

    public boolean makeBurgerTextIsDisplayed() {
        return driver.findElement(makeBurgerText).isDisplayed();
    }

    public void clickLogo() {
        driver.findElement(clickLogo).click();
    }

    public void clickLinkBuns() {
        driver.findElement(linkBuns).click();
    }

    public void clickLinkSouse() {
        driver.findElement(linkSouse).click();
    }

    public void clickLinkFills() {
        driver.findElement(linkFills).click();
    }

    public boolean textBunsIsDisplayed() {
        return driver.findElement(textBuns).isDisplayed();
    }

    public boolean textSouseIsDisplayed() {
        return driver.findElement(textSouse).isDisplayed();
    }

    public boolean textFillsIsDisplayed() {
        return driver.findElement(textFills).isDisplayed();
    }

}




package tests;

import basic.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import pageObject.*;

import java.util.concurrent.TimeUnit;

public class PersonalRoomTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private PersonalRoomPage personalRoomPage;
    Duration duration;

    @Before

    public void setPropAndStartBrowser() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/Program Files/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        personalRoomPage = new PersonalRoomPage(driver);

    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void checkEnterPersonalRoomTest() {
        homePage.clickEnterAccountButton();

        loginPage.WaitForLoadPage();
        Login login = new Login("lkj2@mail.ru", "qqwwert");
        loginPage.fillLoginForm(login);
        loginPage.clickButtonEnter();
        homePage.clickPersonalRoomButton();

        Assert.assertTrue(personalRoomPage.exitButtonIsDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на Конструктор")
    public void checkGoToConstructorByClickConstructorTest() {
        homePage.clickPersonalRoomButton();
        personalRoomPage.clickConstructionButton();

        Assert.assertTrue(homePage.makeBurgerTextIsDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void checkGoToConstructorByClickLogoTest() {
        homePage.clickPersonalRoomButton();
        homePage.clickLogo();

        Assert.assertTrue(homePage.makeBurgerTextIsDisplayed());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void checkExitFromPersonalRoomTest() {
        homePage.clickEnterAccountButton();

        loginPage.WaitForLoadPage();
        Login login = new Login("lkj2@mail.ru", "qqwwert");
        loginPage.fillLoginForm(login);
        loginPage.clickButtonEnter();
        homePage.clickPersonalRoomButton();
        personalRoomPage.clickExitButton();

        Assert.assertTrue(loginPage.enterButtonIsDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}



package tests;

import basic.Login;
import basic.Registration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegistrationPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private Registration registration;

    @Before

    public void setPropAndStartBrowser() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/Program Files/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(HomePage.URL);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void checkSuccessfulRegistrationTest() {
        homePage.clickEnterAccountButton();
        loginPage.clickLinkRegister();
        registration = new Registration("Лера", "tyop2@mail.ru", "qqwwert");
        registrationPage.fillRegistrationForm(registration);
        registrationPage.clickRegisteredButton();

        loginPage.WaitForLoadPage();
        Login login = new Login("tyop2@mail.ru", "qqwwert");
        loginPage.fillLoginForm(login);
        loginPage.WaitForLoadPage();
        loginPage.clickButtonEnter();

        Assert.assertTrue(homePage.takeOrderButtonIsDisplayed());

    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void checkInvalidPasswordTest() {
        homePage.clickEnterAccountButton();
        loginPage.clickLinkRegister();

        registration = new Registration("Лера", "sdf2@mail.ru", "123");
        registrationPage.fillRegistrationForm(registration);
        registrationPage.clickRegisteredButton();

        Assert.assertTrue(registrationPage.invalidPasswordMessageIsDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}




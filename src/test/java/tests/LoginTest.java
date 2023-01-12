package tests;

import basic.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import pageObject.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private RestorePasswordPage restorePasswordPage;

    @Before

    public void setPropAndStartBrowser() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/Program Files/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);

    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void checkLoginEnterAccountButtonTest() {
        homePage.clickEnterAccountButton();

        loginPage.WaitForLoadPage();
        Login login = new Login("lkj2@mail.ru", "qqwwert");
        loginPage.fillLoginForm(login);
        loginPage.clickButtonEnter();

        Assert.assertTrue(homePage.takeOrderButtonIsDisplayed());

    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void checkLoginPersonalRoomButtonTest() {
        homePage.clickPersonalRoomButton();

        loginPage.WaitForLoadPage();
        Login login = new Login("lkj2@mail.ru", "qqwwert");
        loginPage.fillLoginForm(login);
        loginPage.clickButtonEnter();

        Assert.assertTrue(homePage.takeOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void checkLoginRegistrationFormTest() {
        homePage.clickEnterAccountButton();
        loginPage.clickLinkRegister();
        registrationPage.clickLinkEnter();

        loginPage.WaitForLoadPage();
        Login login = new Login("lkj2@mail.ru", "qqwwert");
        loginPage.fillLoginForm(login);
        loginPage.clickButtonEnter();

        Assert.assertTrue(homePage.takeOrderButtonIsDisplayed());

    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля.")
    public void checkLoginRestorePasswordPageTest() {
        homePage.clickEnterAccountButton();
        loginPage.clickLinkRestorePassword();
        restorePasswordPage.clickLinkEnter();

        loginPage.WaitForLoadPage();
        Login login = new Login("lkj2@mail.ru", "qqwwert");
        loginPage.fillLoginForm(login);
        loginPage.clickButtonEnter();

        Assert.assertTrue(homePage.takeOrderButtonIsDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

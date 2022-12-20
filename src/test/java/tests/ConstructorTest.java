package tests;
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

public class ConstructorTest {
    private WebDriver driver;
    private HomePage homePage;


    @Before
    public void setPropAndStartBrowser() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/Program Files/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);

    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void goToFillsTest() {
        homePage.clickLinkFills();
        Assert.assertTrue(homePage.textFillsIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void goToSouseTest() {
        homePage.clickLinkSouse();
        Assert.assertTrue(homePage.textSouseIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void goToBunsTest() {
        homePage.clickLinkSouse();
        homePage.clickLinkBuns();
        Assert.assertTrue(homePage.textBunsIsDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}

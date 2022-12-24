package pageObject;

import basic.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;


    //Поле "Email"By.name("name");
    private final By emailField = By.xpath(".//fieldset[1]/div/div/input");

    //Поле "Пароль"
    private final By passwordField = By.xpath(".//fieldset[2]/div/div/input");

    //Кнопка "Войти"
    private final By enterButton = By.xpath(".//button[text()='Войти']");

    //Ссылка  "Зарегистрироваться"
    protected final By linkRegistration = By.linkText("Зарегистрироваться");

    //Ссылка "Восстановить пароль"
    private final By linkRestorePassword = By.xpath(".//a[text()='Восстановить пароль']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLoginForm(Login login) {
        clickEmailField();
        fillEmailField(login.getEmail());
        fillPasswordField(login.getPassword());
    }

    public void WaitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedConditions.visibilityOfElementLocated(enterButton);
    }

    public void clickEmailField() {
        driver.findElement(emailField).click();
    }


    public void fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickButtonEnter() {
        driver.findElement(enterButton).click();
    }

    public void clickLinkRegister() {
        driver.findElement(linkRegistration).click();
    }

    public void clickLinkRestorePassword() {
        driver.findElement(linkRestorePassword).click();
    }

    public boolean enterButtonIsDisplayed() {
        return driver.findElement(enterButton).isDisplayed();
    }

}

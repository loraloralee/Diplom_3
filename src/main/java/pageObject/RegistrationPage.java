package pageObject;

import basic.Registration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;

    //Поле "Имя"
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input");

    //Поле "Email"
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");

    //Поле "Пароль"
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input");

    //Кнопка "Зарегистрироваться"
    private final By registeredButton = By.xpath(".//button[text()='Зарегистрироваться']");

    //Ссылка "Войти"
    private final By linkEnter = By.xpath(".//a[text()='Войти']");

    // Текст "Некорректный пароль"
    private final By invalidPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillRegistrationForm(Registration registration) {
        fillNameField(registration.getName());
        fillEmailField(registration.getEmail());
        fillPasswordField(registration.getPassword());
    }

    public void fillNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisteredButton() {
        driver.findElement(registeredButton).click();
    }

    public void clickLinkEnter() {
        driver.findElement(linkEnter).click();
    }

    public boolean invalidPasswordMessageIsDisplayed() {
        return driver.findElement(invalidPasswordMessage).isDisplayed();
    }

}
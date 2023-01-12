package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {
    private final WebDriver driver;

    //Ссылка "Войти"
    private final By linkEnter = By.xpath(".//a[text()='Войти']");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickLinkEnter(){
        driver.findElement(linkEnter).click();
    }
}

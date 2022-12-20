package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalRoomPage {

    private final WebDriver driver;

    //Кнопка "Выход"
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    //Кнопка "Конструктор"
    private final By constructionButton = By.xpath(".//p[text() = 'Конструктор']");

    public PersonalRoomPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }

    public void clickConstructionButton(){
        driver.findElement(constructionButton).click();
    }

    public boolean exitButtonIsDisplayed() {
        return driver.findElement(exitButton).isDisplayed();
    }
}

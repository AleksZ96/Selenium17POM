package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public WebDriver driver;
    public WebDriverWait wait;
    WebElement message;
    WebElement logoutButton;

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getMessage() {
        return driver.findElement(By.className("has-text-align-center"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.linkText("Log out"));
    }

    //--------------------------

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }

    public String messageText() {
        return getMessage().getText();
    }
}

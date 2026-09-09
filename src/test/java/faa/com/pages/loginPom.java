package faa.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPom {
    WebDriver driver;
    By username = By.id("user-name");
    By password = By.id("password");
    By login_button = By.id("login-button");
    By error_message = By.cssSelector("[data-test=\"error\"]");

    public loginPom(WebDriver driver){
        this.driver = driver; 
    }

    public void EnterUsername(String u) {
        driver.findElement(username).sendKeys(u);
    }
    public void EnterPassword(String u) {
        driver.findElement(password).sendKeys(u);
    }
    public void ClickLogin() {
        driver.findElement(login_button).click();
    }
    public String getErrorText(){
        return driver.findElement(this.error_message).getText();
    }
}


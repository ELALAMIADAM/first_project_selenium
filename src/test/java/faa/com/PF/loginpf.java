package faa.com.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpf {
    WebDriver driver;
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login_botton;

    @FindBy(css = "[data-test=\"error\"]")
    private WebElement error_message;

    public loginpf(WebDriver driver){
        this.driver=driver;
    }

    

}

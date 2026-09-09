package faa.com.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        PageFactory.initElements(driver, this);
    }

    public void EnterUsername(String u){
        username.sendKeys(u);
    }

    public void EnterPassword(String u){
        password.sendKeys(u);
    }

    public void ClickButtonLogin(){
        login_botton.click();
    }
    public String getErrorMessage(){
        return error_message.getText();
    }
    public void Login(String u, String p ){
        EnterUsername(u);
        EnterPassword(p);
        ClickButtonLogin();
    }

}

package faa.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import faa.com.pages.loginPom;


public class loginWithPOMTest  {
    WebDriver driver;
    loginPom lp;
    @BeforeEach 
    public void setUp(){
        driver = new ChromeDriver();
        lp = new loginPom(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach 
    public void tearDown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    @Test 
    public void loginValid(){
        lp.EnterUsername("standard_user");
        lp.EnterPassword("secret_sauce");
        lp.ClickLogin();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test 
    public void loginInvalid(){
        lp.EnterUsername("standard_user_fake");
        lp.EnterPassword("secret_sauce");
        lp.ClickLogin();
        assertTrue(lp.getErrorText().contains("Username and password do not match any user in this service"));
    }
}

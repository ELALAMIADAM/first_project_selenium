package faa.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import faa.com.PF.loginpf;

public class loginpfTest {
    WebDriver driver;
    loginpf lp;
    @BeforeEach 
    public void setUp(){
        driver = new ChromeDriver();
        lp = new loginpf(driver);
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
        lp.Login("standard_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test 
    public void loginInvalid(){
        lp.Login("standard_user_fake", "secret_sauce");
        assertTrue(lp.getErrorMessage().contains("Username and password do not match any user in this service"));
    }
}

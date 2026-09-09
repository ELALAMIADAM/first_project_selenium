package faa.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import faa.com.pages.loginPom;

public class loginpomcsvTest {
    WebDriver driver;
    loginPom lp;
    // String username,password,result;
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

    @ParameterizedTest 
    @CsvFileSource(resources = "/dataValid.csv",numLinesToSkip = 1)
    public void loginwithCsvAndPomValid(String username, String password, String result){
        lp.EnterUsername(username);
        lp.EnterPassword(password);
        lp.ClickLogin();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @ParameterizedTest 
    @CsvFileSource(resources = "/dataInvalid.csv",numLinesToSkip = 1)
    public void loginwithCsvAndPomInvalid(String username, String password, String result){
        lp.EnterUsername(username);
        lp.EnterPassword(password);
        lp.ClickLogin();
        assertTrue(lp.getErrorText().contains("Username and password do not match any user in this service"));
    }

}

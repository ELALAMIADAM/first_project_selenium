package faa.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class gridTest {
    WebDriver driver;
    @BeforeEach 
    public void setUp(){
        String nav = System.getProperty("browser", "chrome");
        switch (nav) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "grid":
                URL gridUrl = null;
                try {
                    gridUrl = new URL("http://127.1.0.1:4444");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                ChromeOptions cho = new ChromeOptions();
                FirefoxOptions ffo = new FirefoxOptions();
                EdgeOptions edo = new EdgeOptions();
                driver = new RemoteWebDriver(gridUrl, ffo);
                driver = new RemoteWebDriver(gridUrl, ffo);
                driver = new RemoteWebDriver(gridUrl, ffo);
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
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
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

    }
    @Test 
    public void loginInvalid(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user_fake");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String var = driver.findElement(By.cssSelector("[data-test=\"error\"]")).getText();
        assertTrue(var.contains("Epic sadface: Username and password do not match any user in this service"));

    }
}

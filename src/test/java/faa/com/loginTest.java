package faa.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginTest {
    WebDriver driver;
    @BeforeEach 
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        // driver = new ChromeDriver();
        // driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        // driver.findElement(By.id("login-button")).click();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        // driver.quit();
    }
    @Test 
    public void loginInvalid(){
        // driver = new ChromeDriver();
        // driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user_fake");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String var = driver.findElement(By.cssSelector("[data-test=\"error\"]")).getText();
        // assertTrue(driver.findElement(By.cssSelector("[data-test=\"error\"]")).isDisplayed());
        // assertEquals("Epic sadface: Username and password do not match any user in this service", var);
        assertTrue(var.contains("Epic sadface: Username and password do not match any user in this service"));
        // driver.quit();
    }
}

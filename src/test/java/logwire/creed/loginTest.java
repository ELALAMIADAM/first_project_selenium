package logwire.creed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {
    WebDriver driver;
    @Test 
    public void loginValid(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        driver.quit();
    }
    @Test 
    public void loginInvalid(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user_fake");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String var = driver.findElement(By.cssSelector("[data-test=\"error\"]")).getText();
        // assertTrue(driver.findElement(By.cssSelector("[data-test=\"error\"]")).isDisplayed());
        // assertEquals("Epic sadface: Username and password do not match any user in this service", var);
        assertTrue(var.contains("Epic sadface: Username and password do not match any user in this service"));
        driver.quit();
    }
}

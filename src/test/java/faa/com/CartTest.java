package faa.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {
    WebDriver driver;
    @BeforeEach 
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    @AfterEach 
    public void tearDown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void CartTest(){
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        assertTrue(driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed());
        String var = driver.findElement(By.cssSelector("[data-test=\"shopping-cart-badge\"]")).getText();
        assertEquals("1", var);
        driver.findElement(By.cssSelector("[data-test=\"shopping-cart-link\"]")).click();
        assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
        
    } 


}

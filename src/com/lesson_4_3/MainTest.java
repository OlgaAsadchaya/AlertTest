package com.lesson_4_3;

import static org.junit.Assert.*;
import org.junit.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    WebDriver driver;

    @org.junit.Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void alertTest() {
        WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Alert')]"));
        button.click();
        try{
            Alert alert = driver.switchTo().alert();
            String textOnAlert = alert.getText();
            assertEquals("I am a JS Alert",textOnAlert);
            alert.accept();
            WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
            String a = result.getText();
            assertEquals("You successfuly clicked an alert",a);
        }
        catch (NoAlertPresentException e)
        {
            e.printStackTrace();
        }

    }
    @Test
    public void confirmTest() {
        WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Confirm')]"));
        button.click();
        try{
            Alert alert = driver.switchTo().alert();
            String textOnAlert = alert.getText();
            assertEquals("I am a JS Confirm",textOnAlert);
            alert.accept();
            WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
            String a = result.getText();
            assertEquals("You clicked: Ok",a);
        }
        catch (NoAlertPresentException e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public void promtTest() {
        WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Prompt')]"));
        button.click();
        try{
            Alert alert = driver.switchTo().alert();
            String textOnAlert = alert.getText();
            assertEquals("I am a JS prompt",textOnAlert);
            alert.sendKeys("Test");
            alert.accept();
            WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
            String a = result.getText();
            assertEquals("You entered: Test",a);
        }
        catch (NoAlertPresentException e)
        {
            e.printStackTrace();
        }
    }
}
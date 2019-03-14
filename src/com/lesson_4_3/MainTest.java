package com.lesson_4_3;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void alertTest() {
        WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Alert')]"));
        button.click();

        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        assertEquals("I am a JS Alert", textOnAlert);
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String resultText = result.getText();
        assertEquals("You successfuly clicked an alert", resultText);
    }

    @Test
    public void confirmTest() {
        WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Confirm')]"));
        button.click();

        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        assertEquals("I am a JS Confirm", textOnAlert);
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String resultText = result.getText();
        assertEquals("You clicked: Ok", resultText);
    }
    @Test
    public void promtTest() {
        WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Prompt')]"));
        button.click();

        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        assertEquals("I am a JS prompt", textOnAlert);
        alert.sendKeys("Test");
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String resultText = result.getText();
        assertEquals("You entered: Test", resultText);
    }
}
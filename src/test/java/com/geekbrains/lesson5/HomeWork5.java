package com.geekbrains.lesson5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeWork5 {
    WebDriver driver;
    WebDriverWait webDriverWait;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://auto.mail.ru/");
    }

    @Test
    void likeRandomBuy() throws InterruptedException {

     //   Thread.sleep(5000);
        List<WebElement> buylist;
        driver.findElement(By.xpath("//a[.='Каталог марок']")).click();
        driver.findElement(By.xpath("(//a[@href='/catalog/audi/'])[1]")).click();
        driver.findElement(By.xpath("(//a[@href='/catalog/audi/a8/d5/sedan/'])[1]")).click();
        driver.findElement(By.xpath("(//a[@class='text text_bold_medium'])[1]")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("modification_id"));
    }

    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();
        // window.localStorage.clear();
        driver.quit();
    }

}

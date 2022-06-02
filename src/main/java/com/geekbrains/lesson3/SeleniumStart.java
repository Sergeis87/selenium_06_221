package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebDriverManager.firefoxdriver().setup();
        WebDriver ffDriver = new FirefoxDriver();
        ffDriver.get("https://ya.ru");
        Thread.sleep(5000);

        ffDriver.quit();
        driver.quit();
    }
}

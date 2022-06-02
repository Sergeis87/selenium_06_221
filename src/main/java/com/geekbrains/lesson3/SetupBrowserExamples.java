package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        //chromeOptions.addArguments("--headless");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://google.com");

        ((JavascriptExecutor)webDriver).executeScript("window.alert(\"Hello world!\");");
        //let element = document.evaluate("//span[contains(.,'Starting Selenium')]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)
       // element.singleNodeValue.remove()
        Thread.sleep(2000);
        webDriver.switchTo().alert().accept();

        webDriver.switchTo().newWindow(WindowType.TAB);
        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));

        webDriver.get("https://ya.ru");
        Thread.sleep(5000);
        webDriver.close();

        Thread.sleep(5000);
        webDriver.quit();
    }
}

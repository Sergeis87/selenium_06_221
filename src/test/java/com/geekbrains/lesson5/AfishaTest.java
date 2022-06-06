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

public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    //div[@data-test='PAGE-SECTION-HEADER' and contains(.,'Кино')]
    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.afisha.ru/");
    }

    @Test
    void likeRandomMovie() throws InterruptedException {
        List<WebElement> filmslist = driver.findElements(
                By.xpath("//div[@data-test='PAGE-SECTION-HEADER' and contains(.,'Кино')]/following-sibling::div" +
                        "//a[@data-test='LINK ITEM-URL']"));

        //  filmslist.stream().filter(f -> f.getText().contains("Эскортницы")).findFirst().get().click();
        filmslist.get(1).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']" +
                "//button[@data-test='BUTTON FAVORITE']")));
        driver.findElement(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']" +
                "//button[@data-test='BUTTON FAVORITE']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'login')]")));
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("login")));
        Assertions.assertTrue(driver.findElement(By.id("login")).isDisplayed());


    }

    @Test
    void clickToOkkoLink() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(By.xpath("//a[.='КИНО']")))
                .build()
                .perform();
        driver.findElement(By.xpath("//div[@data-test='SUGGEST']//a[.='Скоро онлайн в Okko']")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("okko-soon"));
       // Thread.sleep(5000);
    }


    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();
        // window.localStorage.clear();
        driver.quit();
    }
}


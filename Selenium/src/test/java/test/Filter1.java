package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class Filter1 {
    public static void Filter1() {

        WebDriver driver = driverFactory.getChromeDriver();
        try {
            int scc = 0;
            driver.get("https://thegioitraicay.net/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            scc ++;
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png = ("D:\\image\\filter-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            WebElement nav = driver.findElement(By.cssSelector(".nav-item.has-mega a.nav-link"));
            nav.click();

            scc ++;
             srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             png = ("D:\\image\\filter-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            WebElement filter = driver.findElement(By.xpath("/html/body/div[2]/div/aside/div[1]/div/aside[2]/div[2]/ul/li[1]/span/label"));
            filter.click();

            scc ++;
             srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             png = ("D:\\image\\filter-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            Thread.sleep( 5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
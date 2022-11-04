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
public class TimKiem {
    public static void TimKiem() {

        WebDriver driver = driverFactory.getChromeDriver();
        try {
int scc=0;
            driver.get("https://thegioitraicay.net/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            scc ++;
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png = ("D:\\image\\search-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            WebElement search = driver.findElement(By.cssSelector("input.input-group-field.st-default-search-input.search-text.auto-search"));
            search.sendKeys("Xoai");

            scc ++;
             srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             png = ("D:\\image\\search-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            WebElement confirm = driver.findElement(By.xpath("/html/body/header/nav/div/div[1]/div/div/form/span/button"));
            confirm.click();

            scc ++;
             srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             png = ("D:\\image\\search-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            Thread.sleep( 5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
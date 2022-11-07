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
public class ThemGioHang {
    public static void ThemGioHang() {

        WebDriver driver = driverFactory.getChromeDriver();
        try {
            int scc =0;
            driver.get("https://thegioitraicay.net/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement nav = driver.findElement(By.cssSelector(".nav-item.has-mega a.nav-link"));
            nav.click();

            scc ++;
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String png = ("D:\\image\\them-" + scc + ".png");
            String png = ("E:\\ITC\\HK4\\SoftwareTesting\\pratice\\DACK-7\\Selenium\\image_demo\\them-" + scc + ".png");

            FileHandler.copy(srcFile, new File(png));

            WebElement view = driver.findElement(By.xpath("/html/body/div[2]/div/section/div[2]/section/div[1]/div[1]/div/div[2]/h3/a"));
            view.click();

            scc ++;
             srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             png = ("E:\\ITC\\HK4\\SoftwareTesting\\pratice\\DACK-7\\Selenium\\image_demo\\them-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            WebElement add = driver.findElement(By.xpath("//*[@id=\"add-to-cart-form\"]/div[2]/button"));
            add.click();

            scc ++;
             srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             png = ("E:\\ITC\\HK4\\SoftwareTesting\\pratice\\DACK-7\\Selenium\\image_demo\\them-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            Thread.sleep( 5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
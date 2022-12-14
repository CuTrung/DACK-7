package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class DangNhap {
    public static void DangNhap() {

        WebDriver driver = driverFactory.getChromeDriver();
        try {
            int scc = 0;
            String emailTxt = "test@gmail.com";
            String passTxt = "thisIsPass";
            //1. Dang Nhap
            driver.get("https://thegioitraicay.net/account/login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement email = driver.findElement(By.cssSelector(".form-group input[type='email']"));
            WebElement pass = driver.findElement(By.cssSelector(".form-group input[type='password']"));

            email.sendKeys(emailTxt);
            pass.sendKeys(passTxt);

            scc ++;
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String png = ("D:\\image\\dangnhap-" + scc + ".png");
            String png = ("E:\\ITC\\HK4\\SoftwareTesting\\pratice\\DACK-7\\Selenium\\image_demo\\dangnhap-" + scc + ".png");

            FileHandler.copy(srcFile, new File(png));

            WebElement login = driver.findElement(By.cssSelector(".pull-xs-left .btn.btn-primary"));
            login.click();

            scc ++;
            srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            png = ("E:\\ITC\\HK4\\SoftwareTesting\\pratice\\DACK-7\\Selenium\\image_demo\\dangnhap-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
    public void scrLk(){

    }
}
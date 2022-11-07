package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class DangKy {
    public static void DangKy() {

        WebDriver driver = driverFactory.getChromeDriver();
        try {
            int scc = 0;
            String emailTxt = "10344@gmail.com";
            String passTxt = "thisIsPass";
            String fNameTxt = "Test";
            String lNameTxt = "Test";
            //1. Truy cap website
            driver.get("https://thegioitraicay.net/account/register");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            //2. Dien Thong Tin
            WebElement lName = driver.findElement(By.cssSelector(".form-group input#lastName"));
            WebElement fName = driver.findElement(By.cssSelector(".form-group input#firstName"));
            WebElement email = driver.findElement(By.cssSelector(".form-group input#email"));
            WebElement pass = driver.findElement(By.cssSelector(".form-group input#password"));

            
            email.sendKeys(emailTxt);
            pass.sendKeys(passTxt);
            lName.sendKeys(lNameTxt);
            fName.sendKeys(fNameTxt);

            scc ++;
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\ITC\\HK4\\SoftwareTesting\\pratice\\DACK-7\\Selenium\\image_demo\\dangky-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            //3. Xac Nhan 
            WebElement Signup = driver.findElement(By.cssSelector("button[value='Đăng ký']"));
            Signup.click();

            scc ++;
            srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            png = ("D:\\image\\dangky-" + scc + ".png");
            // image_demo
            png = ("E:\\ITC\\HK4\\SoftwareTesting\\pratice\\DACK-7\\Selenium\\image_demo\\dangky-" + scc + ".png");
            FileHandler.copy(srcFile, new File(png));

            Thread.sleep( 5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
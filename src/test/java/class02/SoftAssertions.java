package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertions {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void launchTheWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //First test case with 2 assertions
    @Test(groups ="regression")
    public void invalidCredentials() {
        //username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
//        password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("abracadabra");
//        login
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
//        invalid credentials
        WebElement errorMSG = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String ActualErrorMsg = errorMSG.getText();
        String ExpectedErrorMsg = "Invalid credentials";//removing an s will fail this assertion but will continue to run tests

        //What to do when you want to continue test assertions even if one fails-> Call it from a class SoftAssert.
        SoftAssert softAssert=new SoftAssert();//declare the instance and call it as SoftAssert not Assert.
        softAssert.assertEquals(ActualErrorMsg,ExpectedErrorMsg);
//sout to check if all assertions run
        System.out.println("Test after first assertion");
        //2nd assertions: Check if error message is displayed
        boolean isdisplayed=errorMSG.isDisplayed();
        //assertion
        softAssert.assertTrue(isdisplayed);

        //assert all the assertions that have been made
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}

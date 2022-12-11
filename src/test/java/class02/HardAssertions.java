package class02;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HardAssertions {
    //HardAssertions are assertions where the first assertion has to pass in order for the next one to run.
    // If assertion failes, it will stop testing and sends it as fail.
   //Task: Verify the text of element
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    //First test case with 2 assertions
    @Test(groups="regression")
    public void invalidCredentials(){
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
        String ExpectedErrorMsg="Invalid credentials";//removing an s will fail this assertion and the next assertion wont run.

//   Assertion is used instead of if-condition because it's more reliable answer to confirm.
        //Asserting two strings from internet and in our website?
        Assert.assertEquals(ActualErrorMsg,ExpectedErrorMsg);
        System.out.println("first assertion");

        //Confirming that error message is displayed..
        boolean isDisplayed=errorMSG.isDisplayed();
       // System.out.println(isDisplayed);
        //Need to use assertion instead since we're asserting
        Assert.assertTrue(isDisplayed);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}

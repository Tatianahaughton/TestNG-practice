package annotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestAnnotation {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("i am before suit");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("i am after suit");
    }

    @BeforeTest
    public void BT() {
        System.out.println("i am before test");
    }

    @AfterTest
    public void AT() {
        System.out.println("i am after test");}
}
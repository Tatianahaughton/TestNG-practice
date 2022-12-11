package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAnnotations {
    //Cases executed in ascending/alphabetical order
    @Test
    public void AfirstTestCase() {
        System.out.println("This is the first test case");
    }
        @Test
        public void BsecondTestCase() {
            System.out.println("This is the second test case");
        }

        @Test
    public void thirdTestCase(){
            System.out.println("Third method");
        }
        @Test
        public void fourthTestCase(){
            System.out.println("Fourth method");
        }
        @BeforeMethod
    public void beforeMethod() {
            System.out.println("This is @BeforeMethod");//will run before each @Test methods
        }

        @AfterMethod
    public void afterMethod() {
            System.out.println("This is @AfterMethod");
        }
    }


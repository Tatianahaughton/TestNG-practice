package class01;

import org.testng.annotations.Test;

public class Priority {
    //Assigning priority of order of execution
    @Test(priority = 3,groups = "regression")
    public void Atest() {
        System.out.println("I am an A test");
    }

    @Test(priority = 1)
    public void Btest() {
        System.out.println("I am an B test");
    }

    @Test(priority = 2)
    public void Ctest() {
        System.out.println("I am an C test");
    }
    @Test//no priority assigned=priority=0 by default
    public void Dtest() {
        System.out.println("I am an D test");
    }

    @Test//no priority assigned to more than one case=priority=0 goes in ascending order again
    public void ABtest() {
        System.out.println("I am an AB test");
    }

}

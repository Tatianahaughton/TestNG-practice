package class01;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void LogIn() {
        //System.out.println("i");passes it
        System.out.println(6/0);
    }
//DependsOn another method of the same class first//Will execute only after the case it depends on passes
    @Test(dependsOnMethods = {"LogIn"})
    public void DashBoardVerification() {
        System.out.println("After login in,we're verifying the dashboard");
    }
}

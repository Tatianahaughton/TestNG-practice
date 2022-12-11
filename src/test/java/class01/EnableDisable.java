package class01;

import org.testng.annotations.Test;

public class EnableDisable {
    @Test(enabled = false)//to disable a test case from running
    public void Atest(){
        System.out.println("I am an A test");
    }
    @Test
    public void Btest(){
        System.out.println("I am a B test");
    }

    @Test(enabled = false)//Default=true
    public void Ctest(){
        System.out.println("I am a B test");
    }

}

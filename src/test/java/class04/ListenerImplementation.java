package class04;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test passed"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed "+result.getName());
    }
}

package Softude.Hyperlocology.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int i=0;
	int maxTry=1;
	@Override
	public boolean retry(ITestResult result) {
        if(i<maxTry) {
        	i++;
           return true;
        }
		return false;
	}

}

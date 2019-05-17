package Testscript;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;

public class StandardOrder2 extends DriverTestcase {	
	

@Test(dataProviderClass=DataReader.class,dataProvider="NewStandrdOrder")
public void EndtoEndOrdertest(Object[][] Data) throws Exception
{
	Login.get().Docusign("http://yopmail.com");
	
	
}


}

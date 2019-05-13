package Testscript;
import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;


public class StandardOrder extends DriverTestcase {	
	
@Test(dataProviderClass=DataReader.class,dataProvider="NewStandrdOrder")
	public void EndtoEndOrder(Object[] Data) throws Exception
	{
		//ExtentTestManager.getTest().setDescription("Login Into C4C");
		Login.get().Login("C4C");
		
		C4Chelper.get().Movetoaccount(Data);
		C4Chelper.get().MovetoOpportunuity(Data);
		//Thread.sleep(3000);
		C4Chelper.get().AddQuote();
		Configurationhelper.get().AddProduct(Data);
		GenralInfohelper.get().GenralInfomration(Data);
		BCNupdatehelper.get().BCNUpdate(Data);
		DisscountAndAprrovalhelper.get().DisscountandApprove(Data);
		SendProposalhelper.get().CustomerSign(Data);
		Orderinghelper.get().CreateOrder(Data);
		
	}


}

package Testscript;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;

public class StandardOrderOnnet extends DriverTestcase {	
	
@Test(dataProviderClass=DataReader.class,dataProvider="NewStandrdOrder")
	public void EndtoEndOrder(Object[][] Data) throws Exception
	{
		//ExtentTestManager.getTest().setDescription("Login Into C4C");
	
		Login.get().Login("C4C");
		
		C4Chelper.get().Movetoaccount(Data);
		C4Chelper.get().MovetoOpportunuity(Data);
		//C4Chelper.get().EditQuote();
		Thread.sleep(3000);
		C4Chelper.get().AddQuote();
		Configurationhelper.get().AddProduct(Data);
		GenralInfohelper.get().GenralInfomration(Data);
		BCNupdatehelper.get().BCNUpdate(Data);
		//DisscountAndAprrovalhelper.get().DisscountandApprove(Data);
		if(Data[0][21].toString().contains("Quote Level")){
			DisscountAndAprrovalhelper.get().ApplyDisscountQuotelevel(Data);
			
		}
		else
		{
			DisscountAndAprrovalhelper.get().ApplyDisscountlinelevel(Data);
		}
		DisscountAndAprrovalhelper.get().ApproveQuote(Data);
		SendProposalhelper.get().CustomerSign(Data);
		if(Data[0][24].toString().equals("Email")) {
			Orderinghelper.get().AcceptsQuote(Data);
			Orderinghelper.get().CreateOrder(Data);
		}
		else {
			Orderinghelper.get().AcceptsQuotebyEsignature(Data);
			C4Chelper.get().NavigatetoC4C();
			C4Chelper.get().Movetoaccount(Data);
			C4Chelper.get().MovetoOpportunuity(Data);
			C4Chelper.get().EditQuote();
			C4Chelper.get().CheckdocumentSigned();
			Orderinghelper.get().AcceptsQuote(Data);
			Orderinghelper.get().CreateOrder(Data);
			
//			
	}
			
	//Configurationhelper.get().AddProducttest(Data);
	
		
	}
@Test(dataProviderClass=DataReader.class,dataProvider="NewStandrdOrder")
public void EndtoEndOrdertest(Object[][] Data) throws Exception
{
	Configurationhelper.get().AddProducttest(Data);
	
	
}


}

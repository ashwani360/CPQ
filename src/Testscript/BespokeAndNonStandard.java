package Testscript;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;

public class BespokeAndNonStandard extends DriverTestcase {	
	
@Test(dataProviderClass=DataReader.class,dataProvider="NewStandrdOrder")
	public void EndtoEndOrderOffnet(Object[][] Data) throws Exception
	{
//		//ExtentTestManager.getTest().setDescription("Login Into C4C");
//	
		Login.get().Login("C4C");
//		
		C4Chelper.get().Movetoaccount(Data);
		C4Chelper.get().MovetoOpportunuity(Data);

		C4Chelper.get().EditQuote();
		Thread.sleep(40000);
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
////			
	}
			
	//Configurationhelper.get().AddProducttest(Data);
	
	//Configurationhelper.get().Intercation();
	}
@Test(dataProviderClass=DataReader.class,dataProvider="NewStandrdOrder")
public void EndtoEndOrdertest(Object[][] Data) throws Exception
{
	Configurationhelper.get().AddProducttest(Data);
	
	
}


}

package Testscript;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;
import ScriptHelper.BespokandNonStandard;

public class StandardOrderOnnet extends DriverTestcase {	
	
@Test(dataProviderClass=DataReader.class,dataProvider="NewStandrdOrder")
	public void EndtoEndOrder(Object[][] Data) throws Exception
	{
		//ExtentTestManager.getTest().setDescription("Login Into C4C");
	
		Login.get().Login("C4C");
		
		C4Chelper.get().Movetoaccount(Data);
		C4Chelper.get().MovetoOpportunuity(Data);
		
		Thread.sleep(3000);
		C4Chelper.get().AddQuote();
		Configurationhelper.get().AddProduct(Data);
		C4Chelper.get().VerifyQuoteStage();
		if(Configurationhelper.get().Quotestatus.get().equals("Waiting for 3rd Party"))
		{
			Explorehelper.get().NavigatetoExplore();
			Explorehelper.get().ExploreWorkflow(Data);
			Login.get().Logout("Explore");
			//Thread.sleep(30000);
			Login.get().Login("ExploreNearNet");
			Explorehelper.get().ExploreWorkflownearnet(Data);
			Login.get().Logout("ExploreNearNet");
			//Thread.sleep(30000);
			Login.get().Login("C4C");
			
			//C4Chelper.get().Movetoaccount(Data);
			//C4Chelper.get().MovetoOpportunuity(Data);
			C4Chelper.get().EditQuote();
			Configurationhelper.get().Reconfigure(Data);
			C4Chelper.get().VerifyQuoteStage();
//			System.out.println("Reoccurane Value currently as:"+Configurationhelper.get().Rerunrequired.get().toString());
			if(Configurationhelper.get().Rerunrequired.get().equals("Yes"))
			{
			Configurationhelper.get().ReconfigureAgain(Data);
			Explorehelper.get().NavigatetoExplore();
			Explorehelper.get().ExploreWorkflow(Data);
			Login.get().Logout("Explore");
			Login.get().Login("ExploreNearNet");
			Explorehelper.get().ExploreWorkflownearnet(Data);
			Login.get().Logout("ExploreNearNet");
			Login.get().Login("C4C");
			
			//C4Chelper.get().Movetoaccount(Data);
			//C4Chelper.get().MovetoOpportunuity(Data);
			C4Chelper.get().EditQuote();
			Configurationhelper.get().Reconfigure(Data);
			C4Chelper.get().VerifyQuoteStage();
			}
		}
		else if(Configurationhelper.get().Quotestatus.get().equals("POA"))
		{
			Configurationhelper.get().POA();
			C4Chelper.get().VerifyQuoteStage();
			}
		else if(Configurationhelper.get().Quotestatus.get().equals("Created"))
		{
			Configurationhelper.get().SEDataupdate(Data);
			C4Chelper.get().VerifyQuoteStage();
			}
		else if(Configurationhelper.get().Quotestatus.get().equals("To be Priced"))
		{
			//Need to write the codeExceptionPPT()
			Configurationhelper.get().ExceptionPPT();
			C4Chelper.get().VerifyQuoteStage();
		}
		// If Stage is waiting for third Party Need to call All the Explore functions
		
		BspokeNonStandard.get().Bespoke(Data);
		GenralInfohelper.get().GenralInfomration(Data);
		
	//Login.get().OpenCPQQuoteDirectly();
	BCNupdatehelper.get().BCNUpdate(Data);
		//DisscountAndAprrovalhelper.get().DisscountandApprove(Data);
		
		
		if(Data[0][21].toString().contains("Quote Level")){
			DisscountAndAprrovalhelper.get().ApplyDisscountQuotelevel(Data);
			
		}
		else if(Data[0][21].toString().contains("Line Level"))
		{
			DisscountAndAprrovalhelper.get().ApplyDisscountlinelevel(Data);
		}
		DisscountAndAprrovalhelper.get().ApproveQuote(Data);
		Configurationhelper.get().SetCurrectQuoteStage();
		C4Chelper.get().VerifyQuoteStage();
		// belowMethods will not call if Quote is not in Aprroved Stage 
		if(Configurationhelper.get().Quotestatus.get().equals("Approved")){
		SendProposalhelper.get().CustomerSign(Data);
		C4Chelper.get().VerifyQuoteStage();
		if(Data[0][24].toString().equals("Email")) {
			Orderinghelper.get().AcceptsQuote(Data);
			C4Chelper.get().VerifyQuoteStage();
			Orderinghelper.get().CreateOrder(Data);
			C4Chelper.get().VerifyQuoteStage();
		}
		else {
			Orderinghelper.get().AcceptsQuotebyEsignature(Data);
			C4Chelper.get().NavigatetoC4C();
			C4Chelper.get().Movetoaccount(Data);
			C4Chelper.get().MovetoOpportunuity(Data);
			C4Chelper.get().EditQuote();
			C4Chelper.get().CheckdocumentSigned();
			C4Chelper.get().VerifyQuoteStage();
			Orderinghelper.get().AcceptsQuote(Data);
			C4Chelper.get().VerifyQuoteStage();
			Orderinghelper.get().CreateOrder(Data);
			C4Chelper.get().VerifyQuoteStage();
			
			}
		
	}
			
	//Configurationhelper.get().AddProducttest(Data);
		Login.get().Login("Siebel");
		Orderinghelper.get().SeibleOrderVerification(Data);
		
	}

@Test(dataProviderClass=DataReader.class,dataProvider="NewStandrdOrder")
public void Testermethod(Object[][] Data) throws Exception
{
	Login.get().Login("ExploreNearNet");
	Login.get().Logout("ExploreNearNet");
}

@Test(dataProviderClass=DataReader.class,dataProvider="NewContainer")
public void EndtoEndOrderContainerNew(Object[][] Data) throws Exception
{
	Login.get().Login("C4C");
	
	C4Chelper.get().Movetoaccount(Data);
	C4Chelper.get().MovetoOpportunuityContainer(Data);
	
	Thread.sleep(3000);
	C4Chelper.get().Product_Add();
	C4Chelper.get().AddContainerQuote();
	ContainerHelper.get().AddContainerProduct(Data);
	C4Chelper.get().VerifyQuoteStage();
	GenralInfohelper.get().GenralInfomration(Data);
	ContainerHelper.get().ContainerApproveQuote();
	if(!Data[0][4].equals("CST")) {
	ContainerHelper.get().ContainerSEApproval();
	C4Chelper.get().VerifyQuoteStage();
	ContainerHelper.get().ContainerCSTApproval(Data);
	C4Chelper.get().VerifyQuoteStage();
}
	else
	{
		ContainerHelper.get().ContainerCSTApproval(Data);
	}
	SendProposalhelper.get().Containerprices(Data);
	SendProposalhelper.get().CustomerSign(Data);
	if(Data[0][24].toString().equals("Email")) {
		Orderinghelper.get().AcceptsQuote(Data);
		ContainerHelper.get().ContainerCreateOrder();
	//	Orderinghelper.get().CreateOrder(Data);
	}
	else {
		Orderinghelper.get().AcceptsQuotebyEsignature(Data);
		C4Chelper.get().NavigatetoC4C();
		C4Chelper.get().Movetoaccount(Data);
		C4Chelper.get().MovetoOpportunuity(Data);
		C4Chelper.get().EditQuote();
		C4Chelper.get().CheckdocumentSigned();
		Orderinghelper.get().AcceptsQuote(Data);
		ContainerHelper.get().ContainerCreateOrder();
		
		}
	
	
}
@Test(dataProviderClass=DataReader.class,dataProvider="Bulkupload")
public void EndtoEndOrderBulkUpload(Object[][] Data) throws Exception
{
	//ExtentTestManager.getTest().setDescription("Login Into C4C");

	Login.get().Login("C4C");
	
	C4Chelper.get().Movetoaccount(Data);
	C4Chelper.get().MovetoOpportunuity(Data);
	
	Thread.sleep(3000);
	C4Chelper.get().AddQuote();
	BulkHelper.get().AddProductWithbulkTemplate(Data);
	if(Configurationhelper.get().Quotestatus.get().equals("POA"))
	{
		Configurationhelper.get().POA();
		C4Chelper.get().VerifyQuoteStage();
		}
	else if(Configurationhelper.get().Quotestatus.get().equals("Created"))
	{
		Configurationhelper.get().SEDataupdate(Data);
		C4Chelper.get().VerifyQuoteStage();
	}
	else if(Configurationhelper.get().Quotestatus.get().equals("To be Priced"))
	{
		//Need to write the codeExceptionPPT()
		Configurationhelper.get().ExceptionPPT();
		C4Chelper.get().VerifyQuoteStage();
	}
	// If Stage is waiting for third Party Need to call All the Explore functions
	
	GenralInfohelper.get().GenralInfomration(Data);
	BCNupdatehelper.get().BCNUpdate(Data);
	//DisscountAndAprrovalhelper.get().DisscountandApprove(Data);
	
	
	if(Data[0][21].toString().contains("Quote Level")){
		DisscountAndAprrovalhelper.get().ApplyDisscountQuotelevel(Data);
		
	}
	else if(Data[0][21].toString().contains("Line Level"))
	{
		DisscountAndAprrovalhelper.get().ApplyDisscountlinelevel(Data);
	}
	DisscountAndAprrovalhelper.get().ApproveQuote(Data);
	Configurationhelper.get().SetCurrectQuoteStage();
	// belowMethods will not call if Quote is not in Aprroved Stage 
	if(Configurationhelper.get().Quotestatus.get().equals("Approved")){
	SendProposalhelper.get().CustomerSign(Data);
	C4Chelper.get().VerifyQuoteStage();
	if(Data[0][24].toString().equals("Email")) {
		Orderinghelper.get().AcceptsQuote(Data);
		C4Chelper.get().VerifyQuoteStage();
		Orderinghelper.get().CreateOrder(Data);
		C4Chelper.get().VerifyQuoteStage();
	}
	else {
		Orderinghelper.get().AcceptsQuotebyEsignature(Data);
		C4Chelper.get().NavigatetoC4C();
		C4Chelper.get().Movetoaccount(Data);
		C4Chelper.get().MovetoOpportunuity(Data);
		C4Chelper.get().EditQuote();
		C4Chelper.get().CheckdocumentSigned();
		C4Chelper.get().VerifyQuoteStage();
		Orderinghelper.get().AcceptsQuote(Data);
		C4Chelper.get().VerifyQuoteStage();
		Orderinghelper.get().CreateOrder(Data);
		C4Chelper.get().VerifyQuoteStage();
		
		}
	
}
		
//Configurationhelper.get().AddProducttest(Data);
	Login.get().Login("Siebel");
	Orderinghelper.get().SeibleOrderVerification(Data);
	
}


}

package ScriptHelper;

import org.dom4j.DocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverHelper;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class SendProposalHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\SendProposal.xml");
	xmlreader xml2=new xmlreader("src\\Locators\\Configuration.xml");
	public SendProposalHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

	public void Containerprices(Object[][] Inputdata) throws Exception {
		WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/customersignatureTab")));
		Clickon(getwebelement(xml.getlocator("//locators/customersignatureTab")));
		SendKeys(getwebelement(xml.getlocator("//locators/ContainerNRR")),"100");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ContainerNRR")),Keys.ENTER);
		waitForpageload();
		//Clickon(getwebelement(xml.getlocator("//locators/AcceptError")));
		SendKeys(getwebelement(xml.getlocator("//locators/ContainerMRR")),"100");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ContainerMRR")),Keys.ENTER);
		waitForpageload();
		//Clickon(getwebelement(xml.getlocator("//locators/AcceptError")));
		
	}
	
	public void CustomerSign(Object[][] Inputdata) throws Exception {
		if(Inputdata[0][24].toString().equals("Email")) {
			//WaitforCPQloader();
			//Clickon(getwebelement(xml2.getlocator("//locators/saveQuote")));
			waitForpageload();
			
		WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/customersignatureTab")));
		Clickon(getwebelement(xml.getlocator("//locators/customersignatureTab")));
		WaitforElementtobeclickable(xml.getlocator("//locators/GenrateProposal"));
		Clickon(getwebelement(xml.getlocator("//locators/GenrateProposal")));
//		try {
//			Thread.sleep(5000);
//			AcceptJavaScriptMethod();
//			}
//			catch(Exception e)
//			{
//				System.out.println("No Alert Present");
//			}
		waitForpageload();
		WaitforElementtobeclickable(xml.getlocator("//locators/GeneratedMessage"));
		WaitforElementtobeclickable(xml.getlocator("//locators/ProposalLink").replace("QuoteID", QuoteID.get().toString()));
		Clickon(getwebelement2(xml.getlocator("//locators/ProposalLink").replace("QuoteID", QuoteID.get().toString())));
		WaitforFiletobeDownloaded(QuoteID.get().toString()+".pdf");
		//safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ForCustomerSignature")));
		Clickon(getwebelement2(xml.getlocator("//locators/ForCustomerSignature")));
		
		WaitforElementtobeclickable(xml.getlocator("//locators/Mod"));
		//CloseProposalwindow();
		//Select(getwebelement(xml.getlocator("//locators/Mod")), Inputdata[0][24].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Mod")));
		Clickon(getwebelement(xml.getlocator("//locators/ModValue").replace("Workflow", Inputdata[0][24].toString())));
		WaitforElementtobeclickable(xml.getlocator("//locators/to"));
		SendKeys(getwebelement(xml.getlocator("//locators/to")),Inputdata[0][25].toString());
		Clickon(getwebelement(xml.getlocator("//locators/SendtoCustomer")));
//		try {
//			Thread.sleep(5000);
//			AcceptJavaScriptMethod();
//			}
//			catch(Exception e)
//			{
//				System.out.println("No Alert Present");
//			}
		}
		else 
		{
			//WaitforCPQloader();
			WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
			javascriptexecutor(getwebelement(xml.getlocator("//locators/customersignatureTab")));
			Clickon(getwebelement(xml.getlocator("//locators/customersignatureTab")));
			WaitforElementtobeclickable(xml.getlocator("//locators/GenrateProposal"));
			Clickon(getwebelement(xml.getlocator("//locators/GenrateProposal")));
			
//			try {
//			Thread.sleep(5000);
//			AcceptJavaScriptMethod();
//			}
//			catch(Exception e)
//			{
//				System.out.println("No Alert Present");
//			}
			//CloseProposalwindow();
			//WaitforElementtobeclickable(xml.getlocator("//locators/ForCustomerSignature"));
			waitForpageload();
			WaitforElementtobeclickable(xml.getlocator("//locators/GeneratedMessage"));
			WaitforElementtobeclickable(xml.getlocator("//locators/ProposalLink").replace("QuoteID", QuoteID.get().toString()));
			safeJavaScriptClick(getwebelement2(xml.getlocator("//locators/ForCustomerSignature")));
			//Clickon(getwebelement(xml.getlocator("//locators/ForCustomerSignature")));
			waitForpageload();
			WaitforElementtobeclickable(xml.getlocator("//locators/Mod"));
			//Select(getwebelement(xml.getlocator("//locators/Mod")), Inputdata[0][24].toString());
			Clickon(getwebelement(xml.getlocator("//locators/Mod")));
			Clickon(getwebelement(xml.getlocator("//locators/ModValue").replace("Workflow", Inputdata[0][24].toString())));
			WaitforElementtobeclickable(xml.getlocator("//locators/to"));
			SendKeys(getwebelement(xml.getlocator("//locators/to")),Inputdata[0][25].toString());
			//Clickon(getwebelement(xml.getlocator("//locators/SentoSign")));
//			try {
//				Thread.sleep(5000);
//				AcceptJavaScriptMethod();
//				}
//				catch(Exception e)
//				{
//					System.out.println("No Alert Present");
//				}
			waitForpageload();
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/SentoSign")));
			waitForpageload();
		}
		
	}
	

}

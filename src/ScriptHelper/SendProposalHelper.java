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
	
	public SendProposalHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

	public void Containerprices(Object[][] Inputdata) throws Exception {
		WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		Clickon(getwebelement(xml.getlocator("//locators/customersignatureTab")));
		SendKeys(getwebelement(xml.getlocator("//locators/ContainerNRR")),Inputdata[0][25].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/ContainerNRR")),Inputdata[0][25].toString());
		
	}
	
	public void CustomerSign(Object[][] Inputdata) throws Exception {
		if(Inputdata[0][24].toString().equals("Email")) {
			//WaitforCPQloader();
		WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		Clickon(getwebelement(xml.getlocator("//locators/customersignatureTab")));
		WaitforElementtobeclickable(xml.getlocator("//locators/GenrateProposal"));
		Clickon(getwebelement(xml.getlocator("//locators/GenrateProposal")));
		try {
			Thread.sleep(5000);
			AcceptJavaScriptMethod();
			}
			catch(Exception e)
			{
				System.out.println("No Alert Present");
			}
		WaitforElementtobeclickable(xml.getlocator("//locators/ForCustomerSignature"));
		Clickon(getwebelement(xml.getlocator("//locators/ForCustomerSignature")));
		Thread.sleep(5000);
		CloseProposalwindow();
		//Select(getwebelement(xml.getlocator("//locators/Mod")), Inputdata[0][24].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Mod")));
		Clickon(getwebelement(xml.getlocator("//locators/ModValue").replace("Workflow", Inputdata[0][24].toString())));
		WaitforElementtobeclickable(xml.getlocator("//locators/to"));
		SendKeys(getwebelement(xml.getlocator("//locators/to")),Inputdata[0][25].toString());
		Clickon(getwebelement(xml.getlocator("//locators/SendtoCustomer")));
		try {
			Thread.sleep(5000);
			AcceptJavaScriptMethod();
			}
			catch(Exception e)
			{
				System.out.println("No Alert Present");
			}
		}
		else 
		{
			//WaitforCPQloader();
			WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
			javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			Clickon(getwebelement(xml.getlocator("//locators/customersignatureTab")));
			WaitforElementtobeclickable(xml.getlocator("//locators/GenrateProposal"));
			Clickon(getwebelement(xml.getlocator("//locators/GenrateProposal")));
			try {
			Thread.sleep(5000);
			AcceptJavaScriptMethod();
			}
			catch(Exception e)
			{
				System.out.println("No Alert Present");
			}
			//CloseProposalwindow();
			//WaitforElementtobeclickable(xml.getlocator("//locators/ForCustomerSignature"));
			Thread.sleep(5000);
			//CloseProposalwindow();
			//WaitforElementtobeclickable(xml.getlocator("//locators/ForCustomerSignature"));
			Thread.sleep(5000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/ForCustomerSignature")));
			
			Thread.sleep(5000);
			WaitforElementtobeclickable(xml.getlocator("//locators/Mod"));
			//Select(getwebelement(xml.getlocator("//locators/Mod")), Inputdata[0][24].toString());
			Clickon(getwebelement(xml.getlocator("//locators/Mod")));
			Clickon(getwebelement(xml.getlocator("//locators/ModValue").replace("Workflow", Inputdata[0][24].toString())));
			WaitforElementtobeclickable(xml.getlocator("//locators/to"));
			SendKeys(getwebelement(xml.getlocator("//locators/to")),Inputdata[0][25].toString());
			Clickon(getwebelement(xml.getlocator("//locators/SentoSign")));
			try {
				Thread.sleep(5000);
				AcceptJavaScriptMethod();
				}
				catch(Exception e)
				{
					System.out.println("No Alert Present");
				}
			Thread.sleep(5000);
			
		}
	}
	

}

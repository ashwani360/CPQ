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


	public void CustomerSign(Object[] Inputdata) throws Exception {
		WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		Clickon(getwebelement(xml.getlocator("//locators/customersignatureTab")));
		WaitforElementtobeclickable(xml.getlocator("//locators/GenrateProposal"));
		Clickon(getwebelement(xml.getlocator("//locators/GenrateProposal")));
		Thread.sleep(2000);
		AcceptJavaScriptMethod();
		WaitforElementtobeclickable(xml.getlocator("//locators/ForCustomerSignature"));
		Clickon(getwebelement(xml.getlocator("//locators/ForCustomerSignature")));
		Select(getwebelement(xml.getlocator("//locators/Mod")), Inputdata[18].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/to"));
		SendKeys(getwebelement(xml.getlocator("//locators/to")),Inputdata[19].toString());
		Clickon(getwebelement(xml.getlocator("//locators/SendtoCustomer")));
		Thread.sleep(2000);
		AcceptJavaScriptMethod();
	}
	

}

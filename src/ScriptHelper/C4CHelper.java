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

public class C4CHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\C4C.xml");
	
	public C4CHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}


	// Code For Account Navigation
	public void Movetoaccount(Object[] Inputdata) throws Exception
	{
		
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customer Section");
		//Thread.sleep(10000);
	
		Clickon(getwebelement(xml.getlocator("//locators/CustomerSection")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Customer Section in Left Navigation");
		Clickon(getwebelement(xml.getlocator("//locators/Accountlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Account link in navidation");
		Clickon(getwebelement(xml.getlocator("//locators/OCN")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Account Name");
	}

	public void  MovetoOpportunuity(Object[] Inputdata) throws Exception{
		
		Clickon(getwebelement(xml.getlocator("//locators/OpportunuityTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunuitynumber")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Name ");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
		
	}
	public void AddQuote() throws Exception {
		Clickon(getwebelement(xml.getlocator("//locators/AddQuote")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote Button");
	}
	
}

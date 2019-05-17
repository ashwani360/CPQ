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

public class BCNUpdateHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\BCNUpdate.xml");
	
	public BCNUpdateHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}


	public void BCNUpdate(Object[][] Inputdata) throws Exception {
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/Alllineitem")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select All Product check box to update the BCN");
		WaitforElementtobeclickable(xml.getlocator("//locators/BillingInfobutton"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting For BCN button to be Accessible");
		Clickon(getwebelement(xml.getlocator("//locators/BillingInfobutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the BCN update button");
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/customerreferece")),Inputdata[0][18].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Customer Reference number");
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/po")),Inputdata[0][19].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Customer PO number");
		Thread.sleep(1000);
		//Inputdata[0][20].toString()
		Clickon(getwebelement(xml.getlocator("//locators/bcn")));
		
	
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the BCN");
		WaitforElementtobeclickable(xml.getlocator("//locators/applybutton"));
		Clickon(getwebelement(xml.getlocator("//locators/applybutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Apply button");
	}
	
}

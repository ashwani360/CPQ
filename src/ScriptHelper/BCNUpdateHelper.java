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
		//Thread.sleep(5000);
		//waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
		waitForpageload();
		
		//WaitforCPQloader();
		//KeydownKey(Keys.CONTROL);
		System.out.println("Total line item"+getwebelementscount(xml.getlocator("//locators/Lineitemcounter")));
		for(int i=0;i<getwebelementscount(xml.getlocator("//locators/Lineitemcounter"));i++){
			Thread.sleep(3000);
			waitForpageload();
			System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
			Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
			Thread.sleep(3000);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the"+String.valueOf(i+1)+" Line item from model Grid");
			
			WaitforElementtobeclickable(xml.getlocator("//locators/BillingInfobutton"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting For BCN button to be Accessible");
			Clickon(getwebelement(xml.getlocator("//locators/BillingInfobutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Billing Information button");
			Thread.sleep(3000);
			WaitforElementtobeclickable(xml.getlocator("//locators/customerreferece").replace("BCN", Inputdata[0][20].toString()));
			Clickon(getwebelement(xml.getlocator("//locators/customerreferece").replace("BCN", Inputdata[0][20].toString())));
			Thread.sleep(2000);
			
			EnterText(Inputdata[0][18].toString());
			
			
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Customer Reference number");
			Thread.sleep(2000);
			WaitforElementtobeclickable(xml.getlocator("//locators/po").replace("BCN", Inputdata[0][20].toString()));
			
			Clickon(getwebelement(xml.getlocator("//locators/po").replace("BCN", Inputdata[0][20].toString())));
			Thread.sleep(2000);
			//SendKeys(getwebelement(xml.getlocator("//locators/po").replace("BCN",  Inputdata[0][20].toString())),Inputdata[0][19].toString());
			EnterText(Inputdata[0][19].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Customer PO number");
			Thread.sleep(2000);
			//Inputdata[0][20].toString()
			//Clickon(getwebelement(xml.getlocator("//locators/bcn").replace("BCN", Inputdata[0][20].toString())));
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/bcn").replace("BCN", Inputdata[0][20].toString())));
		
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the BCN");
			WaitforElementtobeclickable(xml.getlocator("//locators/applybutton"));
			Clickon(getwebelement(xml.getlocator("//locators/applybutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clikc on Apply BCN button");
			
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
			Thread.sleep(3000);
		}
		//KeyupKey(Keys.CONTROL);
		Thread.sleep(1000);
		//Clickon(getwebelement(xml.getlocator("//locators/Alllineitem")));
		
	}
	
}

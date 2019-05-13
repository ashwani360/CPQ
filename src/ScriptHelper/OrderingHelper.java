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

public class OrderingHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Ordering.xml");
	
	public OrderingHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}


	public void CreateOrder(Object[] Inputdata) throws Exception {
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/OrderTab")));
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		Thread.sleep(2000);
		Select(getwebelement(xml.getlocator("//locators/QuoteAction")), "Accept");
		Thread.sleep(2000);
		Select(getwebelement(xml.getlocator("//locators/Reasone")), "Price");
		Thread.sleep(5000);
		//safeJavaScriptClick();
		//Clickon(getwebelement(xml.getlocator("//locators/FileBrowse")));
		uploadafile(xml.getlocator("//locators/FileBrowse"),"QT-20180312-014836-01.pdf");
		getwebelement(xml.getlocator("//locators/Fileuploaded"));
		SendKeys(getwebelement(xml.getlocator("//locators/CustomerSignedDate")),"13/05/2019");
		Clickon(getwebelement(xml.getlocator("//locators/ConfirQuoteAction")));
		WaitforElementtobeclickable(xml.getlocator("//locators/AdditionalinfomrationTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/AdditionalinfomrationTab")));
		Clickon(getwebelement(xml.getlocator("//locators/AdditionalinfomrationTab")));
		WaitforElementtobeclickable(xml.getlocator("//locators/Accordian"));
		Clickon(getwebelement(xml.getlocator("//locators/Accordian")));
		SendKeys(getwebelement(xml.getlocator("//locators/Asitecomponey")),Inputdata[20].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/BSitecom")),Inputdata[21].toString());
		Clickon(getwebelement(xml.getlocator("//locators/SaveInfo")));
		WaitforElementtobeclickable(xml.getlocator("//locators/CreateOrder"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/CreateOrder")));
		Clickon(getwebelement(xml.getlocator("//locators/CreateOrder")));
	}

}

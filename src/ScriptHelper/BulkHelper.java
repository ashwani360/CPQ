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

public class BulkHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\BulkUpload.xml");
	
	public BulkHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}


	public void AddProductWithbulkTemplate(Object[][] Inputdata) throws InterruptedException, DocumentException {
		// Click on Bulk upload tab
		WaitforElementtobeclickable(xml.getlocator("//locators/BulkuploadTab"));
		Clickon(getwebelement(xml.getlocator("//locators/BulkuploadTab")));
		WaitforElementtobeclickable(xml.getlocator("//locators/BulkuploadApp"));
		switchtofram(getwebelement(xml.getlocator("//locators/BulkuploadApp")));
		WaitforElementtobeclickable(xml.getlocator("//locators/AddNewLineitems"));
		Clickon(getwebelement(xml.getlocator("//locators/AddNewLineitems")));
		WaitforElementtobeclickable(xml.getlocator("//locators/UploadNewFile"));
		Clickon(getwebelement(xml.getlocator("//locators/UploadNewFile")));
		WaitforElementtobeclickable(xml.getlocator("//locators/FileInput"));
		uploadafile(xml.getlocator("//locators/UploadNewFile"),"Bulk_Upload_Template_V1.3.xlsm");
		Thread.sleep(4000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Uploadfile"));
		Clickon(getwebelement(xml.getlocator("//locators/Uploadfile")));
		waitandForElementtobenotDisplay(xml.getlocator("//locators/LoaderDiv"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/DetailLink"));
		Clickon(getwebelement(xml.getlocator("//locators/DetailLink")));
		WaitforElementtobeclickable(xml.getlocator("//locators/CheckConnectivity"));
		Clickon(getwebelement(xml.getlocator("//locators/CheckConnectivity")));
		Thread.sleep(30000);
		WaitforElementtobeclickable(xml.getlocator("//locators/RefreshButton"));
		Clickon(getwebelement(xml.getlocator("//locators/RefreshButton")));
		WaitforElementtobeclickable(xml.getlocator("//locators/SelectAll"));
		Clickon(getwebelement(xml.getlocator("//locators/SelectAll")));
		WaitforElementtobeclickable(xml.getlocator("//locators/AddtoQuote"));
		Clickon(getwebelement(xml.getlocator("//locators/AddtoQuote")));
		WaitforElementtobeclickable(xml.getlocator("//locators/Pendingbutton"));
		while(!GetText(getwebelement(xml.getlocator("//locators/PendingCount"))).equals("0"))
		{
			Thread.sleep(3000);
			WaitforElementtobeclickable(xml.getlocator("//locators/RefreshButton"));
			Clickon(getwebelement(xml.getlocator("//locators/RefreshButton")));
		}
		WaitforElementtobeclickable(xml.getlocator("//locators/CountinuetoQuote"));
		Clickon(getwebelement(xml.getlocator("//locators/CountinuetoQuote")));
		
		// Click on Upload file
		// Click on New file
		// Upload file
		//wait all the connectivity check done.
		// Click on Select All
		// Click on Countinue with the Quote
		//
	}
	
}

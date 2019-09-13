package ScriptHelper;

import java.io.IOException;

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
	xmlreader xml2=new xmlreader("src\\Locators\\Configuration.xml");
	public BulkHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}


	public void AddProductWithbulkTemplate(Object[][] Inputdata) throws Exception {
		// Click on Bulk upload tab
				WaitforElementtobeclickable(xml.getlocator("//locators/BulkuploadTab"));
				Clickon(getwebelement(xml.getlocator("//locators/BulkuploadTab")));
				WaitforElementtobeclickable(xml.getlocator("//locators/BulkuploadApp"));
				//Waitforswitchtofram(xml.getlocator("//locators/BulkuploadApp"));
				////Thread.sleep(10000);
				switchtofram(getwebelement(xml.getlocator("//locators/BulkuploadApp")));
				System.out.println(gettitle());
				WaitforElementtobeclickable(xml.getlocator("//locators/AddNewLineitems"));
				Clickon(getwebelement(xml.getlocator("//locators/AddNewLineitems")));
				////Thread.sleep(3000);
				WaitforElementtobeclickable(xml.getlocator("//locators/UploadNewFile"));
				Clickon(getwebelement(xml.getlocator("//locators/UploadNewFile")));
				WaitforElementtobeclickable(xml.getlocator("//locators/FileInput"));
				uploadafile(xml.getlocator("//locators/FileInput"),Inputdata[0][5].toString());
				////Thread.sleep(4000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Uploadfile"));
				Clickon(getwebelement(xml.getlocator("//locators/Uploadfile")));
				////Thread.sleep(8000);
				//WaitforElementtobeclickable(xml.getlocator("//locators/LoaderDiv"));
				waitandForElementtobenotDisplay(xml.getlocator("//locators/LoaderDiv"),1);
				////Thread.sleep(4000);
				WaitforElementtobeclickable(xml.getlocator("//locators/DetailLink"));
				Clickon(getwebelement(xml.getlocator("//locators/DetailLink")));
				WaitforElementtobeclickable(xml.getlocator("//locators/CheckConnectivity"));
				Clickon(getwebelement(xml.getlocator("//locators/CheckConnectivity")));
				WaitforElementtobeclickable(xml.getlocator("//locators/CCPendingbutton"));
				System.out.println("Before loop the- Style Value"+Getattribute(getwebelement(xml.getlocator("//locators/CCPendingbutton")),"style"));
				System.out.println("Before loop the- Condition Value"+Getattribute(getwebelement(xml.getlocator("//locators/CCPendingbutton")),"style").contains("display: none;"));
				
				while(!Getattribute(getwebelement(xml.getlocator("//locators/CCPendingbutton")),"style").contains("display: none;"))
				{
					System.out.println("In Start of loop the- Style Value"+Getattribute(getwebelement(xml.getlocator("//locators/CCPendingbutton")),"style"));
					
					System.out.println("In Start of loop the- Condition Value"+Getattribute(getwebelement(xml.getlocator("//locators/CCPendingbutton")),"style").contains("display: none;"));
					////Thread.sleep(3000);
					WaitforElementtobeclickable(xml.getlocator("//locators/RefreshButton"));
					Clickon(getwebelement(xml.getlocator("//locators/RefreshButton")));
					System.out.println("In End of loop the- Style Value"+Getattribute(getwebelement(xml.getlocator("//locators/CCPendingbutton")),"style"));
					
					System.out.println("In End of loop the- Condition Value"+Getattribute(getwebelement(xml.getlocator("//locators/CCPendingbutton")),"style").contains("display: none;"));
					
				}
				////Thread.sleep(10000);
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectAll"));
				Clickon(getwebelement(xml.getlocator("//locators/SelectAll")));
				WaitforElementtobeclickable(xml.getlocator("//locators/AddtoQuote"));
				Clickon(getwebelement(xml.getlocator("//locators/AddtoQuote")));
				WaitforElementtobeclickable(xml.getlocator("//locators/Pendingbutton"));
				
				while(!Getattribute(getwebelement(xml.getlocator("//locators/Pendingbutton")),"style").contains("display: none;"))
				{
					System.out.println("In Start of loop the- Style Value"+Getattribute(getwebelement(xml.getlocator("//locators/Pendingbutton")),"style"));
					
					System.out.println("In Start of loop the- Condition Value"+Getattribute(getwebelement(xml.getlocator("//locators/Pendingbutton")),"style").contains("display: none;"));
					////Thread.sleep(3000);
					WaitforElementtobeclickable(xml.getlocator("//locators/RefreshButton"));
					Clickon(getwebelement(xml.getlocator("//locators/RefreshButton")));
					System.out.println("In End of loop the- Style Value"+Getattribute(getwebelement(xml.getlocator("//locators/Pendingbutton")),"style"));
					
					System.out.println("In End of loop the- Condition Value"+Getattribute(getwebelement(xml.getlocator("//locators/Pendingbutton")),"style").contains("display: none;"));
					
				}
				WaitforElementtobeclickable(xml.getlocator("//locators/CountinuetoQuote"));
				Clickon(getwebelement(xml.getlocator("//locators/CountinuetoQuote")));
				waitForpageload();
				WaitforCPQloader();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Save Button");
				Expandthesection(getwebelement(xml2.getlocator("//locators/SectionName").replace("Sectionname", "Opportunity Info")),getwebelement(xml2.getlocator("//locators/Clickableelemt").replace("Sectionname", "Opportunity Info")));
				////Thread.sleep(5000);
				QuoteID.set(GetValueofInput(getwebelement(xml2.getlocator("//locators/QuoteID"))));
				System.out.println(QuoteID.get());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Quote ID is"+QuoteID.get().toString());
				DealClass.set(GetValueofInput(getwebelement(xml2.getlocator("//locators/Dealclass"))));
				TechnicalComplexity.set(GetValueofInput(getwebelement(xml2.getlocator("//locators/Technicalcomplexity"))));
				LeagalComplexity.set(GetValueofInput(getwebelement(xml2.getlocator("//locators/LegalComplexity"))));
				Quotestatus.set(GetValueofInput(getwebelement(xml2.getlocator("//locators/Quotestatus"))));
				System.out.println("Quite Stage on Screee"+GetValueofInput(getwebelement(xml2.getlocator("//locators/Quotestatus"))));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Quote stage is"+Quotestatus.get().toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Deal Class is"+DealClass.get().toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Techincal Complaxity is"+TechnicalComplexity.get().toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Legal Complexity is"+LeagalComplexity.get().toString());
				System.out.println("Deal class after adding all the products is"+DealClass.get());
				System.out.println("Techincal Complexity after adding all the products is"+TechnicalComplexity.get());
				System.out.println("Techincal Complexity after adding all the products is"+LeagalComplexity.get());
				System.out.println("Satage  after adding all the products is"+Quotestatus.get());
				Clickon(getwebelement(xml2.getlocator("//locators/saveQuote")));
				waitForpageload();
				// Click on Upload file
				// Click on New file
				// Upload file
				//wait all the connectivity check done.
				// Click on Select All
				// Click on Countinue with the Quote
				//
	}
	
}

package ScriptHelper;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class ContainerJourneyHelper extends DriverHelper {
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Container.xml");
	
	public ContainerJourneyHelper(WebDriver dr) {
		super(dr);
		
	}

	
	
	
	public void AddContainerProduct(Object[][] Data) throws InterruptedException, Exception
	{
		for(int i=0; i<Data.length;i++)
		{
		Clickon(getwebelement(xml.getlocator("//locators/EnterProductName")));
		SendKeys(getwebelement(xml.getlocator("//locators/EnterProductName")),Data[i][0].toString());
		Clickon(getwebelement(xml.getlocator("//locators/AddContainerProduct")));
		getwebelement(xml.getlocator("//locators/EnterProductName")).clear();
		}
	}
	
	public void ContainerApproveQuote(Object[][] Data) throws Exception, DocumentException
	{
		WaitforElementtobeclickable(xml.getlocator("//locators/TechnicalApprovalTab"));
		Clickon(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
		for(int i=0;i<Data.length;i++)
		{	
			Clickon(getwebelement(xml.getlocator("//locators/UploadXlsxAttachment").replace("index", String.valueOf(i+1))));
			WaitforElementtobeclickable(xml.getlocator("//locators/SelectCategory").replace("value", "Internal"));
			Clickon(getwebelement(xml.getlocator("//locators/SelectCategory").replace("value", "Internal")));
			Select(getwebelement(xml.getlocator("//locators/Selecttype")),"EOF(xls)");
			uploadafile(xml.getlocator("//locators/ChooseFile"),"IP Guardian_Order Form QtO' 1.0.xlsx");
			isElementPresent(xml.getlocator("//locators/Filename").replace("value", "IP Guardian_Order Form QtO' 1.0.xlsx"));
			Clickon(getwebelement(xml.getlocator("//locators/UploadFile")));
			
		}
		ClickswithAction(xml.getlocator("//locators/CheckboxTechnicalApproval"));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SubmitTechnicalApprovalButton")));
	}
	
	public void ContainerSEApproval() throws Exception
	{
		ProxyLogin("CPQ_SE_User", xml.getlocator("//locators/ProxyLink"));
		
		WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
		Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
		WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
		Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
		waitForpageload();
		WaitforCPQloader();
		WaitforElementtobeclickable(xml.getlocator("//locators/TechnicalApprovalTab"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
		javascriptexecutor(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
		Clickon(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
		WaitforElementtobeclickable(xml.getlocator("//locators/SubmitToCSTApproval"));
		Clickon(getwebelement(xml.getlocator("//locators/SubmitToCSTApproval")));
		Thread.sleep(30000);
	}
	public void ContainerCSTApproval(Object[][] Data) throws DocumentException, Exception
	{
		ProxyLogin("CPQ_CST_User", xml.getlocator("//locators/ProxyLink"));
		WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
		Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
		WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
		Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
		waitForpageload();
		WaitforCPQloader();
		WaitforElementtobeclickable(xml.getlocator("//locators/TechnicalApprovalTab"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
		javascriptexecutor(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
		Clickon(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
		for(int i=0;i<Data.length;i++)
		{	
			Clickon(getwebelement(xml.getlocator("//locators/UploadXlsxAttachment").replace("index", String.valueOf(i+1))));
			WaitforElementtobeclickable(xml.getlocator("//locators/SelectCategory").replace("value", "Customer Facing"));
			Clickon(getwebelement(xml.getlocator("//locators/SelectCategory").replace("value", "Customer Facing")));
			Select(getwebelement(xml.getlocator("//locators/Selecttype")),"EOF(pdf)");
			uploadafile(xml.getlocator("//locators/ChooseFile"),"IP Guardian_Order Form QtO' 1.0.pdf");
			isElementPresent(xml.getlocator("//locators/Filename").replace("value", "IP Guardian_Order Form QtO' 1.0.pdf"));
			Clickon(getwebelement(xml.getlocator("//locators/UploadFile")));
		}
		Clickon(getwebelement(xml.getlocator("//locators/CSTApproval")));
	}
}


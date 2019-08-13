package ScriptHelper;

import org.dom4j.DocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

import Driver.CSV;
import Driver.DriverHelper;
import Driver.PropertyReader;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class Tester extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\DisscountandAprroval.xml");
	xmlreader xml2=new xmlreader("src\\Locators\\C4C.xml");
	xmlreader xml3=new xmlreader("src\\Locators\\Configuration.xml");
	PropertyReader pr=new PropertyReader();
	public Tester(WebDriver parentdriver)
	{
		super(parentdriver);
	}


	public void Testert(Object[][] Inputdata) throws Exception {
		
		if(Integer.parseInt(Igmad.get())>=0 && Integer.parseInt(Igmad.get())<=17 && Connectivitytype.get().equals("Onnet") ) 
		{
			ApproveQuote("VP2 Sales");
		}
		if(Integer.parseInt(Igmad.get())>17 && Integer.parseInt(Igmad.get())<=23 &&  Connectivitytype.get().equals("Onnet")) 
		{
			ApproveQuote("VP1 Finanace");
			ApproveQuote("VP1 Sales");
		}
		if(Integer.parseInt(Igmad.get())>17 && Integer.parseInt(Igmad.get())<=23 && !Connectivitytype.get().equals("Onnet")) 
		{

			ApproveQuote("VP1 Finanace");
			ApproveQuote("VP1 Sales");
			ApproveQuote("CRO");
			ApproveQuote("CFO");
		}
	}
	public void ApproveQuote(String Approver) throws Exception
	{
		switch(Approver)
		{
			case "Self Approve" :
			{
				System.out.println("No Further Approval Required");
				Thread.sleep(30000);
				break;
			}
			case "VP2 Sales" :
			{
				// Click on Admin link
//				WaitforElementtobeclickable(xml.getlocator("//locators/Admin"));
//				javascriptexecutor(getwebelement(xml.getlocator("//locators/Admin")));
//				
//				Clickon(getwebelement(xml.getlocator("//locators/Admin")));
//				openurl("Admin");
//				Switchtotab();
//				WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
//				Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
//				WaitforElementtobeclickable(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_VP1_Sales")));
//				Clickon(getwebelement(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_VP1_Sales"))));
				ProxyLogin("CPQ_VP2_Sales", xml.getlocator("//locators/ProxyLink"));
				Thread.sleep(20000);
//				WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
//				Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
//				
//			
//				WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
//				Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
				openurl2(CurrentQuoteURL.get());
				waitForpageload();
				Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
		        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
		        Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		        Thread.sleep(4000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApproverComment"));
		        SendKeys(getwebelement(xml.getlocator("//locators/ApproverComment")),"Approve");
		        Thread.sleep(2000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApproveasApprover"));
		        Clickon(getwebelement(xml.getlocator("//locators/ApproveasApprover")));
		        Thread.sleep(5000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		        openurl("CPQAdmin");
		        Thread.sleep(5000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
		        Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
		        Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
		        Thread.sleep(10000);
		        openurl2(CurrentQuoteURL.get());
		        
		        Thread.sleep(30000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				break;
			}
			case "VP1 Sales" :
			{
			
//				WaitforElementtobeclickable(xml.getlocator("//locators/Admin"));
//				Clickon(getwebelement(xml.getlocator("//locators/Admin")));
//				Switchtotab();
//				WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
//				Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
	//
	//
//				WaitforElementtobeclickable(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_VP1_Sales")));
//				Clickon(getwebelement(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_VP1_Sales"))));
				ProxyLogin("CPQ_VP1_Sales", xml.getlocator("//locators/ProxyLink"));
				Thread.sleep(20000);
//				WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
//				Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
//				
//				WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
//				Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
				openurl2(CurrentQuoteURL.get());
				waitForpageload();
				Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
		        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
		        Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		        Thread.sleep(4000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApproverComment"));
		        SendKeys(getwebelement(xml.getlocator("//locators/ApproverComment")),"Approve");
		        Thread.sleep(2000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApproveasApprover"));
		        Clickon(getwebelement(xml.getlocator("//locators/ApproveasApprover")));
		        Thread.sleep(5000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		        openurl("CPQAdmin");
		        Thread.sleep(5000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
		        Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
		        Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
		        Thread.sleep(10000);
		        openurl2(CurrentQuoteURL.get());
		        
		        Thread.sleep(30000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			}
			
			case "Deal Pricing":
			{
				// Generate the File
				System.out.println("Quote ACV is "+Quoteacv.get().toString());
				System.out.println("Quote TCV is "+Quotetcv.get().toString());
				System.out.println("Quote ARR is "+Quotearr.get().toString());
				System.out.println("Quote Igmag is "+Igmad.get().toString());
				CSV filegenerator=new CSV();
				filegenerator.createfile(Quoteacv.get().toString(), Quotetcv.get().toString(), Quotearr.get().toString(), Igmad.get().toString(), QuoteID.get().toString());
				// Assing the Quote
				ProxyLogin("CPQ_DealPrice_User", xml.getlocator("//locators/ProxyLink"));
				openurl2(CurrentQuoteURL.get());
				waitForpageload();
				Clickon(getwebelement(xml3.getlocator("//locators/PPT/PLtab")));
				WaitforElementtobeclickable(xml3.getlocator("//locators/Listexpander"));
				Clickon(getwebelement(xml3.getlocator("//locators/Listexpander")));
				WaitforElementtobeclickable(xml3.getlocator("//locators/UserSelector").replace("Username", "Namita Singh"));
				Clickon(getwebelement(xml3.getlocator("//locators/UserSelector").replace("Username", "Namita Singh")));
				//Select assignuser=new Select(getwebelement("//select[@name='portfolioTeamAssignment']"));
				//assignuser.selectByVisibleText("Prashant Manu");
				WaitforElementtobeclickable(xml3.getlocator("//locators/PPT/Assignquote"));
				Clickon(getwebelement(xml3.getlocator("//locators/PPT/Assignquote")));
				WaitforElementtobeclickable(xml.getlocator("//locators/MMTupload"));
				uploadafile(xml.getlocator("//locators/MMTupload"),QuoteID.get().toString()+".csv");
				Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Uploadmargin"));
				Clickon(getwebelement(xml.getlocator("//locators/Uploadmargin")));
				 SendKeys(getwebelement(xml.getlocator("//locators/textarea1")),"Comment from Deal team");
				 SendKeys(getwebelement(xml.getlocator("//locators/textarea2")),"Comment from Deal team");
				//Upload the File
				Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
		        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
		        Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		        Thread.sleep(4000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApproverComment"));
		        SendKeys(getwebelement(xml.getlocator("//locators/ApproverComment")),"Approve");
		        Thread.sleep(2000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApproveasApprover"));
		        Clickon(getwebelement(xml.getlocator("//locators/ApproveasApprover")));
		        Thread.sleep(5000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		        openurl("CPQAdmin");
		        Thread.sleep(5000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
		        Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
		        Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
		        Thread.sleep(10000);
		        openurl2(CurrentQuoteURL.get());
		        
		        Thread.sleep(30000);
		        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				// Approve From All the Approver based on Igmad and Connectivity.
				if(Integer.parseInt(Igmad.get())>=0 && Integer.parseInt(Igmad.get())<=17 && Connectivitytype.get().equals("Onnet") ) 
				{
					ApproveQuote("VP2 Sales");
				}
				if(Integer.parseInt(Igmad.get())>17 && Integer.parseInt(Igmad.get())<=23 &&  Connectivitytype.get().equals("Onnet")) 
				{
					ApproveQuote("VP1 Finanace");
					ApproveQuote("VP1 Sales");
				}
				if(Integer.parseInt(Igmad.get())>17 && Integer.parseInt(Igmad.get())<=23 && !Connectivitytype.get().equals("Onnet")) 
				{

					ApproveQuote("VP1 Finanace");
					ApproveQuote("VP1 Sales");
					ApproveQuote("CRO");
					ApproveQuote("CFO");
				}
			}
			case "VP1 Finanace":

	        {

	               ProxyLogin("CPQ_VP1_Finanace", xml.getlocator("//locators/ProxyLink"));
	               openurl2(CurrentQuoteURL.get());
	   				waitForpageload();
	   				Thread.sleep(5000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
			        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
			        Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        Thread.sleep(4000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApproverComment"));
			        SendKeys(getwebelement(xml.getlocator("//locators/ApproverComment")),"Approve");
			        Thread.sleep(2000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApproveasApprover"));
			        Clickon(getwebelement(xml.getlocator("//locators/ApproveasApprover")));
			        Thread.sleep(5000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        openurl("CPQAdmin");
			        Thread.sleep(5000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
			        Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
			        Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
			        Thread.sleep(10000);
			        openurl2(CurrentQuoteURL.get());
			        
			        Thread.sleep(30000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));

	               break;

	        }

	        case "VP2 Finanace":

	        {

	               ProxyLogin("CPQ_VP2_Finanace", xml.getlocator("//locators/ProxyLink"));
//	               WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
//	               Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
//	               WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
//	               Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
	               openurl2(CurrentQuoteURL.get());
	  				waitForpageload();
	  				Thread.sleep(5000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
			        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
			        Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        Thread.sleep(4000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApproverComment"));
			        SendKeys(getwebelement(xml.getlocator("//locators/ApproverComment")),"Approve");
			        Thread.sleep(2000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApproveasApprover"));
			        Clickon(getwebelement(xml.getlocator("//locators/ApproveasApprover")));
			        Thread.sleep(5000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        openurl("CPQAdmin");
			        Thread.sleep(5000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
			        Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
			        Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
			        Thread.sleep(10000);
			        openurl2(CurrentQuoteURL.get());
			        
			        Thread.sleep(30000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
	               break;

	        }

	        case "CRO":

	        {

	               ProxyLogin("CPQ_CRO", xml.getlocator("//locators/ProxyLink"));
	               openurl2(CurrentQuoteURL.get());
	  				waitForpageload();
	  				Thread.sleep(5000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
			        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
			        Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        Thread.sleep(4000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApproverComment"));
			        SendKeys(getwebelement(xml.getlocator("//locators/ApproverComment")),"Approve");
			        Thread.sleep(2000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApproveasApprover"));
			        Clickon(getwebelement(xml.getlocator("//locators/ApproveasApprover")));
			        Thread.sleep(5000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        openurl("CPQAdmin");
			        Thread.sleep(5000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
			        Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
			        Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
			        Thread.sleep(10000);
			        openurl2(CurrentQuoteURL.get());
			        
			        Thread.sleep(30000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
	               break;

	        }

	        case "CFO":

	        {

	               ProxyLogin("CPQ_CFO", xml.getlocator("//locators/ProxyLink"));
	               openurl2(CurrentQuoteURL.get());
	  				waitForpageload();
	  				Thread.sleep(5000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
			        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
			        Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        Thread.sleep(4000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApproverComment"));
			        SendKeys(getwebelement(xml.getlocator("//locators/ApproverComment")),"Approve");
			        Thread.sleep(2000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApproveasApprover"));
			        Clickon(getwebelement(xml.getlocator("//locators/ApproveasApprover")));
			        Thread.sleep(5000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			        javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			        openurl("CPQAdmin");
			        Thread.sleep(5000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
			        Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
			        Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
			        Thread.sleep(10000);
			        openurl2(CurrentQuoteURL.get());
			        
			        Thread.sleep(30000);
			        WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
	               break;

	        }
			default:
			{
				System.out.println("Nothing to Do here");
				break;
			}
		}
	
	}
}

package ScriptHelper;

import java.text.DecimalFormat;

import org.dom4j.DocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverHelper;
import Driver.PropertyReader;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class DisscountAndAprrovalHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\DisscountandAprroval.xml");
	xmlreader xml2=new xmlreader("src\\Locators\\C4C.xml");
	PropertyReader pr=new PropertyReader();
	public DisscountAndAprrovalHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

	public void DisscountandApprove(Object[][] Inputdata,int i) throws Exception {
	
		//ApplyDisscount(Inputdata,i);
		ApproveQuote(Inputdata);
		
	}
	
public void ApplyDisscountQuotelevel(Object[][] Inputdata) throws Exception {
	
		System.out.println("Quote Level Disscount");
		
		
		if(Inputdata[0][21].toString().split(">")[1].trim().equals("Percentage Off")) {
			WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuoteTab"));
			javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			Clickon(getwebelement(xml.getlocator("//locators/CPQQuoteTab")));
			Thread.sleep(5000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Percentage/DiscountType"));
		//Select(getwebelement(xml.getlocator("//locators/Percentage/DiscountType")), Inputdata[0][21].toString().split(">")[1].trim());
		Clickon(getwebelement(xml.getlocator("//locators/Percentage/DiscountType")));
		Clickon(getwebelement(xml.getlocator("//locators/Percentage/OptionstoSelect")));
		WaitforElementtobeclickable(xml.getlocator("//locators/Percentage/NRCDiscount"));
		Clear(getwebelement(xml.getlocator("//locators/Percentage/NRCDiscount")));
		WaitforElementtobeclickable(xml.getlocator("//locators/Percentage/NRCDiscount"));
		SendKeys(getwebelement(xml.getlocator("//locators/Percentage/NRCDiscount")), Inputdata[0][22].toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/Percentage/MRCDiscount"));
		Clear(getwebelement(xml.getlocator("//locators/Percentage/MRCDiscount")));
		WaitforElementtobeclickable(xml.getlocator("//locators/Percentage/MRCDiscount"));
		SendKeys(getwebelement(xml.getlocator("//locators/Percentage/MRCDiscount")), Inputdata[0][23].toString());
		Thread.sleep(2000);
//		WaitforElementtobeclickable(xml.getlocator("//locators/Percentage/CalculateDisscount"));
//		Clickon(getwebelement(xml.getlocator("//locators/Percentage/CalculateDisscount")));
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Percentage/MRCDiscount")),Keys.TAB);
		WaitforElementtobeclickable(xml.getlocator("//locators/Percentage/CalculateDisscount"));
		Clickon(getwebelement(xml.getlocator("//locators/Percentage/CalculateDisscount")));
		System.out.println("NRC Disscount"+Inputdata[0][22].toString());
		System.out.println("NRC Disscount"+Inputdata[0][23].toString());
		}
		else if(Inputdata[0][21].toString().split(">")[1].trim().equals("Amount Off")){
			WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuoteTab"));
			javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			Clickon(getwebelement(xml.getlocator("//locators/CPQQuoteTab")));
			WaitforElementtobeclickable(xml.getlocator("//locators/Ammountoff/DiscountType"));
			//Select(getwebelement(xml.getlocator("//locators/Ammountoff/DiscountType")), Inputdata[0][21].toString().split(">")[1].trim());
			Clickon(getwebelement(xml.getlocator("//locators/Ammountoff/DiscountType")));
			Clickon(getwebelement(xml.getlocator("//locators/Ammountoff/OptionstoSelect")));
			WaitforElementtobeclickable(xml.getlocator("//locators/Ammountoff/NRCDiscount"));
			Clear(getwebelement(xml.getlocator("//locators/Ammountoff/NRCDiscount")));
			WaitforElementtobeclickable(xml.getlocator("//locators/Ammountoff/NRCDiscount"));
			SendKeys(getwebelement(xml.getlocator("//locators/Ammountoff/NRCDiscount")), Inputdata[0][22].toString());
			WaitforElementtobeclickable(xml.getlocator("//locators/Ammountoff/MRCDiscount"));
			Clear(getwebelement(xml.getlocator("//locators/Ammountoff/MRCDiscount")));
			WaitforElementtobeclickable(xml.getlocator("//locators/Ammountoff/MRCDiscount"));
			SendKeys(getwebelement(xml.getlocator("//locators/Ammountoff/MRCDiscount")), Inputdata[0][23].toString());
			Thread.sleep(2000);
			WaitforElementtobeclickable(xml.getlocator("//locators/Ammountoff/CalculateDisscount"));
			Clickon(getwebelement(xml.getlocator("//locators/Ammountoff/CalculateDisscount")));
			//WaitforElementtobeclickable(xml.getlocator("//locators/Ammountoff/CalculateDisscount"));
			//Clickon(getwebelement(xml.getlocator("//locators/Ammountoff/CalculateDisscount")));
			System.out.println("NRC Disscount"+Inputdata[0][22].toString());
			System.out.println("NRC Disscount"+Inputdata[0][23].toString());
		}
		else if(Inputdata[0][21].toString().split(">")[1].trim().equals("Target Price"))
		{
			WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuoteTab"));
			javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			Clickon(getwebelement(xml.getlocator("//locators/CPQQuoteTab")));
			WaitforElementtobeclickable(xml.getlocator("//locators/TargetPrice/DiscountType"));
			//Select(getwebelement(xml.getlocator("//locators/TargetPrice/DiscountType")), Inputdata[0][21].toString().split(">")[1].trim());
			Clickon(getwebelement(xml.getlocator("//locators/TargetPrice/DiscountType")));
			Clickon(getwebelement(xml.getlocator("//locators/TargetPrice/OptionstoSelect")));
			WaitforElementtobeclickable(xml.getlocator("//locators/TargetPrice/NRCDiscount"));
			Clear(getwebelement(xml.getlocator("//locators/TargetPrice/NRCDiscount")));
			WaitforElementtobeclickable(xml.getlocator("//locators/TargetPrice/NRCDiscount"));
			SendKeys(getwebelement(xml.getlocator("//locators/TargetPrice/NRCDiscount")), Inputdata[0][22].toString());
			WaitforElementtobeclickable(xml.getlocator("//locators/TargetPrice/MRCDiscount"));
			Clear(getwebelement(xml.getlocator("//locators/TargetPrice/MRCDiscount")));
			WaitforElementtobeclickable(xml.getlocator("//locators/TargetPrice/MRCDiscount"));
			SendKeys(getwebelement(xml.getlocator("//locators/TargetPrice/MRCDiscount")), Inputdata[0][23].toString());
			Thread.sleep(2000);
			WaitforElementtobeclickable(xml.getlocator("//locators/TargetPrice/CalculateDisscount"));
			Clickon(getwebelement(xml.getlocator("//locators/TargetPrice/CalculateDisscount")));
			WaitforElementtobeclickable(xml.getlocator("//locators/TargetPrice/CalculateDisscount"));
			Clickon(getwebelement(xml.getlocator("//locators/TargetPrice/CalculateDisscount")));
			System.out.println("NRC Disscount"+Inputdata[0][22].toString());
			System.out.println("NRC Disscount"+Inputdata[0][23].toString());
		}
		else
		{
			System.out.println("No Disscount Required");
		}
	
}
public void ApplyDisscountlinelevel(Object[][] Inputdata) throws Exception {

	{
		 for(int i=0;i<Inputdata.length;i++) {
			 System.out.println("NRC Disscount"+Inputdata[i][22].toString());
				System.out.println("NRC Disscount"+Inputdata[i][23].toString());
			  }
		
		//System.out.println("Line Level Disscount");
	}
}
public void ApproveQuote(Object[][] Inputdata) throws Exception {
	
	waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
	waitForpageload();
	//Thread.sleep(10000);
		//WaitforElementtobeclickable(xml.getlocator("//locators/Showdisscountcoulumn"));
	safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Showdisscountcoulumn")));
	//Clickonoutofviewportwithstring(xml.getlocator("//locators/Showdisscountcoulumn"));
		WaitforElementtobeclickable(xml.getlocator("//locators/TcvDisscount"));
		//DecimalFormat df = new DecimalFormat("0.00");
		//df.setMaximumFractionDigits(2);
		//System.out.println(Gettext(getwebelement(xml.getlocator("//locators/TcvDisscount"))));
		//TotalTCVdisscount.set(Float.parseFloat(Gettext(getwebelement(xml.getlocator("//locators/TcvDisscount")))));
		
	//WaitforElementtobeclickable(xml.getlocator("//locators/TcvDisscount"));
	System.out.println(Gettext(getwebelement(xml.getlocator("//locators/TcvDisscount"))));
	TotalTCVdisscount.set(Float.parseFloat(Gettext(getwebelement(xml.getlocator("//locators/TcvDisscount")))));
	DefineApprover(Inputdata);
	SubmitforApproval(ApprovalCase.get(),Inputdata);
	
	ApproveQuote(ApprovalCase.get());
	//NavigatetoC4C();
	if(!ApprovalCase.get().equals("Self Approve")) {
	Movetoaccount(Inputdata);
	MovetoOpportunuity(Inputdata);
	EditQuote();
	//-----------------------------------------------
	if(isElementPresent(xml.getlocator("//locators/TechnicalApprovalTab")))
	{
		Clickon(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
		Clickon(getwebelement(xml.getlocator("//locators/CheckboxTechnicalApproval")));
		Clickon(getwebelement(xml.getlocator("//locators/SubmitTechnicalApprovalButton")));
	//	Clickon(getwebelement(xml.getlocator("//locators/ReturnToC4C")));
		
		SEEngagement();
		//---------------------------------------------------	
		CSTEngagement();
		
	}
	
	
}
	}

public void SEEngagement() throws InterruptedException, Exception 
{
	openurl("Admin");
//	Switchtotab();
	WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
	Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
	WaitforElementtobeclickable(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_SE_User")));
	Clickon(getwebelement(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_SE_User"))));
	WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
	Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
	WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
	Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
	WaitforElementtobeclickable(xml.getlocator("//locators/TechnicalApprovalTab"));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
	javascriptexecutor(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
	Clickon(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
	WaitforElementtobeclickable(xml.getlocator("//locators/SubmitToCSTApproval"));
	Clickon(getwebelement(xml.getlocator("//locators/SubmitToCSTApproval")));
	openurl("Admin");
	WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
	Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
	Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
	
	
}

public void CSTEngagement() throws InterruptedException, Exception 
{
	WaitforElementtobeclickable(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_SE_User")));
	Clickon(getwebelement(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_SE_User"))));
	WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
	Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
	WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
	Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
	WaitforElementtobeclickable(xml.getlocator("//locators/TechnicalApprovalTab"));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
	javascriptexecutor(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
	Clickon(getwebelement(xml.getlocator("//locators/TechnicalApprovalTab")));
	Clickon(getwebelement(xml.getlocator("//locators/CSTApproval")));
	openurl("Admin");
	WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
	Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
	Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
	
}
public void SubmitforApproval(String Approvalcase,Object[][] Inputdata) throws Exception
{
	if(ApprovalCase.get().equals("Deal Pricing"))
	{
		System.out.println("Deal Pricing Jouney Need to follow");
	}
	else if(ApprovalCase.get().equals("VP1 Sales") ||Approvalcase.equals("VP2 Sales"))
	{
		WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
		javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
		Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting For Loading to be Completed");
		WaitforElementtobeclickable(xml.getlocator("//locators/SubmitetoApproval"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submite for Approval");
		Clickon(getwebelement(xml.getlocator("//locators/SubmitetoApproval")));
		WaitforElementtobeclickable(xml.getlocator("//locators/ApproverCommentFinal"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submite for Approval");
		SendKeys(getwebelement(xml.getlocator("//locators/ApproverCommentFinal")),"Automation Comemnt");
		WaitforElementtobeclickable(xml.getlocator("//locators/FinalSubmit"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submite for Approval");
		Clickon(getwebelement(xml.getlocator("//locators/FinalSubmit")));
		
	}
	else {
		WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
		javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
		Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting For Loading to be Completed");
		WaitforElementtobeclickable(xml.getlocator("//locators/SubmitetoApproval"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submite for Approval");
		Clickon(getwebelement(xml.getlocator("//locators/SubmitetoApproval")));
		
		
	}

}
public void NavigatetoC4C() throws Exception
{
	Geturl(Getkeyvalue("C4C_URL"));

}
public void Movetoaccount(Object[][] Inputdata) throws Exception
{
	
	//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customer Section");
	//Thread.sleep(10000);

	Clickon(getwebelement(xml2.getlocator("//locators/CustomerSection")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Customer Section in Left Navigation");
	Clickon(getwebelement(xml2.getlocator("//locators/Accountlink")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Account link in navidation");
	Clickon(getwebelement(xml2.getlocator("//locators/OCN").replace("Accountnumber", Inputdata[0][0].toString())));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Account Name");
}
public void  MovetoOpportunuity(Object[][] Inputdata) throws Exception{
	
	Clickon(getwebelement(xml2.getlocator("//locators/OpportunuityTab")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Tab");
	Clickon(getwebelement(xml2.getlocator("//locators/Opportunuitynumber").replace("Opportunuitynumber", Inputdata[0][1].toString())));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Name ");
	Thread.sleep(10000);
	Clickon(getwebelement(xml2.getlocator("//locators/QuoteTab")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
	Thread.sleep(10000);
}
public void EditQuote() throws Exception {
	Clickon(getwebelement(xml2.getlocator("//locators/Quotenumber").replace("Quotenumber", QuoteID.get().toString())));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote Button");
	Thread.sleep(10000);
	Clickon(getwebelement(xml2.getlocator("//locators/QuoteActions")));
	Thread.sleep(10000);
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote Button");
	Clickon(getwebelement(xml2.getlocator("//locators/QuoteEdit")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote Button");
	Thread.sleep(10000);
	WaitforElementtobeclickable(xml2.getlocator("//locators/customersignatureTab"));
		
}
public ThreadLocal<String> DefineApprover(Object[][] Inputdata)
{  //String ApprovalCase = null;
System.out.println("Deal Class is"+DealClass.get());
System.out.println("Toatal TCV Disscount is"+TotalTCVdisscount.get());
	if(DealClass.get().equals("Bronze")&& !Inputdata[0][28].toString().equals("Yes")) 
	{
		if(TotalTCVdisscount.get()<5.00) {
			System.out.println("Self Approve");
			//ApprovalCase="Self Approve";
			ApprovalCase.set("Self Approve");
		}
		else if(TotalTCVdisscount.get()<10.00 && TotalTCVdisscount.get()>=5.00) {
			System.out.println("VP1 Sales");
			//ApprovalCase="VP1 Sales";
			ApprovalCase.set("VP1 Sales");
		}
		else if(TotalTCVdisscount.get()<15.00 && TotalTCVdisscount.get()>=10.00) {
			System.out.println("VP2 Sales");
			//ApprovalCase="VP2 Sales";
			ApprovalCase.set("VP2 Sales");
		}
		else if(TotalTCVdisscount.get()>15.00) {
			System.out.println("Deal Pricing");
			//ApprovalCase="Deal Pricing";
			ApprovalCase.set("Deal Pricing");
		}
		
	}
	else
	{
		System.out.println("Deal Pricing");
		//ApprovalCase="Deal Pricing";
		ApprovalCase.set("Deal Pricing");

		
	}
	
	return ApprovalCase;
}
public void ApproveQuote(String Approver) throws Exception
{
	switch(Approver)
	{
		case "Self Approve" :
		{
			System.out.println("No Further Approval Required");
			break;
		}
		case "VP2 Sales" :
		{
			// Click on Admin link
//			WaitforElementtobeclickable(xml.getlocator("//locators/Admin"));
//			javascriptexecutor(getwebelement(xml.getlocator("//locators/Admin")));
//			
//			Clickon(getwebelement(xml.getlocator("//locators/Admin")));
			openurl("Admin");
			Switchtotab();
			WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
			Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
			WaitforElementtobeclickable(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_VP1_Sales")));
			Clickon(getwebelement(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_VP1_Sales"))));
			WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
			Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
			
		
			WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
			Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
			
			WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
			javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
			Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			WaitforElementtobeclickable(xml.getlocator("//locators/ApproverComment"));
			SendKeys(getwebelement(xml.getlocator("//locators/ApproverComment")),"Approve");
			WaitforElementtobeclickable(xml.getlocator("//locators/ApproveasApprover"));
			Clickon(getwebelement(xml.getlocator("//locators/ApproveasApprover")));
			
			WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
			CloseProposalwindow();
			switchtodefault();
			break;
		}
		case "VP1 Sales" :
		{
		
			WaitforElementtobeclickable(xml.getlocator("//locators/Admin"));
			Clickon(getwebelement(xml.getlocator("//locators/Admin")));
			Switchtotab();
			WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
			Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));


			WaitforElementtobeclickable(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_VP1_Sales")));
			Clickon(getwebelement(xml.getlocator("//locators/UsernameProxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_VP1_Sales"))));
			WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
			Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
			
			WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
			Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
			
			WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
			javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Approval Tab");
			Clickon(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			WaitforElementtobeclickable(xml.getlocator("//locators/ApproverComment"));
			SendKeys(getwebelement(xml.getlocator("//locators/ApproverComment")),"Approve");
			WaitforElementtobeclickable(xml.getlocator("//locators/ApproveasApprover"));
			Clickon(getwebelement(xml.getlocator("//locators/ApproveasApprover")));
			
			WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			javascriptexecutor(getwebelement(xml.getlocator("//locators/ApprovalTab")));
			Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
			CloseProposalwindow();
			switchtodefault();
		}
		default:
		{
			System.out.println("Nothing to Do here");
			break;
		}
	}
}
}

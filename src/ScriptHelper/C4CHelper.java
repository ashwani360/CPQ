package ScriptHelper;

import org.dom4j.DocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverHelper;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class C4CHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\C4C.xml");
	xmlreader xml2=new xmlreader("src\\Locators\\Configuration.xml");
	public C4CHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}
	public void NavigatetoC4C() throws Exception
	{
		Geturl(Getkeyvalue("C4C_URL"));
	
	}
	// Code For Account Navigation
	public void Movetoaccount(Object[][] Inputdata) throws Exception
	{
		
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customer Section");
		//Thread.sleep(10000);
		if(!Inputdata[0][0].toString().equals("")) {
		WaitforElementtobeclickable(xml.getlocator("//locators/CustomerSection"));
		Clickon(getwebelement(xml.getlocator("//locators/CustomerSection")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Customer Section in Left Navigation");
		WaitforElementtobeclickable(xml.getlocator("//locators/Accountlink"));
		
		Clickon(getwebelement(xml.getlocator("//locators/Accountlink")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/AccountsDropdown"));
		Clickon(getwebelement(xml.getlocator("//locators/AccountsDropdown")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectAll")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Account link in navidation");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/AccountSearchField"));
		Search(Inputdata[0][0].toString(),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search For Account number"+Inputdata[0][0].toString());
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/OCN").replace("Accountnumber", Inputdata[0][0].toString()));
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Clickon(getwebelement(xml.getlocator("//locators/OCN").replace("Accountnumber", Inputdata[0][0].toString())));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Account Name");
		WaitforElementtobeclickable(xml.getlocator("//locators/customer"));
		}
		else
		{
			// Price Lookup without Quote
			WaitforElementtobeclickable(xml.getlocator("//locators/SalesSection"));
			Clickon(getwebelement(xml.getlocator("//locators/SalesSection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Customer Section in Left Navigation");
			WaitforElementtobeclickable(xml.getlocator("//locators/Quotelink"));
			
			Clickon(getwebelement(xml.getlocator("//locators/Quotelink")));
			WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		}
		//Thread.sleep(2000);
	}

	public void Product_Add() throws Exception
	{
		Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/ProductTab"));
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Clickon(getwebelement(xml.getlocator("//locators/ProductTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Tab in Account details");
		//Click on New to add Opportunity  Bandwidth
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/AddProductlink"));
		
		
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/AddProductlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New button to create New Opportunuity");
		Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Product/Fields").replace("FName", "Product"));
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Product")),"");
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Product")),"SD WAN");
		Thread.sleep(2000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Product")),Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Opportunuity Name");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Product/Fields").replace("FName", "Contract Length In Months"));
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Contract Length In Months")),"");
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Contract Length In Months")),"12");
		Thread.sleep(2000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Contract Length In Months")),Keys.ENTER);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Product/Fields").replace("FName", "Install and Setup"));
		getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Install and Setup")).clear();
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Install and Setup")),"500");
		Thread.sleep(2000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Install and Setup")),Keys.ENTER);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Product/Fields").replace("FName", "Bandwidth"));
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Bandwidth")),"");
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Bandwidth")),"10 MBPS");
		
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Bandwidth")),Keys.ENTER);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Product/Fields").replace("FName", "A End City"));
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "A End City")),"");
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "A End City")),"London");
		
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "A End City")),Keys.ENTER);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Product/Fields").replace("FName", "B End City"));
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "B End City")),"");
		Thread.sleep(3000);
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "B End City")),"London");
		
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "B End City")),Keys.ENTER);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Product/Fields").replace("FName", "Cloud Service Provider"));
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Cloud Service Provider")),"");
		Thread.sleep(3000);
		SendKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Cloud Service Provider")),"IBM");
		
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Product/Fields").replace("FName", "Cloud Service Provider")),Keys.ENTER);
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/AddProductlink"));
		
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/AddProductlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New button to create New Opportunuity");
		Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Product/Save"));
		
		
		Clickon(getwebelement(xml.getlocator("//locators/Product/Save")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New button to create New Opportunuity");
		Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		}
	//Code for Opportunity Add
	public void Opportunity_Add() throws Exception
	{
		Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/OpportunuityTab"));
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Clickon(getwebelement(xml.getlocator("//locators/OpportunuityTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Tab in Account details");
		//Click on New to add Opportunity
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Newlink"));
		
		
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Newlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New button to create New Opportunuity");
		Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(10000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Name"));
		SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/Name")),"Auto_opty3");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Opportunity/Name")),Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Opportunuity Name");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Offer"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/Offer")),"New Business");
		
		
		
			Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Offer")));
			WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Offer"));
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "New Business")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Offer type");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/PrimaryProgramme"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/PrimaryProgramme")),"Business Development");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/PrimaryProgramme")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/PrimaryProgramme"));
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Business Development")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Primary Program");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/PrimaryAttribute"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/PrimaryAttribute")),"Cisco");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/PrimaryAttribute")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/PrimaryAttribute"));
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Cisco")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter PrimaryAttribute");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/OpportunityCurrency"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/OpportunityCurrency"))," ");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/OpportunityCurrency")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/OpportunityCurrency"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/OpportunityCurrency")),"US Dollar");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/OpportunityCurrency"));
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Euro")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Currency");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/More"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/More")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on More link");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/SaveOpenOpty"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/SaveOpenOpty")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save and Open Opportunuity Option");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Clickmore"));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Clickmore")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on More link to Expand the Details");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Editopty"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Editopty")));
		
		//Enter Sales Unit detail
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		/*WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/SalesUnit"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/SalesUnit")));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/SalesUnit")));
		SendKeyswithAction(getwebelement(xml.getlocator("//locators/Opportunity/SalesUnit")),"Colt");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/SalesUnit"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/SalesUnit")),"Colt"); */
		//Enter Legal Complexity detail
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit Option to Edit the Details");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Lcomplexity"));
		SendKeyswithAction(getwebelement(xml.getlocator("//locators/Opportunity/Lcomplexity")),"");
		Thread.sleep(1000);
		//SendKeyswithAction(getwebelement(xml.getlocator("//locators/Opportunity/Lcomplexity")),"Standard");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Lcomplexity")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Standard")));
		//Enter Technical Complexity detail
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Legal Complexity");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Tcomplexity"));
		//SendKeyswithAction(getwebelement(xml.getlocator("//locators/Opportunity/Tcomplexity")),"1");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Tcomplexity")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "1")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Techincal Complexity");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/ClickSaveOpty"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/ClickSaveOpty")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save Detail");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/OptyId"));
		OpportunityID.set(Gettext(getwebelement(xml.getlocator("//locators/Opportunity/OptyId"))));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Newly Created Opportunuity ID is"+OpportunityID.get().toString());
		System.out.println(OpportunityID.get());	
	}
	public void Opportunity_AddContainer(Object[][] Inputdata) throws Exception
	{
		Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/OpportunuityTab"));
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Clickon(getwebelement(xml.getlocator("//locators/OpportunuityTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Tab in Account details");
		//Click on New to add Opportunity
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Newlink"));
		
		
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Newlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New button to create New Opportunuity");
		Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(10000);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Name"));
		SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/Name")),"Auto_opty3");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Opportunity/Name")),Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Opportunuity Name");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		if(Inputdata[0][3].toString().equals("New Container")) 
		{
			Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Offer")));
			WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Offer"));
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "New Business")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Offer type");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		}
		else if(Inputdata[0][3].toString().equals("Modify Container"))
		{
			Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Offer")));
			WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Offer"));
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Modify")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Offer type");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
			
		}
		
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/PrimaryProgramme"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/PrimaryProgramme")),"Business Development");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/PrimaryProgramme")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/PrimaryProgramme"));
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Business Development")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Primary Program");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/PrimaryAttribute"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/PrimaryAttribute")),"Cisco");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/PrimaryAttribute")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/PrimaryAttribute"));
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Cisco")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter PrimaryAttribute");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/OpportunityCurrency"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/OpportunityCurrency"))," ");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/OpportunityCurrency")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/OpportunityCurrency"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/OpportunityCurrency")),"US Dollar");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/OpportunityCurrency"));
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Euro")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Currency");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/More"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/More")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on More link");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/SaveOpenOpty"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/SaveOpenOpty")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save and Open Opportunuity Option");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Clickmore"));
		
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Clickmore")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on More link to Expand the Details");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Editopty"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Editopty")));
		
		//Enter Sales Unit detail
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		/*WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/SalesUnit"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/SalesUnit")));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/SalesUnit")));
		SendKeyswithAction(getwebelement(xml.getlocator("//locators/Opportunity/SalesUnit")),"Colt");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/SalesUnit"));
		//SendKeys(getwebelement(xml.getlocator("//locators/Opportunity/SalesUnit")),"Colt"); */
		//Enter Legal Complexity detail
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit Option to Edit the Details");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Lcomplexity"));
		SendKeyswithAction(getwebelement(xml.getlocator("//locators/Opportunity/Lcomplexity")),"");
		Thread.sleep(1000);
		//SendKeyswithAction(getwebelement(xml.getlocator("//locators/Opportunity/Lcomplexity")),"Standard");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Lcomplexity")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Standard")));
		//Enter Technical Complexity detail
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Legal Complexity");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/Tcomplexity"));
		//SendKeyswithAction(getwebelement(xml.getlocator("//locators/Opportunity/Tcomplexity")),"1");
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/Tcomplexity")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "1")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Techincal Complexity");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/ClickSaveOpty"));
		Clickon(getwebelement(xml.getlocator("//locators/Opportunity/ClickSaveOpty")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Save Detail");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunity/OptyId"));
		OpportunityID.set(Gettext(getwebelement(xml.getlocator("//locators/Opportunity/OptyId"))));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Newly Created Opportunuity ID is"+OpportunityID.get().toString());
		}
	
	public void  MovetoOpportunuity(Object[][] Inputdata) throws Exception{
		System.out.println("Current Opp ID="+OpportunityID.get().toString());
		if((Inputdata[0][1].toString().equals("New"))&& OpportunityID.get().toString().equals("New"))
		{
		Opportunity_Add();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: New Opportunuty Has been created");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/oppo"));
		Thread.sleep(2000);
		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
		Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
		//Thread.sleep(2000);
		
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		}
		else if(Inputdata[0][1].toString().equals("")& !Inputdata[0][0].toString().equals("")){
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Price Lookup Quote without Opportunuity");
			Thread.sleep(2000);
			WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
			Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
			Thread.sleep(2000);
		}
		else if(Inputdata[0][1].toString().equals("")& Inputdata[0][0].toString().equals("")){
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Price Lookup Quote without Opportunuity");
			
		}
		else
		{
			if(OpportunityID.get().toString().equals("New")) {
			OpportunityID.set(Inputdata[0][1].toString());
			}
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Exiting Opportunuity ID is to be used"+OpportunityID.get().toString());
			
			WaitforElementtobeclickable(xml.getlocator("//locators/OpportunuityTab"));
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Clickon(getwebelement(xml.getlocator("//locators/OpportunuityTab")));
		
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Tab");
		WaitforElementtobeclickable(xml.getlocator("//locators/AccountSearchField"));
		Search(OpportunityID.get().toString(),2);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Seach for Opportunuity");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunuitynumber").replace("Opportunuitynumber", OpportunityID.get().toString()));
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Clickon(getwebelement(xml.getlocator("//locators/Opportunuitynumber").replace("Opportunuitynumber", OpportunityID.get().toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Name ");
		//Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/oppo"));
		Thread.sleep(2000);
		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
		Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
		//Thread.sleep(2000);
		
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		}
		
		
	}
	public void  VerifyQuoteStage() throws Exception {
		try {
			Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
		}
		catch(Exception e)
		{
			System.out.println("No Proxy Login enabled");
		}
		openurl2(CurrentQuoteURL.get().toString());
		Thread.sleep(15000);
		getwebelement(xml2.getlocator("//locators/QuoteID"));
		Quotestatus.set(GetValueofInput(getwebelement(xml2.getlocator("//locators/Quotestatus"))));
		System.out.println("Quite Stage on Screee"+GetValueofInput(getwebelement(xml2.getlocator("//locators/Quotestatus"))));
		openurl("C4C");
		WaitforElementtobeclickable(xml.getlocator("//locators/SalesSection"));
		Clickon(getwebelement(xml.getlocator("//locators/SalesSection")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Customer Section in Left Navigation");
		WaitforElementtobeclickable(xml.getlocator("//locators/Quotelink"));
		
		Clickon(getwebelement(xml.getlocator("//locators/Quotelink")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Search(QuoteID.get().toString(),1);
		
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search for Current Quote ID"+QuoteID.get().toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/Quotenumber").replace("Quotenumber", QuoteID.get().toString()));
		WaitforElementtobeclickable(xml.getlocator("//locators/C4CQuoteStage").replace("QuoteNumber", QuoteID.get().toString()));
		System.out.println("Quite Stage on Screeen"+GetText(getwebelement(xml.getlocator("//locators/C4CQuoteStage").replace("QuoteNumber", QuoteID.get().toString()))));
		SoftAssert Verify=new SoftAssert();
		Verify.assertTrue(GetText(getwebelement(xml.getlocator("//locators/C4CQuoteStage").replace("QuoteNumber", QuoteID.get().toString()))).equalsIgnoreCase(Quotestatus.get().toString()),"Quote Stage are matching");
		openurl2(CurrentQuoteURL.get().toString());
		Thread.sleep(15000);
	}
	public void  MovetoOpportunuityContainer(Object[][] Inputdata) throws Exception{
		System.out.println("Current Opp ID="+OpportunityID.get().toString());
		if((Inputdata[0][1].toString().equals("New"))&& OpportunityID.get().toString().equals("New"))
		{
		Opportunity_AddContainer(Inputdata);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: New Opportunuty Has been created");
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/oppo"));
		Thread.sleep(2000);
		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
		Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
		//Thread.sleep(2000);
		
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		}
		
		else
		{
			if(OpportunityID.get().toString().equals("New")) {
			OpportunityID.set(Inputdata[0][1].toString());
			}
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Exiting Opportunuity ID is to be used"+OpportunityID.get().toString());
			
			WaitforElementtobeclickable(xml.getlocator("//locators/OpportunuityTab"));
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Clickon(getwebelement(xml.getlocator("//locators/OpportunuityTab")));
		
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Tab");
		WaitforElementtobeclickable(xml.getlocator("//locators/AccountSearchField"));
		Search(OpportunityID.get().toString(),2);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Seach for Opportunuity");
		WaitforElementtobeclickable(xml.getlocator("//locators/Opportunuitynumber").replace("Opportunuitynumber", OpportunityID.get().toString()));
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Clickon(getwebelement(xml.getlocator("//locators/Opportunuitynumber").replace("Opportunuitynumber", OpportunityID.get().toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Opportunuity Name ");
		//Thread.sleep(3000);
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		WaitforElementtobeclickable(xml.getlocator("//locators/oppo"));
		Thread.sleep(2000);
		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
		Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
		//Thread.sleep(2000);
		
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		}
		
		
	}
	public void AddQuote() throws Exception {
		
		//while (gettitle().toString().contains("SAP Cloud for Customer")) {
//			System.out.println(gettitle().toString());
//			System.out.println(gettitle().toString().contains("SAP Cloud for Customer"));
//			WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
//		Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
		//Thread.sleep(5000);
		
		Thread.sleep(3000);
		WaitforElementtobeclickable(xml.getlocator("//locators/AddQuote"));
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AddQuote")));
		Thread.sleep(10000);
		
		if(isElementPresent(xml.getlocator("//locators/PricelookupQuote"))) {	
			
		try {
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Add Colt Organization Country");
			WaitforElementtobeclickable(xml.getlocator("//locators/ColtOrganizationCountry"));
			Clickon(getwebelement(xml.getlocator("//locators/ColtOrganizationCountry")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "France")));
			//Enter Technical Complexity detail
			WaitforElementtobeclickable(xml.getlocator("//locators/SalesChanel"));
			Clickon(getwebelement(xml.getlocator("//locators/SalesChanel")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Wholesale")));
			WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		}
		catch(WebDriverException e)
		{
			System.out.println("Price Lookup in Account");
		}
			WaitforElementtobeclickable(xml.getlocator("//locators/QuoteCurrency"));
			Clickon(getwebelement(xml.getlocator("//locators/QuoteCurrency")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Euro")));
			WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
			Clickon(getwebelement(xml.getlocator("//locators/PriceLookupLegalComplexity")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "Standard")));
			WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/PriceLookupTechnicalComplexity")));
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/optionlist").replace("option", "1")));
			WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Techincal Complexity");
			Clickon(getwebelement(xml.getlocator("//locators/PriceLookupProceed")));
		}
		else
		{
			System.out.println(" Nothing to update here");
		}
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Quote Button");
		System.out.print(gettitle().toString());
		//}
		System.out.println("Out of While loop");
		waitForpagenavigated(1);
		// Verify the Opportunuity and Account data
	}
	public void EditQuote() throws Exception {
		Thread.sleep(5000);
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		//WaitforElementtobeclickable(xml.getlocator("//locators/AccountSearchField"));
		//Search(QuoteID.get().toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/SalesSection"));
		Clickon(getwebelement(xml.getlocator("//locators/SalesSection")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Customer Section in Left Navigation");
		WaitforElementtobeclickable(xml.getlocator("//locators/Quotelink"));
		
		Clickon(getwebelement(xml.getlocator("//locators/Quotelink")));
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Search(QuoteID.get().toString(),3);
		
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Search for Current Quote ID"+QuoteID.get().toString());
		WaitforElementtobeclickable(xml.getlocator("//locators/Quotenumber").replace("Quotenumber", QuoteID.get().toString()));
		Clickon(getwebelement(xml.getlocator("//locators/Quotenumber").replace("Quotenumber", QuoteID.get().toString())));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clikc on Quote ID"+QuoteID.get().toString());
		
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		Thread.sleep(2000);
		WaitforElementtobeclickable(xml.getlocator("//locators/OpenQuote"));
		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteActions"));
		Clickon(getwebelement(xml.getlocator("//locators/QuoteActions")));
		
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Actions Option");
		//Thread.sleep(2000);
		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteEdit"));
		Clickon(getwebelement(xml.getlocator("//locators/QuoteEdit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Edit option");
		
		//WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
		waitForpageload();
		waitForpagenavigated(1);
		
	}
	
	public void Search(String Searchvalue,int i) throws Exception
	{
	
		Thread.sleep(2000);	
		WaitforElementtobeclickable(xml.getlocator("//locators/AccountSearchField"));   
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Look for Search field");
			Clickon(getwebelement(xml.getlocator("//locators/AccountSearchField")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter search value & hit Enter");
			System.out.println("("+xml.getlocator("//locators/SearchValue")+")["+i+"]");
			SendKeys(getwebelement("("+xml.getlocator("//locators/SearchValue")+")["+i+"]"), Searchvalue);
			SendkeaboardKeys(getwebelement("("+xml.getlocator("//locators/SearchValue")+")["+i+"]"),Keys.ENTER);
			//Thread.sleep(3000);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter the Search keyword-"+Searchvalue);
			
	}
	public void CheckdocumentSigned() throws Exception
	{
		Thread.sleep(30000);
		Pagerefresh();
		Thread.sleep(30000);
		WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
		Clickon(getwebelement(xml.getlocator("//locators/customersignatureTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customer Signature Tab");
		
		waitForpageload();
	if(!(Gettext(getwebelement(xml.getlocator("//locators/Status"))).equals("Signed")))
	{
//		WaitforElementtobeclickable(xml.getlocator("//locators/Refresh"));
//		Clickon(getwebelement(xml.getlocator("//locators/Refresh")));
		Pagerefresh();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Refresh link");
		
	}
	}
public void AddContainerQuote() throws Exception {
		
		//while (gettitle().toString().contains("SAP Cloud for Customer")) {
//			System.out.println(gettitle().toString());
//			System.out.println(gettitle().toString().contains("SAP Cloud for Customer"));
//			WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
//		Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
		//Thread.sleep(5000);
	WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
	WaitforElementtobeclickable(xml.getlocator("//locators/oppo"));
	Thread.sleep(2000);
	WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
	Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
	
		WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
		
		WaitforElementtobeclickable(xml.getlocator("//locators/AddContainterQuote"));
		Thread.sleep(3000);
		
		Clickon(getwebelement(xml.getlocator("//locators/AddContainterQuote")));
		//Thread.sleep(10000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Quote Button");
		System.out.print(gettitle().toString());
		//}
		System.out.println("Out of While loop");
		waitForpagenavigated(1);
//		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
//		Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
//		Thread.sleep(5000);
//		Clickon(getwebelement(xml.getlocator("//locators/AddQuote")));
//		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteTab"));
//		Clickon(getwebelement(xml.getlocator("//locators/QuoteTab")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Quote Tab in Opportunuity Detail page ");
//		Thread.sleep(5000);
//		Clickon(getwebelement(xml.getlocator("//locators/AddQuote")));
//		Clickon(getwebelement(xml.getlocator("//locators/AddQuote")));
//		WaitforElementtobeclickable(xml.getlocator("//locators/AddQuote"));
//		Clickon(getwebelement(xml.getlocator("//locators/AddQuote")));
//		WaitforElementtobeclickable(xml.getlocator("//locators/AddQuote"));
//		Clickon(getwebelement(xml.getlocator("//locators/AddQuote")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote Button");
		//WaitforC4Cloader(xml.getlocator("//locators/C4Cloader"),1);
	}
}

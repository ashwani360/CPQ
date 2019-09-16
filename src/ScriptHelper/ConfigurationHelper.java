package ScriptHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverHelper;
import Driver.PropertyReader;
//import Driver.JsonReader;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class ConfigurationHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Configuration.xml");
	PropertyReader pr=new PropertyReader();
	Object[] ExploreID=new Object[2];
	List Completeset=new ArrayList();
	List Completesetnearnet=new ArrayList();
	public ConfigurationHelper(WebDriver parentdriver)
	{
		super(parentdriver);
		
	}

	public void AddProducttest(Object[][] Inputdata) throws Exception {
	  
		  for(int i=0;i<Inputdata.length;i++) {
		  System.out.println(Inputdata[i][2].toString());
		  }
	  
	}
	public void AddFamilyProduct(Object[][] Inputdata, int i) throws Exception
	
	{  	
		String Productfamility=Inputdata[i][2].toString().split(">")[0].trim();
		String ProductName=Inputdata[i][2].toString().split(">")[1].trim();
		System.out.println(Productfamility);
		System.out.println(ProductName);
		Selectfamily(Productfamility);
		ConfigureProduct(ProductName,Inputdata,i);
	}
	public void Selectfamily(String family) throws Exception
	{
		System.out.println("Family is"+family);
		switch(family)
		{
		   // case statements
		   // values must be of same type of expression
		   case "Ethernet" :
			   { 
				   
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
			   	WaitforElementtobeclickable((xml.getlocator("//locators/Ethernetfamily")));
				Clickon(getwebelement(xml.getlocator("//locators/Ethernetfamily")));
		      break; // break is optional
			   }
		   case "Optical" :
		   {ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
		   WaitforElementtobeclickable((xml.getlocator("//locators/Opticalfamily")));
			Clickon(getwebelement(xml.getlocator("//locators/Opticalfamily")));
		      break; // break is optional
		   }
		   
		   default :  
		   		{ ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
		   		WaitforElementtobeclickable((xml.getlocator("//locators/FamilyName").replace("Familyname", family)));
			 Clickon(getwebelement(xml.getlocator("//locators/FamilyName").replace("Familyname", family)));
			 break;
			   }
		}
	}
	
	public void Selectconnectivity(String type,String site,Object[] referece,Object[] nearnetreferece) throws Exception
	{
		if(site.equals("ASite"))
		{
			switch(type){
			
			case "Onnet":
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectOnnetAsite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetAsite")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Option for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/AsiteOnnet"));
				   
				Clickon(getwebelement(xml.getlocator("//locators/AsiteOnnet")));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				referece[0]="";
				break;
			}
			case "Automated Offnet":
			{
				// Click on the Offnet check button.
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/OffNetCheckASite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/OffNetCheckASite")));
	//			Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				// Select any Offnet option
				// Close the Pop-up for optional
				//Close the Site selection popup
				////Thread.sleep(2000);
				if(isElementPresent(xml.getlocator("//locators/ClosePopupOffnet")))
                {
                   Clickon(getwebelement(xml.getlocator("//locators/ClosePopupOffnet")));
                   System.out.println("Popup Window Handled");
                   Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
                }
                else
                {  
                	System.out.println("No Popup Window");
                }
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectAutomatedOffNet"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectAutomatedOffNet")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				  
				referece[0]="";
				break;
			}
			case "Manual Offnet":
			{
				// Click on the Offnet check button.
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/OffNetCheckASite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/OffNetCheckASite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				// Click on Manula request for OLO
				//Close the Site selection popup
				////Thread.sleep(2000);
				if(isElementPresent(xml.getlocator("//locators/ClosePopupOffnet")))
                {
                   Clickon(getwebelement(xml.getlocator("//locators/ClosePopupOffnet")));
                   System.out.println("Popup Window Handled");
                   Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
                }
                else
                {  
                	System.out.println("No Popup Window");
                }
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualEngagement"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualEngagement")));
				// Select the Options for the OLO Cost,Revsalidation,Re negosiation, OLO+DSL
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequest"));
			    
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequest")),"REQUEST MANUAL OLO");
				// Updated the data in Empac screen and create the request.
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				//WaitforElementtobeclickable(xml.getlocator("//locators/PriorityDropdown"));
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				System.out.println("Switched to Iframe");
				//Clickon(getwebelement(xml.getlocator("//locators/CPQExploreWindowfields")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority"));
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),"Actual");
			    waitForpageloadExplore();
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
			    waitForpageloadExplore();
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/GetQuoteButton"));
				
				Clickon(getwebelement(xml.getlocator("//locators/GetQuoteButton")));
				////Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				waitForpageloadExplore();
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ClickOloButton")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[0]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualOffNet"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectManualOffNet")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				break;
			}
			case "Automated DSL":
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/DSLCheckASite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/DSLCheckASite")));
	//			Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				// Select any Offnet option
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/AutomatedDSLCheckASite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/AutomatedDSLCheckASite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				referece[0]="";
				break;
			}
			case "Manual DSL":
			{ 
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/DSLCheckASite"));
		    
				Clickon(getwebelement(xml.getlocator("//locators/DSLCheckASite")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
			// Select any Offnet option
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualEngagement"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualEngagement")));
				// Select the Options for the OLO Cost,Revsalidation,Re negosiation, OLO+DSL
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequest"));
			    
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequest")),"REQUEST MANUAL DSL");
				// Updated the data in Empac screen and create the request.
				CancelJavaScriptMethod();
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				//WaitforElementtobeclickable(xml.getlocator("//locators/PriorityDropdown"));
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				System.out.println("Switched to Iframe");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority"));
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),"Actual");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
			    waitForpageloadExplore();
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/GetQuoteButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/GetQuoteButton")));
				////Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ClickOloButton")));
				waitForpageloadExplore();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[0]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				// Select the Manula DSL option
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualDSLOptionAEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualDSLOptionAEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				break;

			}
			case "Nearnet":
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/NearNetAsite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/NearNetAsite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				
				referece[0]="";
				break;
			}
			case "Manual Nearnet":
			{
				// Click on Manual request for NearNet
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualEngagement"));
				Clickon(getwebelement(xml.getlocator("//locators/ManualEngagement")));
				
				// Updated the data in Empac screen and create the request.
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequest"));
			    
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequest")),"REQUEST MANUAL NEARNET");
				//WaitforElementtobeclickable(xml.getlocator("//locators/PriorityDropdown"));
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				Thread.sleep(4000);
				waitForpageloadExplore();
				WaitforElementtobeclickable((xml.getlocator("//locators/Nearnetpopup")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type"));
				SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type")),"Existing Building Second Entry");
				SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type")),Keys.ENTER);
				waitForpageloadExplore();
				////Thread.sleep(2000);
				Clickon(getwebelement(xml.getlocator("//locators/ClickSubmitEmacNearNet")));
				Thread.sleep(2000);
				AcceptJavaScriptMethod();
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				nearnetreferece[0]=(Gettext(getwebelement(xml.getlocator("//locators/ExpRequestIDNearNet"))));
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualNearNetAsite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualNearNetAsite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				referece[0]="";
				break;
				
			}
			case "Offnet Revalidation":
			{
				
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequest"));
				
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequest")),"UPDATE SELECTED REQUEST");
				// Updated the data in Empac screen and create the request.
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				// Select The Revalidation or Renegotation options
				////Thread.sleep(2000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Revalidate"));
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Revalidate")));
				
				waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
			    waitForpageloadExplore();
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Revalidate"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Revalidate")));
				
				////Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement("("+xml.getlocator("//locators/ClickOloButton")+")[2]"));
				
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[0]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualOffNetRevalidate"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectManualOffNetRevalidate")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				
				break;
			}
			case "Offnet Renegotiation":
			{
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequest"));
				
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequest")),"UPDATE SELECTED REQUEST");
				// Updated the data in Empac screen and create the request.
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				// Select The Revalidation or Renegotation options
				////Thread.sleep(2000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Renegotiate"));
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Renegotiate")));
				SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
                WaitforElementtobeclickable(xml.getlocator("//locators/Renagociate"));
                waitForpageloadExplore();
				Clickon(getwebelement(xml.getlocator("//locators/Renagociate")));
				////Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement("("+xml.getlocator("//locators/ClickOloButton")+")[2]"));
				waitForpageloadExplore();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[0]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualOffNetRevalidate"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectManualOffNetRevalidate")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				break;
			}
			
			case "Nearnet Revalidation":
			{
				break;
			}
			case "Manual Offnet+DSL":
			{
				// Click on the Offnet check button.
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/OffNetCheckASite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/OffNetCheckASite")));
				////Thread.sleep(2000);
				if(isElementPresent(xml.getlocator("//locators/ClosePopupOffnet")))
                {
                   Clickon(getwebelement(xml.getlocator("//locators/ClosePopupOffnet")));
                   System.out.println("Popup Window Handled");
                   Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
                }
                else
                {  
                	System.out.println("No Popup Window");
                }
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/DSLCheckASite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/DSLCheckASite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				// Click on Manula request for OLO
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualEngagement"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualEngagement")));
				// Select the Options for the OLO Cost,Revsalidation,Re negosiation, OLO+DSL
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequest"));
			    
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequest")),"REQUEST MANUAL OLO AND/OR MANUAL DSL");
				// Updated the data in Empac screen and create the request.
				CancelJavaScriptMethod();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				//WaitforElementtobeclickable(xml.getlocator("//locators/PriorityDropdown"));
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				System.out.println("Switched to Iframe");
				//Clickon(getwebelement(xml.getlocator("//locators/CPQExploreWindowfields")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority"));
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),"Actual");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
			    waitForpageloadExplore();
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/GetQuoteButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/GetQuoteButton")));
				waitForpageloadExplore();
				////Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ClickOloButton")));
				waitForpageloadExplore();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[0]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualOffNet"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectManualOffNet")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				break;
			}
			default:
			{
				break;
			}
			
			}
			
		}
		else
		{
			switch(type){
			
			case "Onnet":
			{
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click the On net Tab for B site");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectOnnetBsite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetBsite")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Clickon(getwebelement(xml.getlocator("//locators/BsiteOnnet")));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				referece[1]="";
				break;
			}
			case "Automated Offnet":
			{
				
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/OffNetCheckBSite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/OffNetCheckBSite")));
				////Thread.sleep(2000);
				if(isElementPresent(xml.getlocator("//locators/ClosePopupOffnet")))
                {
                   Clickon(getwebelement(xml.getlocator("//locators/ClosePopupOffnet")));
                   System.out.println("Popup Window Handled");
                   Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
                }
                else
                {  
                	System.out.println("No Popup Window");
                }
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectAutomatedOffNetBEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectAutomatedOffNetBEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				  
				referece[1]="";
				break;
			}
			case "Manual Offnet":
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/OffNetCheckBSite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/OffNetCheckBSite")));
				////Thread.sleep(2000);
				if(isElementPresent(xml.getlocator("//locators/ClosePopupOffnet")))
                {
                   Clickon(getwebelement(xml.getlocator("//locators/ClosePopupOffnet")));
                   System.out.println("Popup Window Handled");
                   Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
                }
                else
                {  
                	System.out.println("No Popup Window");
                }
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualEngagementBEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualEngagementBEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequestBEnd"));
			    
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequestBEnd")),"REQUEST MANUAL OLO");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority"));
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),"Actual");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
			    waitForpageloadExplore();
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/GetQuoteButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/GetQuoteButton")));
				////Thread.sleep(6000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ClickOloButton")));
				waitForpageloadExplore();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[1]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//switchtodefault();
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualOffNetBEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectManualOffNetBEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				break;
			}
			case "Automated DSL":
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/DSLCheckBSite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/DSLCheckBSite")));
	//			Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				// Select any Offnet option
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/AutomatedDSLCheckBSite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/AutomatedDSLCheckBSite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				referece[0]="";
				break;
			}
			case "Manual DSL":
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/DSLCheckBSite"));
		    
				Clickon(getwebelement(xml.getlocator("//locators/DSLCheckBSite")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
			// Select any Offnet option
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualEngagementBEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualEngagementBEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				
				// Select the Options for the OLO Cost,Revsalidation,Re negosiation, OLO+DSL
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				//WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequestBEnd"));
			    
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequestBEnd")),"REQUEST MANUAL DSL");
				// Updated the data in Empac screen and create the request.
				CancelJavaScriptMethod();
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				//WaitforElementtobeclickable(xml.getlocator("//locators/PriorityDropdown"));
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				System.out.println("Switched to Iframe");
				waitForpageloadExplore();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority"));
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),"Actual");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
				
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/GetQuoteButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/GetQuoteButton")));
				
				////Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ClickOloButton")));
				waitForpageloadExplore();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[0]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				// Select the Manula DSL option
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualDSLOptionBEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualDSLOptionBEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				break;

			}
			case "Nearnet":
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/NearNetBsite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/NearNetBsite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				
				referece[0]="";
				break;
			}
			case "Manual Nearnet":
			{// Click on Manual request for NearNet
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualEngagementBEnd"));
				Clickon(getwebelement(xml.getlocator("//locators/ManualEngagementBEnd")));
				
				// Updated the data in Empac screen and create the request.
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequestBEnd"));
			    
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequestBEnd")),"REQUEST MANUAL NEARNET");
				//WaitforElementtobeclickable(xml.getlocator("//locators/PriorityDropdown"));
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				WaitforElementtobeclickable((xml.getlocator("//locators/Nearnetpopup")));
				waitForpageloadExplore();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type"));
				SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type")),"Existing Building Second Entry");
				Thread.sleep(2000);
				Clickon(getwebelement(xml.getlocator("//locators/ClickSubmitEmacNearNet")));
				////Thread.sleep(2000);
				try {
				AcceptJavaScriptMethod();
				}
				catch(Exception e)
				{
					System.out.println("No Alert");
				}
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				nearnetreferece[1]=(Gettext(getwebelement(xml.getlocator("//locators/ExpRequestIDNearNet"))));
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualNearNetAsite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualNearNetAsite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				referece[0]="";
			
				break;
			}
			case "Offnet Revalidation":
			{
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequestBEnd"));
				
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequestBEnd")),"UPDATE SELECTED REQUEST");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				// Select The Revalidation or Renegotation options
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Revalidate"));
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Revalidate")));
				
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
			    waitForpageloadExplore();
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Revalidate"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Revalidate")));
				////Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement("("+xml.getlocator("//locators/ClickOloButton")+")[2]"));
				waitForpageloadExplore();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[1]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//switchtodefault();
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualOffNetRevaidateBEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectManualOffNetRevaidateBEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				
				break;
			}
			case "Offnet Renegotiation":
			{
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequestBEnd"));
				
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequestBEnd")),"UPDATE SELECTED REQUEST");
				// Updated the data in Empac screen and create the request.
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				// Select The Revalidation or Renegotation options
				////Thread.sleep(2000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Renegotiate"));
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Renegotiate")));
				SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
                WaitforElementtobeclickable(xml.getlocator("//locators/Renagociate"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Renagociate")));
				////Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement("("+xml.getlocator("//locators/ClickOloButton")+")[2]"));
				waitForpageloadExplore();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[0]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualOffNetRevaidateBEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectManualOffNetRevaidateBEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				break;
			}
			
			case "Nearnet Revalidation":
			{
				break;
			}
			case "Manual Offnet+DSL":
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/OffNetCheckBSite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/OffNetCheckBSite")));
				////Thread.sleep(2000);
				if(isElementPresent(xml.getlocator("//locators/ClosePopupOffnet")))
                {
                   Clickon(getwebelement(xml.getlocator("//locators/ClosePopupOffnet")));
                   System.out.println("Popup Window Handled");
                   Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
                }
                else
                {  
                	System.out.println("No Popup Window");
                }
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/DSLCheckBSite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/DSLCheckBSite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ManualEngagementBEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ManualEngagementBEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequestBEnd"));
			    
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequestBEnd")),"REQUEST MANUAL OLO AND/OR MANUAL DSL");
				CancelJavaScriptMethod();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority"));
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),"Actual");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
			    waitForpageloadExplore();
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
			    waitForpageloadExplore();
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/GetQuoteButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/GetQuoteButton")));
				////Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				Waitforswitchtofram2("//iframe[@name='exploreEngagementComponent']");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				waitForpageloadExplore();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ClickOloButton")));
				waitForpageloadExplore();
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/RequestId"));
				referece[1]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				//RequestID.set();
				switchtodefault();
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Closebutton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Closebutton")));
				// Select the Newly Created record with waiting for third party into the Grid system.
				
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//switchtodefault();
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualOffNetBEnd"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/SelectManualOffNetBEnd")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				break;
			}
			default:
			{
				break;
			}
			
			}
			
		}
	}
	
	
	public void FeidldlevelValidationAccount(Object[][] Inputdata) throws InterruptedException, DocumentException, Exception {

        ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Save Button");

    Expandthesection(getwebelement(xml.getlocator("//locators/SectionName").replace("Sectionname", "Account Details")),getwebelement(xml.getlocator("//locators/Clickableelemt").replace("Sectionname", "Account Details")));

        ////Thread.sleep(5000);
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/OCNCPQ"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/OCNName"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/Address"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/SalesChannel"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/PricingSegment"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/CustomerTear"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/ColtOrganizationCountry"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/AccountValidation"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/NewLogoflag"))).equals(null));
 NewLogoflag.set(GetValueofInput(getwebelement(xml.getlocator("//locators/NewLogoflag"))).toString());
 }

 public void FeidldlevelValidationOpp(Object[][] Inputdata) throws InterruptedException, DocumentException, Exception {
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/Oppo"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/OppName"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/Offertype"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/Createdby"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/Technical"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/Leagal"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/Dealclass"))).equals(null));
 Assert.assertTrue(!GetValueofInput(getwebelement(xml.getlocator("//locators/goApproval"))).equals(null));
 }
 public void selectproduct(String Productname) throws InterruptedException, DocumentException
 {
 	   
	   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
	    ////Thread.sleep(3000);
	    WaitforElementtobeclickable((xml.getlocator("//locators/Productname").replace("Productname", Productname)));
		Clickon(getwebelement(xml.getlocator("//locators/Productname").replace("Productname", Productname)));
		
		
 }
	public void ConfigureProduct(String Prodcutname,Object[][] Inputdata, int i) throws Exception
	{		Object[] ExploreID=new Object[2];
			ExploreID[0]="";
			ExploreID[1]="";
			Object[] ExploreIDNearnet=new Object[2];
			ExploreIDNearnet[0]="";
			ExploreIDNearnet[1]="";
			Connectivitytype.set(Inputdata[i][11].toString());
			Connectivitytype.set(Inputdata[i][12].toString());
			System.out.println("Product is"+Prodcutname);
		switch(Prodcutname)
		{
		   // case statements
		   // values must be of same type of expression
		case "Colt IP Access" :
		   { 
			   selectproduct(Prodcutname);
			   waitForpageload();
			   Clickon(getwebelement(xml.getlocator("//locators/Start")));
			   
			   Getmapiframeloaded(xml.getlocator("//locators/GoogleMapifram"),xml.getlocator("//locators/Legend")); 
				//////Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Asite"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
				SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
				////Thread.sleep(2000);
				//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				javascriptexecutor(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
				Select(getwebelement(xml.getlocator("//locators/ContracttermIP")), Inputdata[i][7].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
				Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), Inputdata[i][9].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resiliency");
				Select(getwebelement(xml.getlocator("//locators/ServiceResilenceIP")), Inputdata[i][10].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Select(getwebelement(xml.getlocator("//locators/Billingtype")), Inputdata[i][29].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				if(Inputdata[i][30].toString().equals("Yes")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
					Clickon(getwebelement(xml.getlocator("//locators/FutureSupport")));
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				}
				//----------------------------------
				if(Inputdata[i][11].toString().contains("Offnet Revalidation")||Inputdata[i][11].toString().contains("Offnet Renegotiation")) {
					Selectconnectivity("Manual Offnet","ASite",ExploreID,ExploreIDNearnet);
					Rerunrequired.set("Yes");
				}
				else if(Inputdata[i][11].toString().contains("Nearnet Revalidation"))
				{
					Selectconnectivity("Manual Nearnet","ASite",ExploreID,ExploreIDNearnet);
					Rerunrequired.set("Yes");
					
				}
				else {
				Selectconnectivity(Inputdata[i][11].toString(),"ASite",ExploreID,ExploreIDNearnet);
				
				}
				
				///----------------------------------------------------------------------------------------------
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button");
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				Select(getwebelement(xml.getlocator("//locators/Routertype")), Inputdata[i][32].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Select(getwebelement(xml.getlocator("//locators/LanInterface")), Inputdata[i][33].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				String[] Allfeatures=Inputdata[i][34].toString().split(",");
				System.out.println("Number of Featues:"+Allfeatures.length);
				for(int j=0;j<Allfeatures.length;j++)
				{
					System.out.println("Featues Name:"+Allfeatures[j]);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button");
					Clickon(getwebelement(xml.getlocator("//locators/RouterFeature").replace("Featurename", Allfeatures[j])));
				}
				Select(getwebelement(xml.getlocator("//locators/Interfacetype")), Inputdata[i][35].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Select(getwebelement(xml.getlocator("//locators/interface")), Inputdata[i][36].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Select(getwebelement(xml.getlocator("//locators/Connector")), Inputdata[i][37].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Select(getwebelement(xml.getlocator("//locators/IPAddressFomate")), Inputdata[i][38].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				if(!Inputdata[i][39].toString().equals(""))
				{
					Select(getwebelement(xml.getlocator("//locators/IPV4Type")), Inputdata[i][39].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Select(getwebelement(xml.getlocator("//locators/IPV4number")), Inputdata[i][40].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				}
				if(!Inputdata[i][41].toString().equals(""))
				{
					Select(getwebelement(xml.getlocator("//locators/IPV6Type")), Inputdata[i][41].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Select(getwebelement(xml.getlocator("//locators/IPV6number")), Inputdata[i][42].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				}
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button");
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				// Site Addons Use Feature Tab
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button");
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				Select(getwebelement(xml.getlocator("//locators/Layer3Resilency")), Inputdata[i][43].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button");
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				if(isElementdisplayed(xml.getlocator("//locators/SecondarySite")))
				{
					if(Inputdata[i][12].toString().equals(""))
					{
						Clickon(getwebelement(xml.getlocator("//locators/Sameasprimary")));
						
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
						SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][6].toString());
						////Thread.sleep(2000);
						//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
						//getwebelement(xml.getlocator("//locators/LoadingDailog"));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					}
					Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
					Select(getwebelement(xml.getlocator("//locators/ServiceBandwidthBackup")), Inputdata[i][43].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resiliency");
					Select(getwebelement(xml.getlocator("//locators/ServiceResilenceLayer2")), Inputdata[i][44].toString());
					if(Inputdata[i][30].toString().equals("Yes")) {
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
						Clickon(getwebelement(xml.getlocator("//locators/FutureSupport")));
						//getwebelement(xml.getlocator("//locators/LoadingDailog"));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					}
					//----------------------------------
					if(Inputdata[i][12].toString().contains("Offnet Revalidation")||Inputdata[i][12].toString().contains("Offnet Renegotiation")) {
						Selectconnectivity("Manual Offnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
					}
					else if(Inputdata[i][12].toString().contains("Nearnet Revalidation"))
					{
						Selectconnectivity("Manual Nearnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
						
					}
					else {
					Selectconnectivity(Inputdata[i][12].toString(),"ASite",ExploreID,ExploreIDNearnet);
					
					}
					if(!Inputdata[i][12].toString().equals("")) {
					Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
					Select(getwebelement(xml.getlocator("//locators/Routertype")), Inputdata[i][31].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Select(getwebelement(xml.getlocator("//locators/LanInterface")), Inputdata[i][32].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					String[] AllfeaturesB=Inputdata[i][33].toString().split(",");
					for(int j=0;i<AllfeaturesB.length;i++)
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button");
						Clickon(getwebelement(xml.getlocator("//locators/RouterFeature").replace("Featurename", Allfeatures[i])));
					}
					}
					Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
					// Site Addons Use Feature Tab
					Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
					
				}
				if(Inputdata[i][45].toString().equals("Yes")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
					Clickon(getwebelement(xml.getlocator("//locators/Diversity")));
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					if(!Getattribute(getwebelement(xml.getlocator("//locators/ParitalSave")),"checked").equals("checked")) {
					Clickon(getwebelement(xml.getlocator("//locators/ParitalSave")));
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					}
					
				}
				Thread.sleep(2000);
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				
				
				// Service Addone current column used for the Service Addone
				// For Site Level Addition column can be added
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				if(Inputdata[i][47].toString().equals("Yes")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
					Clickon(getwebelement(xml.getlocator("//locators/BespokeRequired")));
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					if(!Getattribute(getwebelement(xml.getlocator("//locators/ParitalSave")),"checked").equals("checked")) {
						Clickon(getwebelement(xml.getlocator("//locators/ParitalSave")));
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						}
				}
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				Select(getwebelement(xml.getlocator("//locators/ExitingLeadtime")), "No");
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Thread.sleep(2000);
				Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheckIP")));
				Clickon(getwebelement(xml.getlocator("//locators/Promotion").replace("promotion", Inputdata[i][29].toString())));
				if(isElementPresent(xml.getlocator("//locators/PPT/Save")))
				{
					Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
				}
				else 
				{
					Clickon(getwebelement(xml.getlocator("//locators/PPT/AddtoTransaction")));
				}
		   }
		   case "Ethernet Line" :
			   { 
				   
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
				    ////Thread.sleep(3000);
				    WaitforElementtobeclickable((xml.getlocator("//locators/EthernetProductP2P")));
					Clickon(getwebelement(xml.getlocator("//locators/EthernetProductP2P")));
					Getmapiframeloaded(xml.getlocator("//locators/GoogleMapifram"),xml.getlocator("//locators/Legend")); 
					//////Thread.sleep(5000);
					//WaitforElementtobeclickable(());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
					////Thread.sleep(2000);
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter B Siter Address");
					 //////Thread.sleep(2000);
					SendKeys(getwebelement(xml.getlocator("//locators/Bsite")),Inputdata[i][6].toString());
					////Thread.sleep(2000);
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Bsite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					//////Thread.sleep(3000);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
					Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Detail Tab");
					Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
					////// Code for Near Net Selection
					SelectPromotion(Inputdata, i);
					///////////////////////////////////
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
					Select(getwebelement(xml.getlocator("//locators/Contractterm")), Inputdata[i][7].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
					Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), Inputdata[i][9].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resiliency");
					Select(getwebelement(xml.getlocator("//locators/ServiceResilence")), Inputdata[i][10].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					//----------------------------------
					if(Inputdata[i][11].toString().contains("Offnet Revalidation")||Inputdata[i][11].toString().contains("Offnet Renegotiation")) {
						Selectconnectivity("Manual Offnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
					}
					else if(Inputdata[i][11].toString().contains("Nearnet Revalidation"))
					{
						Selectconnectivity("Manual Nearnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
						
					}
					else {
					Selectconnectivity(Inputdata[i][11].toString(),"ASite",ExploreID,ExploreIDNearnet);
					
					}
					if(Inputdata[i][12].toString().contains("Offnet Revalidation")||Inputdata[i][12].toString().contains("Offnet Renegotiation"))
					{
						Selectconnectivity("Manual Offnet","BSite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
					}
					else if(Inputdata[i][12].toString().contains("Nearnet Revalidation"))
					{
						Selectconnectivity("Manual Nearnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
						
					}
					else {
						Selectconnectivity(Inputdata[i][12].toString(),"BSite",ExploreID,ExploreIDNearnet);
					}
					///----------------------------------------------------------------------------------------------
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Feature Tab");
					if(!Inputdata[i][13].toString().equals("")) {
					Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
					Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					}
					String exception="No Exception";
					try {
					exception=Gettext(getwebelement2(xml.getlocator("//locators/PPT/BasePrice")));
					System.out.println("Exception is"+exception);
					}
					catch(Exception e)
					{
						System.out.println("Exception is"+exception);
					}
					if(exception.equalsIgnoreCase("Price Not Found"))
					{
						System.out.println("Pricing Execption found nd needs to partial save");
						javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
						
						Clickon(getwebelement(xml.getlocator("//locators/PPT/PartialSave")));
						//Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
						
					}
					AdditionalProductData();
//					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
//					Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
					
					
					
					if(isElementPresent(xml.getlocator("//locators/PPT/Save")))
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
					}
					else 
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/AddtoTransaction")));
					}
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		            
					break; // break is optional
			   }
		   case "Ethernet Hub" :
		   {

			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
			   WaitforElementtobeclickable((xml.getlocator("//locators/EthernetHub")));
			   Clickon(getwebelement(xml.getlocator("//locators/EthernetHub")));
			   Getmapiframeloaded(xml.getlocator("//locators/GoogleMapifram"),xml.getlocator("//locators/Legend")); 
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
				SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
				////Thread.sleep(1000);
				//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
				////Thread.sleep(10000);
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
				javascriptexecutor(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Detail Tab");
				Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
			////// Code for Near Net Selection
				SelectPromotion(Inputdata, i);
								///////////////////////////////////
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
				Select(getwebelement(xml.getlocator("//locators/Contractterm")), Inputdata[i][7].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
				Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), Inputdata[i][9].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resiliency");
				Select(getwebelement(xml.getlocator("//locators/ServiceResilence")), Inputdata[i][10].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Selectconnectivity(Inputdata[i][11].toString(),"ASite",ExploreID,ExploreIDNearnet);
				ExploreID[1]="";
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
				javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Feature Tab");
				if(!Inputdata[i][13].toString().equals("")) {
					Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
					Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					}
//				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
//				Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
				
				String exception="No Exception";
				try {
				exception=Gettext(getwebelement2(xml.getlocator("//locators/PPT/BasePrice")));
				System.out.println("Exception is"+exception);
				}
				catch(Exception e)
				{
					System.out.println("Exception is"+exception);
				}
				if(exception.equalsIgnoreCase("Price Not Found"))
				{
					Clickon(getwebelement(xml.getlocator("//locators/PPT/PartialSave")));
					//Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
					
				}
				AdditionalProductData();

				if(isElementPresent(xml.getlocator("//locators/PPT/Save")))
				{
					Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
				}
				else 
				{
					
					Clickon(getwebelement(xml.getlocator("//locators/PPT/AddtoTransaction")));
				}
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				
				break; // break is optional
		   }
		   case "Ethernet Spoke" :
		   {
			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
			   WaitforElementtobeclickable((xml.getlocator("//locators/EtherNetSpoke")));
			   Clickon(getwebelement(xml.getlocator("//locators/EtherNetSpoke")));
			   Getmapiframeloaded(xml.getlocator("//locators/GoogleMapifram"),xml.getlocator("//locators/Legend")); 
				 if(Inputdata[i][3].toString().equals("New")) {
				  // Select New
				    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
					Select(getwebelement(xml.getlocator("//locators/HubType")), Inputdata[i][3].toString());
					  //Select Hub
				   //Inputdata[i][3].toString().equals("New")
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
					//Select(getwebelement(xml.getlocator("//locators/ListofNewhub")), Inputdata[i][4].toString());
					Clickon(getwebelement(xml.getlocator("//locators/HublistExpander")));
					System.out.println("Need to select the hub"+xml.getlocator("//locators/HubReferencelist").replace("Hubnumber", Inputdata[i][3].toString()));
					Clickon(getwebelement(xml.getlocator("//locators/HubReferencelist").replace("Hubnumber", Inputdata[i][4].toString())));
					//WaitforElementtobeclickable((xml.getlocator("//locators/HubAddresslabel")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					//Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Spoke Site Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][6].toString());
					////Thread.sleep(1000);
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					////Thread.sleep(3000);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
					Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Detail Tab");
					Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
				////// Code for Near Net Selection
					SelectPromotion(Inputdata, i);
									///////////////////////////////////
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
					Select(getwebelement(xml.getlocator("//locators/Contractterm")), Inputdata[i][7].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
					Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), Inputdata[i][9].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resiliency");
					Select(getwebelement(xml.getlocator("//locators/ServiceResilence")), Inputdata[i][10].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					if(Inputdata[i][11].toString().contains("Offnet Revalidation")||Inputdata[i][11].toString().contains("Offnet Renegotiation")) {
						Selectconnectivity("Manual Offnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
					}
					else if(Inputdata[i][11].toString().contains("Nearnet Revalidation"))
					{
						Selectconnectivity("Manual Nearnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
						
					}
					else {
					Selectconnectivity(Inputdata[i][11].toString(),"ASite",ExploreID,ExploreIDNearnet);
					
					}
					ExploreID[1]="";
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					if(!Inputdata[i][13].toString().equals("")) {
						Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
						Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						}
//					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
//					Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
					String exception="No Exception";
					try {
					exception=Gettext(getwebelement2(xml.getlocator("//locators/PPT/BasePrice")));
					System.out.println("Exception is"+exception);
					}
					catch(Exception e)
					{
						System.out.println("Exception is"+exception);
					}
					if(exception.equalsIgnoreCase("Price Not Found"))
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/PartialSave")));
						//Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
						
					}
					AdditionalProductData();
					
					
					if(isElementPresent(xml.getlocator("//locators/PPT/Save")))
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
					}
					else 
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/AddtoTransaction")));
					}
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			   }
			   else
			   {
				   // Select Exiting
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
				   Select(getwebelement(xml.getlocator("//locators/HubType")), Inputdata[i][3].toString());
				   WaitforElementtobeclickable(xml.getlocator("//locators/HubReference"));
				   // Enter Hub Reference Number
				   // 
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
				   SendKeys(getwebelement(xml.getlocator("//locators/HubReference")),Inputdata[i][4].toString());
					
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
				   WaitforElementtobeclickable(xml.getlocator("//locators/HubSite"));
					SendKeys(getwebelement(xml.getlocator("//locators/HubSite")),Inputdata[i][5].toString());
					
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/HubSite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Spoke Siter Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][6].toString());
					////Thread.sleep(1000);
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					//////Thread.sleep(3000);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
					Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Detail Tab");
					Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
				////// Code for Near Net Selection
					SelectPromotion(Inputdata, i);
									///////////////////////////////////
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
					Select(getwebelement(xml.getlocator("//locators/Contractterm")), Inputdata[i][7].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
					Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), Inputdata[i][9].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resiliency");
					Select(getwebelement(xml.getlocator("//locators/ServiceResilence")), Inputdata[i][10].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					if(Inputdata[i][11].toString().contains("Offnet Revalidation")||Inputdata[i][11].toString().contains("Offnet Renegotiation")) {
						Selectconnectivity("Manual Offnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
					}
					else if(Inputdata[i][11].toString().contains("Nearnet Revalidation"))
					{
						Selectconnectivity("Manual Nearnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
						
					}
					else {
					Selectconnectivity(Inputdata[i][11].toString(),"ASite",ExploreID,ExploreIDNearnet);
					
					}
					ExploreID[1]="";
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					if(!Inputdata[i][13].toString().equals("")) {
						Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
						Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						}
					String exception="No Exception";
					try {
					exception=Gettext(getwebelement2(xml.getlocator("//locators/PPT/BasePrice")));
					System.out.println("Exception is"+exception);
					}
					catch(Exception e)
					{
						System.out.println("Exception is"+exception);
					}
					if(exception.equalsIgnoreCase("Price Not Found"))
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/PartialSave")));
						//Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
						
					}
					AdditionalProductData();
					
					
					if(isElementPresent(xml.getlocator("//locators/PPT/Save")))
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
					}
					else 
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/AddtoTransaction")));
					}
//					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
//					Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				   
			   }
		      break; // break is optional
		   }
		   case "Wave" :
		   {
			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
			   WaitforElementtobeclickable((xml.getlocator("//locators/OpticalWave")));
			   Clickon(getwebelement(xml.getlocator("//locators/OpticalWave")));
			   Getmapiframeloaded(xml.getlocator("//locators/GoogleMapifram"),xml.getlocator("//locators/Legend")); 
				
			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
				SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
				////Thread.sleep(1000);
				//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter B Siter Address");
				SendKeys(getwebelement(xml.getlocator("//locators/Bsite")),Inputdata[i][6].toString());
				////Thread.sleep(1000);
				//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Bsite")),Keys.ENTER);
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//////Thread.sleep(3000);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
				javascriptexecutor(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
				Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Detail Tab");
				Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
			////// Code for Near Net Selection
				SelectPromotion(Inputdata, i);
								///////////////////////////////////
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
				Select(getwebelement(xml.getlocator("//locators/Contractterm")), Inputdata[i][7].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//------------------------------------
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Interface");
				Select(getwebelement(xml.getlocator("//locators/Interface")), Inputdata[i][8].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//-------------------------------------
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
				Select(getwebelement(xml.getlocator("//locators/WebServiceBandwidth")), Inputdata[i][9].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resiliency");
				Select(getwebelement(xml.getlocator("//locators/ServiceResilence")), Inputdata[i][10].toString());
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Selectconnectivity(Inputdata[i][11].toString(),"Asite",ExploreID,ExploreIDNearnet);
				Selectconnectivity(Inputdata[i][12].toString(),"Bsite",ExploreID,ExploreIDNearnet);
				String exception="No Exception";
				try {
				exception=Gettext(getwebelement2(xml.getlocator("//locators/PPT/BasePrice")));
				System.out.println("Exception is"+exception);
				}
				catch(Exception e)
				{
					System.out.println("Exception is"+exception);
				}
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
				javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
				if(!Inputdata[i][13].toString().equals("")) {
					Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
					Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));

					}
				if(exception.equalsIgnoreCase("Price Not Found")||isElementPresent(xml.getlocator("//locators/Nonfeasiblemsg")))
				{
					Clickon(getwebelement(xml.getlocator("//locators/PPT/PartialSave")));
					
				}
				
				AdditionalProductData();
				if(isElementPresent(xml.getlocator("//locators/PPT/Save")))
				{
					Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
				}
				else 
				{
					Clickon(getwebelement(xml.getlocator("//locators/PPT/AddtoTransaction")));
				}
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		      break; // break is optional
		   }
		   default :  
		   		{ 
		   			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
		   			WaitforElementtobeclickable((xml.getlocator("//locators/Ethernetfamily")));
		   			Clickon(getwebelement(xml.getlocator("//locators/Ethernetfamily")));
		   			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter B Siter Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Bsite")),Inputdata[i][6].toString());
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Bsite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					//////Thread.sleep(3000);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Next button to Run the Connectivity Check");
					Clickon(getwebelement(xml.getlocator("//locators/ConnectivitiCheck")));
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Detail Tab");
					Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
					SelectPromotion(Inputdata, i);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
					Select(getwebelement(xml.getlocator("//locators/Contractterm")), Inputdata[i][7].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
					Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), Inputdata[i][9].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resiliency");
					Select(getwebelement(xml.getlocator("//locators/ServiceResilence")), Inputdata[i][10].toString());
					
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					if(Inputdata[i][11].toString().contains("Offnet Revalidation")||Inputdata[i][11].toString().contains("Offnet Renegotiation")) {
						Selectconnectivity("Manual Offnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
					}
					else if(Inputdata[i][11].toString().contains("Nearnet Revalidation"))
					{
						Selectconnectivity("Manual Nearnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
						
					}
					else {
					Selectconnectivity(Inputdata[i][11].toString(),"ASite",ExploreID,ExploreIDNearnet);
					
					}
					if(Inputdata[i][12].toString().contains("Offnet Revalidation")||Inputdata[i][12].toString().contains("Offnet Renegotiation"))
					{
						Selectconnectivity("Manual Offnet","BSite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
					}
					else if(Inputdata[i][12].toString().contains("Nearnet Revalidation"))
					{
						Selectconnectivity("Manual Nearnet","ASite",ExploreID,ExploreIDNearnet);
						Rerunrequired.set("Yes");
						
					}
					else {
						Selectconnectivity(Inputdata[i][12].toString(),"BSite",ExploreID,ExploreIDNearnet);
					}
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					if(!Inputdata[i][13].toString().equals("")) {
						Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
						Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
						Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
						Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));

						}
					String exception="No Exception";
					try {
					exception=Gettext(getwebelement2(xml.getlocator("//locators/PPT/BasePrice")));
					System.out.println("Exception is"+exception);
					}
					catch(Exception e)
					{
						System.out.println("Exception is"+exception);
					}
					if(exception.equalsIgnoreCase("Price Not Found"))
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/PartialSave")));
						
					}
					AdditionalProductData();
					
					if(isElementPresent(xml.getlocator("//locators/PPT/Save")))
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/Save")));
					}
					else 
					{
						Clickon(getwebelement(xml.getlocator("//locators/PPT/AddtoTransaction")));
					}
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			 break;
			   }
		}
		Completeset.add(ExploreID);
		Completesetnearnet.add(ExploreIDNearnet);
	}
	
	private boolean isElementdisplayed(String getlocator) {
		// TODO Auto-generated method stub
		return false;
	}

	public void AdditionalProductData() throws DocumentException, InterruptedException, IOException {
		// Need to write the code
		////Thread.sleep(30000);
		
		if(isElementPresent(xml.getlocator("//locators/AdditionalProductDataTabparent")))
		{
			javascriptexecutor(getwebelement(xml.getlocator("//locators/AdditionalProductDataTabparent")));
			Clickon(getwebelement(xml.getlocator("//locators/AdditionalProductDataTab")));
			Select(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTime")),"No");
			Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
			Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
			
			////Thread.sleep(5000);
		}
		Thread.sleep(8000);
		// Arrange the Add to transaction button locator to make it common
	}
	public void AddLineitemGridLeadTime(){
		// Need to write the code
	}
	public void AddProduct(Object[][] Inputdata) throws Exception {
		
		waitForpageload();
		WaitforCPQloader();
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader"),1);
//		waitandForElementDisplay(xml.getlocator("//locators/AddProduct"),1);
//		waitForpageload();
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting For Page to Be updated as Stanrad Quote");
		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteID"));
		
		getwebelement(xml.getlocator("//locators/QuoteID"));
		SendKeys(getwebelement(xml.getlocator("//locators/quoteName")),"Automation Quote");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Product Button");
		QuoteID.set(GetValueofInput(getwebelement(xml.getlocator("//locators/QuoteID"))));
		System.out.println(QuoteID.get());
		CurrentURL();
		FeidldlevelValidationAccount(Inputdata);
		////--------------------------------------------------
		
		//Verify the OCN number
		// Verify the Opportunity number/
		// Currency
		// Legal Complexity
		// Technical contact
		// Deal Class
		// Pricing Segment
		// Sales Channel
		//Quote Created, Quote Expiry.
		//Status
		
		////---------------------------------------------------
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Newly Created Quote ID is"+QuoteID.get().toString());
//		Expandthesection(getwebelement(xml.getlocator("//locators/SectionName").replace("Sectionname", "Opportunity Info")),getwebelement(xml.getlocator("//locators/Clickableelemt").replace("Sectionname", "Opportunity Info")));
//		DealClass.set(Gettext(getwebelement(xml.getlocator("//locators/Dealclass"))));
//		TechnicalComplexity.set(Gettext(getwebelement(xml.getlocator("//locators/Technicalcomplexity"))));
//		LeagalComplexity.set(Gettext(getwebelement(xml.getlocator("//locators/LegalComplexity"))));
		for(int i=0;i<Inputdata.length;i++) {
//			waitForpageload();
//			waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
//			waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader"),1);
//			waitandForElementDisplay(xml.getlocator("//locators/AddProduct"),1);
			waitForpageload();
			WaitforElementtobeclickable(xml.getlocator("//locators/LineitemGrid"));
			WaitforElementtobeclickable(xml.getlocator("//locators/AddProduct"));
			
		Clickon(getwebelement(xml.getlocator("//locators/AddProduct")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Add Product button");
		AddFamilyProduct(Inputdata,i);
		WaitforElementtobeclickable(xml.getlocator("//locators/LineitemGrid"));
//		waitForpageload();
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader"),1);
//		waitandForElementDisplay(xml.getlocator("//locators/AddProduct"),1);
//		waitForpageload();
		
		}
		//AddLineitemGridLeadTime();
		Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
		waitForpageload();
		WaitforCPQloader();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Save Button");
		Expandthesection(getwebelement(xml.getlocator("//locators/SectionName").replace("Sectionname", "Opportunity Info")),getwebelement(xml.getlocator("//locators/Clickableelemt").replace("Sectionname", "Opportunity Info")));
		////Thread.sleep(5000);
		FeidldlevelValidationOpp(Inputdata);
		QuoteID.set(GetValueofInput(getwebelement(xml.getlocator("//locators/QuoteID"))));
		System.out.println(QuoteID.get());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Quote ID is"+QuoteID.get().toString());
		DealClass.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Dealclass"))));
		TechnicalComplexity.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Technicalcomplexity"))));
		LeagalComplexity.set(GetValueofInput(getwebelement(xml.getlocator("//locators/LegalComplexity"))));
		Quotestatus.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
		System.out.println("Quite Stage on Screee"+GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Quote stage is"+Quotestatus.get().toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Deal Class is"+DealClass.get().toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Techincal Complaxity is"+TechnicalComplexity.get().toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Legal Complexity is"+LeagalComplexity.get().toString());
		System.out.println("Deal class after adding all the products is"+DealClass.get());
		System.out.println("Techincal Complexity after adding all the products is"+TechnicalComplexity.get());
		System.out.println("Techincal Complexity after adding all the products is"+LeagalComplexity.get());
		System.out.println("Satage  after adding all the products is"+Quotestatus.get());
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader"),1);
//		waitandForElementDisplay(xml.getlocator("//locators/AddProduct"),1);
//		waitForpageload();
		
		
		////Thread.sleep(3000);
		//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
		
		RequestID.set(Completeset);
		RequestIDNearnet.set(Completesetnearnet);
		System.out.println(RequestID.get().size());
		List data=RequestID.get();
		//data=RequestID.get();
		for(int i=0;i<data.size();i++)
		{
			Object[] newdata=(Object[]) data.get(i);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: OLO Reference number for A Site for lineitem-"+i+" is "+newdata[0].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: OLO Reference number for B Site for lineitem-"+i+" is "+newdata[1].toString());
			
			System.out.println("Size Foe Each line item"+newdata.length);
			System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
			System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
		}
		System.out.println(RequestIDNearnet.get().size());
		List data2=RequestIDNearnet.get();
		//data=RequestID.get();
		for(int i=0;i<data2.size();i++)
		{
			Object[] newdata=(Object[]) data2.get(i);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: NearNet Reference number for A Site for lineitem-"+i+" is "+newdata[0].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: NearNet Reference number for B Site for lineitem-"+i+" is "+newdata[1].toString());
			
			System.out.println("Size Foe Each line item- Nearnet"+newdata.length);
			System.out.println("A Site for lineitem Nearnet"+i+" is "+newdata[0].toString());
			System.out.println("B Site for lineitem Nearnet"+i+" is "+newdata[1].toString());
		}
	}
	
	
	public void Reconfigure(Object[][] Inputdata) throws Exception {
		List data=RequestID.get();
		List dataNearnet=RequestIDNearnet.get();
		waitForpageload();
		WaitforCPQloader();
		////Thread.sleep(30000);
		//WaitforCPQloader2();
		//WaitforElementtobeclickable(xml.getlocator("//locators/StandrdQuote"));
		
		//getwebelement(xml.getlocator("//locators/StandrdQuote"));
		
		for(int i=0;i<data.size();i++)
		{
			Object[] newdata=(Object[]) data.get(i);
			System.out.println("Size Foe Each line item"+newdata.length);
			System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
			System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
		}
		for(int i=0;i<dataNearnet.size();i++)
		{
			Object[] newdata=(Object[]) dataNearnet.get(i);
			System.out.println("Size Foe Each line item"+newdata.length);
			System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
			System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
		}
		//data=RequestID.get();
		for(int i=0;i<data.size();i++)
		{
			Object[] newdata=(Object[]) data.get(i);
			if(!(newdata[0].toString().equals("") && newdata[1].toString().equals(""))) 
			{
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//////Thread.sleep(5000);
				System.out.println("Date for A site"+newdata[0].toString());
				System.out.println("Date for B site"+newdata[1].toString());
				System.out.println("Reconfigure the the lineiten number"+i);
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				WaitforElementtobeclickable(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				WaitforElementtobeclickable(xml.getlocator("//locators/Reconfigure"));
				
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/updateQuote"));
				
				Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/ReconfigsaveQuote"));
				
				Clickon(getwebelement(xml.getlocator("//locators/ReconfigsaveQuote")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				// Need to check if New request need to be raised..
				// raised a request whenever required
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				
			}
			Quotestatus.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
			System.out.println("Quite Stage on Screee"+GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Quote stage is"+Quotestatus.get().toString());
			
		}
		
		for(int i=0;i<dataNearnet.size();i++)
		{
			Object[] newdata=(Object[]) dataNearnet.get(i);
			if(!(newdata[0].toString().equals("") && newdata[1].toString().equals(""))) 
			{
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//////Thread.sleep(5000);
				System.out.println("Date for A site"+newdata[0].toString());
				System.out.println("Date for B site"+newdata[1].toString());
				System.out.println("Reconfigure the the lineiten number"+i);
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				WaitforElementtobeclickable(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				WaitforElementtobeclickable(xml.getlocator("//locators/Reconfigure"));
				
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/updateQuote"));
				
				Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/ReconfigsaveQuote"));
				
				Clickon(getwebelement(xml.getlocator("//locators/ReconfigsaveQuote")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				// Need to check if New request need to be raised..
				// raised a request whenever required
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				
			}
		}
		RequestID.get().clear();
		RequestIDNearnet.get().clear();
		Completeset.clear();
		Completesetnearnet.clear();
	}
	public void ReconfigureAgain(Object[][] Inputdata) throws Exception {
		waitForpageload();
		WaitforCPQloader();
		//data=RequestID.get();
		//Object[] ExploreID=new Object[2];
		WaitforElementtobeclickable(xml.getlocator("//locators/StandrdQuote"));
		
		getwebelement(xml.getlocator("//locators/StandrdQuote"));
		
		for(int i=0;i<Inputdata.length;i++) {
			Object[] ExploreID2=new Object[2];
			ExploreID2[0]="";
			ExploreID2[1]="";
			Object[] ExploreID2Nearnet=new Object[2];
			ExploreID2Nearnet[0]="";
			ExploreID2Nearnet[1]="";
			if(Inputdata[i][11].toString().contains("Offnet Renegotiation")) {
				System.out.println("Updating Lineitem-"+i+" for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				waitForpageload();
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				////Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/SiteDetailTab"));
				Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
				
				Selectconnectivity("Offnet Renegotiation","ASite",ExploreID2,ExploreID2Nearnet);
				
			}
			else if(Inputdata[i][11].toString().contains("Offnet Revalidation"))
			{
				System.out.println("Updating Lineitem-"+i+" for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				waitForpageload();
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				////Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/SiteDetailTab"));
				Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
				
				Selectconnectivity("Offnet Revalidation","ASite",ExploreID2,ExploreID2Nearnet);
				
			}
			else if(Inputdata[i][11].toString().contains("Nearnet Revalidation"))
			{
				System.out.println("Updating Lineitem-"+i+" for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				waitForpageload();
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				////Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/SiteDetailTab"));
				Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
				
				Selectconnectivity("Nearnet Revalidation","ASite",ExploreID2,ExploreID2Nearnet);
				
			}
			else
			{
				ExploreID2[0]="";
			}
			if(Inputdata[i][12].toString().contains("Offnet Renegotiation")) {
				System.out.println("Updating Lineitem-"+i+" for B site");
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				waitForpageload();
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				////Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				WaitforElementtobeclickable(xml.getlocator("//locators/SiteDetailTab"));
				Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
				Selectconnectivity("Offnet Renegotiation","BSite",ExploreID2,ExploreID2Nearnet);
				
			}
			else if(Inputdata[i][12].toString().contains("Offnet Revalidation")) {
				System.out.println("Updating Lineitem-"+i+" for B site");
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				waitForpageload();
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				////Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				WaitforElementtobeclickable(xml.getlocator("//locators/SiteDetailTab"));
				Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
				Selectconnectivity("Offnet Revalidation","BSite",ExploreID2,ExploreID2Nearnet);
			}
			else if(Inputdata[i][12].toString().contains("Nearnet Revalidation")) {
				System.out.println("Updating Lineitem-"+i+" for B site");
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				waitForpageload();
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				////Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				WaitforElementtobeclickable(xml.getlocator("//locators/SiteDetailTab"));
				Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
				Selectconnectivity("Nearnet Revalidation","BSite",ExploreID2,ExploreID2Nearnet);
				
			}
			else
			{
				ExploreID2[1]="";
			}

			Completeset.add(ExploreID2);
			Completesetnearnet.add(ExploreID2Nearnet);
			WaitforElementtobeclickable(xml.getlocator("//locators/updateQuote"));
			
			Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
			//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
			WaitforElementtobeclickable(xml.getlocator("//locators/ReconfigsaveQuote"));
			
			Clickon(getwebelement(xml.getlocator("//locators/ReconfigsaveQuote")));
			
		}
		
		RequestID.set(Completeset);
		RequestIDNearnet.set(Completesetnearnet);
		
	}
	
	public void SetCurrectQuoteStage() throws IOException, InterruptedException, DocumentException
	{
		//Pagerefresh();
		waitForpageload();
		WaitforCPQloader();
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader"),1);
//		waitandForElementDisplay(xml.getlocator("//locators/AddProduct"),1);
//		waitForpageload();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting For Page to Be updated as Stanrad Quote");
		WaitforElementtobeclickable(xml.getlocator("//locators/StandrdQuote"));
		
		getwebelement(xml.getlocator("//locators/QuoteID"));
		Quotestatus.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
		System.out.println("Quite Stage on Screee"+GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
		
	}
	public void SEDataupdate(Object[][] Inputdata)throws Exception
	{
		
		if(Inputdata[0][2].toString().split(">")[1].trim().equals("Colt IP Access"))
		{
			ProxyLogin("CPQ_SE_User", xml.getlocator("//locators/ProxyLink"));
			
			WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
			Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
			WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
			Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
			waitForpageload();
			WaitforCPQloader();
			Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
			waitForpageload();
			
			for(int i=0;i<Inputdata.length;i++) 
			{
				
				
				waitForpageload();
				WaitforElementtobeclickable(xml.getlocator("//locators/LineitemGrid"));
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				WaitforElementtobeclickable(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				WaitforElementtobeclickable(xml.getlocator("//locators/Reconfigure"));
				
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/updateQuote"));
				Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				// code for Diversity
				if(Inputdata[i][46].toString().contains("Yes"))
				{
				WaitforElementtobeclickable(xml.getlocator("//locators/DiversityTab"));
				Clickon(getwebelement(xml.getlocator("//locators/DiversityTab")));
		//		WaitforElementtobeclickable(xml.getlocator("//locators/Diversity"));
		//		Clickon(getwebelement(xml.getlocator("//locators/Diversity")));
				
				if(!getwebelement(xml.getlocator("//locators/DiversityCheckbox")).getAttribute("checked").contains("checked"))
				{
					System.out.println("Diversity Checkbox is not enabled, need to enabled first");
					WaitforElementtobeclickable(xml.getlocator("//locators/Diversity"));
					Clickon(getwebelement(xml.getlocator("//locators/Diversity")));
				}
				else {
					System.out.println("Diversity checkbox is enabled!!");	
				}
				waitandForElementDisplayed(xml.getlocator("//locators/CommentsforSalerelatedtoDiversity"));
				SendKeys(getwebelement(xml.getlocator("//locators/CommentsforSalerelatedtoDiversity")), Inputdata[i][29].toString());
				
				WaitforElementtobeclickable(xml.getlocator("//locators/DiversityType"));
				Select(getwebelement(xml.getlocator("//locators/DiversityType")), Inputdata[i][30].toString());
				waitForpageload();
				waitandForElementDisplayed(xml.getlocator("//locators/diverseFromServiceReferenceDiversity"));
				Clear(getwebelement(xml.getlocator("//locators/diverseFromServiceReferenceDiversity")));
				SendKeys(getwebelement(xml.getlocator("//locators/diverseFromServiceReferenceDiversity")), Inputdata[i][29].toString());
				
				waitandForElementDisplayed(xml.getlocator("//locators/DiversityDescription"));
				Clear(getwebelement(xml.getlocator("//locators/DiversityDescription")));
				SendKeys(getwebelement(xml.getlocator("//locators/DiversityDescription")), Inputdata[i][31].toString());
				
				waitandForElementDisplayed(xml.getlocator("//locators/diverseFromServiceReferenceDiversity"));
				javascriptexecutor(getwebelement(xml.getlocator("//locators/NotesAndProductDescription")));
				waitandForElementDisplayed(xml.getlocator("//locators/NotesAndProductDescription"));
				Clear(getwebelement(xml.getlocator("//locators/NotesAndProductDescription")));
				SendKeys(getwebelement(xml.getlocator("//locators/NotesAndProductDescription")), Inputdata[i][32].toString());
				waitandForElementDisplayed(xml.getlocator("//locators/Clickupdate"));
				Clickon(getwebelement(xml.getlocator("//locators/Clickupdate")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				waitandForElementDisplayed(xml.getlocator("//locators/PricesAndPromotionsTab"));
				Clickon(getwebelement(xml.getlocator("//locators/PricesAndPromotionsTab")));
				waitandForElementDisplayed(xml.getlocator("//locators/Save"));
				Clickon(getwebelement(xml.getlocator("//locators/Save")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Proxylogout();
				
				openurl2(CurrentQuoteURL.get());
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				
				
				
			    }
				// code for Bespoke
				else if(Inputdata[i][47].toString().contains("Yes"))
				{
					WaitforElementtobeclickable(xml.getlocator("//locators/BespokeTab"));
					Clickon(getwebelement(xml.getlocator("//locators/BespokeTab")));
					waitForpageload();
					
					if(!getwebelement(xml.getlocator("//locators/Bespoke")).getAttribute("checked").contains("checked"))
					{
						System.out.println("Diversity Checkbox is not enabled, need to enabled first");
						WaitforElementtobeclickable(xml.getlocator("//locators/Bespoke"));
						Clickon(getwebelement(xml.getlocator("//locators/Bespoke")));
					}
					else {
						System.out.println("Diversity checkbox is enabled!!");	
					}
					waitandForElementDisplayed(xml.getlocator("//locators/BasePokeCommentsforsale"));
					SendKeys(getwebelement(xml.getlocator("//locators/BasePokeCommentsforsale")), Inputdata[i][29].toString());
					
					WaitforElementtobeclickable(xml.getlocator("//locators/BesPokeFeatures"));
					Select(getwebelement(xml.getlocator("//locators/BesPokeFeatures")), Inputdata[i][30].toString());
					waitForpageload();
					
					waitandForElementDisplayed(xml.getlocator("//locators/BesPokeDescription"));
					Clear(getwebelement(xml.getlocator("//locators/BesPokeDescription")));
					SendKeys(getwebelement(xml.getlocator("//locators/BesPokeDescription")), Inputdata[i][29].toString());
					
					waitandForElementDisplayed(xml.getlocator("//locators/BespokeFeatureLevel"));
					Select(getwebelement(xml.getlocator("//locators/BespokeFeatureLevel")), Inputdata[i][30].toString());		
					
					
					waitandForElementDisplayed(xml.getlocator("//locators/BesPokeDescription"));
					javascriptexecutor(getwebelement(xml.getlocator("//locators/NotesAndProductDescriptionForBespoke")));
					waitandForElementDisplayed(xml.getlocator("//locators/NotesAndProductDescriptionForBespoke"));
					Clear(getwebelement(xml.getlocator("//locators/NotesAndProductDescriptionForBespoke")));
					SendKeys(getwebelement(xml.getlocator("//locators/NotesAndProductDescriptionForBespoke")), Inputdata[i][32].toString());
				    
					WaitforElementtobeclickable(xml.getlocator("//locators/Clickupdate"));
					javascriptexecutor(getwebelement(xml.getlocator("//locators/Clickupdate")));
					Clickon(getwebelement(xml.getlocator("//locators/Clickupdate")));
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					waitandForElementDisplayed(xml.getlocator("//locators/PricesAndPromotionsTab"));
					Clickon(getwebelement(xml.getlocator("//locators/PricesAndPromotionsTab")));
					waitandForElementDisplayed(xml.getlocator("//locators/Save"));
					Clickon(getwebelement(xml.getlocator("//locators/Save")));
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Proxylogout();
					
					openurl2(CurrentQuoteURL.get());
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
					
					
				}
			
			}	
		}
		else
		{
		ProxyLogin("CPQ_SE_User", xml.getlocator("//locators/ProxyLink"));
		
		WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
		Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
		WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
		Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
		waitForpageload();
		WaitforCPQloader();
		Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
		waitForpageload();
		for(int i=0;i<Inputdata.length;i++) {
//			waitForpageload();
//			waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
//			waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader"),1);
//			waitandForElementDisplay(xml.getlocator("//locators/AddProduct"),1);
			waitForpageload();
			WaitforElementtobeclickable(xml.getlocator("//locators/LineitemGrid"));
			WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				System.out.println(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				WaitforElementtobeclickable(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1)));
				
				Clickon(getwebelement(xml.getlocator("//locators/ModelSelector").replace("index", String.valueOf(i+1))));
				WaitforElementtobeclickable(xml.getlocator("//locators/Reconfigure"));
				
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/updateQuote"));
				
				Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/ReconfigsaveQuote"));
				
				Clickon(getwebelement(xml.getlocator("//locators/ReconfigsaveQuote")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				// Need to check if New request need to be raised..
				// raised a request whenever required
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));}
				Proxylogout();
		
				openurl2(CurrentQuoteURL.get());
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		
		}
	}
	public void ExceptionPPT() throws Exception
	{
		waitForpageload();
		Clickon(getwebelement(xml.getlocator("//locators/PPT/EngagePortfolio")));	
		waitForpageload();
		clickOKonError();
		////Thread.sleep(30000);
		//waitForpageload();
		//WaitforCPQloader();
//		openurl("Admin");
////		Switchtotab();
//		WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
//		Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
//		WaitforElementtobeclickable(xml.getlocator("//locators/usernameproxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_PPT_User")));
//		Clickon(getwebelement(xml.getlocator("//locators/usernameproxy").replace("Ashwani.Singh31@colt.net",pr.readproperty("CPQ_PPT_User"))));
		ProxyLogin("CPQ_PPT_User",xml.getlocator("//locators/ProxyLink"));
//		WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
//		Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
//		WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
//		Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
//		//Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
		openurl2(CurrentQuoteURL.get());
		//Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
		waitForpageload();
		
		WaitforCPQloader();
		////Thread.sleep(10000);
		WaitforElementtobeclickable(xml.getlocator("//locators/PPT/PLtab"));
		Clickon(getwebelement(xml.getlocator("//locators/PPT/PLtab")));
		WaitforElementtobeclickable(xml.getlocator("//locators/Listexpander"));
		Clickon(getwebelement(xml.getlocator("//locators/Listexpander")));
		WaitforElementtobeclickable(xml.getlocator("//locators/UserSelector").replace("Username", "Prashant Manu"));
		Clickon(getwebelement(xml.getlocator("//locators/UserSelector").replace("Username", "Prashant Manu")));
		//Select assignuser=new Select(getwebelement("//select[@name='portfolioTeamAssignment']"));
		//assignuser.selectByVisibleText("Prashant Manu");
		WaitforElementtobeclickable(xml.getlocator("//locators/PPT/Assignquote"));
		Clickon(getwebelement(xml.getlocator("//locators/PPT/Assignquote")));
		waitForpageload();
		//String exception=xml.getlocator("//locators/PPT/Bpnotfound").toString();
		//Thread.sleep(20000);
		/// Click on generale Informarion Tab
		int totalpricelines=getwebelementscount(xml.getlocator("//locators/PPT/Pricenotfound").toString());
		if(totalpricelines>0)
		{
		for(int i=1;i<=totalpricelines;i++) {
		//while(Quotestatus.get().toString().equals("Priced")){
		if(GetText(getwebelement2(xml.getlocator("//locators/PPT/Bpnotfound").replace("index", String.valueOf(i)))).equalsIgnoreCase("Base price not found"))
		{
			//SendKeys(getwebelement(xml.getlocator("//locators/PPT/Basepricenrr")),"555");
			////Thread.sleep(2000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/PPT/Basepricenrr").replace("index", String.valueOf(i))));
			waitForpageload();
			////Thread.sleep(2000);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			
			EnterText("555");
			EnterText2(Keys.ENTER);
			waitForpageload();
			//SendKeys(getwebelement(xml.getlocator("//locators/PPT/Basepricemrr")),"666");
			////Thread.sleep(2000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/PPT/Basepricemrr").replace("index", String.valueOf(i))));
			////Thread.sleep(2000);
			waitForpageload();
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			
			EnterText("666");
			EnterText2(Keys.ENTER);
			waitForpageload();
			////Thread.sleep(10000);
			//Quotestatus.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
		}
		else if(GetText(getwebelement(xml.getlocator("//locators/PPT/Bpnotfound").replace("index", String.valueOf(i)))).equalsIgnoreCase("FastTrack price not found"))
		{
			//Clickon(getwebelement(xml.getlocator("//locators/PPT/Fastracknrr")));
			////Thread.sleep(2000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/PPT/Fastracknrr").replace("index", String.valueOf(i))));
			waitForpageload();
			////Thread.sleep(2000);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			
			EnterText("777");
			EnterText2(Keys.ENTER);
			waitForpageload();
			//SendKeys(getwebelement(xml.getlocator("//locators/PPT/Fastracknrr")),"777");
			////Thread.sleep(10000);
			//Quotestatus.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
			
		}
		}
	}
		int totalcitylines=getwebelementscount(xml.getlocator("//locators/PPT/Pricincity").toString());
		if(totalcitylines>0) {
		for(int i=1;i<=totalcitylines;i++) {
		
			//Select a row
			Clickon(getwebelement(xml.getlocator("//locators/PPT/PricingCutinotfoundmodel")));
			waitForpageload();
			////Thread.sleep(2000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PPT/Reconfigure"));
			Clickon(getwebelement(xml.getlocator("//locators/PPT/Reconfigure")));
			////Thread.sleep(2000);
			WaitforElementtobeclickable(xml.getlocator("//locators/PPT/Sitedetails"));
			Clickon(getwebelement(xml.getlocator("//locators/PPT/Sitedetails")));
			////Thread.sleep(2000);
			// If A Side available Sameas hub id="pricingCityAendPPT_input"
			if(isElementPresent(xml.getlocator("//locators/PPT/AEndPrincingCitylist"))) {
				Clickon(getwebelement(xml.getlocator("//locators/AEndCityExpander")));
				System.out.println("Need to select the City"+xml.getlocator("//locators/AEndCity").replace("CityName", "Parice"));
				 Clickon(getwebelement(xml.getlocator("//locators/AEndCity").replace("CityName", "Paris")));
			  
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
			//Select(getwebelement(xml.getlocator("//locators/PPT/PricingCitydropdown")), "Berlin");
			////Thread.sleep(2000);
			}
			if(isElementPresent(xml.getlocator("//locators/PPT/BEndPrincingCitylist"))) {
				Clickon(getwebelement(xml.getlocator("//locators/BEndCityExpander")));
				System.out.println("Need to select the City"+xml.getlocator("//locators/BEndCity").replace("CityName", "Paris"));
				 Clickon(getwebelement(xml.getlocator("//locators/BEndCity").replace("CityName", "Paris")));
			  
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				}
			
			//if B Side Available
			Clickon(getwebelement(xml.getlocator("//locators/PPT/Clickupdate")));
			Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
			////Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/PPT/Clicksave")));
			waitForpageload();
			////Thread.sleep(10000);
			//Quotestatus.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
		//}
			
		}//Return quote to sales
		}
			////Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/PPT/Sendtosales")));
			waitForpageload();
			//Thread.sleep(30000);
			//openurl("CPQAdmin");
			//WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
			//Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
			Proxylogout();
			//Thread.sleep(30000);
			openurl2(CurrentQuoteURL.get());
			waitForpageload();
			WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			
			
			
		
		
	}
	
	
	public void POA() throws Exception
	{
		waitForpageload();
		Clickon(getwebelement(xml.getlocator("//locators/PPT/EngagePortfolio")));	
		waitForpageload();
		clickOKonError();
		waitForpageload();
		//Thread.sleep(30000);
		//waitForpageload();
		//WaitforCPQloader();
//		openurl("Admin");
////		Switchtotab();
//		WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
//		Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
//		WaitforElementtobeclickable(xml.getlocator("//locators/usernameproxy").replace("Ashwani.Singh31@colt.net", pr.readproperty("CPQ_PPT_User")));
//		Clickon(getwebelement(xml.getlocator("//locators/usernameproxy").replace("Ashwani.Singh31@colt.net",pr.readproperty("CPQ_PPT_User"))));
		ProxyLogin("CPQ_DealPrice_User",xml.getlocator("//locators/ProxyLink"));
		//WaitforElementtobeclickable(xml.getlocator("//locators/QuotetoOrderLink"));
		//Clickon(getwebelement(xml.getlocator("//locators/QuotetoOrderLink")));
		//WaitforElementtobeclickable(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim()));
		//Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
		//Clickon(getwebelement(xml.getlocator("//locators/CPQQuotelink").replace("QuoteId", QuoteID.get().trim())));
		openurl2(CurrentQuoteURL.get());
		//Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
		waitForpageload();
		waitForpageload();
		WaitforCPQloader();
		//Thread.sleep(10000);
		WaitforElementtobeclickable(xml.getlocator("//locators/PPT/PLtab"));
		Clickon(getwebelement(xml.getlocator("//locators/PPT/PLtab")));
		WaitforElementtobeclickable(xml.getlocator("//locators/Listexpander"));
		Clickon(getwebelement(xml.getlocator("//locators/Listexpander")));
		WaitforElementtobeclickable(xml.getlocator("//locators/UserSelector").replace("Username", "Namita Singh"));
		Clickon(getwebelement(xml.getlocator("//locators/UserSelector").replace("Username", "Namita Singh")));
		//Select assignuser=new Select(getwebelement("//select[@name='portfolioTeamAssignment']"));
		//assignuser.selectByVisibleText("Prashant Manu");
		WaitforElementtobeclickable(xml.getlocator("//locators/PPT/Assignquote"));
		Clickon(getwebelement(xml.getlocator("//locators/PPT/Assignquote")));
		waitForpageload();
		//String exception=xml.getlocator("//locators/PPT/Bpnotfound").toString();
		int totalPOAlines=getwebelementscount(xml.getlocator("//locators/PPT/POALineItem").toString());
		for(int i=1;i<=totalPOAlines;i++) {
		
		
			//SendKeys(getwebelement(xml.getlocator("//locators/PPT/Basepricenrr")),"555");
			////Thread.sleep(2000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/PPT/Basepricenrr").replace("index",String.valueOf(i) )));
			waitForpageload();
			////Thread.sleep(2000);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			
			EnterText("555");
			EnterText2(Keys.ENTER);
			waitForpageload();
			//SendKeys(getwebelement(xml.getlocator("//locators/PPT/Basepricemrr")),"666");
			////Thread.sleep(2000);
			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/PPT/Basepricemrr").replace("index",String.valueOf(i))));
			waitForpageload();
			////Thread.sleep(2000);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			EnterText2(Keys.BACK_SPACE);
			
			EnterText("666");
			EnterText2(Keys.ENTER);
			waitForpageload();
		
		}
		Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
		waitForpageload();
		//Quotestatus.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Quotestatus"))));
			//Return quote to sales
		////Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/PPT/Sendtosales")));
		waitForpageload();
		//Thread.sleep(30000);
//		openurl("CPQAdmin");
//		WaitforElementtobeclickable(xml.getlocator("//locators/InternalUser"));
//		Clickon(getwebelement(xml.getlocator("//locators/InternalUser")));
//		WaitforElementtobeclickable(xml.getlocator("//locators/Proxylogout"));
//		Clickon(getwebelement(xml.getlocator("//locators/Proxylogout")));
		Proxylogout();
		
		openurl2(CurrentQuoteURL.get());
		WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		
	}
	
	public void SelectPromotion(Object[][] data, int i) throws InterruptedException, DocumentException
	{
		try {
		if(!data[i][29].toString().equals(""))
		{
			Clickon(getwebelement(xml.getlocator("//locators/Promocode").replace("promo", data[i][29].toString())));
		}
		}
		catch(NullPointerException e)
		{
			System.out.println("Ni Promotions Applied");
		}
	}
}

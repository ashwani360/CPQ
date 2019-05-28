package ScriptHelper;

import java.util.ArrayList;
import java.util.List;

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

public class ConfigurationHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Configuration.xml");
	Object[] ExploreID=new Object[2];
	List Completeset=new ArrayList();
	
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
	{  	String Productfamility=Inputdata[i][2].toString().split(">")[0].trim();
		String ProductName=Inputdata[i][2].toString().split(">")[1].trim();
		Selectfamily(Productfamility);
		ConfigureProduct(ProductName,Inputdata,i);
	}
	public void Selectfamily(String family) throws Exception
	{
		switch(family)
		{
		   // case statements
		   // values must be of same type of expression
		   case "Ethernet" :
			   { ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
				Clickon(getwebelement(xml.getlocator("//locators/Ethernetfamily")));
		      break; // break is optional
			   }
		   case "Optical" :
		   {ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
			Clickon(getwebelement(xml.getlocator("//locators/Opticalfamily")));
		      break; // break is optional
		   }
		   
		   default :  
		   		{ ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
			 Clickon(getwebelement(xml.getlocator("//locators/Ethernetfamily")));
			 break;
			   }
		}
	}
	
	public void Selectconnectivity(String type,String site,Object[] referece) throws Exception
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				//Clickon(getwebelement(xml.getlocator("//locators/CPQExploreWindowfields")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority"));
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),"Actual");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
				
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/GetQuoteButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/GetQuoteButton")));
				Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
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
			
				break;
			}
			case "Manual DSL":
			{
			
				break;
			}
			case "Automated Nearnet":
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
			
				break;
			}
			case "Revalidate":
			{
				
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequest"));
				
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequest")),"UPDATE SELECTED REQUEST");
				// Updated the data in Empac screen and create the request.
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				// Select The Revalidation or Renegotation options
				Thread.sleep(2000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "REVALIDATE"));
				Clickon(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "REVALIDATE")));
				
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
				
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Revalidate"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Revalidate")));
				Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				
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
				referece[1]="";
				break;
			}
			case "Automated Offnet":
			{
				
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/OffNetCheckBSite"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/OffNetCheckBSite")));
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority"));
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),"Actual");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Priority")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
				
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/GetQuoteButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/GetQuoteButton")));
				Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/ClickOloButton")));
				
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
			
				break;
			}
			case "Manual DSL":
			{
			
				break;
			}
			case "Automated Nearnet":
			{
				Clickon(getwebelement(xml.getlocator("//locators/NearNetBsite")));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//referece[]=(Gettext(getwebelement(xml.getlocator("//locators/RequestId"))).split(":"))[1].trim();;
				
				break;
			}
			case "Manual Nearnet":
			{
			
				break;
			}
			case "Revalidate":
			{
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequestBEnd"));
				
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequestBEnd")),"UPDATE SELECTED REQUEST");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				// Select The Revalidation or Renegotation options
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "REVALIDATE"));
				Clickon(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "REVALIDATE")));
				
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
				
			    //Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Actual")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/Revalidate"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Revalidate")));
				Thread.sleep(2000);
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				AcceptJavaScriptMethod();
				// Accept Alert 
				// Save the Reqord ID for the Explore code.
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/ClickOloButton"));
			    
				Clickon(getwebelement("("+xml.getlocator("//locators/ClickOloButton")+")[2]"));
				
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
	
	
	
	public void ConfigureProduct(String Prodcutname,Object[][] Inputdata, int i) throws Exception
	{		Object[] ExploreID=new Object[2];
		switch(Prodcutname)
		{
		   // case statements
		   // values must be of same type of expression
		   case "Ethernet Line" :
			   { 
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
					Clickon(getwebelement(xml.getlocator("//locators/EthernetProductP2P")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
					Thread.sleep(1000);
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter B Siter Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Bsite")),Inputdata[i][6].toString());
					Thread.sleep(1000);
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Bsite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					//Thread.sleep(3000);
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
					if(Inputdata[i][11].toString().contains("Re")) {
						Selectconnectivity("Manual Offnet","ASite",ExploreID);
						Rerunrequired.set("Yes");
					}
					else {
					Selectconnectivity(Inputdata[i][11].toString(),"ASite",ExploreID);
					
					}
					if(Inputdata[i][12].toString().contains("Re"))
					{
						Selectconnectivity("Manual Offnet","BSite",ExploreID);
						Rerunrequired.set("Yes");
					}
					else {
						Selectconnectivity(Inputdata[i][12].toString(),"BSite",ExploreID);
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
					}
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
					Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		      break; // break is optional
			   }
		   case "Ethernet Hub" :
		   {

			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
			   Clickon(getwebelement(xml.getlocator("//locators/EthernetHub")));
			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
				SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
				Thread.sleep(1000);
				//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Map to be loaded completly");
				Thread.sleep(10000);
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
				Selectconnectivity(Inputdata[i][11].toString(),"ASite",ExploreID);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
				javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Feature Tab");
				Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
				Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
				Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		      break; // break is optional
		   }
		   case "Ethernet Spoke" :
		   {
			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
			   Clickon(getwebelement(xml.getlocator("//locators/EtherNetSpoke")));
			   if(Inputdata[i][3].toString().equals("New")) {
				  // Select New
				    ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
					Select(getwebelement(xml.getlocator("//locators/HubType")), Inputdata[i][3].toString());
					
				   //Select Hub
				   //Inputdata[i][3].toString().equals("New")
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
					Select(getwebelement(xml.getlocator("//locators/ListofNewhub")), Inputdata[i][4].toString());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Spoke Site Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][6].toString());
					Thread.sleep(1000);
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Thread.sleep(3000);
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
					Selectconnectivity(Inputdata[i][11].toString(),"Asite",ExploreID);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Feature Tab");
					Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
					Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
					Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			   }
			   else
			   {
				   // Select Exiting
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
				   Select(getwebelement(xml.getlocator("//locators/HubType")), Inputdata[i][3].toString());
					
				   // Enter Hub Reference Number
				   // 
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Contract Term");
				   SendKeys(getwebelement(xml.getlocator("//locators/HubReference")),Inputdata[i][4].toString());
					
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
					SendKeys(getwebelement(xml.getlocator("//locators/HubSite")),Inputdata[i][5].toString());
					
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/HubSite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Spoke Siter Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][6].toString());
					Thread.sleep(1000);
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					//Thread.sleep(3000);
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
					Selectconnectivity(Inputdata[i][11].toString(),"Asite",ExploreID);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Feature Tab");
					Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
					Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
					Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
				   
			   }
		      break; // break is optional
		   }
		   case "Wave" :
		   {
			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
			   Clickon(getwebelement(xml.getlocator("//locators/OpticalWave")));
			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
				SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
				Thread.sleep(1000);
				//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter B Siter Address");
				SendKeys(getwebelement(xml.getlocator("//locators/Bsite")),Inputdata[i][6].toString());
				Thread.sleep(1000);
				//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Bsite")),Keys.ENTER);
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				//Thread.sleep(3000);
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
				Selectconnectivity(Inputdata[i][11].toString(),"Asite",ExploreID);
				Selectconnectivity(Inputdata[i][12].toString(),"Bsite",ExploreID);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
				javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Feature Tab");
				Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
				Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
				Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
		      break; // break is optional
		   }
		   default :  
		   		{ 
		   			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
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
					//Thread.sleep(3000);
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
					Selectconnectivity(Inputdata[i][11].toString(),"Asite",ExploreID);
					Selectconnectivity(Inputdata[i][12].toString(),"Bsite",ExploreID);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
					javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Feature Tab");
					Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Fast Track Option");
					Clickon(getwebelement(xml.getlocator("//locators/FastTrackAddon")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add to Quote button");
					Clickon(getwebelement(xml.getlocator("//locators/AddtoTransaction")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					WaitforElementtobeclickable(xml.getlocator("//locators/ApprovalTab"));
			 break;
			   }
		}
		Completeset.add(ExploreID);
	}
	public void AddProduct(Object[][] Inputdata) throws Exception {
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting For Page to Be updated as Stanrad Quote");
		getwebelement(xml.getlocator("//locators/StandrdQuote"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Product Button");
		QuoteID.set(Gettext(getwebelement(xml.getlocator("//locators/QuoteID"))));
		DealClass.set(Gettext(getwebelement(xml.getlocator("//locators/Dealclass"))));
		TechnicalComplexity.set(Gettext(getwebelement(xml.getlocator("//locators/Technicalcomplexity"))));
		LeagalComplexity.set(Gettext(getwebelement(xml.getlocator("//locators/LegalComplexity"))));
		for(int i=0;i<Inputdata.length;i++) {
		Clickon(getwebelement(xml.getlocator("//locators/AddProduct")));
		AddFamilyProduct(Inputdata,i);
		DealClass.set(Gettext(getwebelement(xml.getlocator("//locators/Dealclass"))));
		TechnicalComplexity.set(Gettext(getwebelement(xml.getlocator("//locators/Technicalcomplexity"))));
		LeagalComplexity.set(Gettext(getwebelement(xml.getlocator("//locators/LegalComplexity"))));
		}
		Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
		
		
		
		Thread.sleep(10000);
		//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
		
		RequestID.set(Completeset);
		System.out.println(RequestID.get().size());
		List data=RequestID.get();
		//data=RequestID.get();
		for(int i=0;i<data.size();i++)
		{
			Object[] newdata=(Object[]) data.get(i);
			System.out.println("Size Foe Each line item"+newdata.length);
			System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
			System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
		}
	}
	
	public void Reconfigure(Object[][] Inputdata) throws Exception {
		List data=RequestID.get();
		
		for(int i=0;i<data.size();i++)
		{
			Object[] newdata=(Object[]) data.get(i);
			System.out.println("Size Foe Each line item"+newdata.length);
			System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
			System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
		}
		//data=RequestID.get();
		for(int i=0;i<data.size();i++)
		{
			Object[] newdata=(Object[]) data.get(i);
			if(!(newdata[0].toString().equals("") || newdata[1].toString().equals(""))) 
			{
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				System.out.println("Date for A site"+newdata[0].toString());
				System.out.println("Date for B site"+newdata[1].toString());
				System.out.println("Reconfigure the the lineiten number"+i);
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure").replace("index", String.valueOf(i+1))));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				WaitforElementtobeclickable(xml.getlocator("//locators/updateQuote"));
				
				Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				WaitforElementtobeclickable(xml.getlocator("//locators/saveQuote"));
				
				Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
//				//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				// Need to check if New request need to be raised..
				// raised a request whenever required
				
			}
		}
		RequestID.get().clear();;
		Completeset.clear();
	}
	public void ReconfigureAgain(Object[][] Inputdata) throws Exception {
		
		//data=RequestID.get();
		//Object[] ExploreID=new Object[2];
		for(int i=0;i<Inputdata.length;i++) {
			Object[] ExploreID2=new Object[2];
			
			if(Inputdata[i][11].toString().contains("Re")) {
				System.out.println("Updating Lineitem-"+i+" for A site");
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure").replace("index", String.valueOf(i+1))));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				WaitforElementtobeclickable(xml.getlocator("//locators/SiteDetailTab"));
				Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
				
				Selectconnectivity("Revalidate","ASite",ExploreID2);
				
			}
			else
			{
				ExploreID2[0]="";
			}
			if(Inputdata[i][12].toString().contains("Re")) {
				System.out.println("Updating Lineitem-"+i+" for B site");
				WaitforElementtobeclickable(xml.getlocator("//locators/customersignatureTab"));
				Clickon(getwebelement(xml.getlocator("//locators/Reconfigure").replace("index", String.valueOf(i+1))));
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Selectconnectivity("Revalidate","BSite",ExploreID2);
				
			}
			else
			{
				ExploreID2[1]="";
			}
			WaitforElementtobeclickable(xml.getlocator("//locators/updateQuote"));
			
			Clickon(getwebelement(xml.getlocator("//locators/updateQuote")));
			//Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
			WaitforElementtobeclickable(xml.getlocator("//locators/saveQuote"));
			
			Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
		}
		
		RequestID.set(Completeset);
		
	}
}

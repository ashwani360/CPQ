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

public class ConfigurationHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Configuration.xml");
	
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
	public void ConfigureProduct(String Prodcutname,Object[][] Inputdata, int i) throws Exception
	{
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
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
					Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetAsite")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Option for A site");
					Clickon(getwebelement(xml.getlocator("//locators/AsiteOnnet")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click the On net Tab for B site");
					Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetBsite")));
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
		   case "Ethernet Hub" :
		   {

			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
			   Clickon(getwebelement(xml.getlocator("//locators/EthernetHub")));
			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
				SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
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
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetAsite")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Option for A site");
				Clickon(getwebelement(xml.getlocator("//locators/AsiteOnnet")));
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
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click the On net Tab for B site");
					Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetAsite")));
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
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click the On net Tab for B site");
					Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetAsite")));
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
				   
			   }
		      break; // break is optional
		   }
		   case "Wave" :
		   {
			   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
			   Clickon(getwebelement(xml.getlocator("//locators/OpticalWave")));
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
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetAsite")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Option for A site");
				Clickon(getwebelement(xml.getlocator("//locators/AsiteOnnet")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click the On net Tab for B site");
				Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetBsite")));
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
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
					Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetAsite")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Option for A site");
					Clickon(getwebelement(xml.getlocator("//locators/AsiteOnnet")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click the On net Tab for B site");
					Clickon(getwebelement(xml.getlocator("//locators/SelectOnnetBsite")));
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
			 break;
			   }
		}
		
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
		
		}
		
		
	}
	
	
}

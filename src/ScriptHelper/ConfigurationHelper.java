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


	public void AddProduct(Object[] Inputdata) throws Exception {
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting For Page to Be updated as Stanrad Quote");
		getwebelement(xml.getlocator("//locators/StandrdQuote"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Product Button");
		Clickon(getwebelement(xml.getlocator("//locators/AddProduct")));
		String Productfamility=Inputdata[2].toString().split(">")[0].trim();
		String ProductName=Inputdata[2].toString().split(">")[1].trim();
		
		if(Productfamility.equals("Ethernet")) {
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
		Clickon(getwebelement(xml.getlocator("//locators/Ethernetfamily")));
		}
		else {
			System.out.println("Select Other Family");
		}
		if(ProductName.equals("Ethernet Line")) {
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
			Clickon(getwebelement(xml.getlocator("//locators/EthernetProductP2P")));
			}
			else {
				System.out.println("Select Other Product");
			}
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
		SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[3].toString());
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
		//getwebelement(xml.getlocator("//locators/LoadingDailog"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
		Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter B Siter Address");
		SendKeys(getwebelement(xml.getlocator("//locators/Bsite")),Inputdata[4].toString());
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
		Select(getwebelement(xml.getlocator("//locators/Contractterm")), Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
		Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
		Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
		Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Resiliency");
		Select(getwebelement(xml.getlocator("//locators/ServiceResilence")), Inputdata[7].toString());
		
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
		
	}
	
}

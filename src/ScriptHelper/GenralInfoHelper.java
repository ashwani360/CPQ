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

public class GenralInfoHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\GeneralInfo.xml");
	
	public GenralInfoHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}


	public void GenralInfomration(Object[][] Inputdata) throws Exception {
		SendKeys(getwebelement(xml.getlocator("//locators/Technicalcontactname")),Inputdata[0][14].toString());
		//WaitforElementtobeclickable(xml.getlocator("//locators/Technicalcontactlname"));
		Clickon(getwebelement(xml.getlocator("//locators/Technicalcontactlname")));
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/Technicalcontactlname")),Inputdata[0][15].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Technicalcontactemail")));
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/Technicalcontactemail")),Inputdata[0][16].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Technicalcontactphone")));
		Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/Technicalcontactphone")),"+"+Inputdata[0][17].toString());
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Technicalcontactphone")),Keys.ENTER);
		//WaitforElementtobeclickable(xml.getlocator("//locators/Alllineitem"));
	}
	

}

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
		WaitforCPQloader();
		Expandthesection(getwebelement(xml.getlocator("//locators/SectionName").replace("Sectionname", "Legal Contact Details")),getwebelement(xml.getlocator("//locators/Clickableelemt").replace("Sectionname", "Legal Contact Details")));
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/LegalcontactGetdetail")));
		WaitforElementtobeclickable("//div[contains(@aria-labelledby,'-label')]/div[contains(text(),'Contact')]");
		
		//Clickonoutofviewport(getwebelement(xml.getlocator("//locators/LegalcontactGetdetail")));
		//Clickon(getwebelement(xml.getlocator("//locators/LegalcontactGetdetail")));
		//waitandForElementDisplay(xml.getlocator("//locators/Selectprimarycontact"),1);
		//Thread.sleep(3000);
//		try {
//		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Selectprimarycontact")));
//		}
//		catch(org.openqa.selenium.StaleElementReferenceException ex)
//		{
//			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Selectprimarycontact")));
//		}
		Clickon(getwebelement(xml.getlocator("//locators/Selectprimarycontact")));
		Clickon(getwebelement(xml.getlocator("//locators/SubmitContact")));
		
		Expandthesection(getwebelement(xml.getlocator("//locators/SectionName").replace("Sectionname", "Technical/Ordering Contacts")),getwebelement(xml.getlocator("//locators/Clickableelemt").replace("Sectionname", "Technical/Ordering Contacts")));
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/TechnicalcontactGetdetail")));
		//Clickon(getwebelement(xml.getlocator("//locators/TechnicalcontactGetdetail")));
		//waitandForElementDisplay(xml.getlocator("//locators/Selectprimarycontact"),1);
		//Thread.sleep(3000);
		WaitforElementtobeclickable("//div[contains(@aria-labelledby,'-label')]/div[contains(text(),'Contact')]");
//		try {
//			safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Selectprimarycontact")));
//			}
//			catch(org.openqa.selenium.StaleElementReferenceException ex)
//			{
//				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Selectprimarycontact")));
//			}
		Clickon(getwebelement(xml.getlocator("//locators/Selectprimarycontact")));
		Clickon(getwebelement(xml.getlocator("//locators/SubmitContact")));
		waitForpageload();
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader"),1);
//		waitandForElementDisplay(xml.getlocator("//locators/AddProduct"),1);
//		waitForpageload();
		
	}
	
	

}

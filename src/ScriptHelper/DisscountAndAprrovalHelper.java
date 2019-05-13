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

public class DisscountAndAprrovalHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\DisscountandAprroval.xml");
	
	public DisscountAndAprrovalHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}


	public void DisscountandApprove(Object[] Inputdata) throws Exception {
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

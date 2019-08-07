package ScriptHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

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

public class OrderingHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Ordering.xml");
	xmlreader xml2=new xmlreader("src\\Locators\\Configuration.xml");
	public OrderingHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}


	public void AcceptsQuote(Object[][] Inputdata) throws Exception {
		if(Inputdata[0][24].toString().equals("Email")) {
			//WaitforCPQloader();
			Clickon(getwebelement(xml2.getlocator("//locators/saveQuote")));
			waitForpageload();
			Thread.sleep(20000);
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/OrderTab")));
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/AcceptsDroplist")));
		Clickon(getwebelement(xml.getlocator("//locators/AcceptsorReject")));
		//Select(getwebelement(xml.getlocator("//locators/QuoteAction")), "Accept");
		Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/Reasonedroplist")));
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/Reasone")));
		//Select(getwebelement(xml.getlocator("//locators/Reasone")), "Price");
		Thread.sleep(5000);
		//safeJavaScriptClick();
		//Clickon(getwebelement(xml.getlocator("//locators/FileBrowse")));
		uploadafile(xml.getlocator("//locators/FileBrowse"),"QT-20180312-014836-01.pdf");
		getwebelement(xml.getlocator("//locators/Fileuploaded"));
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		SendKeys(getwebelement(xml.getlocator("//locators/CustomerSignedDate")),date);
		Clickon(getwebelement(xml.getlocator("//locators/ConfirQuoteAction")));
		/////
		}
		else
		{
			WaitforCPQloader();
			Thread.sleep(20000);
			WaitforElementtobeclickable(xml.getlocator("//locators/OrderTab"));
			javascriptexecutor(getwebelement(xml.getlocator("//locators/OrderTab")));
			Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/QuoteActionContainer")));
			Clickon(getwebelement(xml.getlocator("//locators/AcceptQuote")));
			
//			Select(getwebelement(xml.getlocator("//locators/QuoteAction")), "Accept");
			Thread.sleep(2000);
			Clickon(getwebelement(xml.getlocator("//locators/ReasonForStatusContainer")));
			Clickon(getwebelement(xml.getlocator("//locators/Reasone")));
			
//			Select(getwebelement(xml.getlocator("//locators/Reasone")), "Price");
			Thread.sleep(5000);
//			//safeJavaScriptClick();
//			//Clickon(getwebelement(xml.getlocator("//locators/FileBrowse")));
//			uploadafile(xml.getlocator("//locators/FileBrowse"),"QT-20180312-014836-01.pdf");
//			getwebelement(xml.getlocator("//locators/Fileuploaded"));
			String pattern = "dd/MM/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String date = simpleDateFormat.format(new Date());
			System.out.println(date);
			SendKeys(getwebelement(xml.getlocator("//locators/CustomerSignedDate")),date);
			Clickon(getwebelement(xml.getlocator("//locators/ConfirQuoteAction")));
		}
		try {
		WaitforElementtobeclickable("(//span[text()='Close'])[1]/parent::*/parent::*");
		}
		catch(Exception e)
		{
			System.out.println(" No Popup displayed");
		}
		//Thread.sleep(60000);
		Pagerefresh();
//			try {
//				Clickon(getwebelement("(//*[text()='OK']/parent::*/parent::*)[1]"));
//				System.out.println(" Popup displayed");
//			}
//			catch(Exception e)
//			{
//				System.out.println(" No Popup displayed");
//				
//			}
		WaitforCPQloader();
		Thread.sleep(20000);
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/OrderTab")));
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
			WaitforElementtobeclickable(xml.getlocator("//locators/OrderNote"));
		//WaitforElementtobeclickable(xml.getlocator("//locators/AcceptatedProposal"));	
			
	
		
	}
	public void CreateOrder(Object[][] Inputdata) throws Exception {
		//WaitforCPQloader();
		Clickon(getwebelement(xml2.getlocator("//locators/saveQuote")));
		waitForpageload();
		WaitforElementtobeclickable(xml.getlocator("//locators/AdditionalinfomrationTab"));
		javascriptexecutor(getwebelement(xml.getlocator("//locators/AdditionalinfomrationTab")));
		Clickon(getwebelement(xml.getlocator("//locators/AdditionalinfomrationTab")));
		Thread.sleep(10000);
		WaitforElementtobeclickable(xml.getlocator("//locators/EditCustomerDetails"));
		Clickon(getwebelement(xml.getlocator("//locators/EditCustomerDetails")));
		Thread.sleep(8000);
		for(int i=0;i<Inputdata.length;i++) {
			//WaitforElementtobeclickable(xml.getlocator("//locators/Accordian").replace("index",String.valueOf(i+1) ));
			
			//Clickon(getwebelement(xml.getlocator("//locators/Accordian").replace("index",String.valueOf(i+1))));
			
			if(Inputdata[i][2].toString().split(">")[1].trim().equals("Ethernet Line") || Inputdata[i][2].toString().split(">")[1].trim().equals("Wave") ) {
				//javascriptexecutor(getwebelement(xml.getlocator("//locators/AdditionalinfomrationTab")));
				Clickon(getwebelement(xml.getlocator("//locators/Asitecomponey").replace("index",String.valueOf(i+1))));
				Thread.sleep(2000);
				EnterText(Inputdata[i][26].toString());
				Thread.sleep(1000);
				Clickon(getwebelement(xml.getlocator("//locators/BSitecom").replace("index",String.valueOf(i+1))));
				Thread.sleep(2000);
				EnterText(Inputdata[i][27].toString());
		//SendKeys(getwebelement(xml.getlocator("//locators/BSitecom").replace("index",String.valueOf(i+1))),Inputdata[i][27].toString());
		//Clickon(getwebelement(xml.getlocator("//locators/SaveInfo")));
		//Clickon(getwebelement(xml.getlocator("//locators/Accordian").replace("index",String.valueOf(i+1))));
		
			}
			else {
				//javascriptexecutor(getwebelement(xml.getlocator("//locators/AdditionalinfomrationTab")));
				
				//WaitforElementtobeclickable(xml.getlocator("//locators/Accordian").replace("index",String.valueOf(i+1) ));
				//Clickon(getwebelement(xml.getlocator("//locators/Accordian").replace("index",String.valueOf(i+1))));
				//SendKeys(getwebelement(xml.getlocator("//locators/Asitecomponey").replace("index",String.valueOf(i+1))),Inputdata[i][26].toString());
				//SendKeys(getwebelement(xml.getlocator("//locators/BSitecom")),Inputdata[i][27].toString());
				//Clickon(getwebelement(xml.getlocator("//locators/SaveInfo")));
				//Clickon(getwebelement(xml.getlocator("//locators/Accordian").replace("index",String.valueOf(i+1))));
				Clickon(getwebelement(xml.getlocator("//locators/Asitecomponey").replace("index",String.valueOf(i+1))));
				Thread.sleep(2000);
				EnterText(Inputdata[i][26].toString());
				Thread.sleep(1000);
			}
			//WaitforElementtobeclickable(xml.getlocator("//locators/Accordian").replace("index",String.valueOf(i+1) ));
			
			//Clickon(getwebelement(xml.getlocator("//locators/Accordian").replace("index",String.valueOf(i+1))));
			
		}
		Clickon(getwebelement(xml.getlocator("//locators/SaveInfo")));
		Thread.sleep(8000);
		
		//WaitforElementtobeclickable(xml.getlocator("//locators/CreateOrder"));
		//javascriptexecutor(getwebelement(xml.getlocator("//locators/CreateOrder")));
		Clickon(getwebelement(xml.getlocator("//locators/CreateOrder")));
		//WaitforElementtobeclickable("(//span[text()='Close'])[1]/parent::*/parent::*");
		
		Thread.sleep(60000);
		Pagerefresh();
		Thread.sleep(30000);
		WaitforElementtobeclickable(xml.getlocator("//locators/OrderConfirmation"));
		safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Showordercoulumn")));
		Thread.sleep(20000);
		for(int i=0;i<Inputdata.length;i++) {
			OrderType.set(GetText(getwebelement(xml.getlocator("//locators/OdrderType").replace("index", String.valueOf(i+1)))));
		 }
		if(OrderType.get().equals("SIEBEL"))
		{
    	
		while(GetValueofInput(getwebelement(xml.getlocator("//locators/Ordernubmer"))).equals(""))
		{
			Pagerefresh();
			Thread.sleep(30000);
			CustomerOrderNumber.set(GetValueofInput(getwebelement(xml.getlocator("//locators/Ordernubmer"))));
		}
		}
		
	}
	
	
	public void SeibleOrderVerification(Object[][] Inputdata) throws Exception {
		if(OrderType.get().equals("SIEBEL"))
		{
			// Click on Customer Order number
			Clickon(getwebelement(xml.getlocator("//locators/Sieble/CustomerOrderTab")));
			SendKeys(getwebelement(xml.getlocator("//locators/Sieble/CustomerOrdernumber")),CustomerOrderNumber.get());
			//foreach(webelement element as )
			for(int j=1;j<=getwebelementscount(xml.getlocator("//locators/Sieble/SrviceOrdernumber"));j++)
					{
				System.out.println(GetText(getwebelement("("+xml.getlocator("//locators/Sieble/SrviceOrdernumber")+")["+j+"]")));
				Clickon(getwebelement("("+xml.getlocator("//locators/Sieble/SrviceOrdernumber")+")["+j+"]"));
				
				if(Inputdata[j][2].toString().contains("Hub"))
				{
					Assert.assertTrue(GetText(getwebelement(xml.getlocator("//locators/Sieble/Asite"))).equals(Inputdata[j][5]));
				}
				else
				{
					// Verify A Site Address
					Assert.assertTrue(GetText(getwebelement(xml.getlocator("//locators/Sieble/Asite"))).equals(Inputdata[j][5]));
					Assert.assertTrue(GetText(getwebelement(xml.getlocator("//locators/Sieble/Bsite"))).equals(Inputdata[j][5]));
					// Verify B Site Address
				}
				// Verify Badwidth
				Assert.assertTrue(GetText(getwebelement(xml.getlocator("//locators/Sieble/Bandwidth"))).equals(Inputdata[j][9]));
				// verify resilency
				Assert.assertTrue(GetText(getwebelement(xml.getlocator("//locators/Sieble/Resilency"))).equals(Inputdata[j][10]));
					}
			// Search for  Customer Order Number.
			// Read All the Service Order numbers and Log.
			// For Each service Oder number Verify : A end Address, B End Address, Bandwidth and Resiliencey
		}
	}
	public void AcceptsQuotebyEsignature(Object[][] Inputdata) throws Exception {

	Thread.sleep(60000);
	Geturl("http://yopmail.com");
	Thread.sleep(10000);
	SendKeys(getwebelement("//input[@id='login']"),Inputdata[0][25].toString().split("@")[0]);
	Clickon(getwebelement("//input[@value='Check Inbox']"));
	Thread.sleep(30000);
	//Clickon(getwebelement("//input[@value='Check Inbox']"));
	switchtofram(getwebelement("name=ifinbox"));
	System.out.println("Witched to iframe");
	Clickon(getwebelement("//span[contains(text(),'"+QuoteID.get().toString()+"')]/parent::*"));
	switchtodefault();
	System.out.println("Witched to default content");
	Thread.sleep(4000);
	switchtofram(getwebelement("id=ifmail"));
	System.out.println("switched to iframe");
	Clickon(getwebelement("//span[contains(text(),'REVIEW DOCUMENT')]"));
	switchtodefault();
	Switchtotabandsignthequote();
	System.out.println("Witched to default content");
	}

}

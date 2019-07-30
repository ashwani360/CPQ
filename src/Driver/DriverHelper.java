package Driver;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.w3c.dom.Element;

import com.relevantcodes.extentreports.LogStatus;

import Reporter.ExtentTestManager;

public class DriverHelper {
	
	WebDriver driver;
	Wait<WebDriver> wait;
	WebElement el;
	List<WebElement> ellist;
	public static ThreadLocal<String> QuoteID=new ThreadLocal<>();
	public static ThreadLocal<String> CurrentQuoteURL=new ThreadLocal<>();
	public static ThreadLocal<String> DealClass=new ThreadLocal<>();
	public static ThreadLocal<String> TechnicalComplexity=new ThreadLocal<>();
	public static ThreadLocal<String> LeagalComplexity=new ThreadLocal<>();
	public static ThreadLocal<Float> TotalTCVdisscount=new ThreadLocal<>();
	public static ThreadLocal<String> Ordernumber= new ThreadLocal<>();
	public static ThreadLocal<String> ApprovalCase= new ThreadLocal<>();
	public static ThreadLocal<String> OrderscreenURL= new ThreadLocal<>();
	public static ThreadLocal<String> SchedulerURL= new ThreadLocal<>();
	public static ThreadLocal<Integer> workitemcounter= new ThreadLocal<>();
	public static ThreadLocal<String> NCServiceId= new ThreadLocal<>();
	public static ThreadLocal<String> HubNCServiceId= new ThreadLocal<>();
	public static ThreadLocal<String> HubOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> HubOrderscreenURL= new ThreadLocal<>();
	public static ThreadLocal<String> ProductId= new ThreadLocal<>();
	public static ThreadLocal<String> SpokeOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> SpokeOrderscreenURL= new ThreadLocal<>();
	public static ThreadLocal<String> SpokeNCServiceId= new ThreadLocal<>();
	public static ThreadLocal<String> SpokeProductId= new ThreadLocal<>();
	public static ThreadLocal<String> ProductInstancenumber= new ThreadLocal<>();
	public static ThreadLocal<String> ModifiedOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> ModifyOrderscreenURL= new ThreadLocal<>();
	public static ThreadLocal<String> EndCheck= new ThreadLocal<>();
	public static ThreadLocal<String> CeaseOrderscreenURL= new ThreadLocal<>();
	public static ThreadLocal<String> CeaseOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> CompOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> EthernetProductOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> SiebelCeaseOrdernumber= new ThreadLocal<>();									 
	public static ThreadLocal<String> CircuitReference= new ThreadLocal<>();						   
	public static ThreadLocal<String> ANTCheck= new ThreadLocal<>();
	public static ThreadLocal<String> Errors= new ThreadLocal<>();
	public static ThreadLocal<String> SiebelOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> HubSiebelOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> SpokeSiebelOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> ServiceOrder= new ThreadLocal<>();
	public static ThreadLocal<String> CircuitRefnumber= new ThreadLocal<>();
	public static ThreadLocal<String> CircuitRefnumberHub= new ThreadLocal<>();
    public static ThreadLocal<String> HubNetworkReference= new ThreadLocal<>();
    public static ThreadLocal<String> TechnicalOrderStatus= new ThreadLocal<>();
	public static ThreadLocal<String> SpokeCircuitRefnumber= new ThreadLocal<>();
	public static ThreadLocal<String> ModifiedSiebelOrdernumber= new ThreadLocal<>();
	public static ThreadLocal<String> AendBuildingId= new ThreadLocal<>();
	public static ThreadLocal<List> RequestID= new ThreadLocal<>();
	public static ThreadLocal<List> RequestIDNearnet= new ThreadLocal<>();
	public static ThreadLocal<String>  Rerunrequired=new ThreadLocal<>();
	public static ThreadLocal<String> OpportunityID=new ThreadLocal<>();
	public static ThreadLocal<String> Quotestatus=new ThreadLocal<>();
	public static ThreadLocal<String> Quotetcv=new ThreadLocal<>();
	public static ThreadLocal<String> Quoteacv=new ThreadLocal<>();
	public static ThreadLocal<String> Quotearr=new ThreadLocal<>();
	public static ThreadLocal<String> Igmad=new ThreadLocal<>();
	public static ThreadLocal<String> CustomerOrderNumber=new ThreadLocal<>();
	public static ThreadLocal<String> OrderType=new ThreadLocal<>();
	public static ThreadLocal<String> Connectivitytype=new ThreadLocal<>();
	public DriverHelper(WebDriver dr)
	{
		driver=dr;
		wait = new FluentWait<WebDriver>(driver) 
				.withTimeout(60, TimeUnit.SECONDS)    
				.pollingEvery(1000, TimeUnit.MILLISECONDS)    
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
			;
		Rerunrequired.set("No");
		OpportunityID.set("New");
		OrderType.set("");
		//workitemcounter.set(1);
		//QuoteID.set("QT-20190621-033408-01");
		//OpportunityID.set("267899");
		//DealClass.set("Bronze");
//		//TotalTCVdisscount.set((float) 0);
//		List Completeset=new ArrayList();
//		for(int i=0;i<2;i++) {
//			Object[] ExploreID=new Object[2];
//		
//			if(i==0) {
//				ExploreID[0]="";
//				ExploreID[1]="";
//			}
//			else {
//				ExploreID[0]="20190526021849";
//				ExploreID[1]="20190526030013";
//			}
//			Completeset.add(ExploreID);
//			System.out.println(Completeset.get(i).toString());
//		}
//		
//		
//		RequestID.set(Completeset);
//		List data=RequestID.get();
//		//data=RequestID.get();
//		for(int i=0;i<data.size();i++)
//		{
//			Object[] newdata=(Object[]) data.get(i);
//			System.out.println("Size For Each line item"+newdata.length);
//			System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
//			System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
//		}
	}
	 
	public void javascriptexecutor(WebElement el) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", el);
		js.executeScript("window.scrollTo(0, 0)");
		//window.scrollTo(0, 0);
	}
	public void javascriptexecutor2(WebElement el) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", el);
		//js.executeScript("window.scrollTo(0, 0)");
		//window.scrollTo(0, 0);
	}
	
	public void SendKeyswithAction(WebElement el, String key) throws InterruptedException {
		
		Clickon(el);
		Actions action = new Actions(driver);
		 
	    action.sendKeys(key).build().perform();
	    action.sendKeys(Keys.ENTER).build().perform();
	    
	}
public void ClickswithAction(String el) throws InterruptedException {
		
		
		Actions action = new Actions(driver);
		 
	    action.click(driver.findElement(By.xpath(el))).build().perform();
	    //action.sendKeys(Keys.TAB).build().perform();
	    
	}
	public void WaitforElementtobeclickable(String locator) throws InterruptedException
	{
		System.out.println("In Wait for Element Clickable method for - "+locator);
		//waitForpageload();
		if(locator.startsWith("//") || locator.startsWith("(")) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))); 
		//getwebelement(xml.getlocator("//locators/StandrdQuote"));
		System.out.println("Waiting for Element to be clickabal and active"+locator);
		//Thread.sleep(2000);
		}
		else if(locator.startsWith("name"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.name(locator.split("=")[1]))); 
			//getwebelement(xml.getlocator("//locators/StandrdQuote"));
			System.out.println("Waiting for Element to be clickabal and active"+locator);
			//Thread.sleep(2000);
			
		}
		else if(locator.startsWith("id"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locator.split("=")[1]))); 
			//getwebelement(xml.getlocator("//locators/StandrdQuote"));
			System.out.println("Waiting for Element to be clickabal and active"+locator);
			//Thread.sleep(2000);
			
		}
	}
	public void Getloadingcomplete(String locator) throws InterruptedException
	{
		wait.until(ExpectedConditions.attributeToBe(By.xpath(locator), "style", "display: none;")); 
		//getwebelement(xml.getlocator("//locators/StandrdQuote"));
		System.out.println("Waiting Loading mask");
		Thread.sleep(5000);
		
	}
	
	public void CloseProposalwindow() throws InterruptedException
	{   String parentWinHandle = driver.getWindowHandle();
		Set<String> totalopenwindow=driver.getWindowHandles();
		if(totalopenwindow.size()>1) {
		for(String handle: totalopenwindow)
		{
            if(!handle.equals(parentWinHandle))
            {
            driver.switchTo().window(handle);
            
            }
		}
		driver.close();
		driver.switchTo().window(parentWinHandle);
		}
		else {
			System.out.println("No popup displayed");
		}
	}
	public void Switchtotabandsignthequote() throws Exception
	{   String parentWinHandle = driver.getWindowHandle();
		Set<String> totalopenwindow=driver.getWindowHandles();
		for(String handle: totalopenwindow)
		{
            if(!handle.equals(parentWinHandle))
            {
            driver.switchTo().window(handle);
            Thread.sleep(12000);
            try {
            safeJavaScriptClick(getwebelement("//*[@id='disclosureAccepted']"));
            }
            catch(Exception e) {
            Clickon(getwebelement("//*[text()='Required']"));
            }
            Clickon(getwebelement("//button[text()='Continue']"));
    		Clickon(getwebelement("//button[@data-qa='SignHere']"));
    		Clickon(getwebelement("//div[@class='page-tabs']"));
    		//create object 'action' of Actions class
    		//Dragedrop(getwebelement("//button[@data-qa='SignHere']"),getwebelement("//div[@class='page-tabs']"));
    		Thread.sleep(10000);
    		Clickon(getwebelement("//button[text()='Adopt and Sign']"));
//    		Thread.sleep(10000);
//    		Clickon(getwebelement("//button[text()='Ok']"));
    		Thread.sleep(10000);
    		WaitforElementtobeclickable("//button[text()='Finish']");
    		Clickon(getwebelement("//button[text()='Finish']"));
    		WaitforElementtobeclickable("(//button[text()='Continue'])[2]");
    		Clickon(getwebelement("(//button[text()='Continue'])[2]"));
    		Thread.sleep(10000);
            }
		}
		driver.close();
		driver.switchTo().window(parentWinHandle);
	}
	public void Switchtotab() throws Exception
	{   String parentWinHandle = driver.getWindowHandle();
		Set<String> totalopenwindow=driver.getWindowHandles();
		for(String handle: totalopenwindow)
		{
            if(!handle.equals(parentWinHandle))
            {
            driver.switchTo().window(handle);
            Thread.sleep(4000);
           
            }
		}
		//driver.close();
		//driver.switchTo().window(parentWinHandle);
	}
	public void Getmapiframeloaded(String framlocator, String l1) throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(framlocator.split("=")[1])));
		//driver.switchTo().frame(driver.findElement(By.id(framlocator.split("=")[1])));
		System.out.println("Switched to Iframe");
		Thread.sleep(5000);
		//driver.switchTo().frame(driver.findElement(By.id(framlocator.split("=")[1])));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(l1)));
		//driver.switchTo().defaultContent();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(messagelocator))); 
//		try {
		//ExpectedConditions.
//			
//			System.out.println("Verify that Iframe exits");
//			//Thread.sleep(3000);
//			String[] finalval=framlocator.split("=");
//			//Thread.sleep(3000);
//			driver.findElement(By.id(finalval[1]));
//		}
//		catch(Exception e)
//		{
//			Thread.sleep(2000);
//			Getmapiframeloaded(framlocator);
//		}
		
	}
	
	public void Getmaploaded(String framlocator, String messagelocator) throws InterruptedException
	{
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id(framlocator.split("=")[1])));
		//try {
		System.out.println("Code for Map Loading Start");
		//Thread.sleep(3000);
		String[] finalval=framlocator.split("=");
		//Thread.sleep(3000);
		WaitforElementtobeclickable(framlocator);
		
		driver.switchTo().frame(driver.findElement(By.id(finalval[1])));
		System.out.println("Switched to Iframe");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(messagelocator))); 
		System.out.println("Element found and Waiting");
		System.out.println(driver.findElement(By.xpath(messagelocator)).getText().toString());
		driver.switchTo().defaultContent();
		//ExpectedConditions.elementToBeClickable(locator)
		//Thread.sleep(2000);
		System.out.println("Code for Map Loading End ");
		Thread.sleep(2000);
		//}
		//}
//		catch(Exception e)
//		{
//			System.out.println("In catch"+e.getMessage());
//			Thread.sleep(1000);
//			driver.switchTo().defaultContent();
//			System.out.println("Switched to Default Content");
//			Getmaploaded(framlocator,messagelocator);
//			
//		}
		
	}
	
	public WebElement getwebelement(String locator) throws InterruptedException
	{   //Log.info("Indriverhelper"+driver);
	 //WebElement el;
		System.out.print("In Get element method for - "+locator);
	String[] finalval;
	try {
		if(locator.startsWith("name"))
		{
			finalval=locator.split("=");
			//Log.info(finalval[1]);
			//Log.info("Indriverhelper"+driver);
			//wait.until();
			el= driver.findElement(By.name(finalval[1]));
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el= driver.findElement(By.name(finalval[1]));
					//RemoteWebDriver dr;
					try {
					wait.until(ExpectedConditions.elementToBeClickable(el));
					}
					catch(Exception e) {
					wait.until(ExpectedConditions.visibilityOf(el));
					}
					return el;     
				 }  
				}); 
			//wait.until(ExpectedConditions.stalenessOf(element))
		}
		else if(locator.startsWith("id"))
		{
			finalval=locator.split("=");
			//Log.info(finalval[1]);
			//Log.info("Indriverhelper"+driver);
			//el=driver.findElement(By.id(finalval[1]));
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el=driver.findElement(By.id(finalval[1]));
					try {
						wait.until(ExpectedConditions.elementToBeClickable(el));
						}
						catch(Exception e) {
						wait.until(ExpectedConditions.visibilityOf(el));
						}
					//wait.until(el.isEnabled());
					return el;   
				 }  
				});
			 //el= driver.findElement(By.id(finalval[1]));
		}
		else if (locator.startsWith("//")|| locator.startsWith("(//")||locator.startsWith("("))
		{
			//el=driver.findElement(By.xpath(locator)); 
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el=driver.findElement(By.xpath(locator)); 
					try {
						wait.until(ExpectedConditions.elementToBeClickable(el));
						}
						catch(Exception e) {
						wait.until(ExpectedConditions.visibilityOf(el));
						}
					return el;   
				 }  
				});
			
		}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage().toString());
		//getwebelement(locator);
	}
		//Thread.sleep(1000);
	try {
		System.out.println("Is the element is enabled-"+el.isEnabled());
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage().toString());
	}
		return el;
	}
	public String gettitle() {
		return driver.getTitle();
	}
	
	public WebElement ReturnElement(String locator){
		
			System.out.print("In Get element method for - "+locator);
		String[] finalval;
		try {
			if(locator.startsWith("name"))
			{
				finalval=locator.split("=");
				//Log.info(finalval[1]);
				//Log.info("Indriverhelper"+driver);
				//wait.until();
				el= driver.findElement(By.name(finalval[1]));
				
						
					
				//wait.until(ExpectedConditions.stalenessOf(element))
			}
			else if(locator.startsWith("id"))
			{
				finalval=locator.split("=");
				//Log.info(finalval[1]);
				//Log.info("Indriverhelper"+driver);
				el=driver.findElement(By.id(finalval[1]));
				
						
					
				 //el= driver.findElement(By.id(finalval[1]));
			}
			else if (locator.startsWith("//")|| locator.startsWith("(//")||locator.startsWith("("))
			{
				el=driver.findElement(By.xpath(locator)); 
				
						
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage().toString());
			//getwebelement(locator);
		}
			//Thread.sleep(1000);
		try {
			System.out.println("Is the element is enabled-"+el.isEnabled());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage().toString());
		}
			return el;
		
	}
	public WebElement getwebelement2(String locator) throws InterruptedException
	{   
		if (locator.startsWith("//")|| locator.startsWith("(//"))
		{	
					el=(WebElement) driver.findElement(By.xpath(locator)); 
					return driver.findElement(By.xpath(locator));     	
		}
		Thread.sleep(1000);
		return el;
	}
	public void openurl(String environment) throws Exception {
		String URL=null;
		PropertyReader pr=new PropertyReader();
		Log.info(environment+"_URL");
		URL=pr.readproperty(environment+"_URL");
		
		driver.get(URL);
		
	}
	public void openurl2(String environment) throws Exception {
		
		
		driver.get(environment);
		
	}
	public void Geturl(String URL) throws Exception {
	
		driver.get(URL);
		
	}
	public void Clickon(WebElement el) throws InterruptedException {
		//Thread.sleep(3000);
		
		try {
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
	        //use executeScript() method and pass the arguments 
	        //Here i pass values based on css style. Yellow background color with solid red color border. 
	// js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", el);	
		el.click();
		System.out.println("try to click on the element");
	//js.executeScript("arguments[0].setAttribute('style', 'border: 0px solid red;');", el);	
		
		}
		catch(WebDriverException e)
		//Thread.sleep(3000);
		{
			//Thread.sleep(3000);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println("Error in Clickon " + e.getMessage());
			if(!e.toString().equals("NoSuchElementException")){
			try {
			if(e.getMessage().contains("Element is not clickable at point"))
			{
				Thread.sleep(3000);
				System.out.println("Size of the element is not perfect so waited and re-tried the click actions");
				//js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", el);	
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
				//el.click();
				//js.executeScript("arguments[0].setAttribute('style', 'border: 0px solid red;');", el);	
			}
			else if(driver.findElement(By.xpath("//div[@id='lockCreateScreen' and not(@style='display: none;')]")).isDisplayed())
			{
				System.out.println("Mask was overlayed so trying click with the Java script");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
				
			}
			}
			catch(NoSuchElementException e12)
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
			}
			}
			else {
				Assert.fail("The Elelemt with locator"+el.getTagName()+" and "+el.hashCode());
			}
		}
	}
	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				Log.info("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				Log.info("Unable to click on element");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
		} catch (StaleElementReferenceException e) {
			Log.info("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			Log.info("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			Log.info("Unable to click on element "+ e.getStackTrace());
		}
	}
	public void switchtofram(WebElement el){
		driver.switchTo().frame(el);
		
	}
	public void switchtodefault(){
		driver.switchTo().defaultContent();
		
	}
			public String Getattribute(WebElement el,String attributename) {
			Log.info(el.getAttribute(attributename));
			return el.getAttribute(attributename);
	  }
			
			public void ProxyLogin(String User, String Proxylink) throws Exception
			{
				openurl("CPQAdmin");
				WaitforElementtobeclickable("//a[text()='Internal Users']");
				Clickon(getwebelement("//a[text()='Internal Users']"));
				Thread.sleep(2000);
				String uri=Getattribute(getwebelement(Proxylink),"href");
				System.out.println("URL is"+uri);
				String[] URL1=uri.split("user_id=");
				System.out.println(URL1[0]);
				System.out.println(URL1[1]);
				String URL2=(URL1[1].split("&"))[1];
				System.out.println(URL2);
				PropertyReader pr=new PropertyReader();
				String FinalURL=URL1[0]+"user_id="+pr.readproperty(User)+"&"+URL2;
				System.out.println(FinalURL);
				
				Log.info("CPQ_URL");
				openurl2(FinalURL);
			}
public void Moveon(WebElement el) {
			
		Actions action = new Actions(driver);
		 
	    action.moveToElement(el).build().perform();
	}
	public boolean isElementPresent(String locator) {
	    try {
	        driver.findElement(By.xpath(locator));
	        Log.info("Element Found: True");
	        return true;
	    } catch (NoSuchElementException e) {
	    	 Log.info("Element Found: False");
	        return false;
	    }
	}
public void Expandthesection(WebElement Section, WebElement ClickableElement) throws Exception {
		
	Thread.sleep(5000);	
	String classvalue=Getattribute(Section,"class");
		System.out.println(classvalue);
	if(!classvalue.contains("green")){
		System.out.println("In IF class");
		//Clickon(ClickableElement);
		((JavascriptExecutor)

				driver).executeScript("arguments[0].scrollIntoView();", ClickableElement);
		safeJavaScriptClick(ClickableElement);
		
	}
	else {
		System.out.println("Already expanded");
	}
	}
public void Clickonoutofviewport(WebElement locator) throws Exception {
	((JavascriptExecutor)

			driver).executeScript("arguments[0].scrollIntoView();", locator);
	safeJavaScriptClick(locator);
}
public void Clickonoutofviewportwithstring(String locator) throws Exception {

	((JavascriptExecutor)

			driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()='Show Groups']")));
	//
	((JavascriptExecutor)

			driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(locator)));
	
	System.out.println("See if Scrolled");
	Thread.sleep(5000);	
	System.out.println("Waiting....");
	safeJavaScriptClick(driver.findElement(By.xpath(locator)));
}
	public void waitandclickForworkitemsPresent(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	//Goto Error Tab
		            	// Clickon(getwebelement(xml.getlocator("//locators/Tasks/Errors")));
		            	//if any Error displayed
		            	//if(isElementPresent("Locator for first error"))
		            	//{
		            	//Assert.fail("An Error Occuured on Error Tab");
		            	//break;
		            	//}
		            	//else
		            	//{
		            	//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		            	//Log.info("Refreshing the Pages");
			        	//driver.navigate().refresh();
			        	//Log.info("Waiting For 20 Sec");
			        	//Thread.sleep(20000);
		            	//}
		            	//Assert False and Break
		            	//else navigate to WorkItems and do the page refresh and weight
		            	Log.info("Refreshing the Pages");
			        	driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(20000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	
	public void waitandclickForOrderCompleted(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	Log.info("Refreshing the Pages");
			        	driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(20000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	
	public void waitandclickForOrderStarted(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	Log.info("Refreshing the Pages");
			        	driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(20000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	
	public void waitandForElementDisplayed(String locator) throws InterruptedException
	{
		Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
	}
	public void waitandForElementDisplay(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	Log.info("Refreshing the Pages");
			        	//driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(20000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	public void waitandForElementtobenotDisplay(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		            	Log.info("Refreshing the Pages");
			        	//driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	System.out.println("Waiting......");
			        	Thread.sleep(3000);
		            }
		            else{
		            	break;
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	public void waitandForElementDisplay2(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	//Log.info("Refreshing the Pages");
			        	//driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(3000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	public void Pagerefresh() throws InterruptedException
	{
			driver.navigate().refresh();
			Thread.sleep(5000);
			        	
	}
	public void Select3(WebElement el, String value) throws IOException, InterruptedException
	{ try {
		if (el.isEnabled() && el.isDisplayed()) {
			Log.info("Clicking on element with using java script click");

			((JavascriptExecutor) driver).executeScript("arguments[0].value='"+value+"'",el);
		} else {
			Log.info("Unable to click on element");
		}
	} catch (StaleElementReferenceException e) {
		Log.info("Element is not attached to the page document "+ e.getStackTrace());
	} catch (NoSuchElementException e) {
		Log.info("Element was not found in DOM "+ e.getStackTrace());
	} catch (Exception e) {
		Log.info("Unable to click on element "+ e.getStackTrace());
	}
	}
	
	public int getwebelementscount(String locator) throws InterruptedException
	{ 
		ellist=driver.findElements(By.xpath(locator));
		return ellist.size();
	}
	
	public void SendKeys(WebElement el,String value) throws InterruptedException, IOException {
		//Thread.sleep(3000);
		//el.
		//System.out.println(el.getRect().getHeight()+"-"+el.getRect().getWidth()+"-"+el.getRect().x+"-"+el.getRect().x);
		//ExtentTestManager.getTest().log(LogStatus.PASS,ExtentTestManager.getTest().addBase64ScreenShot(capturescreenshotforelement(el)));
		el.sendKeys(value);
		
		//Thread.sleep(3000);
	}
	

	public void SendkeaboardKeys(WebElement el,Keys k) throws InterruptedException {
		//Thread.sleep(3000);
		el.sendKeys(k);
		//Thread.sleep(3000);
	}
	
	public String GetText(WebElement el) {
			String actual=el.getText().toUpperCase().toString();
	//		String actual1=el.getText().toUpperCase().toString();
			return actual;
		}
	
	public String GetInputValue(WebElement el) {
		String actual=el.getAttribute("value");
		return actual;
		}

	public String Getkeyvalue(String Key) throws IOException{ 
			PropertyReader pr=new PropertyReader();
		    String Keyvalue;
			Keyvalue=pr.readproperty(Key);
			return Keyvalue;
		}
	
	public void VerifyTextpresent(String text) throws IOException
		{ 
			Log.info(text);
			Assert.assertFalse(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
		}
	
	public void VerifyText(String text) throws IOException
		{ 
			Log.info(text);
			Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
		}
	
	public String Gettext(WebElement el) throws IOException
		{ 
			String text=el.getText().toString();
			return text;
		}
	public String GetValueofInput(WebElement el) throws IOException
	{ 
		String text=el.getAttribute("value");
		return text;
	}
	
	public String[] GetText2(WebElement el) throws IOException
		{ 
			String text=el.getText().toString();
			String[] text2=text.split(" \\[");
			Log.info("New Task Name is:"+text2);
			return text2;
		}
	
	public String GetText3(WebElement el, String string) throws IOException
		{ 
			String text=el.getText().toString();
			return text;
		}
	
	public void Select(WebElement el, String value) throws IOException, InterruptedException
		{ //Thread.sleep(3000);
			Select s1=new Select(el);
			s1.selectByVisibleText(value);
			//Thread.sleep(3000);
		}
	public void Select2(WebElement el, String value) throws IOException, InterruptedException
	{ //Thread.sleep(3000);
		Select s1=new Select(el);
		s1.selectByValue(value);
		//Thread.sleep(3000);
	}
	public void Clear(WebElement el) throws IOException, InterruptedException
		{ //Thread.sleep(3000);
			el.clear();
			//Thread.sleep(3000);
		}
	public void WaitforCPQloader( ) throws IOException, InterruptedException
	{
		
		try {
			//Thread.sleep(3000);
			System.out.println(driver.findElement(By.xpath("//html")).getAttribute("class"));
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//html[contains(@class,'loading')]"))));
			//System.out.println(driver.findElement(By.xpath("//html")).getAttribute("class"));
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html[contains(@class,'loading')]")));
			System.out.println(driver.findElement(By.xpath("//html")).getAttribute("class"));
			//Thread.sleep(3000);
			//wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//html")), "class", "loading")ExpectedConditions.attributeContains(driver.findElement(By.xpath("//html")), "class", "page-loaded loading"));
			//wait.until(ExpectedConditions.and(),
				//	ExpectedConditions.and(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//html")), "class", "page-loaded loading")));
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html[contains(@class,'page-loaded')]")));
			System.out.println(driver.findElement(By.xpath("//html")).getAttribute("class"));
			
			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//html")), "class", "loading"));
			Thread.sleep(700);
			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//html")), "class", "page-loaded loading"));
			
				}
				catch(Exception e) {
					Log.info("No Loader displayed");
					System.out.println("in catch");
					Thread.sleep(1000);
					//WaitforCPQloader();
//					String currentstate=driver.findElement(By.xpath("//html")).getAttribute("class");
//					if(currentstate.contains("loading"))
//					{
//						WaitforCPQloader( );
//					}
				}
		
		
	}
	public void CurrentURL() {
		CurrentQuoteURL.set(driver.getCurrentUrl());
	}
	public void WaitforCPQloader2( ) throws IOException, InterruptedException
	{
		for(int i=0;i<=20;i++) {
		//Thread.sleep(30000);
		if(driver.findElement(By.xpath("//html")).getAttribute("class").toString().contains("loading"))
		{
			System.out.println("In check");
			Thread.sleep(500);
			//WaitforCPQloader2( );
		}
		else {
			System.out.println("Loading Finnished");
			
		}
		
	}
		Thread.sleep(2000);
//		System.out.println("In second loader");
//		
//		try {
//			//Thread.sleep(3000);
//			System.out.println(driver.findElement(By.xpath("//html")).getAttribute("class"));
//			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//html[contains(@class,'loading')]"))));
//			//System.out.println(driver.findElement(By.xpath("//html")).getAttribute("class"));
//			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//html[contains(@class,'loading')]"))));
//			System.out.println(driver.findElement(By.xpath("//html")).getAttribute("class"));
//			
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//html[contains(@class,'page-loaded')]"))));
//				}
//				catch(Exception e) {
//					Log.info("No Loader displayed");
//					System.out.println("in catch");
//					Thread.sleep(500);
//					WaitforCPQloader2();
//				}
		
	}
	public void WaitforC4Cloader(String el, int timeout ) throws IOException, InterruptedException
	{ Thread.sleep(1500);
		
		try {
			driver.findElement(By.xpath(el));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(el)));
	//wait.until(ExpectedConditions.presenceOfElementLocated(driver.findElement(By.xpath(el))));
		}
		catch(Exception e) {
			Log.info("No Loader displayed");
		}
//		for(int i=0;i<=timeout*60/20;i++){
//			try {
//	            if (isElementPresent(el)){
//	            	//Log.info("Refreshing the Pages");
//		        	//driver.navigate().refresh();
//		        	Log.info("Waiting For 20 Sec");
//		        	Thread.sleep(20000);
//	            }
//	            else{
//	            	//Log.info("Refreshing the Pages");
//		        	//driver.navigate().refresh();
//		        	break;
//	            }
//	            }
//	        catch (Exception e) {
//	        	Log.info(e.getMessage());
//	        }
//		}
		Thread.sleep(8000);
	}
	public void AcceptJavaScriptMethod() throws InterruptedException{
		Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.switchTo().defaultContent();
		}
	public void CancelJavaScriptMethod() throws InterruptedException{
		Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			driver.switchTo().defaultContent();
		}
	public void waitForpageload() throws InterruptedException
	{
		
		//wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));	
		Thread.sleep(20000);
	}
	public void waitForpagenavigated(int timeout) throws InterruptedException
	{
		for(int i=0;i<=timeout*100/5;i++){
		try {
            if (!driver.getTitle().toString().contains("Transaction")){
            	//Log.info("Refreshing the Pages");
	        	//driver.navigate().refresh();
	        	Log.info("Waiting For 20 Sec");
	        	System.out.println( "Waiting for Navigation happen");
	        	Thread.sleep(500);
            }
            else{
            	//Log.info("Refreshing the Pages");
            	System.out.println( "Nevigated to CPQ");
	        	//driver.navigate().refresh();
	        	break;
            }
            }
        catch (Exception e) {
        	Log.info(e.getMessage());
        }
	}
	//Thread.sleep(3000);
		//wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));	
		//Thread.sleep(1000);
	}
	public void Dragedrop(WebElement source,WebElement Destination){
		Actions action = new Actions(driver);
		//use dragAndDrop() method. It accepts two parametes source and target.
		action.dragAndDrop(source, Destination).build().perform();
	}
	
	public void EnterText(String s){
		Actions keyAction = new Actions(driver);     
		keyAction.sendKeys(s).perform();
	}
	public void EnterText2(Keys k){
		Actions keyAction = new Actions(driver);     
		keyAction.sendKeys(k).perform();
	}
	public void savePage(){
			Actions keyAction = new Actions(driver);     
			keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
		}
	public void KeydownKey(Keys key){
		Actions keyAction = new Actions(driver);     
		keyAction.keyDown(key).perform();
	}
	public void KeyupKey(Keys key){
		Actions keyAction = new Actions(driver);     
		keyAction.keyUp(key).perform();
	}
	public void uploadafile(String  locator,String FileName)
	{
		String str = System.getProperty("user.dir")+"\\src\\Data\\"+FileName;
		String[]  finalval=locator.split("=");
		WebElement el=driver.findElement(By.id(finalval[1])); 
		el.sendKeys(str);
//		// + "\\Lib\\chromedriver.exe"
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Clipboard clipboard = toolkit.getSystemClipboard();
//		StringSelection strSel = new StringSelection(str);
//		clipboard.setContents(strSel, null);
//		Actions keyAction = new Actions(driver); 
//		keyAction.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
//		keyAction.sendKeys(Keys.ENTER);
		
	}
	public String capturescreenshotforelement(WebElement ele) throws IOException
	{
		String screenshot2;
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	BufferedImage  fullImg = ImageIO.read(screenshot);

	// Get the location of element on the page
	org.openqa.selenium.Point point = ele.getLocation();

	// Get width and height of the element
	int eleWidth = ele.getSize().getWidth();
	int eleHeight = ele.getSize().getHeight();

	// Crop the entire page screenshot to get only element screenshot
	BufferedImage eleScreenshot= fullImg.getSubimage(point.getX()-20, point.getY()-20,
	    eleWidth+20, eleHeight+20);
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	ImageIO.write(eleScreenshot, "png", bos);
	byte[] imageBytes = bos.toByteArray();
    screenshot2 = "data:image/png;base64,"+Base64.getMimeEncoder().encodeToString(imageBytes);
    bos.close();
    return screenshot2;
	}
	}

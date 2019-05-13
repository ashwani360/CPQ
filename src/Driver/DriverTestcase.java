package Driver;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import Listeners.TestListener;
import ScriptHelper.BCNUpdateHelper;
import ScriptHelper.C4CHelper;
import ScriptHelper.ConfigurationHelper;
import ScriptHelper.DisscountAndAprrovalHelper;
import ScriptHelper.GenralInfoHelper;
import ScriptHelper.LoginHelper;
import ScriptHelper.OrderingHelper;
import ScriptHelper.SendProposalHelper;


public class DriverTestcase {
	
	
	
public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();

	
	public static final ThreadLocal<LoginHelper> Login= new InheritableThreadLocal<>();
	public static final ThreadLocal<BCNUpdateHelper> BCNupdatehelper= new InheritableThreadLocal<>();
	public static final ThreadLocal<C4CHelper> C4Chelper= new InheritableThreadLocal<>();
	//public static final ThreadLocal<AccountNavigationHelper> SiebelNavigationHelper= new InheritableThreadLocal<>();
	public static final ThreadLocal<ConfigurationHelper> Configurationhelper= new InheritableThreadLocal<>();
	public static final ThreadLocal<DisscountAndAprrovalHelper> DisscountAndAprrovalhelper= new InheritableThreadLocal<>();
	public static final ThreadLocal<GenralInfoHelper> GenralInfohelper= new InheritableThreadLocal<>();
	public static final ThreadLocal<OrderingHelper> Orderinghelper= new InheritableThreadLocal<>();
	public static final ThreadLocal<SendProposalHelper> SendProposalhelper= new InheritableThreadLocal<>();
	
	public static TestListener Testlistener;
	//public static CarNorOrderHelper CarNorOrderhelper;
	public ThreadLocal<String> TestName=new ThreadLocal(); 
	

	public static int  itr;
	@BeforeMethod
	   public void BeforeMethod(Method method,ITestContext ctx ,Object[] data) throws IOException, InterruptedException{
	 
		setup();
		Object[] st = null;
		
		try 
		
		{
	 	st=(Object[]) data[0];
		}
		catch(Exception e)
		{
			st=new Object[][] {{""}};
		}
	
	//Log.info("Index is:"+itr+"Length od data is:"+data.length);
	      if(method.getName().equals("EndtoEndOrder"))
	      {
	   		//DataReader dt=new DataReader();
	   		//Object[][] data=dt.datareader();
		    //Object[] st= (Object[]) data[itr][0];
		    Log.info(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
	      }
	    
	}


	//@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		// Open Browser
		WebDriver dr = null;
		PropertyReader pr=new PropertyReader();
		String targatedbrowser=pr.readproperty("browser");
		String url=pr.readproperty("URL");
		Log.info("URL");
		if(targatedbrowser.equals("chrome"))
		{ 
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			Map<String, Object> prefs = new HashMap<String, Object>();
			 // Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);
			
			
            // Create object of ChromeOption class
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-popup-blocking");
			//options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
			capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
			//capabilities.setCapability(CapabilityType.);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
			dr= new ChromeDriver(capabilities);
			//driver.manage().window().maximize();
			dr.get("chrome://settings/content/popups");
			Thread.sleep(4000);
			//dr.switchTo().frame("settings");
			//Thread.sleep(2000);
			//dr.findElement(By.xpath("//*[@id='popups']")).click();
			//Thread.sleep(4000);
			Actions builder = new Actions(dr);
			builder.sendKeys(Keys.TAB).build().perform();
			builder.sendKeys(Keys.TAB).build().perform();
			builder.sendKeys(Keys.TAB).build().perform();
			builder.sendKeys(Keys.ENTER).build().perform();
			//dr.findElement(By.id("control")).click();
			//Thread.sleep(4000);
		}
		else if (targatedbrowser.equals("ie"))
		{
			Log.info("For IE inprogress");
		}
		
		else
		{
			Log.info("For FF inprogress");
		}
		
		dr.manage().window().maximize();
		WEB_DRIVER_THREAD_LOCAL.set(dr);
		Thread.sleep(2000);
		LoginHelper LN= new LoginHelper(getwebdriver());
		
		
		
		BCNUpdateHelper BCN= new BCNUpdateHelper(getwebdriver());
		C4CHelper C4C= new C4CHelper(getwebdriver());
		ConfigurationHelper CON= new ConfigurationHelper(getwebdriver());
		DisscountAndAprrovalHelper DISAAPR= new DisscountAndAprrovalHelper(getwebdriver());
		GenralInfoHelper GEN= new GenralInfoHelper(getwebdriver());
		OrderingHelper ORD= new OrderingHelper(getwebdriver());
		SendProposalHelper PRO= new SendProposalHelper(getwebdriver());
		
		Login.set(LN);
		BCNupdatehelper.set(BCN);
		C4Chelper.set(C4C);
		Configurationhelper.set(CON);
		DisscountAndAprrovalhelper.set(DISAAPR);
		GenralInfohelper.set(GEN);
		Orderinghelper.set(ORD);
		SendProposalhelper.set(PRO);
	}

	@org.testng.annotations.BeforeSuite
	public void BeforeSuite(){
	itr=0;
	DOMConfigurator.configure("log4j.xml");
	}
	
	@AfterTest
	public void Teardown()
	{
		
		getwebdriver().close();
	}
	public WebDriver getwebdriver() {
		WebDriver dr = WEB_DRIVER_THREAD_LOCAL.get();
		return dr;
	}
}

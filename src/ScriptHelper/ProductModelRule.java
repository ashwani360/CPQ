package ScriptHelper;

import java.io.IOException;
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
import Driver.Log;
import Driver.PropertyReader;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class ProductModelRule extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Configuration.xml");
	PropertyReader pr=new PropertyReader();
	Object[] ExploreID=new Object[2];
	List Completeset=new ArrayList();
	List Completesetnearnet=new ArrayList();
	public ProductModelRule(WebDriver parentdriver)
	{
		super(parentdriver);
	}

	public void FeidldlevelValidationAccount(Object[][] Inputdata) throws InterruptedException, DocumentException, Exception {
		 ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Save Button");

		    Expandthesection(getwebelement(xml.getlocator("//locators/SectionName").replace("Sectionname", "Account Details")),getwebelement(xml.getlocator("//locators/Clickableelemt").replace("Sectionname", "Account Details")));

		        Thread.sleep(5000);
		NewLogoflag.set(GetValueofInput(getwebelement(xml.getlocator("//locators/NewLogoflag"))).toString());
		System.out.println("New Logo Flag is"+NewLogoflag);
	}
	
	public void AddProductrule(Object[][] Inputdata) throws Exception {
		
		waitForpageload();
		WaitforCPQloader();
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader"),1);
//		waitandForElementDisplay(xml.getlocator("//locators/AddProduct"),1);
//		waitForpageload();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting For Page to Be updated as Stanrad Quote");
		WaitforElementtobeclickable(xml.getlocator("//locators/QuoteID"));
		
		getwebelement(xml.getlocator("//locators/QuoteID"));
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Product Button");
		QuoteID.set(GetValueofInput(getwebelement(xml.getlocator("//locators/QuoteID"))));
		System.out.println(QuoteID.get());
		CurrentURL();
		// Set the New Logo Flag and Fields level Validation
		FeidldlevelValidationAccount(Inputdata);
		
		
		
		///
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
		AddFamilyProductrule(Inputdata,i);
		WaitforElementtobeclickable(xml.getlocator("//locators/LineitemGrid"));
//		waitForpageload();
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader1"),1);
//		waitandForElementtobenotDisplay(xml.getlocator("//locators/AjaxLoader"),1);
//		waitandForElementDisplay(xml.getlocator("//locators/AddProduct"),1);
//		waitForpageload();
		
		}
		
		Clickon(getwebelement(xml.getlocator("//locators/saveQuote")));
		waitForpageload();
		WaitforCPQloader();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Save Button");
		Expandthesection(getwebelement(xml.getlocator("//locators/SectionName").replace("Sectionname", "Opportunity Info")),getwebelement(xml.getlocator("//locators/Clickableelemt").replace("Sectionname", "Opportunity Info")));
		Thread.sleep(5000);
		
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
		
		
		Thread.sleep(3000);
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
	
	public void Selectfamily(String family) throws Exception
	{
		switch(family)
		{
		   // case statements
		   // values must be of same type of expression
		   case "Ethernet" :
			   { ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct Family");
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
		   		WaitforElementtobeclickable((xml.getlocator("//locators/Ethernetfamily")));
			 Clickon(getwebelement(xml.getlocator("//locators/Ethernetfamily")));
			 break;
			   }
		}
	}
	public void ConfigureProductrule(String Prodcutname,Object[][] Inputdata, int i) throws Exception
	{		Object[] ExploreID=new Object[2];
			ExploreID[0]="";
			ExploreID[1]="";
			Object[] ExploreIDNearnet=new Object[2];
			ExploreIDNearnet[0]="";
			ExploreIDNearnet[1]="";
			Connectivitytype.set(Inputdata[i][11].toString());
			Connectivitytype.set(Inputdata[i][12].toString());
		switch(Prodcutname)
		{
		   // case statements
		   // values must be of same type of expression
		   case "Ethernet Line" :
			   { 
				   
				   ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Producct");
				    Thread.sleep(3000);
				    WaitforElementtobeclickable((xml.getlocator("//locators/EthernetProductP2P")));
					Clickon(getwebelement(xml.getlocator("//locators/EthernetProductP2P")));
					Getmapiframeloaded(xml.getlocator("//locators/GoogleMapifram"),xml.getlocator("//locators/Legend")); 
					//Thread.sleep(5000);
					//WaitforElementtobeclickable(());
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter A Site Address");
					SendKeys(getwebelement(xml.getlocator("//locators/Asite")),Inputdata[i][5].toString());
					Thread.sleep(2000);
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
					//getwebelement(xml.getlocator("//locators/LoadingDailog"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter B Siter Address");
					 //Thread.sleep(2000);
					SendKeys(getwebelement(xml.getlocator("//locators/Bsite")),Inputdata[i][6].toString());
					Thread.sleep(2000);
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
					/////
					NewLogoBandwidthValidation(Prodcutname);
					BuildingTypeResilency(Prodcutname);
					//Bandwidth for new Logo & existing
					//Product type with Resiliency
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
					//Coverage
					Covarge(Prodcutname);
					//Feature Availablibity
					// Return on the Site detail tab
					FeaturesAvailability(Prodcutname, Inputdata,i);
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
					exception=Gettext(getwebelement(xml.getlocator("//locators/PPT/BasePrice")));
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
					
					// Code for Feature Validation for A Site with Building Type
					// Code for Feature validation for B Site with Building Type
					// Code for Feature Validation for A Site with Connectivity Type
					// Code for Feature validation for B Site with Connectivity Type
					
					//AdditionalProductData();
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
			/////
				NewLogoBandwidthValidation(Prodcutname);
				BuildingTypeResilency(Prodcutname);
				//Bandwidth for new Logo & existing
				//Product type with Resiliency
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
				//Coverage
				Covarge(Prodcutname);
				//Feature Availablibity
				// Return on the Site detail tab
				FeaturesAvailability(Prodcutname, Inputdata,i);
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
				exception=Gettext(getwebelement(xml.getlocator("//locators/PPT/BasePrice")));
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
				//AdditionalProductData();

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
				  
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
					Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
					//Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
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
				/////
					NewLogoBandwidthValidation(Prodcutname);
					BuildingTypeResilency(Prodcutname);
					//Bandwidth for new Logo & existing
					//Product type with Resiliency
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
					//Coverage
					Covarge(Prodcutname);
					//Feature Availablibity
					// Return on the Site detail tab
					FeaturesAvailability(Prodcutname, Inputdata,i);
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
					exception=Gettext(getwebelement(xml.getlocator("//locators/PPT/BasePrice")));
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
					//AdditionalProductData();
					
					
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
				/////
					NewLogoBandwidthValidation(Prodcutname);
					BuildingTypeResilency(Prodcutname);
					//Bandwidth for new Logo & existing
					//Product type with Resiliency
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
					//Coverage
					Covarge(Prodcutname);
					//Feature Availablibity
					// Return on the Site detail tab
					FeaturesAvailability(Prodcutname, Inputdata,i);
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
					exception=Gettext(getwebelement(xml.getlocator("//locators/PPT/BasePrice")));
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
					///AdditionalProductData();
					
					
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
				Thread.sleep(1000);
				//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ARROW_DOWN);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Asite")),Keys.ENTER);
				//getwebelement(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				Getmaploaded(xml.getlocator("//locators/GoogleMapifram"), xml.getlocator("//locators/Messages"));
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
			/////
				NewLogoBandwidthValidation(Prodcutname);
				BuildingTypeResilency(Prodcutname);
				//Bandwidth for new Logo & existing
				//Product type with Resiliency
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
				exception=Gettext(getwebelement(xml.getlocator("//locators/PPT/BasePrice")));
				System.out.println("Exception is"+exception);
				}
				catch(Exception e)
				{
					System.out.println("Exception is"+exception);
				}
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Scroll the Page to Top");
				javascriptexecutor(getwebelement(xml.getlocator("//locators/FeaturesTab")));
				//Coverage
				Covarge(Prodcutname);
				//Feature Availablibity
				// Return on the Site detail tab
				FeaturesAvailability(Prodcutname, Inputdata,i);
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
				
				//AdditionalProductData();
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
				/////
					NewLogoBandwidthValidation(Prodcutname);
					BuildingTypeResilency(Prodcutname);
					//Bandwidth for new Logo & existing
					//Product type with Resiliency
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
					//Coverage
					Covarge(Prodcutname);
					//Feature Availablibity
					// Return on the Site detail tab
					FeaturesAvailability(Prodcutname, Inputdata,i);
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
					exception=Gettext(getwebelement(xml.getlocator("//locators/PPT/BasePrice")));
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
				Thread.sleep(2000);
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
				Thread.sleep(2000);
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				System.out.println("Switched to Iframe");
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				System.out.println("Switched to Iframe");
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				Thread.sleep(4000);
				System.out.println("Additional Wait inserted");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type"));
				SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type")),"Existing Building Second Entry");
				SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type")),Keys.ENTER);
				
				Thread.sleep(2000);
				Clickon(getwebelement(xml.getlocator("//locators/ClickSubmitEmacNearNet")));
				Thread.sleep(2000);
				AcceptJavaScriptMethod();
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				// Select The Revalidation or Renegotation options
				Thread.sleep(2000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Revalidate"));
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Revalidate")));
				
				
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				// Select The Revalidation or Renegotation options
				Thread.sleep(2000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Renegotiate"));
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Renegotiate")));
				SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
                WaitforElementtobeclickable(xml.getlocator("//locators/Renagociate"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Renagociate")));
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
				Thread.sleep(2000);
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				System.out.println("Switched to Iframe");
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
				Thread.sleep(2000);
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
				Thread.sleep(2000);
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
				Thread.sleep(6000);
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				System.out.println("Switched to Iframe");
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				WaitforElementtobeclickable((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type"));
				SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Connection Type")),"Existing Building Second Entry");
				Thread.sleep(2000);
				Clickon(getwebelement(xml.getlocator("//locators/ClickSubmitEmacNearNet")));
				Thread.sleep(2000);
				try {
				AcceptJavaScriptMethod();
				}
				catch(Exception e)
				{
					System.out.println("No Alert");
				}
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
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
				WaitforElementtobeclickable(xml.getlocator("//locators/SelectManualRequestBEnd"));
				
				Select(getwebelement(xml.getlocator("//locators/SelectManualRequestBEnd")),"UPDATE SELECTED REQUEST");
				Getloadingcomplete(xml.getlocator("//locators/LoadingDailog"));
				
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				// Select The Revalidation or Renegotation options
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Revalidate"));
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Revalidate")));
				
				
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
				switchtofram(getwebelement("//iframe[@name='exploreEngagementComponent']"));
				// Select The Revalidation or Renegotation options
				Thread.sleep(2000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Renegotiate"));
				safeJavaScriptClick(getwebelement(xml.getlocator("//locators/Requesttype").replace("Typevalue", "Renegotiate")));
				SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),"Ashwani");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Name")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),"+911234567890");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Phone")),Keys.ENTER);
				
			    SendKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),"Ashwani.singh31@colt.net");
			    SendkeaboardKeys(getwebelement((xml.getlocator("//locators/CPQExploreWindowfields").replace("index", "1")).replace("Fieldname", "Email")),Keys.ENTER);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the On net Tab for A site");
                WaitforElementtobeclickable(xml.getlocator("//locators/Renagociate"));
			    
				Clickon(getwebelement(xml.getlocator("//locators/Renagociate")));
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
				Thread.sleep(2000);
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
			default:
			{
				break;
			}
			
			}
			
		}
	}
	
public void AddFamilyProductrule(Object[][] Inputdata, int i) throws Exception

{  	
	String Productfamility=Inputdata[i][2].toString().split(">")[0].trim();
	String ProductName=Inputdata[i][2].toString().split(">")[1].trim();
	Selectfamily(Productfamility);
	ConfigureProductrule(ProductName,Inputdata,i);
}
public void Covarge(String Product) throws IOException, InterruptedException, DocumentException
{
	//String AEndCity = null, BEndCity = null,AEndCountry = null,BEndCountry = null;
//Coverage
// Get the A End Pricing City
	AEndCity.set(GetValueofInput(getwebelement2(xml.getlocator("//locators/AEndpricingcity"))).toString());
	BEndCity.set(GetValueofInput(getwebelement2(xml.getlocator("//locators/BEndpricingcity"))).toString());
	AEndCountry.set(GetValueofInput(getwebelement2(xml.getlocator("//locators/AEndcountry"))).toString());
	BEndCountry.set(GetValueofInput(getwebelement2(xml.getlocator("//locators/BEndcountry"))).toString());
	AEndbuilding.set(GetValueofInput(getwebelement2(xml.getlocator("//locators/AEndbuildingtype"))).toString());
	BEndbuilding.set(GetValueofInput(getwebelement2(xml.getlocator("//locators/BEndbuildingtype"))).toString());
	System.out.println("Attribute 1"+AEndCity.get());
	System.out.println("Attribute 1"+BEndCity.get());
	System.out.println("Attribute 1"+AEndCountry.get());
	System.out.println("Attribute 1"+BEndCountry.get());
	System.out.println("Attribute 1"+AEndbuilding.get());
	System.out.println("Attribute 1"+BEndbuilding.get());
// Get the B End Pricing City
// Get the A End Country
// Get the B End Country
if(!Product.contains("Hub"))
	if(AEndCity.get().equals(BEndCity.get()) && AEndCountry.get().equals(BEndCountry.get()))
	{
		Assert.assertEquals(GetValueofInput(getwebelement2(xml.getlocator("//locators/Coverage"))).toString(), "Metro");
	}
	
	else if(!AEndCity.get().equals(BEndCity.get()) && AEndCountry.get().equals(BEndCountry.get()))
	{
		Assert.assertEquals(GetValueofInput(getwebelement2(xml.getlocator("//locators/Coverage"))).toString(), "National");
	}
	else
	{
		Assert.assertEquals(GetValueofInput(getwebelement2(xml.getlocator("//locators/Coverage"))).toString(), "International");
	}
else
{
	System.out.println("Coverage is not Valid for Hub");
}
}


public void BuildingTypeResilency(String Product) throws InterruptedException, DocumentException
{
	

if(!Product.contains("Hub"))
{ 
	String[] strArray1 = new String[] {"Protected","Unprotected"};
	checkOptions(strArray1, getwebelement(xml.getlocator("//locators/ServiceResilence")));
}

else
{
	String[] strArray1 = new String[] {"Protected"};
	checkOptions(strArray1, getwebelement(xml.getlocator("//locators/ServiceResilence")));
}

}

public void NewLogoBandwidthValidation(String Product) throws IOException, InterruptedException, DocumentException
{  
	System.out.println(Product);
	System.out.println((!Product.contains("Hub"))&&(!Product.contains("Wave")));
	System.out.println((!Product.contains("Hub"))&&(!Product.contains("Wave")));
	if((!Product.contains("Hub"))&&(!Product.contains("Wave"))){
	if(NewLogoflag.get().equals("Yes"))
	{
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
		Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), "60 Mbps");
		WaitforCPQloader( );
		Assert.assertTrue(isElementPresent(xml.getlocator("//locators/ValidationMessage")));
		
		Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), "1 Gbps");
		WaitforCPQloader( );
		Assert.assertFalse(isElementPresent(xml.getlocator("//locators/ValidationMessage")));
		
	}
	else
	{
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Badwidth");
		Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), "60 Mbps");
		WaitforCPQloader( );
		Assert.assertFalse(isElementPresent(xml.getlocator("//locators/ValidationMessage")));
		
		Select(getwebelement(xml.getlocator("//locators/ServiceBandwidth")), "1 Gbps");
		WaitforCPQloader( );
		Assert.assertFalse(isElementPresent(xml.getlocator("//locators/ValidationMessage")));
		
	}
	}
	
}
public void FeaturesAvailability(String Product, Object[][] Inputdata, int i) throws InterruptedException, DocumentException, IOException
{
	Clickon(getwebelement(xml.getlocator("//locators/FeaturesTab")));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Loading to be completed");
	WaitforCPQloader( );
	if(!Product.contains("Hub")||!Product.contains("Spoke"))
	{
		Features(AEndbuilding.get().toString(),Inputdata[i][12].toString(), "AEnd");
		Features(AEndbuilding.get().toString(),Inputdata[i][12].toString(), "BEnd");
	}
	else
	{
		Features(AEndbuilding.get().toString(),Inputdata[i][12].toString(), "AEnd");
	}
	ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Site Detail Tab");
	Clickon(getwebelement(xml.getlocator("//locators/SiteDetailTab")));
}
public void CheckForAllowed(String Feature,String Site) throws IOException, InterruptedException, DocumentException{
	// Check the Locator is not Disabled
	try {
		// get diabled attribute
			String Value=Getattribute(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)),"disabled");
			if(Value.equals("disabled")||Value.equals("true"))
			{
				Assert.assertTrue(false);
			}
		// if Attribute value is equals to disabled Assert Pass.
		// lse
			else
			{
				Clickon(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)));
				WaitforCPQloader( );
				Assert.assertFalse(isElementPresent(xml.getlocator("//locators/Error/"+Feature).replace("SiteEnd", Site)));
				Clickon(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)));
				WaitforCPQloader( );
			}
		// Click on the Locator
		// if Error message displayed
		// Assert Pass
		// else
		// Assert Fail
	}
	catch(Exception e) {

			Clickon(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)));
			WaitforCPQloader( );
			Assert.assertFalse(isElementPresent(xml.getlocator("//locators/Error/"+Feature).replace("SiteEnd", Site)));
			Clickon(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)));
			WaitforCPQloader( );
		}
	}

public void CheckForNotAllowed(String Feature, String Site) throws InterruptedException, DocumentException, IOException{
	try {
		// get diabled attribute
			String Value=Getattribute(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)),"disabled");
			if(Value.equals("disabled")||Value.equals("true"))
			{
				Assert.assertTrue(true);
			}
		// if Attribute value is equals to disabled Assert Pass.
		// lse
			else
			{
				Clickon(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)));
				WaitforCPQloader( );
				Assert.assertTrue(isElementPresent(xml.getlocator("//locators/Error/"+Feature).replace("SiteEnd", Site)));
				Clickon(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)));
				WaitforCPQloader( );
			}
		// Click on the Locator
		// if Error message displayed
		// Assert Pass
		// else
		// Assert Fail
	}
	catch(Exception e) {
		
			Clickon(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)));
			WaitforCPQloader( );
			Assert.assertTrue(isElementPresent(xml.getlocator("//locators/Error/"+Feature).replace("SiteEnd", Site)));
			Clickon(getwebelement(xml.getlocator("//locators/"+Feature).replace("SiteEnd", Site)));
			WaitforCPQloader( );
		
	}
}
public void Features(String buildingtype,String Connectivity, String Site) throws IOException, InterruptedException, DocumentException
{
	
	if((Connectivity.equals("Onnet")||Connectivity.equals("Nearnet")) &&buildingtype.equals("RB"))
	{
		
		if(Site.equals("AEnd"))
		{
			String[] Allowed = new String[] {"Outside_Business_Hours_Installation","Long_Lining","Internal_Cabling","Link_Aggregation","Diversity","Class_of_Service","Performance_Reporting","Pro_Active_Management","Fast_Track"};
			String[] NotAllowed = new String[] {"Dual_Entry","Demarcation_device","Carrier_Hotel_Cross Connect"};
			for(int i=0;i<=Allowed.length-1;i++)
			{
				CheckForAllowed(Allowed[i],Site);
			}
			for(int i=0;i<=NotAllowed.length-1;i++)
			{
				CheckForNotAllowed(NotAllowed[i],Site);
			}
		}
		else
		{
			String[] Allowed = new String[] {"Outside_Business_Hours_Installation","Long_Lining","Internal_Cabling","Link_Aggregation","Diversity","Class_of_Service","Performance_Reporting","Pro_Active_Management","Fast_Track"};
			String[] NotAllowed = new String[] {"Dual_Entry","Demarcation_device","Carrier_Hotel_Cross Connect"};
			for(int i=0;i<=Allowed.length-1;i++)
			{
				CheckForAllowed(Allowed[i],Site);
			}
			for(int i=0;i<=NotAllowed.length-1;i++)
			{
				CheckForNotAllowed(NotAllowed[i],Site);
			}
		}
		
	}
	else if((Connectivity.equals("Onnet")||Connectivity.equals("Nearnet")) && buildingtype.equals("Data Center"))
	{
		if(Site.equals("AEnd"))
		{
			String[] Allowed = new String[] {"Outside_Business_Hours_Installation","Long_Lining","Internal_Cabling","Link_Aggregation","Diversity","Class_of_Service","Performance_Reporting","Pro_Active_Management","Fast_Track","Carrier_Hotel_Cross Connect"};
			String[] NotAllowed = new String[] {"Dual_Entry","Demarcation_device"};
			for(int i=0;i<=Allowed.length-1;i++)
			{
				CheckForAllowed(Allowed[i],Site);
			}
			for(int i=0;i<=NotAllowed.length-1;i++)
			{
				CheckForNotAllowed(NotAllowed[i],Site);
			}
		}
		else
		{
			String[] Allowed = new String[] {"Outside_Business_Hours_Installation","Long_Lining","Internal_Cabling","Link_Aggregation","Diversity","Class_of_Service","Performance_Reporting","Pro_Active_Management","Fast_Track","Carrier_Hotel_Cross_Connect"};
			String[] NotAllowed = new String[] {"Dual_Entry","Demarcation_device"};
			for(int i=0;i<=Allowed.length-1;i++)
			{
				CheckForAllowed(Allowed[i],Site);
			}
			for(int i=0;i<=NotAllowed.length-1;i++)
			{
				CheckForNotAllowed(NotAllowed[i],Site);
			}
		}
	}
	
	if(!(Connectivity.equals("Onnet")||Connectivity.equals("Nearnet")) && buildingtype.equals("RB"))
	{
		if(Site.equals("AEnd"))
		{
			String[] NotAllowed = new String[] {"Outside_Business_Hours_Installation","Long_Lining","Internal_Cabling","Link_Aggregation","Diversity","Class_of_Service","Performance_Reporting","Pro_Active_Management","Fast_Track","Dual_Entry","Carrier_Hotel_Cross_Connect"};
			String[] Allowed = new String[] {"Demarcation_device"};
			for(int i=0;i<=Allowed.length-1;i++)
			{
				CheckForAllowed(Allowed[i],Site);
			}
			for(int i=0;i<=NotAllowed.length-1;i++)
			{
				CheckForNotAllowed(NotAllowed[i],Site);
			}
		}
		else
		{
			String[] NotAllowed = new String[] {"Outside_Business_Hours_Installation","Long_Lining","Internal_Cabling","Link_Aggregation","Diversity","Class_of_Service","Performance_Reporting","Pro_Active_Management","Fast_Track","Dual_Entry","Carrier_Hotel_Cross_Connect"};
			String[] Allowed = new String[] {"Demarcation_device"};
			for(int i=0;i<=Allowed.length-1;i++)
			{
				CheckForAllowed(Allowed[i],Site);
			}
			for(int i=0;i<=NotAllowed.length-1;i++)
			{
				CheckForNotAllowed(NotAllowed[i],Site);
			}
		}
	}
	else if(!(Connectivity.equals("Onnet")||Connectivity.equals("Nearnet")) && !buildingtype.equals("Data Center"))
	{
		if(Site.equals("AEnd"))
		{
			String[] NotAllowed = new String[] {"Outside_Business_Hours_Installation","Long_Lining","Internal_Cabling","Link_Aggregation","Diversity","Class_of_Service","Performance_Reporting","Pro_Active_Management","Fast_Track","Dual_Entry","Carrier_Hotel_Cross_Connect"};
			String[] Allowed = new String[] {"Demarcation_device"};
			for(int i=0;i<=Allowed.length-1;i++)
			{
				CheckForAllowed(Allowed[i],Site);
			}
			for(int i=0;i<=NotAllowed.length-1;i++)
			{
				CheckForNotAllowed(NotAllowed[i],Site);
			}
		}
		else
		{
			String[] NotAllowed = new String[] {"Outside_Business_Hours_Installation","Long_Lining","Internal_Cabling","Link_Aggregation","Diversity","Class_of_Service","Performance_Reporting","Pro_Active_Management","Fast_Track","Dual_Entry","Carrier_Hotel_Cross_Connect"};
			String[] Allowed = new String[] {"Demarcation_device"};
			for(int i=0;i<=Allowed.length-1;i++)
			{
				CheckForAllowed(Allowed[i],Site);
			}
			for(int i=0;i<=NotAllowed.length-1;i++)
			{
				CheckForNotAllowed(NotAllowed[i],Site);
			}
		}
	}
}
}

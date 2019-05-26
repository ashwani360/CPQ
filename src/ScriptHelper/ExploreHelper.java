package ScriptHelper;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Driver.DriverHelper;
import Driver.xmlreader;

public class ExploreHelper extends DriverHelper {

	WebElement el;
	xmlreader xml = new xmlreader("src\\Locators\\Explore.xml");
	
	public ExploreHelper(WebDriver parentdriver) {
		super(parentdriver);
		
	}
	
	public void NavigatetoExplore() throws Exception
	{
		Geturl(Getkeyvalue("Explore_URL"));
	
	}
	public void ExploreWorkflow() throws InterruptedException, Exception 
	{
		//List data=RequestID.get();
		//data=RequestID.get();
		List data=RequestID.get();
		//data=RequestID.get();
		for(int i=0;i<data.size();i++)
		{
			Object[] newdata=(Object[]) data.get(i);
			System.out.println("Size Foe Each line item"+newdata.length);
			System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
			System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
		}
		for(int i=0;i<data.size();i++)
		{
			Object[] newdata=(Object[]) data.get(i);
			for(int j=0;j<newdata.length;j++) {
				if(!newdata[j].toString().equals(""))
				{
					System.out.println("A Site for lineitem"+i+" is "+newdata[j].toString());
					WaitforElementtobeclickable(xml.getlocator("//locators/ONQTWorkQuoteLink"));
					Clickon(getwebelement(xml.getlocator("//locators/ONQTWorkQuoteLink")));
					WaitforElementtobeclickable(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString()));
					Clickon(getwebelement(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString())));
					Thread.sleep(5000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ButtonAction"));
					Clickon(getwebelement(xml.getlocator("//locators/ButtonAction")));
					WaitforElementtobeclickable(xml.getlocator("//locators/AssignRequestToMe"));
					Clickon(getwebelement(xml.getlocator("//locators/AssignRequestToMe")));
					Thread.sleep(5000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ActionButton"));
					Clickon(getwebelement(xml.getlocator("//locators/ActionButton")));
					WaitforElementtobeclickable(xml.getlocator("//locators/CreateCost"));
					Clickon(getwebelement(xml.getlocator("//locators/CreateCost")));
					Thread.sleep(5000);
					WaitforElementtobeclickable(xml.getlocator("//locators/CarrierDropdown"));
					Clickon(getwebelement(xml.getlocator("//locators/CarrierDropdown")));
					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "Colt"));
					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Colt")));
					WaitforElementtobeclickable(xml.getlocator("//locators/NodeDropdown"));
					Clickon(getwebelement(xml.getlocator("//locators/NodeDropdown")));
					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "Graz"));
					
					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Graz")));
					SendKeys(getwebelement(xml.getlocator("//locators/NRCInput")),"500");
					SendKeys(getwebelement(xml.getlocator("//locators/MRCInput")),"500");
					WaitforElementtobeclickable(xml.getlocator("//locators/TermDropdown"));
					Clickon(getwebelement(xml.getlocator("//locators/TermDropdown")));
					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "1"));
					
					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "1")));
					WaitforElementtobeclickable(xml.getlocator("//locators/CurrencyDropdown"));
					Clickon(getwebelement(xml.getlocator("//locators/CurrencyDropdown")));
					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "EUR"));
					
					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "EUR")));
					WaitforElementtobeclickable(xml.getlocator("//locators/PriceTypeDropdown"));
					Clickon(getwebelement(xml.getlocator("//locators/PriceTypeDropdown")));
					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "ACTUAL"));
					
					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "ACTUAL")));
					WaitforElementtobeclickable(xml.getlocator("//locators/ConnectorDropdown"));
					Clickon(getwebelement(xml.getlocator("//locators/ConnectorDropdown")));
					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "100BaseT"));
					
					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "100BaseT")));
					WaitforElementtobeclickable(xml.getlocator("//locators/AccessTechnologyDropdown"));
					Clickon(getwebelement(xml.getlocator("//locators/AccessTechnologyDropdown")));
					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "ETH"));
					
					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "ETH")));
					WaitforElementtobeclickable(xml.getlocator("//locators/CreateCostSubmit"));
					Clickon(getwebelement(xml.getlocator("//locators/CreateCostSubmit")));
					WaitforElementtobeclickable(xml.getlocator("//locators/TypeDropdown"));
					Clickon(getwebelement(xml.getlocator("//locators/TypeDropdown")));
					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "Port"));
					
					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Port")));
					SendKeys(getwebelement(xml.getlocator("//locators/NameInput")),"ABC");
					SendKeys(getwebelement(xml.getlocator("//locators/InputNRCAdditional")),"500");
					SendKeys(getwebelement(xml.getlocator("//locators/InputMRCAdditional")),"500");
					WaitforElementtobeclickable(xml.getlocator("//locators/ApproveQuoteButton"));
					Clickon(getwebelement(xml.getlocator("//locators/ApproveQuoteButton")));
					Thread.sleep(5000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ActionButton"));
					Clickon(getwebelement(xml.getlocator("//locators/ActionButton")));
					WaitforElementtobeclickable(xml.getlocator("//locators/ChangeStatus"));
					Clickon(getwebelement(xml.getlocator("//locators/ChangeStatus")));
					WaitforElementtobeclickable(xml.getlocator("//locators/CloseRequest"));
					Clickon(getwebelement(xml.getlocator("//locators/CloseRequest")));
					WaitforElementtobeclickable(xml.getlocator("//locators/BacktoQuote"));
					Clickon(getwebelement(xml.getlocator("//locators/BacktoQuote")));
					/*WaitforElementtobeclickable(xml.getlocator("//locators/MenuItem"));
					Clickon(getwebelement(xml.getlocator("//locators/MenuItem")));
					WaitforElementtobeclickable(xml.getlocator("//locators/Logout"));
					Clickon(getwebelement(xml.getlocator("//locators/Logout")));*/
				}
				else
				{
					System.out.println("No related Explore Request Raised");
				}
			
			}
		}
		
		
		

		
	}
	

}

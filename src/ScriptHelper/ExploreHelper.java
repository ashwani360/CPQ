package ScriptHelper;

import java.util.List;

import org.openqa.selenium.Keys;
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
	public void ExploreWorkflownearnet(Object[][] inputdata) throws InterruptedException, Exception 
	{ List data=RequestIDNearnet.get();
		for(int i=0;i<data.size();i++)
		{
			Object[] newdata=(Object[]) data.get(i);
			System.out.println("Size Foe Each line item"+newdata.length);
			System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
			System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
		}
		for(int i=0;i<data.size();i++)
		{
		switch(inputdata[i][14].toString())
		{
		case "Approve":
		{
					Object[] newdata=(Object[]) data.get(i);
					for(int j=0;j<newdata.length;j++) {
						if(!newdata[j].toString().equals(""))
						{
						System.out.println("A Site for lineitem"+i+" is "+newdata[j].toString());
						WaitforElementtobeclickable(xml.getlocator("//locators/NearNetFibrePlanningWorkQueue"));
						Clickon(getwebelement(xml.getlocator("//locators/NearNetFibrePlanningWorkQueue")));
						WaitforElementtobeclickable(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString()));
						Clickon(getwebelement(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString())));
//			            Thread.sleep(5000);
						WaitforElementtobeclickable(xml.getlocator("//locators/ButtonAction"));
						Clickon(getwebelement(xml.getlocator("//locators/ButtonAction")));
						WaitforElementtobeclickable(xml.getlocator("//locators/AssignRequestToMeNearnet"));
						Clickon(getwebelement(xml.getlocator("//locators/AssignRequestToMeNearnet")));
						Thread.sleep(5000);
						//String a =Getattribute(getwebelement("//label[text()='Request Type']/following::span"),"value");
						String a=Gettext(getwebelement("//label[text()='Request Type']/following::span"));
						System.out.println(a);
						if(a.equals("BCP Revalidation")) {
							WaitforElementtobeclickable(xml.getlocator("//locators/QuoteValiduptomonths"));
							SendKeys(getwebelement(xml.getlocator("//locators/QuoteValiduptomonths")),"5");	
						}			
						else {
							WaitforElementtobeclickable(xml.getlocator("//locators/ExploreNearNetDistance"));
							Clickon(getwebelement(xml.getlocator("//locators/ExploreNearNetDistance")));
							SendKeys(getwebelement(xml.getlocator("//locators/ExploreNearNetDistance")),"18");
							WaitforElementtobeclickable(xml.getlocator("//locators/QuoteValiduptomonths"));
							Clickon(getwebelement(xml.getlocator("//locators/QuoteValiduptomonths")));
							SendKeys(getwebelement(xml.getlocator("//locators/QuoteValiduptomonths")),"3");
							WaitforElementtobeclickable(xml.getlocator("//locators/ExploreNearNetCurrency"));
							Clickon(getwebelement(xml.getlocator("//locators/ExploreNearNetCurrency")));
							SendKeys(getwebelement(xml.getlocator("//locators/ExploreNearNetCurrency")),"EUR");
							WaitforElementtobeclickable(xml.getlocator("//locators/NearNetAddCost"));
							Clickon(getwebelement(xml.getlocator("//locators/NearNetAddCost")));
							SendKeys(getwebelement(xml.getlocator("//locators/NearNetAddCost")),"EUR");
							WaitforElementtobeclickable(xml.getlocator("//locators/NearNetAddCost"));
							Clickon(getwebelement(xml.getlocator("//locators/NearNetAddCost")));
							WaitforElementtobeclickable(xml.getlocator("//locators/NearNetCostCatogory"));
							Clickon(getwebelement(xml.getlocator("//locators/NearNetCostCatogory")));
							SendKeys(getwebelement(xml.getlocator("//locators/NearNetCostCatogory")),"Construction");
							WaitforElementtobeclickable(xml.getlocator("//locators/NearNetSubCostCatogory"));
							Clickon(getwebelement(xml.getlocator("//locators/NearNetSubCostCatogory")));
							SendKeys(getwebelement(xml.getlocator("//locators/NearNetSubCostCatogory")),"WayLeave");
							WaitforElementtobeclickable(xml.getlocator("//locators/NearNetUnitCost"));
							Clickon(getwebelement(xml.getlocator("//locators/NearNetUnitCost")));
							SendKeys(getwebelement(xml.getlocator("//locators/NearNetUnitCost")),"100");
							WaitforElementtobeclickable(xml.getlocator("//locators/NearNetCostQuantity"));
							Clickon(getwebelement(xml.getlocator("//locators/NearNetCostQuantity")));
							SendKeys(getwebelement(xml.getlocator("//locators/NearNetCostQuantity")),"1");
							WaitforElementtobeclickable(xml.getlocator("//locators/SendtoSalesNearNet"));
							Clickon(getwebelement(xml.getlocator("//locators/SendtoSalesNearNet")));
						
						}
						}
			
						else 
						{
							System.out.println("None of Data update required");
						}
					
					}
					
		
					break;
				}
			case "Dig Cost not Possible":
			{
				Object[] newdata=(Object[]) data.get(i);
				for(int j=0;j<newdata.length;j++) {
				System.out.println("A Site for lineitem"+i+" is "+newdata[j].toString());
				WaitforElementtobeclickable(xml.getlocator("//locators/NearNetFibrePlanningWorkQueue"));
				Clickon(getwebelement(xml.getlocator("//locators/NearNetFibrePlanningWorkQueue")));
				WaitforElementtobeclickable(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString()));
				Clickon(getwebelement(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString())));
//	            Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/ButtonAction"));
				Clickon(getwebelement(xml.getlocator("//locators/ButtonAction")));
				WaitforElementtobeclickable(xml.getlocator("//locators/AssignRequestToMeNearnet"));
				Clickon(getwebelement(xml.getlocator("//locators/AssignRequestToMeNearnet")));
				Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/Digcodenotpossible"));
				Clickon(getwebelement(xml.getlocator("//locators/Digcodenotpossible")));
				WaitforElementtobeclickable(xml.getlocator("//locators/SendtoSalesNearNet"));
				Clickon(getwebelement(xml.getlocator("//locators/SendtoSalesNearNet")));
				break;
				}
			}
			case "Sigle Feed":
			{
				Object[] newdata=(Object[]) data.get(i);
				for(int j=0;j<newdata.length;j++) {
				System.out.println("A Site for lineitem"+i+" is "+newdata[j].toString());
				WaitforElementtobeclickable(xml.getlocator("//locators/NearNetFibrePlanningWorkQueue"));
				Clickon(getwebelement(xml.getlocator("//locators/NearNetFibrePlanningWorkQueue")));
				WaitforElementtobeclickable(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString()));
				Clickon(getwebelement(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString())));
//	            Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/ButtonAction"));
				Clickon(getwebelement(xml.getlocator("//locators/ButtonAction")));
				WaitforElementtobeclickable(xml.getlocator("//locators/AssignRequestToMeNearnet"));
				Clickon(getwebelement(xml.getlocator("//locators/AssignRequestToMeNearnet")));
				Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/SingleFeed"));
				Clickon(getwebelement(xml.getlocator("//locators/SingleFeed")));
				WaitforElementtobeclickable(xml.getlocator("//locators/SendtoSalesNearNet"));
				Clickon(getwebelement(xml.getlocator("//locators/SendtoSalesNearNet")));
				break;
				}
			}
			case "Dual Feed":
			{
				Object[] newdata=(Object[]) data.get(i);
				for(int j=0;j<newdata.length;j++) {
				System.out.println("A Site for lineitem"+i+" is "+newdata[j].toString());
				WaitforElementtobeclickable(xml.getlocator("//locators/NearNetFibrePlanningWorkQueue"));
				Clickon(getwebelement(xml.getlocator("//locators/NearNetFibrePlanningWorkQueue")));
				WaitforElementtobeclickable(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString()));
				Clickon(getwebelement(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString())));
//	            Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/ButtonAction"));
				Clickon(getwebelement(xml.getlocator("//locators/ButtonAction")));
				WaitforElementtobeclickable(xml.getlocator("//locators/AssignRequestToMeNearnet"));
				Clickon(getwebelement(xml.getlocator("//locators/AssignRequestToMeNearnet")));
				Thread.sleep(5000);
				WaitforElementtobeclickable(xml.getlocator("//locators/DualFeed"));
				Clickon(getwebelement(xml.getlocator("//locators/DualFeed")));
				WaitforElementtobeclickable(xml.getlocator("//locators/SendtoSalesNearNet"));
				Clickon(getwebelement(xml.getlocator("//locators/SendtoSalesNearNet")));
				break;
				}
			}
			default:
			{
				break;
			}
		}
	}
				
					}

	public void ExploreWorkflow(Object[][] inputdata) throws InterruptedException, Exception 
	{ List data=RequestID.get();
	for(int i=0;i<data.size();i++)
	{
		Object[] newdata=(Object[]) data.get(i);
		System.out.println("Size Foe Each line item"+newdata.length);
		System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
		System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
	}
	for(int i=0;i<data.size();i++)
	{
	switch(inputdata[i][14].toString())
	{
		
		case "Approve":
		{	
		//List data=RequestID.get();
		//data=RequestID.get();
		
			Object[] newdata=(Object[]) data.get(i);
			for(int j=0;j<newdata.length;j++) {
				if(!newdata[j].toString().equals(""))
				{
					
					System.out.println("A Site for lineitem"+i+" is "+newdata[j].toString());
					WaitforElementtobeclickable(xml.getlocator("//locators/ONQTWorkQuoteLink"));
					Clickon(getwebelement(xml.getlocator("//locators/ONQTWorkQuoteLink")));
					WaitforElementtobeclickable(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString()));
					Clickon(getwebelement(xml.getlocator("//locators/SearchQuoteId").replace("value", newdata[j].toString())));
//		            WaitforElementtobeclickable(xml.getlocator("//locators/SearchQuoteId").replace("value", "20190527115421"));
					
//					Clickon(getwebelement(xml.getlocator("//locators/SearchQuoteId").replace("value", "20190527115421")));
//					System.out.println("workflow");
					Thread.sleep(2000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ButtonAction"));
					Clickon(getwebelement(xml.getlocator("//locators/ButtonAction")));
					WaitforElementtobeclickable(xml.getlocator("//locators/AssignRequestToMe"));
					Clickon(getwebelement(xml.getlocator("//locators/AssignRequestToMe")));
					Thread.sleep(2000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ActionButton"));
					Clickon(getwebelement(xml.getlocator("//locators/ActionButton")));
					WaitforElementtobeclickable(xml.getlocator("//locators/CreateCost"));
					Clickon(getwebelement(xml.getlocator("//locators/CreateCost")));
					Thread.sleep(2000);
					String a =Getattribute(getwebelement("//label[text()='Conversion Type']/following::td[1]/div//input"),"value");
					System.out.println(a);
				if(a.equals("Revalidation")) {
					WaitforElementtobeclickable(xml.getlocator("//locators/QuoteValidity"));
					SendKeys(getwebelement(xml.getlocator("//locators/QuoteValidity")),"45");	
				}
				else if(a.equals("Renegotiation"))
				{
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "NRC"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "NRC")),"600");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "MRC"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "MRC")),"600");	
				}
				else if(a.equals("OLO+DSL"))
				{
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier")),"Colt");	
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Node")),Keys.ARROW_DOWN);	
					Thread.sleep(3000);
					//Clickon(getwebelement(xml.getlocator("//locators/NodeDropdown")));
					Clickon(getwebelement(xml.getlocator("//locators/NodeDropdown")));
                    //SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Node")),Keys.ENTER);
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "NRC"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "NRC")),"500");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "MRC"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "MRC")),"500");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Term (Years)"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Term (Years)")),"1");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Currency"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Currency")),"EUR");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Price Type"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Price Type")),"ACTUAL");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Connector/Interface"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Connector/Interface")),"100BaseT");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Access Technology"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Access Technology")),"ETH");	
					Thread.sleep(2000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ActionButton"));
					Clickon(getwebelement(xml.getlocator("//locators/ActionButton")));
					WaitforElementtobeclickable(xml.getlocator("//locators/CreateCost"));
					Clickon(getwebelement(xml.getlocator("//locators/CreateCost")));
					Thread.sleep(2000);
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier")),"Colt");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Product Name"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Product Name")),"ULL EFM");	
						}
				else if(a.equals("DSL"))
				{
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier")),"Colt");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Product Name"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Product Name")),"ULL EFM");	
					
					
				}
				else {
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier")),"Colt");	
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Node")),Keys.ARROW_DOWN);	
					Thread.sleep(3000);
					//Clickon(getwebelement(xml.getlocator("//locators/NodeDropdown")));
					Clickon(getwebelement(xml.getlocator("//locators/NodeDropdown")));
					//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Node")),Keys.ARROW_DOWN);

                   // SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Node")),Keys.ENTER);
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "NRC"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "NRC")),"500");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "MRC"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "MRC")),"500");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Term (Years)"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Term (Years)")),"1");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Currency"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Currency")),"EUR");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Price Type"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Price Type")),"ACTUAL");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Connector/Interface"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Connector/Interface")),"100BaseT");	
					WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Access Technology"));
					SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Access Technology")),"ETH");	
					
//					//WaitforElementtobeclickable(xml.getlocator("//locators/CarrierDropdown"));
//					//Clickon(getwebelement(xml.getlocator("//locators/CarrierDropdown")));
//					//WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "Colt"));
//					//Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Colt")));
//					//WaitforElementtobeclickable(xml.getlocator("//locators/NodeDropdown"));
//					//Clickon(getwebelement(xml.getlocator("//locators/NodeDropdown")));
//					//WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "Graz"));
//					
//					//Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Graz")));
//					SendKeys(getwebelement(xml.getlocator("//locators/NRCInput")),"500");
//					SendKeys(getwebelement(xml.getlocator("//locators/MRCInput")),"500");
//					WaitforElementtobeclickable(xml.getlocator("//locators/TermDropdown"));
//					Clickon(getwebelement(xml.getlocator("//locators/TermDropdown")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "1"));
//					
//					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "1")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/CurrencyDropdown"));
//					Clickon(getwebelement(xml.getlocator("//locators/CurrencyDropdown")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "EUR"));
//					
//					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "EUR")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/PriceTypeDropdown"));
//					Clickon(getwebelement(xml.getlocator("//locators/PriceTypeDropdown")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "ACTUAL"));
//					
//					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "ACTUAL")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/ConnectorDropdown"));
//					Clickon(getwebelement(xml.getlocator("//locators/ConnectorDropdown")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "100BaseT"));
//					
//					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "100BaseT")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/AccessTechnologyDropdown"));
//					Clickon(getwebelement(xml.getlocator("//locators/AccessTechnologyDropdown")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "ETH"));
//					
//					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "ETH")));
				}
					WaitforElementtobeclickable(xml.getlocator("//locators/CreateCostSubmit"));
					Clickon(getwebelement(xml.getlocator("//locators/CreateCostSubmit")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/TypeDropdown"));
//					Clickon(getwebelement(xml.getlocator("//locators/TypeDropdown")));
//					WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "Port"));
//					
//					Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Port")));
//					SendKeys(getwebelement(xml.getlocator("//locators/NameInput")),"ABC");
//					SendKeys(getwebelement(xml.getlocator("//locators/InputNRCAdditional")),"500");
//					SendKeys(getwebelement(xml.getlocator("//locators/InputMRCAdditional")),"500");
					Thread.sleep(6000);
					WaitforElementtobeclickable(xml.getlocator("//locators/ApproveQuoteButton"));
					Clickon(getwebelement(xml.getlocator("//locators/ApproveQuoteButton")));
					Thread.sleep(6000);
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
		 
			break;
		}
		case "Reject":
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
//			            WaitforElementtobeclickable(xml.getlocator("//locators/SearchQuoteId").replace("value", "20190526084256"));
						
//						Clickon(getwebelement(xml.getlocator("//locators/SearchQuoteId").replace("value", "20190526084256")));
//						System.out.println("workflow");
						//Thread.sleep(5000);
						WaitforElementtobeclickable(xml.getlocator("//locators/ButtonAction"));
						Clickon(getwebelement(xml.getlocator("//locators/ButtonAction")));
						WaitforElementtobeclickable(xml.getlocator("//locators/AssignRequestToMe"));
						Clickon(getwebelement(xml.getlocator("//locators/AssignRequestToMe")));
						//Thread.sleep(5000);
						WaitforElementtobeclickable(xml.getlocator("//locators/ActionButton"));
						Clickon(getwebelement(xml.getlocator("//locators/ActionButton")));
						WaitforElementtobeclickable(xml.getlocator("//locators/Reject"));
						Clickon(getwebelement(xml.getlocator("//locators/Reject")));
						SendKeys(getwebelement(xml.getlocator("//locators/AddMessageTextArea")),"This ONQT Work is Rejected by Automation");
						Clickon(getwebelement(xml.getlocator("//locators/AddMessageSubmit")));
						WaitforElementtobeclickable(xml.getlocator("//locators/BacktoQuote"));
						Clickon(getwebelement(xml.getlocator("//locators/BacktoQuote")));
						//Thread.sleep(5000);
						
					
						
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
			 
			
			break;
		}
		case "Supplier No Bid":
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
//			            WaitforElementtobeclickable(xml.getlocator("//locators/SearchQuoteId").replace("value", "20190527115421"));
						
//						Clickon(getwebelement(xml.getlocator("//locators/SearchQuoteId").replace("value", "20190527115421")));
//						System.out.println("workflow");
						//Thread.sleep(5000);
						WaitforElementtobeclickable(xml.getlocator("//locators/ButtonAction"));
						Clickon(getwebelement(xml.getlocator("//locators/ButtonAction")));
						WaitforElementtobeclickable(xml.getlocator("//locators/AssignRequestToMe"));
						Clickon(getwebelement(xml.getlocator("//locators/AssignRequestToMe")));
						//Thread.sleep(5000);
						WaitforElementtobeclickable(xml.getlocator("//locators/ActionButton"));
						Clickon(getwebelement(xml.getlocator("//locators/ActionButton")));
						WaitforElementtobeclickable(xml.getlocator("//locators/CreateCost"));
						Clickon(getwebelement(xml.getlocator("//locators/CreateCost")));
						//Thread.sleep(5000);
						
						WaitforElementtobeclickable(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier"));
						SendKeys(getwebelement(xml.getlocator("//locators/Filedsname").replace("Fieldname", "Carrier")),"Colt");
//						WaitforElementtobeclickable(xml.getlocator("//locators/CarrierDropdown"));
//						Clickon(getwebelement(xml.getlocator("//locators/CarrierDropdown")));
//						WaitforElementtobeclickable(xml.getlocator("//locators/Selectvalue").replace("value", "Colt"));
//						Clickon(getwebelement(xml.getlocator("//locators/Selectvalue").replace("value", "Colt")));
						
						
						WaitforElementtobeclickable(xml.getlocator("//locators/CreateSupplierNoBidButton"));
						Clickon(getwebelement(xml.getlocator("//locators/CreateSupplierNoBidButton")));
						//Thread.sleep(5000);
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
				
				
			 
			break;
		}

		
	
		System.out.println("Completed the Process start sleeping for couple of second to data trasmited");
		Thread.sleep(50000);
		System.out.println("Ended the waite time");
		
	}
	
	}
	}
	}
}

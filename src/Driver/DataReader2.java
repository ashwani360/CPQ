package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataReader2 {
	
	@DataProvider(name="NewStandrdOrder", parallel=false)
	public static Object[][] datareader() throws IOException
	{
		 FileInputStream file = new FileInputStream(new File("src\\Data\\NewOrderStandard_Data_Mohit.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 int total_row_number=sheet.getLastRowNum();
		 System.out.println("Total Row number in sheet"+(total_row_number-2));
		 String Totallistofrownumber="";
		 for(int i=2;i<=(total_row_number);i++)
		 {
			 Totallistofrownumber=Totallistofrownumber+","+i;
		 }
		 
		 System.out.println(Totallistofrownumber);
		 int totalnumberofrowscoverd=0;
		 Object[][] listOfLists = new Object[sheet.getMergedRegions().size()][2];
		 System.out.println(sheet.getMergedRegions().size());
		 for(int i=0;i<sheet.getMergedRegions().size();i++)
		 {
			 System.out.println(sheet.getMergedRegion(i).toString());
			 if(sheet.getMergedRegion(i).toString().contains("[A") && !sheet.getMergedRegion(i).toString().contains("[A1:"))
			 {
				 int firstrow=sheet.getMergedRegion(i).getFirstRow();
				 int Lasttrow=sheet.getMergedRegion(i).getLastRow();
				 listOfLists[i][0]=firstrow;
				 listOfLists[i][1]=Lasttrow;
				 String currentresionrange="";
				 for(int ii=firstrow;ii<=Lasttrow;ii++)
				 {
					 System.out.println("Current Resion row"+ii);
					 currentresionrange=currentresionrange+","+ii;
				 }
				 System.out.println("Current Resion string"+currentresionrange);
				 Totallistofrownumber=Totallistofrownumber.replace(currentresionrange, "");
				 totalnumberofrowscoverd=totalnumberofrowscoverd+(Lasttrow-firstrow)+1;
			     System.out.println("Rows Covered  from "+firstrow+" and "+Lasttrow+"Wtth total number of Rows"+((Lasttrow-firstrow)+1));
			     System.out.println(Totallistofrownumber);
			 }
		 }
		 System.out.println("Total Rows covered in different resions"+totalnumberofrowscoverd);
		 System.out.println("Total number of rows which were not mergred"+(total_row_number-totalnumberofrowscoverd-1));
//		 for(int i=1;i<=sheet.getLastRowNum();i++)
//		 { 
//			 r=sheet.getRow(i);
//			// listOfLists[]
//		 }
		 return null;
		 
		 
	}
	
	@DataProvider(name="NewContainer", parallel=false)
	public static Object[][] datareader2() throws IOException
	{
		 FileInputStream file = new FileInputStream(new File("src\\Data\\NewOrderStandard2.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(1);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 int total_row_number=sheet.getLastRowNum();
		 System.out.println("Total Row number in sheet"+(total_row_number-2));
		 String Totallistofrownumber="";
		 for(int i=2;i<=(total_row_number);i++)
		 {
			 Totallistofrownumber=Totallistofrownumber+","+i;
		 }
		 
		 System.out.println(Totallistofrownumber);
		 int totalnumberofrowscoverd=0;
		 Object[][] listOfLists = new Object[sheet.getMergedRegions().size()][2];
		 System.out.println(sheet.getMergedRegions().size());
		 for(int i=0;i<sheet.getMergedRegions().size();i++)
		 {
			 System.out.println(sheet.getMergedRegion(i).toString());
			 if(sheet.getMergedRegion(i).toString().contains("[A") && !sheet.getMergedRegion(i).toString().contains("[A1:"))
			 {
				 int firstrow=sheet.getMergedRegion(i).getFirstRow();
				 int Lasttrow=sheet.getMergedRegion(i).getLastRow();
				 listOfLists[i][0]=firstrow;
				 listOfLists[i][1]=Lasttrow;
				 String currentresionrange="";
				 for(int ii=firstrow;ii<=Lasttrow;ii++)
				 {
					 System.out.println("Current Resion row"+ii);
					 currentresionrange=currentresionrange+","+ii;
				 }
				 System.out.println("Current Resion string"+currentresionrange);
				 Totallistofrownumber=Totallistofrownumber.replace(currentresionrange, "");
				 totalnumberofrowscoverd=totalnumberofrowscoverd+(Lasttrow-firstrow)+1;
			     System.out.println("Rows Covered  from "+firstrow+" and "+Lasttrow+"Wtth total number of Rows"+((Lasttrow-firstrow)+1));
			     System.out.println(Totallistofrownumber);
			 }
		 }
		 System.out.println("Total Rows covered in different resions"+totalnumberofrowscoverd);
		 System.out.println("Total number of rows which were not mergred"+(total_row_number-totalnumberofrowscoverd-1));
//		 for(int i=1;i<=sheet.getLastRowNum();i++)
//		 { 
//			 r=sheet.getRow(i);
//			// listOfLists[]
//		 }
		 return null;
		 
		 
	}
	
	public static void main(String []args) throws Exception {
	//DOMConfigurator.configure("log4j.xml");
	//Log.info(Integer.toString(datareader().length));
	//System.out.println(Integer.toString(datareader().length));
		//System.out.println("hi");
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
}
	
}
package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataReader {
	public static boolean isNumeric(String str) {
		  NumberFormat formatter = NumberFormat.getInstance();
		  ParsePosition pos = new ParsePosition(0);
		  formatter.parse(str, pos);
		  return str.length() == pos.getIndex();
		}
	@DataProvider(name="NewStandrdOrder", parallel=false)
	public static Object[][] datareader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\Input_data.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=1;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 //Log.info("Total Data Set for Ethernet P2P will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		 Object[][]  data=null;
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 ////Log.info("Total number of Columns" +r.getLastCellNum());
		 ////Log.info("Total number of Columns" +sheet.getLastRowNum());
		 int firstrow=0;
		 int Lasttrow=0;
		 int rownumber=0;
		 int size=0;
		 int size1=0;
		 String Needtoinclude="No";
		 for(int i=2;i<=sheet.getLastRowNum();i++)
		 { 
			 System.out.println(" Row number in "+i);
			 r=sheet.getRow(i);
			 for(int resion=0;resion<=sheet.getNumMergedRegions()-1;resion++)
			 {
				System.out.println(sheet.getMergedRegion(resion).toString());
				 String numberofrow=sheet.getMergedRegion(resion).toString().substring(sheet.getMergedRegion(resion).toString().indexOf("[")+2, sheet.getMergedRegion(resion).toString().indexOf(":"));
				 System.out.println(isNumeric(numberofrow));
				 System.out.println("Extracted strin"+numberofrow);
				 if(sheet.getMergedRegion(resion).toString().contains("[A") && isNumeric(numberofrow)&& !sheet.getMergedRegion(resion).toString().contains("[A1:") && i>=sheet.getMergedRegion(resion).getFirstRow() && i<=sheet.getMergedRegion(resion).getLastRow()&&i>Lasttrow )
				 {//System.out.println(sheet.getMergedRegion(resion).toString());
					 System.out.println("Matching Resion"+sheet.getMergedRegion(resion));
					 firstrow=sheet.getMergedRegion(resion).getFirstRow();
					 Lasttrow=sheet.getMergedRegion(resion).getLastRow();
					 size=Lasttrow-firstrow+1;
					 //firstrow=i;
					 //size1=size;
					 data=new Object[size][r1.getLastCellNum()];
					 System.out.println("First and last row"+firstrow+"-"+Lasttrow+" with iteration"+i);
					 System.out.println("First and last row"+size);
					 System.out.println("First and last row"+r1.getLastCellNum());
					 System.out.println("Rownumber Counter"+i);
					 Needtoinclude=sheet.getRow(firstrow).getCell(1).toString();
					 System.out.println("Need to include-"+sheet.getRow(firstrow).getCell(1).toString());
					 if(Needtoinclude.equals("No"))
					 {
						 firstrow=0; 
						 //Lasttrow=0;
						 size=0;
						//size1=size1+1; 
						
						 
					 }
					 else
					 {
						 size1=i; 
					 }
				 }
				 
				
			 } 
			 if(firstrow==0 && size==0 && Lasttrow==0 )
			 {
				 firstrow=i;
				 Lasttrow=i;
				 size=Lasttrow-firstrow+1;
				 size1=Lasttrow-firstrow+1;; 
				 //firstrow=i;
				 data=new Object[size][r1.getLastCellNum()];
				System.out.println("First and last row without merge"+firstrow+"-"+Lasttrow+" with iteration"+i);
				 System.out.println("First and last row  without merge"+size);
				 System.out.println("First and last row  without merge"+r1.getLastCellNum());
				 System.out.println("Rownumber Counter  without merge"+i);
				 Needtoinclude=sheet.getRow(firstrow).getCell(1).toString();
			 }
		 
			 ////Log.info(r.getLastCellNum());
		if(Needtoinclude.equals("Yes"))
		{
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   if(DateUtil.isCellDateFormatted(r.getCell(j)))
					   {
						   SimpleDateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
						   strCellValue=dt.format(r.getCell(j).getDateCellValue());
						   //Log.info("The 2Value is in data Format and Value is:"+strCellValue);
					   }
					   else{
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   //Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   }
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   //Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   //Log.info("The Value of this cell is: "+strCellValue);
				   }
			   System.out.println("Value need to be added"+strCellValue);
			   System.out.println("Current Product number"+rownumber);
			   data[rownumber][j-3] = strCellValue.trim().trim();
			   System.out.println("Value added"+data[rownumber][j-3].toString());
			    //data[i-1][j] = ;
			 
			 }
		   data[rownumber][r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[rownumber][r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //Log.info("The Value of this cell is: "+data[rownumber][r1.getLastCellNum()-2]);
		   //Log.info("The Value of this cell is: "+data[rownumber][r1.getLastCellNum()-1]);
		   rownumber=rownumber+1;
		   
		   if(rownumber<size) {
				 System.out.println("Data needs to Add still");
			 }
			else if(rownumber==size) {
				 System.out.println("It's time to save this first chunk"+rownumber);
				
				 listOfLists[rowindex][0]=data;
				 rowindex=rowindex+1;
				 firstrow=0;
				 Lasttrow=0;
				 rownumber=0;
				 size=0;
				 
			 }
		   
		 }
		   ////Log.info(data.toString());
		
		 if(size1==Lasttrow) {
		 Lasttrow=0;
		 firstrow=0;
		 Lasttrow=0;
		 rownumber=0;
		 size=0;
		 size1=0;
		 }
		 if(size==0 || size==1)
		 {
			 Lasttrow=0;
			 firstrow=0;
			 Lasttrow=0;
			 rownumber=0;
			 size=0;
			 size1=0;
			 
		 }
		 System.out.println(" out Row number in "+i);
		
		 size1=0;
			 }
			 //listOfLists[rowindex][0]=data;
			 //rowindex=rowindex+1;
		 
			 
		 workbook.close();
		 return listOfLists;
		 
	}
	@DataProvider(name="NewContainer", parallel=false)
	public static Object[][] datareader2() throws IOException
	{
		FileInputStream file = new FileInputStream(new File("src\\Data\\AutomationInputSheet_Phase 2ARegressionJetUI.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(1);
		 XSSFRow r1=sheet.getRow(0);
		 XSSFRow r;
		 int rowindex=0;
		 int totalrowrequired=0;
		 for(int k=1;k<=sheet.getLastRowNum();k++){
		 XSSFRow counter=sheet.getRow(k);
		 if(counter.getCell(1).toString().equals("Yes"))
		 {
			 totalrowrequired=totalrowrequired+1;
			
		 }
		 
		 }
		 //Log.info("Total Data Set for Ethernet P2P will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		 Object[][]  data=null;
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 ////Log.info("Total number of Columns" +r.getLastCellNum());
		 ////Log.info("Total number of Columns" +sheet.getLastRowNum());
		 int firstrow=0;
		 int Lasttrow=0;
		 int rownumber=0;
		 int size=0;
		 int size1=0;
		 String Needtoinclude="No";
		 for(int i=2;i<=sheet.getLastRowNum();i++)
		 { 
			 System.out.println(" Row number in "+i);
			 r=sheet.getRow(i);
			 for(int resion=0;resion<=sheet.getNumMergedRegions()-1;resion++)
			 {
				System.out.println(sheet.getMergedRegion(resion).toString());
				 String numberofrow=sheet.getMergedRegion(resion).toString().substring(sheet.getMergedRegion(resion).toString().indexOf("[")+2, sheet.getMergedRegion(resion).toString().indexOf(":"));
				 System.out.println(isNumeric(numberofrow));
				 System.out.println("Extracted strin"+numberofrow);
				 if(sheet.getMergedRegion(resion).toString().contains("[A") && isNumeric(numberofrow)&& !sheet.getMergedRegion(resion).toString().contains("[A1:") && i>=sheet.getMergedRegion(resion).getFirstRow() && i<=sheet.getMergedRegion(resion).getLastRow()&&i>Lasttrow )
				 {//System.out.println(sheet.getMergedRegion(resion).toString());
					 System.out.println("Matching Resion"+sheet.getMergedRegion(resion));
					 firstrow=sheet.getMergedRegion(resion).getFirstRow();
					 Lasttrow=sheet.getMergedRegion(resion).getLastRow();
					 size=Lasttrow-firstrow+1;
					 //firstrow=i;
					 //size1=size;
					 data=new Object[size][r1.getLastCellNum()];
					 System.out.println("First and last row"+firstrow+"-"+Lasttrow+" with iteration"+i);
					 System.out.println("First and last row"+size);
					 System.out.println("First and last row"+r1.getLastCellNum());
					 System.out.println("Rownumber Counter"+i);
					 Needtoinclude=sheet.getRow(firstrow).getCell(1).toString();
					 System.out.println("Need to include-"+sheet.getRow(firstrow).getCell(1).toString());
					 if(Needtoinclude.equals("No"))
					 {
						 firstrow=0; 
						 //Lasttrow=0;
						 size=0;
						//size1=size1+1; 
						
						 
					 }
					 else
					 {
						 size1=i; 
					 }
				 }
				 
				
			 } 
			 if(firstrow==0 && size==0 && Lasttrow==0 )
			 {
				 firstrow=i;
				 Lasttrow=i;
				 size=Lasttrow-firstrow+1;
				 size1=Lasttrow-firstrow+1;; 
				 //firstrow=i;
				 data=new Object[size][r1.getLastCellNum()];
				System.out.println("First and last row without merge"+firstrow+"-"+Lasttrow+" with iteration"+i);
				 System.out.println("First and last row  without merge"+size);
				 System.out.println("First and last row  without merge"+r1.getLastCellNum());
				 System.out.println("Rownumber Counter  without merge"+i);
				 Needtoinclude=sheet.getRow(firstrow).getCell(1).toString();
			 }
		 
			 ////Log.info(r.getLastCellNum());
		if(Needtoinclude.equals("Yes"))
		{
		   for(int j=3;j<=r1.getLastCellNum()-1;j++)
			 {
			   String strCellValue;
			   try {
				   if(r.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				   {
					   if(DateUtil.isCellDateFormatted(r.getCell(j)))
					   {
						   SimpleDateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
						   strCellValue=dt.format(r.getCell(j).getDateCellValue());
						   //Log.info("The 2Value is in data Format and Value is:"+strCellValue);
					   }
					   else{
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   //Log.info("The Value is in Int Format and Value is:"+strCellValue);
					   }
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   //Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   //Log.info("The Value of this cell is: "+strCellValue);
				   }
			   System.out.println("Value need to be added"+strCellValue);
			   System.out.println("Current Product number"+rownumber);
			   data[rownumber][j-3] = strCellValue.trim().trim();
			   System.out.println("Value added"+data[rownumber][j-3].toString());
			    //data[i-1][j] = ;
			 
			 }
		   data[rownumber][r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[rownumber][r1.getLastCellNum()-1]=r.getCell(1).toString();
		   //Log.info("The Value of this cell is: "+data[rownumber][r1.getLastCellNum()-2]);
		   //Log.info("The Value of this cell is: "+data[rownumber][r1.getLastCellNum()-1]);
		   rownumber=rownumber+1;
		   
		   if(rownumber<size) {
				 System.out.println("Data needs to Add still");
			 }
			else if(rownumber==size) {
				 System.out.println("It's time to save this first chunk"+rownumber);
				
				 listOfLists[rowindex][0]=data;
				 rowindex=rowindex+1;
				 firstrow=0;
				 Lasttrow=0;
				 rownumber=0;
				 size=0;
				 
			 }
		   
		 }
		   ////Log.info(data.toString());
		
		 if(size1==Lasttrow) {
		 Lasttrow=0;
		 firstrow=0;
		 Lasttrow=0;
		 rownumber=0;
		 size=0;
		 size1=0;
		 }
		 if(size==0 || size==1)
		 {
			 Lasttrow=0;
			 firstrow=0;
			 Lasttrow=0;
			 rownumber=0;
			 size=0;
			 size1=0;
			 
		 }
		 System.out.println(" out Row number in "+i);
		
		 size1=0;
			 }
			 //listOfLists[rowindex][0]=data;
			 //rowindex=rowindex+1;
		 
			 
		 workbook.close();
		 return listOfLists;
		 
	}
		 
//	}
	
	public static void main(String []args) throws Exception {
//	DOMConfigurator.configure("log4j.xml");
//	//Log.info(Integer.toString(datareader().length));
       	System.out.println(datareader().toString());
 Object[][] finaldata=datareader();
 System.out.println("Number of Quote"+finaldata.length);
 for(int i=0;i<=finaldata.length-1;i++)
 {
	 Object[] data2= (Object[]) finaldata[i][0];
	 System.out.println("number of product in Quote:" +i+"***"+data2.length);
	 for(int j=0;j<=data2.length-1;j++) {
//Object[] data3=(Object[]) data2[0];
		 Object[] data4=(Object[]) data2[j];
// System.out.println("Length of data"+data3.length);
// System.out.println("Number of congiguration Attribute for Fist Product"+data3.length);
// System.out.println("Number of congiguration Attribute for Second Product"+data4.length);
// System.out.println("Product name for First Product"+data3[2].toString());
		 System.out.println("Product name for Second Product"+data4[2].toString());	
}
 }
	}
}
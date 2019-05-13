package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataReader {
	
	@DataProvider(name="NewStandrdOrder", parallel=true)
	public static Object[][] datareader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("src\\Data\\NewOrderStandard.xlsx"));
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
		 Log.info("Total Data Set for Ethernet P2P will be"+totalrowrequired);
		 System.out.println("Total Data Set for Ethernet P2P will be"+totalrowrequired);
		 Object[][] listOfLists = new Object[totalrowrequired][1];
		//Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 //Log.info("Total number of Columns" +r.getLastCellNum());
		 //Log.info("Total number of Columns" +sheet.getLastRowNum());
		 for(int i=1;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 Object[]  data=new Object[r1.getLastCellNum()];
			 //Log.info(r.getLastCellNum());
		if(r.getCell(1).toString().equals("Yes")){
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
						   Log.info("The 2Value is in data Format and Value is:"+strCellValue);
						   System.out.println("The 2Value is in data Format and Value is:"+strCellValue);
					   }
					   else{
					   int value=(int)r.getCell(j).getNumericCellValue();
					   strCellValue=String.valueOf(value);
					   Log.info("The Value is in Int Format and Value is:"+strCellValue);
					  System.out.println("The Value is in Int Format and Value is:"+strCellValue);
					   }
				   }
				   
				   else {
					   strCellValue=r.getCell(j).toString();
					   Log.info("The Value of this cell is in String Format and Value is : "+strCellValue);
					   System.out.println("The Value is in Int Format and Value is:"+strCellValue);
				   }
				   }
				   catch(java.lang.NullPointerException e)
				   {
					   strCellValue="";
					   Log.info("The Value of this cell is: "+strCellValue);
					   System.out.println("The Value of this cell is: "+strCellValue);
				   }
			   data[j-3] = strCellValue.trim().trim();
			  
			    //data[i-1][j] = ;
			 
			 }
		   data[r1.getLastCellNum()-2]=r.getCell(0).toString();
		   data[r1.getLastCellNum()-1]=r.getCell(1).toString();
		   Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		   System.out.println("The Value of this cell is: "+data[r1.getLastCellNum()-2]);
		   Log.info("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		  System.out.println("The Value of this cell is: "+data[r1.getLastCellNum()-1]);
		   listOfLists[rowindex][0]=data;
		   rowindex=rowindex+1;
		 }
		 //Log.info(data.toString());
		 workbook.close();
		 }
		 
		 return listOfLists;
		 
	}
	
	
	public static void main(String []args) throws Exception {
	//DOMConfigurator.configure("log4j.xml");
	Log.info(Integer.toString(datareader().length));
	System.out.println(Integer.toString(datareader().length));
	
}
}
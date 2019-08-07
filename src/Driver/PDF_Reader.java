package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDF_Reader {

	static PDFTextStripper pdfStripper = null;
	static PDDocument pdDoc = null;
	static COSDocument cosDoc = null;
	static String parsedText = null;
	public static void Pdfreader() throws FileNotFoundException, IOException
	{
		File file = new File("src\\Data\\Downloads\\QT-20180312-014836-01.pdf");
		PDFParser parser = new PDFParser(new FileInputStream(file));
		parser.parse();
		cosDoc = parser.getDocument();
		pdfStripper = new PDFTextStripper();
		//System.out.println(pdfStripper..length());
		//pdfStripper.setStartPage(1);
		
		//pdfStripper.setEndPage(3);
		
		pdDoc = new PDDocument(cosDoc);
		parsedText = pdfStripper.getText(pdDoc);
	System.out.println("Test content" +parsedText);
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException
	{
		Pdfreader();
	}
}

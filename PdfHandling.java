package Opentesting.SeleniumPractice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PdfHandling {

	
	WebDriver driver;
	
	@Test
	public void verifyContentofpdf() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		File f=new File(System.getProperty("user.dir")+"//Resources//pdffile.pdf");
		driver.get(f.toURI().toURL().toString());
		String curUrl=driver.getCurrentUrl();
		System.out.println(curUrl);
		InputStream is=f.toURI().toURL().openStream();
		BufferedInputStream fileParse=new BufferedInputStream(is);
		PDDocument doc=null;
		doc=PDDocument.load(fileParse);
		String pdfcontent=new PDFTextStripper().getText(doc);
		//System.out.println(pdfcontent);
		System.out.println(new PDFTextStripper().getEndPage());
		
		
		
		
		/*InputStream is=f.toURI().toURL().openStream();
		System.out.println(f);
		BufferedInputStream fileParse=new BufferedInputStream(is);
		PDDocument doc=null;
		doc=PDDocument.load(fileParse);
		int pdfcontent=new PDFTextStripper().getEndPage();
		System.out.println(pdfcontent);*/
		
		
		
	}
	
	
	
}

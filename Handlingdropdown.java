package Opentesting.SeleniumPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlingdropdown {


	public static WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://www.guru99.com/test/newtours/register.php");

	}


	@Test

	public void test1()
	{

		//driver.findElement(By.xpath("//select[@name='country']"));
		//chooseCountries("A");
		System.out.println(chooseCountries("I"));


	}


	@AfterMethod
	public void tearDown()
	{
		driver.quit();

	}


	public List<String>chooseCountries(String alphabet)
	{
		//using Java8 stream concept.
		Select oSel=new Select(driver.findElement(By.xpath("//select[@name='country']")));
		List<String>filteredCountries=oSel.getOptions().stream()
				.map(el->el.getText())
				.filter(el->el.startsWith(alphabet))
				.collect(Collectors.toList());



		return filteredCountries;

	}



//	public List<String>chooseCountries(Object alphabet)
//	{
//
//		//using traditional method..
//		List<String>filteredCountries=new ArrayList<>();
//		Select oSel=new Select(driver.findElement(By.xpath("//select[@name='country']")));
//		for(WebElement el:oSel.getOptions())
//		{
//			if(el.getText().startsWith((String)alphabet))
//			{
//				filteredCountries.add(el.getText());
//			}
//		}
//
//
//
//		return filteredCountries;
//	}


}

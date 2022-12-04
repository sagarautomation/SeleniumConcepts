package Opentesting.SeleniumPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class WorldometerTest {

	public static WebDriver driver=null;
	String population="//div[@class='maincounter-number']//span[@class='rts-counter']";
	String today_thisyear="//div[text()='This year'  or text()='Today']//following-sibling::div//span[@class='rts-counter']";

	@Test(enabled=false)
	public void test1() {



		String arg="//div[@class='maincounter-number']//span[@class='rts-nr-int rts-nr-10e";
		LocalDateTime then = LocalDateTime.now();
		getCurrentworldpopulation(arg, 9);


	}

	@Test
	public void test2() throws InterruptedException
	{
		//			while(true)
		//			{
		//			String currentpopulationcount=driver.findElement(By.xpath("//div[@class='maincounter-number']//span[@class='rts-counter']")).getText();
		//			System.out.println(currentpopulationcount);
		//			}


		getPopulationdata(today_thisyear);


	}


	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\SeleniumPractice\\src\\test\\java\\TestResource\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().window().maximize();


	}

	@AfterClass
	public void afterClass() {


	}




	public void getPopulationdata(String locator) throws InterruptedException
	{
		int count=1;
		while(count<=20)
		{
			System.out.println("Today and This year data after"+count+"seconds");
			List<WebElement>elements=driver.findElements(By.xpath(locator));
			for(WebElement eachelement:elements)
			{
				System.out.println(eachelement.getText());
			}

			Thread.sleep(1000);
			count++;
		}


	}



	public void getCurrentworldpopulation(String arg,int index)
	{
		String currentworldpopulation="";
		while(index>=0)
		{

			try
			{
				currentworldpopulation=currentworldpopulation+driver.findElement(By.xpath(arg+String.valueOf(index)+"']")).getText();
				index=index-3;
			}

			catch(StaleElementReferenceException e)
			{
				currentworldpopulation=currentworldpopulation+driver.findElement(By.xpath(arg+String.valueOf(index)+"']")).getText(); 
			}
		}

		System.out.println("Current world population is"+currentworldpopulation);

	}




}

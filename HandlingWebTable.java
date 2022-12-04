package Opentesting.SeleniumPractice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebTable {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}


	@Test
	public void test()
	{
		//scroll down until the table

		//table[@id='main_table_countries_today']

		List<LinkedHashMap>tableData=new ArrayList<>();

		WebElement table=driver.findElement(By.xpath("//table[@id='main_table_countries_today']"));
		int rowCount=table.findElements(By.xpath("//table[@id='main_table_countries_today']//tr")).size();
		System.out.println("Row count is"+rowCount);
		int colCount=driver.findElements(By.xpath("//table[@id='main_table_countries_today']//th")).size();
		System.out.println("Col count is"+colCount);
		List<WebElement>headers=driver.findElements(By.xpath("//table[@id='main_table_countries_today']//th"));

		for(int i=0;i<rowCount-1;i++)
		{
			LinkedHashMap<String, String>iterationsData=new LinkedHashMap<>();
			String key=headers.get(i).getText();
			System.out.println(key);

		}

		//driver.findElements(By.xpath("//table[@id='main_table_countries_today']//th")).stream().forEach(el->System.out.println(el.getText()));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js. executeScript("arguments[0]. scrollIntoView(true);", element);

	}


	@AfterMethod
	public void tearDown()
	{


	}






}

package Opentesting.SeleniumPractice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Crossbrowser {

	ThreadLocal<WebDriver>dr=new ThreadLocal<>();

	public WebDriver get()
	{
		return dr.get();
	}


	public  void set(WebDriver driverref)
	{
		dr.set(driverref);
	}

	//public WebDriver driver=null;


	@BeforeMethod
	public void setUp(Object[]data)
	{
		//System.out.println(data[1]); //ArrayIndexOutOfBoundException

		LinkedHashMap<String, String>map=(LinkedHashMap<String, String>) data[0];
		if(map.get("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/TestResource/Drivers/chromedriver.exe");
			dr.set(new ChromeDriver());
			dr.get().get("https://google.com");

		}
		else if(map.get("browser").equals("edge"))
		{

			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/test/java/TestResource/Drivers/msedgedriver.exe");
			dr.set(new EdgeDriver());
			dr.get().get("https://google.com");


		}
		else
		{
			System.out.println("invalid browser");
		}

	}


	@Test(dataProvider = "getData")
	public void test1(LinkedHashMap<String, String>iterationsdata)
	{

		System.out.println("----------->Test1 running----------->"+"in"+ iterationsdata.get("browser"));
		System.out.println("sending"+"   "+iterationsdata.get("username")+"   in username field");

	}


	@DataProvider(parallel=true)
	public Object[]getData()
	{
		ArrayList<LinkedHashMap<String, String>>data=new ArrayList<>();
		LinkedHashMap<String, String>firstiteration=new LinkedHashMap<>();
		firstiteration.put("username", "sagar");
		firstiteration.put("browser", "chrome");


		LinkedHashMap<String, String>seconditeration=new LinkedHashMap<>();
		seconditeration.put("username", "tom");
		seconditeration.put("browser", "edge");

		data.add(firstiteration);
		data.add(seconditeration);

		return data.toArray();  //[{},{},{}]  --->return Object array that has map

	}

	@AfterMethod
	public void quit()
	{
		if(Objects.nonNull(dr.get())) {
			System.out.println("Value of non null driver is"+ dr.get());
			dr.get().quit();
		}
		else
		{
			System.out.println("value of driver is"+ dr.get());

		}

	}

}

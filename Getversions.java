package Opentesting.SeleniumPractice;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Getversions {


	public static WebDriver driver=null;


	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://docs.microsoft.com/en-us/deployedge/microsoft-edge-relnote-stable-channel");
		driver.manage().window().maximize();
	}

	@Test
	public void getVersions()
	{
		//List<String>versions=driver.findElements(By.xpath("//h2[starts-with(@id,'version')]")).stream().
		//map(el->el.getText().replaceAll("[^\\d\\d\\.\\d\\.\\d+\\.\\d+]", "").replaceAll("\\d\\d$", ""))
		//.collect(Collectors.toList());



		List<String>versions=driver.findElements(By.xpath("//h2[starts-with(@id,'version')]")).stream()
		.map(el->el.getText()).map(Getversions::getVersion).collect(Collectors.toList());


		System.out.println(versions);
	}


	public  static String getVersion(String v)
	{
		//Version 91.0.864.59: June 24
		String version=null;
		String regex="(\\d+).(\\d+).(\\d+).(\\d+)";

		Pattern pattern = Pattern.compile(regex);
		Matcher m=pattern.matcher(v);
		while(m.find())
		{
			version=m.group();
		}

		return version;

	}

}

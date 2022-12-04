package Opentesting.SeleniumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Seleniumgrid {
	
	
	static WebDriver driver;
	 static String nodeUrl;

	public static void main(String[] args) throws MalformedURLException {
		
		
//		DesiredCapabilities cap=new DesiredCapabilities();
//		cap.setBrowserName("chrome");
//		cap.setPlatform(Platform.WIN10);
//		ChromeOptions opt=new ChromeOptions();
//		opt.merge(cap);
//		String hubUrl="http://192.168.1.67:4444/wd/hub";
//		WebDriver driver=new RemoteWebDriver(new URL(hubUrl),opt);
//		driver.get("http://www.google.com");
//		System.out.println(driver.getTitle());
		nodeUrl = "http://192.168.1.67:26847/wd/hub";
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		driver = new RemoteWebDriver(new URL(nodeUrl), cap);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());


	}

}

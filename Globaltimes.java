package Opentesting.SeleniumPractice;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Globaltimes {

	public static WebDriver driver=null;


	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\SeleniumPractice\\src\\test\\java\\TestResource\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.globaltimes.cn/");
		driver.manage().window().maximize();
	}



	@Test
	public void f() throws InterruptedException, AWTException, MalformedURLException {


		List<WebElement>links=driver.findElements(By.xpath("//div[@id='main_section01']//a"));
		System.out.println("original size is"+links.size());
		Set<String>uniquelink=new HashSet<>();

		for(int i=0;i<=links.size()-1;i++)
		{
			String linkUrl=links.get(i).getAttribute("href");

			System.out.println(linkUrl);
			uniquelink.add(linkUrl);
		}

		System.out.println("unique list size is"+uniquelink.size());
		


		for(String link:uniquelink)
		{
			try 
			{
			driver.switchTo().newWindow(WindowType.TAB);
			driver.navigate().to(link);
			WebElement paragraph=driver.findElement(By.xpath("//div[@class='article_right']"));// /child::br
			System.out.println("Paragraph is"+paragraph.getText());
			//to perform Scroll on application using Selenium
			
			
			}
			
			catch(UnhandledAlertException e)
			{
				Alert a=driver.switchTo().alert();
				//System.out.println(a.getText());
				a.accept();
			}
			
			catch(UnreachableBrowserException e)
			{
				/*Indicates there was a problem communicating with the browser beingcontrolled or the Selenium server.
				The most common causes for this exception are: • 
				The provided server address to RemoteWebDriver is invalid, so theconnection could not be established. 
				The browser has died mid-test.*/
				//System.out.println("Link to navigate is"+link);
			}
			
			catch(NoSuchElementException e)
			{
				
			}

		}



	}

	public String getwindowHandle()
	{
		String mainhandle=driver.getWindowHandle();
		return mainhandle;
	}




	@AfterMethod
	public void afterMethod() {
	}

}

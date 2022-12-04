package Opentesting.SeleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadvideofromPlaylist {



	public static WebDriver driver;
	ArrayList<String>links=new ArrayList<>();
	ArrayList<String>subtitles=new ArrayList<>();

	@BeforeMethod
	public void beforeMethod() {


		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

	}


	@Test(priority=1)
	@Parameters({"url1"}) 
	public void scrapPlaylistlink(String url) throws InterruptedException {

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement searchfield=driver.findElement(By.xpath("//input[@id='search']"));
		searchfield.sendKeys("Retarget Common");
		Thread.sleep(2000);
		searchfield.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement channelname=driver.findElement(By.xpath("//ytd-channel-name[@id='channel-title']"));
		channelname.click();
		WebElement playlistname=driver.findElement(By.xpath("//div[@id='tabsContent']//descendant::div[4]"));
		playlistname.click();
		WebElement playlisttitle=driver.findElement(By.xpath("//*[text()='Rest Assured E2E - English']"));
		playlisttitle.click();
		List<WebElement>elements=driver.findElements(By.xpath("//ytd-playlist-panel-renderer[@id='playlist' and @class='style-scope ytd-watch-flexy']//a[@id='wc-endpoint']"));
		for(WebElement el:elements)
		{
			Thread.sleep(1000);
			links.add(el.getAttribute("href"));
			subtitles.add(el.getText().replaceAll("[^A-Z a-z]", ""));
		}
	}


	@Test(priority=2)
	@Parameters({"url2"}) 
	public void downloadVideos(String url) {

		
		System.out.println(links.size());
		System.out.println(subtitles.size());
		System.out.println(subtitles);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement search=driver.findElement(By.xpath("//input[@name='sf_url']"));
		WebElement button=driver.findElement(By.xpath("//button[@name='sf_submit']"));

		for(String link:links)
		{
			search.sendKeys(link);
			button.click();
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='result-box video']")));;
			WebElement download=driver.findElement(By.xpath("//a[text()='Download']"));
			download.click();

		}
	}



	@AfterMethod
	public void afterMethod() {


		driver.quit();


	}




}



package Opentesting.SeleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Youtube {

	public static void main(String[] args) throws InterruptedException {
		
		
		ArrayList<String>al=new ArrayList<>();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement searchfield=driver.findElement(By.xpath("//input[@id='search']"));

		searchfield.sendKeys("Retarget Common");
		searchfield.sendKeys(Keys.ENTER);
		
		WebElement channelname=driver.findElement(By.xpath("//ytd-channel-name[@id='channel-title']"));
		channelname.click();
		
		WebElement playlistname=driver.findElement(By.xpath("//div[@id='tabsContent']//descendant::div[4]"));
		playlistname.click();
		
		WebElement playlisttitle=driver.findElement(By.xpath("//*[text()='Rest Assured E2E - English']"));
		playlisttitle.click();
		
//		driver.findElements(By.xpath("//ytd-playlist-panel-renderer[@id='playlist' and @class='style-scope ytd-watch-flexy']//a[@id='wc-endpoint']"))
//		.forEach(el->System.out.println(el.getAttribute("href")));
		
		List<WebElement>elements=driver.findElements(By.xpath("//ytd-playlist-panel-renderer[@id='playlist' and @class='style-scope ytd-watch-flexy']//a[@id='wc-endpoint']"));
		//(^\W\d*:\d*)?(\d{1})
		for(WebElement el:elements)
		{
			//System.out.println(el.getAttribute("href"));
			
			System.out.println(el.toString());
			
			if(el.getText().isBlank()||el.getText().isEmpty())
			{
				System.out.println("error");
			}
			System.out.println(el.getText());
		}
		
		
		
		
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://en.savefrom.net/1-youtube-video-downloader-5/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		//input[@name='sf_url']
//		//button[@name='sf_submit']
//		WebElement search=driver.findElement(By.xpath("//input[@name='sf_url']"));
//		
//		search.sendKeys("https://www.youtube.com/watch?v=0i_JoGD-z4Y&list=PL-a9eJ2NZlbT0Hoo_Hj43utwgq2VusPyN&index=1");
//		WebElement button=driver.findElement(By.xpath("//button[@name='sf_submit']"));
//		button.click();
//		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='result-box video']")));;
//		System.out.println("successfully clicked");
//		
//		WebElement download=driver.findElement(By.xpath("//a[text()='Download']"));
//		download.click();
		
		//verify download
		//go to default download location
		//
		
		
		
		
		
		
		
		
		
		

	}

}

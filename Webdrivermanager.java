package Opentesting.SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdrivermanager {

	public static void main(String[] args) {
		
		
		
		//First it will try to find the OS and also browser versions and based on that it will pull the chrome driver from
		//the Github Repo.It maintain the internal path where it has to go and download the X driver
		
		WebDriverManager.chromedriver().setup();
		//if organization uses proxy then
		//WebDriverManager.chromedriver().proxy("https://username:password@mycompanyproxy.com:port").setup();
		WebDriver driver=new ChromeDriver();
		
		//first time when it runs there will be some delay but from next time onwards it used cache.
		//The cache location is "C:/USERS/USERNAME/.CACHE/SELENIUM/resolution.properties"
		//TTL(tIME TO LEAVE) is one of the key in the resolution.properties file with default value as 3600 seconds(1hr)
		//it means when we run program multiple time then until this time elapsed it will not check other browser version.Post expiration of this time 
		//only it will check other versions.
		//If let say in this time the chrome version is updated then code will not work for 1 hour.
		//But this can be overcome by clearing cache using clearResolutioncache()

	}

}

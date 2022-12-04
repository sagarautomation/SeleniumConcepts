package Opentesting.SeleniumPractice;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockingGeoLocation {

	public static void main(String[] args) {
		
		ChromeDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
        devTools.createSession();
        
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(23.650141),
                Optional.of(-73.514427),
                Optional.of(100)));
        driver.get("https://mycurrentlocation.net/");

	}

}

package Opentesting.SeleniumPractice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetDeviceMode {

	public static void main(String[] args) {
		
		ChromeDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
        devTools.createSession();
        
        Map deviceMetrics = new HashMap()
        {{
            put("width", 600);
            put("height", 1000);
            put("mobile", true);
            put("deviceScaleFactor", 50);
        }};
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        driver.get("https://www.google.com");
        

	}

}

package Opentesting.SeleniumPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.log.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureConsoleLogs {

	public static void main(String[] args) {
		
		ChromeDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(),
                logentry -> {
                    System.out.println("log: "+logentry.getText());
                    System.out.println("level: "+logentry.getLevel());
                });
        driver.get("https://testersplayground.herokuapp.com/console-5d63b2b2-3822-4a01-8197-acd8aa7e1343.php");
    }
	

}

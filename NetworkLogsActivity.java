package Opentesting.SeleniumPractice;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.Request;
import org.openqa.selenium.devtools.network.model.Response;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkLogsActivity {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devTool=driver.getDevTools();
		devTool.createSession();
		
		//we enable the Network so that chrome devtool can pull the traffic and give it to client(selenium)
		devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//we can capture all the stuffs that goes with our request
		
		/*devTool.addListener(Network.requestWillBeSent(), request ->{
			Request req=request.getRequest();
			System.out.println(req.getUrl());
			System.out.println(req.getHeaders());
		});*/
		
		
		//After sending event will be fired when we get response back.
		devTool.addListener(Network.responseReceived(),response ->{
			Response res=response.getResponse();
			System.out.println(res.getUrl());
			System.out.println(res.getStatus());
			System.out.println(res.getHeaders());
			if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl()+"is failing");
			}

		});
		
		driver.get("https://sputniknews.com/");



	}

}

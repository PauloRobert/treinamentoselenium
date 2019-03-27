package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class web {
	public static WebDriver createChrome(){
		
		System.setProperty("webdriver.chrome.driver", "C:/eclipse/Selenium/chromedriver.exe");
		
	  	WebDriver driver = new ChromeDriver();	  	
	  	driver.manage().window().maximize();
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	
	  	driver.get("http://www.juliodelima.com.br/taskit/");
		return driver;
	  	
	}

}
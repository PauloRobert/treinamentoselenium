package suporte;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class screenshoot {
	public static void tirar(WebDriver driver, String arquivo) {
		File screnshoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	}
}

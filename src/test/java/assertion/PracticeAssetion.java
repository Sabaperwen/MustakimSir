package assertion;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeAssetion {
@Test
	public void launchInstagram()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		String expectedTitle="Instagram";
		String actualTitle=driver.getTitle();
		assertNotSame(actualTitle, expectedTitle, "Values are  matching");
		driver.quit();
	}
}

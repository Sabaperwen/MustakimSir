package assertion;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeSoftAssert {

	@Test	
	public void testFacebook() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		//URL assertion
		String expectedUrl="https://www.facebook.com/";
		String actualUrl=driver.getCurrentUrl();
		SoftAssert assertions=new SoftAssert();
		assertions.assertEquals(actualUrl, expectedUrl, "url is mismatched");

		//Title assertion

		String expectedTitle="Facebook";
		String actualTitle=driver.getTitle();
		assertions.assertEquals(actualTitle, expectedTitle, "Title is mismatched");

		//Test the Text which is present in email textfieled

		String expectedText="";
		String actualText=driver.findElement(By.id("email")).getAttribute("value");
		assertions.assertEquals(actualText, expectedText, "text is mismatched");

		//border assertion
		String expectedBorder="1px solid rgb(27, 116, 228);";
		String actualBorder=driver.findElement(By.id("email")).getCssValue("border");
		assertions.assertEquals(actualBorder , expectedBorder, "border is mismatched");
Thread.sleep(2000);
//		//error msg Assertion
//		String expectedMsg="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
//		String actualMsg=driver.findElement(By.xpath("//div[@id='email_container']/div[last()]")).getText();
//		assertions.assertEquals(actualMsg, expectedMsg,"Error msg is not matching");
//		 
		driver.quit();
		assertions.assertAll();


	}
}

package generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseClassICGMS implements InitiateNewProcess_details
{
	
		public WebDriver driver ;
		public WebDriverWait wait;
		

		@BeforeMethod
		public void setup()
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
		
		public void get_screenshot() throws InterruptedException
		{
			
			TakesScreenshot t = (TakesScreenshot)driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			Thread.sleep(1000);
			
			String fileName = "screenshot_"+ current_date+"_" +current_time+ ".png";
			File dest = new File("./TestScreenshot/"+fileName);
			
			try {
				Files.copy(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void ToasterPopupClick() throws InterruptedException
			//Toaster Popup Click
			{
		        WebElement toaster = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@style='opacity: 1;']")));
		        toaster.click();
		        Thread.sleep(500);
			}
		
		
		@AfterMethod
		public void Logout() throws InterruptedException
		{
			//Logout
			WebElement Profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-toggle='dropdown']")));
			Profile.click();
			WebElement Logout = driver.findElement(By.xpath("//a[@style='cursor: pointer;']"));
			Logout.click();
		
			// Toaster Popup Click
			ToasterPopupClick();
			
			
			//Email API
			driver.get("https://release-api.icgms.sharajman.com/emailer");
			Thread.sleep(2500);
			
			//Close Browser
			if (driver != null) 
			{
				driver.quit();
			}
		}	
		
}	
package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class login_ICGMS extends BaseClassICGMS
{

	public login_ICGMS(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void login (String Admin , String Pass)
	{
//		System.out.println("Admin: " + Admin);
//	    System.out.println("Pass: " + Pass);
		
		driver.findElement(By.cssSelector("input[formcontrolname='email']")).sendKeys(Admin);
		driver.findElement(By.cssSelector("input[aria-label='Password']")).sendKeys(Pass);		
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		Reporter.log("Login Successfull");
	}
	//Select Role
//	WebElement role = driver.findElement(By.name("role"));
//
//
//	Select s1 = new Select(role);
//	s1.selectByContainsVisibleText("CUSTOMER");
//	Thread.sleep(200);
//	WebElement roleSubmit = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
//	roleSubmit.click();
	
}

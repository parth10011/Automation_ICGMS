package PreInspection;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.BaseClassICGMS;
import generic.DBFunction;
import generic.login_ICGMS;

public class _01_PreInspection_InitiateNewProcess extends BaseClassICGMS 
{
	
	@Test
	public void InitiateNewProcess() throws InterruptedException, AWTException, EncryptedDocumentException, IOException 
	{
		// Login
		String Custemail = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Login, 1, 0);
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		Thread.sleep(500);

		// Toaster Popup Click
		ToasterPopupClick();

		// Initiate Claim
		driver.findElement(By.xpath("//a[@href='/claim']")).click();

		// Select Product
		WebElement Product = driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[1]/div/app-claim-intimation/div[1]/div/div/div[2]/div/div/select"));

		Select s2 = new Select(Product);
		s2.selectByValue("20");
		Thread.sleep(200);

		// Select Insurer
		WebElement Insurer = driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[1]/div/app-claim-intimation/div[1]/div/div/div[3]/div/div/select"));

		Select s3 = new Select(Insurer);
		s3.selectByValue(type_car);

		// Fill the required details
		driver.findElement(By.cssSelector("input[formcontrolname='customer_email']")).sendKeys(Custemail);
		driver.findElement(By.cssSelector("input[formcontrolname='customer_mobile_no']")).sendKeys(randomMobileNumber);
		driver.findElement(By.xpath("//input[@placeholder='Enter Customer Name']")).sendKeys(randomCustName);
		driver.findElement(By.xpath("//input[@placeholder='Enter Vehicle Number']")).sendKeys(randomCarRegistration);
		driver.findElement(By.xpath("//input[@placeholder='Enter State']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//input[@placeholder='Enter year of mfg']")).sendKeys(randomYear);
		driver.findElement(By.xpath("//input[@placeholder='Enter Fuel Type']")).sendKeys("Petrol");
		driver.findElement(By.xpath("//input[@placeholder='Enter Make']")).sendKeys("Mitsubishi");
		driver.findElement(By.xpath("//input[@placeholder='Enter Model']")).sendKeys("Omni");
		driver.findElement(By.xpath("//input[@placeholder='Enter Rreference number']")).sendKeys("PA07CBNV33");
		driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys("Rohini");
		driver.findElement(By.xpath("//input[@placeholder='Enter Branch Name']")).sendKeys("parliament Rd");

		// Toaster Popup Click
		ToasterPopupClick();
		
		// Scroll to end of page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(500);

		// Submit Details
		WebElement Submit = driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[1]/div/app-claim-intimation/div[2]/form/div[2]/button[1]"));
		Submit.click();
		Thread.sleep(500);
		System.out.println("Initation Of Claim Details Filled Successfully");

		// Toaster Popup Click
		ToasterPopupClick();

		// View List
		driver.findElement(By.xpath("//a[@href='/claim-details']")).click();
		Thread.sleep(500);

	}

}
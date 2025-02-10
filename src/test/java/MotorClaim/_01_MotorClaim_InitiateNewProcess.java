package MotorClaim;

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


public class _01_MotorClaim_InitiateNewProcess extends BaseClassICGMS
{
	
	@Test
	public void MotorClaim_InitiateNewProcess() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		String Custemail = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Login, 1, 0);
		//Login
//		Reporter.log("Random Car Number : " + randomCarRegistration);
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		// Toaster Popup Click
		ToasterPopupClick();	  
	    
		// Initiate Claim
		driver.findElement(By.xpath("//a[@href='/claim']")).click();
		
		//Select Product
		WebElement Product = driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[1]/div/app-claim-intimation/div[1]/div/div/div[2]/div/div/select"));

		
				Select s2 = new Select(Product);
				s2.selectByVisibleText("Motor Claim");
				Thread.sleep(200);
		
		//Select Insurer	
		String insurer_Name = DBFunction.getDataFromExcelSheet(EXCEL_PATH, MotorClaim_Insurer_Name, 1, 0);
		WebElement Insurer = driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[1]/div/app-claim-intimation/div[1]/div/div/div[3]/div/div/select"));
			
				Select s3 = new Select(Insurer);
				s3.selectByVisibleText(insurer_Name);
				
			// Fill the required details
			driver.findElement(By.cssSelector("input[formcontrolname='customer_email']")).sendKeys(Custemail);
			driver.findElement(By.cssSelector("input[formcontrolname='customer_mobile_no']")).sendKeys(randomMobileNumber);
			driver.findElement(By.cssSelector("input[formcontrolname='policy_number']")).sendKeys("JAN"+current_date);
			driver.findElement(By.xpath("//input[@formcontrolname='policy_from']")).sendKeys("22012024");
			driver.findElement(By.xpath("//input[@formcontrolname='policy_to']")).sendKeys("29012028");
			driver.findElement(By.xpath("//input[@placeholder='Enter Customer Name']")).sendKeys(randomCustName);
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter Repairer Name')]")).sendKeys(randomRepairName);
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter Make')]")).sendKeys("Lamborghini");
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter Model')]")).sendKeys("Galardo");
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter Type')]")).sendKeys("Super");
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter Color')]")).sendKeys(randomColorName);
			driver.findElement(By.xpath("(//input[contains(@placeholder,'Enter your remark')])[1]")).sendKeys("Enter Remark 2");
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter Registration Number')]")).sendKeys(randomCarRegistration);
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter Repairer Number')]")).sendKeys(randomRepairerNumber);
			driver.findElement(By.xpath("(//input[contains(@placeholder,'Enter your remark')])[2]")).sendKeys("Enter Remark 1");
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter Year of Mfg')]")).sendKeys(randomYear);
			
			get_screenshot();
			
 			// Toaster Popup Click
			ToasterPopupClick(); 
		    
			
			//Scroll to the end of page
			JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");					
			Thread.sleep(1000);
			
			// Submit Details
//			WebElement submit = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/div[1]/div/app-claim-intimation/div[2]/form/div[2]/button[1]"));			
//			submit.click();
//			Thread.sleep(1000);
//			
//			// Toaster Popup Click
//			ToasterPopupClick();
				
			//Open View List
			driver.findElement(By.xpath("//a[@href='/claim-details']")).click();
			
	}
	
}

package MotorClaim;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import generic.BaseClassICGMS;
import generic.DBFunction;
import generic.login_ICGMS;

public class _03_MotorClaim_QualityCheck extends BaseClassICGMS
{

	@Test
	public void MotorClaim_QualityCheck() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Open View List
		driver.findElement(By.xpath("//a[@href='/claim-details']")).click();
		
		//Quality Check Button Click
		driver.findElement(By.xpath("(//button[text()='Quality Check'])[1]")).click();
		
		//Claim Number Enter
		WebElement claim_number = driver.findElement(By.xpath("//input[@placeholder='Enter Claim Number' or @placeholder='Claim Number']"));
		claim_number.sendKeys("223");
		
		//Scroll to the particular web element of page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//label[text()='Upload Images'])[1]")));					
		Thread.sleep(500);
		
		// Front View Image approval
//		WebElement Front_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[1]")));
//		Front_View.click();
//		WebElement Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		 //Chassis Number Image approval
//		WebElement Chassis_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[2]")));
//		Chassis_View.click();
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Odometer Reading Image approval
//		WebElement Odometer_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[3]")));
//		Odometer_View.click();
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Front RH View Image approval
//		WebElement Front_RH_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[4]")));
//		Front_RH_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Front LH View Image approval
//		WebElement Front_LH_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[5]")));
//		Front_LH_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Rear View Image approval
//		WebElement Rear_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[6]")));
//		Rear_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Rear LH View Image approval
//		WebElement Rear_LH_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[7]")));
//		Rear_LH_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Rear RH View Image approval
//		WebElement Rear_RH_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[8]")));
//		Rear_RH_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// RC Copy View Image approval
//		WebElement RC_Copy_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[9]")));
//		RC_Copy_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Front Windcreen INSIDE Image approval
//		WebElement Front_Windscreen_Inside_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[10]")));
//		Front_Windscreen_Inside_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Engine Compartment Image approval
//		WebElement Engine_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[11]")));
//		Engine_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Front Windscreen OUTSIDE Image approval
//		WebElement Front_Windscreen_Outside_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[12]")));
//		Front_Windscreen_Outside_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Dashboard Image approval
//		WebElement Dashboard_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[13]")));
//		Dashboard_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
//		
//		// Front Under Chassis Image approval
//		WebElement Under_Chassis_View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='eye-icon mdi mdi-eye'])[14]")));
//		Under_Chassis_View.click();		
//		Accept = driver.findElement(By.xpath("//button[text()=' Accept ']"));
//		Accept.click();
//		Thread.sleep(1000);
		
		//Enter Remark
		WebElement remark = driver.findElement(By.xpath("//textarea[@formcontrolname='qc_remark']"));
		Thread.sleep(500);
		remark.sendKeys("Approval Done");
		
		//Click Submit
		WebElement submit = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		submit.click();
		Thread.sleep(2000);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
	}
}

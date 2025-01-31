package MotorClaim;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseClassICGMS;
import generic.DBFunction;
import generic.login_ICGMS;

public class _04_MotorClaim_CustomerReview extends BaseClassICGMS
{

	@Test
	public void MotorClaim_CustomerReview() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Log, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Log, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		//Toaster Popup Click
		ToasterPopupClick();
		
		//Open Customer Review
		WebElement review_button = driver.findElement(By.xpath("(//button[text()='Customer Review'])[1]"));
		review_button.click();
		Thread.sleep(1500);
		
		// Click Approve
		WebElement approve_button = driver.findElement(By.xpath("//button[text()='Approve']"));
		approve_button.click();
		
		//Signature
    	WebElement canvas = driver.findElement(By.xpath("//canvas[@width='700' or height='200']"));
    	canvas.click();
    	Thread.sleep(1000);
    	WebElement submit_sign = driver.findElement(By.xpath("//button[text()='Submit the signature']"));
    	submit_sign.click();
    	Thread.sleep(2000);
    	
	}
	
}

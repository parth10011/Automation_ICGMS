package MotorClaim;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseClassICGMS;
import generic.DBFunction;
import generic.login_ICGMS;

public class _08_MotorClaim_InsurerVerification extends BaseClassICGMS 
{

	@Test
	public void MotorClaim_InsurerVerification() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
				
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Scroll to the particular web element of page
//	    WebElement InsurerVeri = driver.findElement(By.xpath("(//button[text()='Insurer Verification'])[1]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();", InsurerVeri);					
//		Thread.sleep(500);
		
		//Insurer Verification Button Click
		WebElement InsurerVeri = driver.findElement(By.xpath("(//button[text()='Insurer Verification'])[1]"));
		InsurerVeri.click();
		
		//Enter Claim Number
		WebElement Claim_Numb = driver.findElement(By.xpath("//input[@formcontrolname='claim_number']"));
		Thread.sleep(500);
		Claim_Numb.sendKeys("abcd");
		
		//Enter Remark
		WebElement remark = driver.findElement(By.xpath("//textarea[@placeholder='Enter Your Remark']"));
		remark.sendKeys("Approval Done");
		Thread.sleep(2000);
		
		//Click on Self Inspection To Be Considered Radio Button
		WebElement self_report_radio = driver.findElement(By.xpath("//input[@value='no']"));
		self_report_radio.click();
		
		//Upload Document
		WebElement Document_Upload = driver.findElement(By.xpath("//input[@accept='application/pdf']"));
		Document_Upload.sendKeys(Doc_Link);
		
		//Enter File Name
		WebElement File_Name = driver.findElement(By.xpath("//input[@placeholder='Enter filename']"));
		File_Name.sendKeys("Dummydotpdf");
		
		//Click Approve
		WebElement Approve_Button = driver.findElement(By.xpath("//span[text()='Approve']"));
		Approve_Button.click();
		Thread.sleep(2000);
		
		//Open View List
		driver.findElement(By.xpath("//a[@href='/insurer-claim-list']")).click();
		Thread.sleep(500);
		
		// Toaster Popup Click
		ToasterPopupClick();
	}
}

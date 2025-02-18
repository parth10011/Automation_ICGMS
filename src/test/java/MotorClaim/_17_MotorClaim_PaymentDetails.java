package MotorClaim;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.BaseClassICGMS;
import generic.DBFunction;
import generic.login_ICGMS;

public class _17_MotorClaim_PaymentDetails extends BaseClassICGMS
{

	@Test
	public void MotorClaim_PaymentDetails() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
				
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Scroll to the particular web element of page
//		WebElement Page = driver.findElement(By.xpath("//a[text()='2']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();", Page);					
//		Thread.sleep(500);
//		
//		// Move to next page
//		WebElement nextPage = driver.findElement(By.xpath("//a[text()='2']"));
//		nextPage.click();
		
		//Insurer Verification Button Click
		WebElement PaymentDet1 = driver.findElement(By.xpath("(//button[text()='Payment Details'])[1]"));
		PaymentDet1.click();
		
		// Enter Amount Paid by Repairer
		WebElement survAmt = driver.findElement(By.xpath("//input[@formcontrolname='amountPaid']"));
		survAmt.sendKeys("55328");
		
		// Enter Date of Payment by Repairer
		WebElement dateRepair = driver.findElement(By.xpath("//input[@formcontrolname='dateOfPayment']"));
		dateRepair.sendKeys(current_date);
		
		// Select Mode Of Payment by Repairer
		WebElement Mode = driver.findElement(By.xpath("//select[@formcontrolname='paymentMode']"));

			Select s1 = new Select(Mode);
			s1.selectByVisibleText("NEFT");
			Thread.sleep(200);
			
		// Enter Reference Number
		WebElement refNum1 = driver.findElement(By.xpath("//input[@formcontrolname='refNumber']"));
		refNum1.sendKeys("REF0L0HAB85DV");
		
		// Enter Remark
		WebElement remark1 = driver.findElement(By.xpath("//textarea[@formcontrolname='paymentRemarks']"));
		remark1.sendKeys("Payment Ok go ahead");
		
		// Enter Amount Paid by Surveyor
		WebElement repAmt = driver.findElement(By.xpath("//input[@formcontrolname='surveyoramountPaid']"));
		repAmt.sendKeys("55328");
		
		// Enter Date of Payment by Surveyor
		WebElement dateSurv = driver.findElement(By.xpath("//input[@formcontrolname='surveyordateOfPayment']"));
		dateSurv.sendKeys(current_date);
		
		// Select Mode Of Payment by Surveyor
		WebElement ModeSurv = driver.findElement(By.xpath("//select[@formcontrolname='surveyorpaymentMode']"));

			Select s2 = new Select(ModeSurv);
			s2.selectByVisibleText("IMPS");
			Thread.sleep(200);
			
		// Enter Reference Number
		WebElement refNum2 = driver.findElement(By.xpath("//input[@formcontrolname='surveyorrefNumber']"));
		refNum2.sendKeys("REF0L0HAB85DV");
		
		// Enter Remark
		WebElement remark2 = driver.findElement(By.xpath("//textarea[@formcontrolname='surveyorpaymentRemarks']"));
		remark2.sendKeys("Payment Ok go ahead");
		
		//Upload Document Files
		WebElement doc_upload = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
		doc_upload.sendKeys(Doc_Link);
		
		//Enter File Name
		WebElement file_name = driver.findElement(By.xpath("//input[@placeholder='Enter filename']"));
		file_name.sendKeys("DummyZeroGo");
		
		//Click Submit
	    WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
	    submit.click();
	    
	    //Toaster Popup Click
	    ToasterPopupClick();
	    
	    //Open View List
		WebElement view_list = driver.findElement(By.xpath("//span[text()='Insurer Claim List ']"));
		view_list.click();
		Thread.sleep(500);
		
		
	}
}

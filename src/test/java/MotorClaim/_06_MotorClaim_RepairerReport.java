package MotorClaim;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import generic.BaseClassICGMS;
import generic.login_ICGMS;
import generic.DBFunction;
public class _06_MotorClaim_RepairerReport extends BaseClassICGMS 
{

	@Test
	public void MotorClaim_RepairerReport() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Repair_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Repair_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		//Toaster Popup Click
		ToasterPopupClick();
		
		//Open View List
		WebElement claim_list = driver.findElement(By.xpath("//a[@href='/repairer-claim-list']"));
		claim_list.click();

		
		//Open Repairer Appointment
		WebElement report_button = driver.findElement(By.xpath("(//button[text()='Repairer Report'])[1]"));
		report_button.click();
		Thread.sleep(500);
		
		//Enter Amount for repair
		WebElement amt_rep = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		amt_rep.sendKeys(Amt_Repair);
		
		//Enter Days for repair
		WebElement days_rep = driver.findElement(By.xpath("//input[@placeholder='Enter Required number of days']"));
		days_rep.sendKeys(Days_Repair);
		
		//Upload Estimation Report
		WebElement report_upload = driver.findElement(By.xpath("//input[@accept='application/pdf']"));
		report_upload.sendKeys(Est_Report);
		
		//Enter Remark
		WebElement remark = driver.findElement(By.xpath("//textarea[@placeholder='Enter Your Remark']"));
		remark.sendKeys("Ok Go Ahead");
		
		//Upload Document Files
		WebElement doc_upload = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
		doc_upload.sendKeys(Doc_Link);
		
		//Enter File Name
		WebElement file_name = driver.findElement(By.xpath("//input[@placeholder='Enter filename']"));
		file_name.sendKeys("Dummy2point0");
		
		//View Customer Inspection Report
		WebElement view_button = driver.findElement(By.xpath("//button[text()=' View ']"));
		view_button.click();
		
		// Toaster Pdf Popup Click
        WebElement pdf_toaster = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='toast-container']")));
        pdf_toaster.click();
        
        //Close Button Click
        WebElement close_button = driver.findElement(By.xpath("//button[@aria-label='Close']"));
	    close_button.click();
	    Thread.sleep(1000);
	    get_screenshot();
	    
	    //Click Submit
	    WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
	    submit.click();
	    
	    //Toaster Popup Click
	    ToasterPopupClick();
	    
	    //Open View List
  		claim_list = driver.findElement(By.xpath("//a[@href='/repairer-claim-list']"));
  		claim_list.click();
  		
	}
	
}

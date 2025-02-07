package PreInspection;

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

public class _04_PreInspection_QualityCheck extends BaseClassICGMS
{

	@Test
	public void Quality_Check() throws InterruptedException, AWTException, EncryptedDocumentException, IOException 
	{
		// Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		Thread.sleep(500);
		
//		//Select User
//		WebElement User = driver.findElement(By.xpath("//select[@name='role']"));
//		
//			Select s1 = new Select(User);
//			s1.selectByValue("1");
//			driver.findElement(By.xpath("//button[text()='Submit']")).click();

		// Toaster Popup Click
		ToasterPopupClick();
		
		// View List
		driver.findElement(By.xpath("//a[@href='/claim-details']")).click();
		
		Thread.sleep(1000);
						
		// Quality Check Button click
		driver.findElement(By.xpath("(//button[text()='Quality Check'])[1]")).click();
		
		// Enter Chassis Number
		WebElement Chassis_input = driver.findElement(By.xpath("//input[@placeholder='Enter Chassis Number']"));
		Chassis_input.sendKeys("CHASSIS1010");
		
		// Enter Engine Number
		WebElement Engine_input = driver.findElement(By.xpath("//input[@placeholder='Enter Engine Number']"));
		Engine_input.sendKeys("ENGINE00202");
		
		// Enter Aadhar Number
		WebElement Aadhar_input = driver.findElement(By.xpath("//input[@placeholder='Enter Aadhar Number']"));
		Aadhar_input.sendKeys("987654646456");
		
		// Enter PAN Number
		WebElement PAN_input = driver.findElement(By.xpath("//input[@placeholder='Enter PAN Number']"));
		PAN_input.sendKeys("ABCDY8876A");
		
		//Chassis Tampered Radio Button Click
		WebElement Radio_Button1 = driver.findElement(By.xpath("//input[@id='chasisTamperedYes']"));
		Radio_Button1.click();
		
		//Chassis Mismatch Radio Button Click
		WebElement Radio_Button2 = driver.findElement(By.xpath("//input[@id='chasisMismatchYes']"));
		Radio_Button2.click();
		
		//Class Change Radio Button Click
		WebElement Radio_Button3 = driver.findElement(By.xpath("//input[@id='classChangeYes']"));
		Radio_Button3.click();
		
		//Engine Running Radio Button Click
		WebElement Radio_Button4 = driver.findElement(By.xpath("//input[@id='engineRunningYes']"));
		Radio_Button4.click();
		
		//Age Approval Radio Button Click
		WebElement Radio_Button5 = driver.findElement(By.xpath("//input[@id='ageApprovalYes']"));
		Radio_Button5.click();
		
		//Select Image Type
		WebElement Image_Type = driver.findElement(By.xpath("//select[@formcontrolname='imageType']"));

		Select s = new Select(Image_Type);
		s.selectByVisibleText("REAR LHS QTR VIEW");
		Thread.sleep(500);
		
		//Select Component
		WebElement Component = driver.findElement(By.xpath("//select[@formcontrolname='component']"));

		Select s2 = new Select(Component);
		s2.selectByVisibleText("LHS Rear Door");
		Thread.sleep(500);
		
		//Damage Noticed Radio Button Click
		WebElement Damage_Radio_Button = driver.findElement(By.xpath("//input[@id='actionNo-0']"));
		Damage_Radio_Button.click();
		Thread.sleep(1000);
		
		// Enter Remark text
		WebElement Remark_input = driver.findElement(By.xpath("//textarea[@placeholder='Enter Your Remark']"));
		Remark_input.sendKeys("Fine From Our Side");
		
		//Approval Click
		WebElement Approve_Button = driver.findElement(By.xpath("//span[text()='Approve']"));
		Approve_Button.click();
		Thread.sleep(3000);
		System.out.println("Quality Check Completed Successfully");
		
		// View List
		driver.findElement(By.xpath("//a[@href='/claim-details']")).click();
		Thread.sleep(1000);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
	}
	
}

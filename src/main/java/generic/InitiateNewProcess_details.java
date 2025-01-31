package generic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Dimension;

public interface InitiateNewProcess_details

{	
	String EXCEL_PATH = "./src/test/resources/TestData/ICGMS Test Data.xlsx";
	String Admin_Log = "SuperAdmin";
	String Cust_Log = "Customer";
	String Oriental = "39";
	String Royal = "1";
	String United = "36";
	String Magma = "34";
	String Tata = "35";
	String New = "37";
	String National = "38";
	String Kotak = "41";
	String Sampo = "40";
	String Iffco = "5";
	String Chola = "6";
	String Bajaj = "4";
	String Sbi = "7";
	
	String url = "https://release.icgms.sharajman.com/";
	String url_UAT = "https://uat.icgms.insapp.in/";
	String SuperAdmin_Email2 = "superadmnphase1@owleyes.ch";
	String SuperAdmin_Email1 = "jasim@superadmin.com";
	String Cust_Pass = "Admin123";
	String Admin_Pass = "Admin123";
	String Motor_Cust_Name = "Moto SEVENTEEN JAN";
	String Pre_Cust_Name = "Tester Customer";
	String Cust_Email10 = "padnunlow@addrin.uk";
	String Cust_Email2 = "eyebuy741@fanclub.pm";
	String Cust_Email11 = "testcust1@sendnow.win";
	String Cust_Email6 = "errox896@exdonuts.com";
	String Cust_Email4 = "hascap814@tapi.re";
	String Cust_Email12 = "sumbadlet@eay.jp";
	String Cust_Email3 = "fatbeg106@cream.pink";
	String Cust_Email5 = "vandayrid@ruru.be";
	String Cust_Email1 = "md.jasim@sharajman.com";
	String Cust_Email7 = "customer11@goatmail.uk";
	String Cust_Email9 = "pittry583@fuwa.be";
	String Cust_Email8 = "bartryfry@macr2.com";
	String Cust_Email13 = "chandini.khan@sharajman.com";
	String type_2wheeler = "29";
	String type_car = "30";
	String type_commercial = "31";
	String Car_Registration = "TN10AW3894";
	String Client_Email = "ribcod478@fanclub.pm";
	String Repairer_Email1 = "repairerphase1@hamham.uk";
	String Repairer_Email2 = "ehtasham@repairer.com";
	String Surveyor_Email1 = "surveyorphase1@sendnow.win";
	String Insurer_Email1 = "royalsundaram@insurer.com";
	Dimension Mobile_View = new Dimension (765 , 1000); //(375 , 812)
	String randomCarRegistration = generateRandomCarRegistration();
	String randomMobileNumber = generateRandomMobileNumber();
	String randomYear = getRandomYear();
	String randomName = getRandomName();
	String Est_Report = "C:\\Users\\parth\\Downloads\\TAS-Manage Master - REC Bid Date-130924-051456.pdf";
	String Img_Link = "C:\\Users\\parth\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-10-14 103740.png";
	String Vid_Link = "C:\\Users\\parth\\OneDrive\\Desktop\\DTU\\ICGMS\\Sample Video.mp4";
	String Doc_Link = "C:\\Users\\parth\\OneDrive\\Desktop\\DTU\\Dummy.pdf";
	String Amt_Repair = "50000";
	String Days_Repair = "20";
//	public Random random = new Random();

	// Get current date
		LocalDate Date = LocalDate.now();
		DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("ddMMyyyy");
		String current_date = Date.format(dt1);
		DateTimeFormatter dt2 = DateTimeFormatter.ofPattern("yyyy");
		String stringcurrent_year = Date.format(dt2);
		int current_year = Integer.parseInt(stringcurrent_year);
		
		// Get current time
		LocalTime Time = LocalTime.now();
		DateTimeFormatter dt3 = DateTimeFormatter.ofPattern("hhmma");
		String current_time = Time.format(dt3);
	

	//Generate Car Registration Number
	public static String generateRandomCarRegistration() {		
		Random random = new Random();
		String[] stateCodes = {"AP", "MH", "KA", "DL", "TN", "GJ", "UP", "RJ", "WB", "KL","JK","OD","CH","CG","NL","PY","PB","HP","MP","AS","BR","HR","TS","TR","UK","DD","GA","SK"};
		String stateCode = stateCodes[random.nextInt(stateCodes.length)];
		int districtCode = 1 + random.nextInt(99); // 2-digit district code (1-99)
		char r1 = (char) ('A' + random.nextInt(26));
		char r2 = (char) ('A' + random.nextInt(26));
		String series = String.valueOf(r1) + String.valueOf(r2);
		String uniqueNumber = String.format("%04d", random.nextInt(10000)); // 4-digit unique number
		return stateCode + districtCode + series+ uniqueNumber;
	}
	//Generate Mobile number
	public static String generateRandomMobileNumber() {
		Random random = new Random();
		String[] n = {"9","8","7","6"};
		String n1 = n[random.nextInt(n.length)]; 
		StringBuilder mobileNumber = new StringBuilder(n1); // Indian mobile number starting with 9, 8, 7, 6
		for (int i = 0; i < 9; i++) {
			mobileNumber.append(random.nextInt(10));
		}
		return mobileNumber.toString();
	}


	//Generate Year
	public static String getRandomYear() {
	int currentYear = 2024; // Replace with the current year if needed
	int year = 2000 + new Random().nextInt(currentYear - 2000 + 1); // Random year between 2000 and current year
	return String.valueOf(year);
	}
	
	//Generate Name
	public static String getRandomName() {
        // List of names
        List<String> names = Arrays.asList(
            "Mathias", "Tobias", "Cristopher", "Ronald", "Donovan", "Fabian", "Luciano", "Masao", 
            "Moses", "Angel", "Zaid", "Conner", "Jared", "Jasper", "Larry", "Eugene", "Devyn", 
            "Kamden", "Armani", "Derick", "Ellis", "Ali", "Camron", "Darrell", "Cortez", "Peter", 
            "Jerome", "Pierre", "Sage", "Sheldon", "Hassan", "Kristopher", "Darryl", "Trey", "Russell", 
            "Korbin", "Abram", "Anton", "Cason", "Frederick" , "Collin" , "Aditya" , "Aurther" , "Kazama"
        );

        // Randomly select a name    
        Random random = new Random();
        int index = random.nextInt(names.size()); // Generate a random index
        return names.get(index); // Return the name at the random index
    }
	
	
}


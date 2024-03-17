package Testcases;

import Pageobjects.HomePage;
import Pageobjects.Travel_insurance01;
import Pageobjects.Travel_insurance02;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testbase.baseclass;
//import utilities.Screenshots;
import utilities.Screenshots;

//import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(utilities.ExtentReport.class)

	public class TC_001_travel_Insurance extends baseclass {
	//	WebDriver driver;      
	//	driver = new ChromeDriver();
	//	driver.get("https://www.policybazaar.com/");
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//	driver.manage().window().maximize();
	
		public static String path;
		HomePage hp;
		Travel_insurance01 Travel01;
		Travel_insurance02 Travel02;
		Logger logger;
		@Test(groups= {"sanity","master"})
		public void main() throws InterruptedException, IOException {
			
			logger = baseclass.logger;
			logger.info("*****Starting TC_001_travel_Insurance*****");
			try {
			hp = new HomePage(baseclass.driver);
			Travel01=new Travel_insurance01(baseclass.driver);
			Travel02=new Travel_insurance02(baseclass.driver);
			hp.click_on_travel_insurance();
			logger.info("*****click_on_travel_insuranceMethod*****");
			Travel01.Destination_travel();
			path=Screenshots.screenShots(driver,"TRAVEL INSURANCE");
			Travel01.click_march_date();
			Travel02.TravelInsurance02();
			System.out.println("----------------------------------------------------------------------");
		}catch(Exception e)
		{
			Assert.fail();
		}
			logger.info("*****Finished TravelInsurance02 Method*****");
			//hp.GotoHome();
		}
		
		
	
	
}





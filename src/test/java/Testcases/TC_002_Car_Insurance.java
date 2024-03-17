package Testcases;
import java.io.IOException;
import java.time.Duration;
import Pageobjects.Car_insurance03;
import Pageobjects.Car_insurance04;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pageobjects.HomePage;
import testbase.baseclass;
//import utilities.Screenshots;
import utilities.Screenshots;

//@Listeners(ExtentReportManager.ExtentReport.class)
public class TC_002_Car_Insurance extends baseclass {

	HomePage hp;
	Car_insurance03 CarInsurance;
	Car_insurance04 CarInsurance1;
	public static String path;
	Logger logger;
	@Test(groups= {"regression","master"})
	public void main() throws InterruptedException, IOException {
		logger = baseclass.logger;
		logger.info("*****Starting TC_002_Car_Insurance*****");
		try {
		hp = new HomePage(baseclass.driver);
		 //logger = baseclass.logger;
		//hp.CarInsurancelogo();
		path=Screenshots.screenShots(driver,"CAR INSURANCE");
		CarInsurance=new Car_insurance03(baseclass.driver);
		CarInsurance.Car_insurance03();
		CarInsurance1=new Car_insurance04(baseclass.driver);
		CarInsurance1.Car_insurance04();
		System.out.println("----------------------------------------------------------------------");
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished TC_002_Car_Insurance*****");
		Thread.sleep(3000);
		//hp.GotoHome();
				
	}
	
}

package Testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pageobjects.Health_Insurance_Products;
import Pageobjects.HomePage;
import testbase.baseclass;
import utilities.Screenshots;
//import utilities.Screenshots;

//@Listeners(ExtentReportManager.ExtentReport.class)

public class TC_004_Health_insurance_products extends baseclass{
	HomePage hp;
	Health_Insurance_Products HI;
	public static String path;

	@Test()
	public void main() throws InterruptedException, IOException {
		logger.info("*****Starting TC_004_Health_insurance_products*****");
		try {
		hp=new HomePage(baseclass.driver);
		 HI=new Health_Insurance_Products(baseclass.driver);
		 System.out.println("----------------------------------------------------------------------");
		 HI.Health_Insurance_Products();
		}catch(Exception e)
		{
			Assert.fail();
		}
	   	path=Screenshots.screenShots(driver,"HEALTH INSURANCE PRODUCTS");
	   	logger.info("*****Finished TC_004_Health_insurance_products*****");

	}
}

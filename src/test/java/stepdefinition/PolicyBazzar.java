package stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import Pageobjects.Car_insurance03;
import Pageobjects.Car_insurance04;
import Pageobjects.Health_Insurance_Products;
import Pageobjects.Health_Inusrance05;
import Pageobjects.HomePage;
import Pageobjects.Travel_insurance01;
import Pageobjects.Travel_insurance02;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testbase.baseclass;
import utilities.Screenshots;
import testbase.baseclass;
public class PolicyBazzar  {
	public static WebDriver  driver;
	
	 public static HomePage hp;
	Travel_insurance01 Travel01;
	Travel_insurance02 Travel02;
	Logger logger;
	Car_insurance03 CarInsurance;
	Car_insurance04 CarInsurance1;
	Health_Inusrance05 HealthInsurance;
	Health_Insurance_Products HI;
	
    
	@Given("User is on the PolicyBazaar homepage")
	public void user_is_on_the_policy_bazaar_homepage() throws InterruptedException, IOException {
		//getWebDriver("windows","chrome");
		logger=LogManager.getLogger(this.getClass());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for chrome browser :  \nEnter 2 for Edge browser : ");

		int br = sc.nextInt();
		if(br==1) {
			ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-blink-features=AutomationControlled");
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.manage().deleteAllCookies();
		System.out.println("Launching Chrome Browser");
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		}else if(br==2){
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
			System.out.println("Launching Edge Browser");
			driver.get("https://www.policybazaar.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		}else {
			System.out.println("no matching browser......");
		}
		
		
		
	}

	@When("user need to fill all travel insurance details")
	public void user_need_to_fill_all_travel_insurance_details() throws Exception {
		//logger = baseclass.logger;
		logger.info("*****Starting TC_001_travel_Insurance*****");
	    HomePage hp = new HomePage(driver);
		Travel01=new Travel_insurance01(driver);
		Travel02=new Travel_insurance02(driver);
		hp.click_on_travel_insurance();
		//logger.info("*****click_on_travel_insuranceMethod*****");
		Travel01.Destination_travel();
		//path=Screenshots.screenShots(driver,"TRAVEL INSURANCE");
		Travel01.click_march_date();
		Travel02.TravelInsurance02();
		System.out.println("----------------------------------------------------------------------");
		//hp.policylogo();
		logger.info("*****Finished TravelInsurance02 Method*****");
		//hp.GotoHome();
		
	}

	@When("user need to fill all car insurance details")
	public void user_need_to_fill_all_car_insurance_details() throws Exception, IOException {
	//	logger = baseclass.logger;
		logger.info("*****Starting TC_002_Car_Insurance*****");
		HomePage hp = new HomePage(driver);
		 //logger = baseclass.logger;
		//hp.CarInsurancelogo();
		//path=Screenshots.screenShots(driver,"CAR INSURANCE");
		CarInsurance=new Car_insurance03(driver);
		CarInsurance.Car_insurance03();
		CarInsurance1=new Car_insurance04(driver);
		CarInsurance1.Car_insurance04();
		System.out.println("----------------------------------------------------------------------");
		//hp.policylogo();
		logger.info("*****Finished TC_002_Car_Insurance*****");
		//Thread.sleep(3000);
	}  

	@When("user need to fill all health insurance details")
	public void user_need_to_fill_all_health_insurance_details() throws Exception, IOException {
	//	logger = baseclass.logger;
		logger.info("*****Starting  TC_003_Health_Insurance *****");
	    HomePage hp = new HomePage(driver);
		 HealthInsurance=new  Health_Inusrance05(driver);
		// logger = baseclass.logger;
		 HealthInsurance.Health_Inusrance05();
		 System.out.println("----------------------------------------------------------------------");
		//path=Screenshots.screenShots(driver,"HEALTH INSURANCE");
		logger.info("*****Finished  TC_003_Health_Insurance*****");
		logger.info("*****Starting TC_004_Health_insurance_products*****");
	//	hp=new HomePage(driver);
		 HI=new Health_Insurance_Products(driver);
		 HI.Health_Insurance_Products();
		 System.out.println("----------------------------------------------------------------------");
			//hp.policylogo();
	   //	path=Screenshots.screenShots(driver,"HEALTH INSURANCE PRODUCTS");
	   	logger.info("*****Finished TC_004_Health_insurance_products*****");

	}

	@Then("driver should close the browser")
	public void driver_should_close_the_browser() {
		driver.quit();
	    
	}


	
	

}

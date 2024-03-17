package Pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
	WebDriver driver;
		
		//constructor
		public HomePage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
	   //WebElements+locators
		@FindBy(xpath="//a[text()='Policybazaar']")
		WebElement policylogo;
		
		
		@FindBy(xpath="//i[@class='icon-bg homeIconsBg icon-bg-new ti']")
		WebElement TravelInsurancelogo;
		
		@FindBy(xpath="//div[@class='shadowHandlerBox']//i[@class='icon-bg homeIconsBg car-insurance']")
		WebElement CarInsurancelogo;
		
		@FindBy(xpath="(//i[@class='icon-bg homeIconsBg health-insurance'])[2]")
		WebElement HealthInsurancelogo;
		
		@FindBy(xpath="//a[text()='Insurance Products ']")
		WebElement InsuranceProducts;
	
		@FindBy(xpath="(//a[text()='Health Insurance'])[2]")
		WebElement HealthInsurancetext;
		
		@FindBy(xpath="//div[@class='ruby-col-3 hidden-md'][2]//span")
		WebElement ProductsList;
		
		public void click_on_travel_insurance() {
			TravelInsurancelogo.click();
		}
		//public void GotoHome() {
			//policylogo.click();
		//}
		public void CarInsurancelogo() {
			CarInsurancelogo.click();
		}
        public void policylogo() {
	       policylogo.click();
}
		
		
		

	}



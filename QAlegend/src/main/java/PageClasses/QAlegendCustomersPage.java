package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QAlegendCustomersPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//i[@class='fa fa-star'])[2]")
	WebElement Customerbox;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement Addcustomerbutton;
	
	@FindBy(id = "contact_type")
	WebElement Contacttype;
	
	@FindBy(id = "name")
	WebElement Customername;
	
	@FindBy(id = "contact_id")
	WebElement Customercontactid;
	
	@FindBy(id = "tax_number")
	WebElement Customertaxnumber;
	
	@FindBy(id = "opening_balance")
	WebElement Customeropeningbalance;
	
	@FindBy(id = "mobile")
	WebElement Customermobilenumer;
	
	
	@FindBy(id="city")
	WebElement Customercity;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Customersavebutton;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement Customersearchbutton;
	
	@FindBy(xpath = "(//tr[@role='row']//td)[2]")
	WebElement customernamedisplay;



	public QAlegendCustomersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickOnCustomerOption() {
		PageUtilities.clickOnElement(Customerbox);
	}
	public void clickonAddCustomerOption() {
		PageUtilities.clickOnElement(Addcustomerbutton);
	}
 
	public String insertCustomerDetails(String filepath,String sheetname) throws IOException {
		String name=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet4")+FakerUtility.randomNumberGenerator();
		String customercontactid=FakerUtility.randomNumberGenerator()+ExcelUtility.getNumeric(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet4")+FakerUtility.randomNumberGenerator();
		String customertaxnumber=ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		String customeropeningbalance=ExcelUtility.getNumeric(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		String customermobile =ExcelUtility.getNumeric(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		String customercity =ExcelUtility.getString(1,5,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		PageUtilities.enterText(Customername, name);
		PageUtilities.enterText(Customercontactid, customercontactid);
		PageUtilities.enterText(Customertaxnumber, customertaxnumber);
		PageUtilities.enterText(Customeropeningbalance, customeropeningbalance);
		PageUtilities.enterText(Customermobilenumer, customermobile);
		PageUtilities.enterText(Customercity, customercity);
		return name;
		
		
	}
	public void clickOnCustomerSaveButton() {
		PageUtilities.clickOnElement(Customersavebutton);
		
		
	}
	public void enterCustomerSerach(String customername) {
		WaitUtility.waitForElementVisibility(Customersearchbutton, 5);
		PageUtilities.enterText(Customersearchbutton, customername);
	}
	public boolean customerMessageDisplay() {
		return(PageUtilities.isElementDisplayed(customernamedisplay));
	}
	
	
	
	
	
}

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

public class QAlegendSalesCommissionPage {

	
	WebDriver driver;
	@FindBy(xpath = "//i[@class='fa fa-handshake-o']")
	WebElement SalesCommissionAgentbutton;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-modal pull-right']")
	WebElement Addsalescommissionbutton;
	
	@FindBy(id = "surname")
	WebElement Prefixbutton;
	
	@FindBy(id = "first_name")
	WebElement Firstnamebutton;
	
	@FindBy(id = "last_name")
	WebElement Lastnamebutton;
	
	@FindBy(id = "email")
	WebElement Emailbutton;
	
	@FindBy(id = "contact_no")
	WebElement Contactnumberbutton;
	
	@FindBy(id = "address")
	WebElement Addressbutton;
	
	@FindBy(id = "cmmsn_percent")
	WebElement Commissionpercentagebutton;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Commissionsavebutton;
	
	@FindBy(xpath= "//input[@class='form-control input-sm']")
	WebElement salescommissionsearch;
	
	@FindBy(xpath = "(//tr[@role='row']//td)[2]")
	WebElement Rolesmessagedisplay;

public QAlegendSalesCommissionPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void salesCommissionAgentOption() {
	
	//PageUtilities.clickOnElement(SalesCommissionAgentbutton);
	SalesCommissionAgentbutton.click();
}
public void clickOnAddSalesCommissionOption() {
	//PageUtilities.clickOnElement(Addsalescommissionbutton);
	Addsalescommissionbutton.click();
}
public String insertSalesCommisionDetails(String filepath,String sheetname) throws IOException {
	String prefix=ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String firstname=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet2")+FakerUtility.randomNumberGenerator();
	String lastname=ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String email=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet2")+FakerUtility.randomNumberGenerator();
	String contactnosales=ExcelUtility.getNumeric(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String address=ExcelUtility.getString(1,5,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String salescommissionpercentage =ExcelUtility.getNumeric(1,6,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	PageUtilities.enterText(Prefixbutton, prefix);
	PageUtilities.enterText(Firstnamebutton, firstname);
	PageUtilities.enterText(Lastnamebutton, lastname);
	PageUtilities.enterText(Emailbutton, email);
	PageUtilities.enterText(Contactnumberbutton, contactnosales);
	PageUtilities.enterText(Addressbutton, address);
	PageUtilities.enterText(Commissionpercentagebutton, salescommissionpercentage);
	return email;
}
public void clickOnCommissionSaveOption() {
	
	//PageUtilities.clickOnElement(Commissionsavebutton);
	Commissionsavebutton.click();
}
public void enterSalesCommissionSearch(String email) {
	WaitUtility.waitForElementVisibility(salescommissionsearch, 5);
	//PageUtilities.enterText(salescommissionsearch, email);
	salescommissionsearch.sendKeys(email);
	
}
public boolean rolesMessageDisplay() {
	return(PageUtilities.isElementDisplayed(Rolesmessagedisplay));
			
			
			
			
			
			
			
			
			
			
}
}
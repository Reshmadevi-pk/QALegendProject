package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QAlegendContactsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//i[@class='fa fa-address-book'])[1]")
	WebElement Contactsbutton;
	
	@FindBy(xpath = "(//i[@class='fa fa-star'])[1]")
	WebElement Suppliersbutton;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement Addsupplierbutton;
	
	@FindBy(xpath = "(//*[@id='contact_type'])[2]")
	WebElement Contacttypebox;
    
    @FindBy(id = "name")
    WebElement Suppliername;
    
    @FindBy(id = "supplier_business_name")
    WebElement Businessname;
    
    @FindBy(id = "contact_id")
    WebElement Contactid;
    
    @FindBy(id = "tax_number")
    WebElement Taxnumber;
    
    @FindBy(id="opening_balance")
    WebElement Openingbalance;

    @FindBy(name = "pay_term_type")
    WebElement Payterm;
    
    @FindBy(id = "mobile")
    WebElement Mobilenumber;
    
    @FindBy(id = "city")
    WebElement City;
    
    @FindBy(xpath = "//button[text()='Save']")
    WebElement Supplierssavebutton;
    
    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement SupplerSearchbutton;
    
    @FindBy(xpath = "(//tr[@role='row']//td)[2]")
    WebElement suppilerroleDisplay;
    

public QAlegendContactsPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}




public void clickOnContactsOption() {
	
	//PageUtilities.clickOnElement(Contactsbutton);
	Contactsbutton.click();
}
public void clickOnSuppliersOption() {
	//PageUtilities.clickOnElement(Suppliersbutton);
	Suppliersbutton.click();
}
public void clickOnAddSupplierOption() {
	//PageUtilities.clickOnElement(Addsupplierbutton);
	Addsupplierbutton.click();
	
}
public String insertSuppliersDetails(String filepath,String sheetname) throws IOException {
	String contacttype=ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
	String name=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet3")+FakerUtility.randomNumberGenerator();
	String businessname=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet3")+FakerUtility.randomNumberGenerator();
	String contactid=FakerUtility.randomNumberGenerator()+ExcelUtility.getNumeric(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet3")+FakerUtility.randomNumberGenerator();
	String taxnumber=ExcelUtility.getString(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
	String openingbalance=ExcelUtility.getNumeric(1,5,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
	String mobile =ExcelUtility.getNumeric(1,6,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
	String city =ExcelUtility.getString(1,7,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
	PageUtilities.dropdownSelectByVisibleText(Contacttypebox, contacttype);//check
	PageUtilities.enterText(Suppliername, name);
	PageUtilities.enterText(Businessname, businessname);
	PageUtilities.enterText(Contactid, contactid);
	PageUtilities.enterText(Taxnumber, taxnumber);
	PageUtilities.enterText(Openingbalance, openingbalance);
	PageUtilities.enterText(Mobilenumber, mobile);
	PageUtilities.enterText(City, city);
	return businessname;
	
}
public void supplierSaveOption() {
	//PageUtilities.clickOnElement(Supplierssavebutton);
	Supplierssavebutton.click();
}
public void enterSupplierSearch(String Businessname) {
	WaitUtility.waitForElementVisibility(SupplerSearchbutton, 5);
	//PageUtilities.enterText(SupplerSearchbutton, Businessname);
	SupplerSearchbutton.sendKeys(Businessname);
}

public boolean supplierRolesDisplayOption() {
	
	return(PageUtilities.isElementDisplayed(suppilerroleDisplay));
}
}










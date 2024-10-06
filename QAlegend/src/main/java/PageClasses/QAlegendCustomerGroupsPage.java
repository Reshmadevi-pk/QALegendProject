package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QAlegendCustomerGroupsPage {
	
	WebDriver driver;
	@FindBy(xpath = "(//i[@class='fa fa-users'])[2]")
	WebElement CustomerGroups;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement Addcustomergroups;
	
	@FindBy(id="name")
	WebElement Customergroupname;
	
	@FindBy(id = "amount")
	WebElement Customergroupcalculationpercentage;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Customergroupsavebutton;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement customerGroupssearch;
	
	@FindBy(xpath = "(//tr[@role='row']//td)[1]")
	WebElement customergroupmessageDisplayed;
	
	public QAlegendCustomerGroupsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnCustomerGroupOption() {
		
		PageUtilities.clickOnElement(CustomerGroups);
	}
public void clickOnAddCustomerGroupOption() {
		
		PageUtilities.clickOnElement(Addcustomergroups);
}
public void insertCustomerGroupsDetails(String groupname,String percent) {
	PageUtilities.enterText(Customergroupname, groupname);
	PageUtilities.enterText(Customergroupcalculationpercentage, percent);
}
public void clickOnCustomerGroupSaveOption() {
	PageUtilities.clickOnElement(Customergroupsavebutton);
}
public void enterCustomergroups(String Customergroupname) {
	WaitUtility.waitForElementVisibility(customerGroupssearch, 5);
	PageUtilities.enterText(customerGroupssearch, Customergroupname);
}
public boolean customergroupMessageDisplayed() {
	return(PageUtilities.isElementDisplayed(customergroupmessageDisplayed));
}

}
package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendHomePage {
	
	WebDriver driver;
	
	@FindBy(xpath ="//span[text()='User Management']")
	WebElement UserManagementoption;
	
	@FindBy(xpath ="//span[@class='title']//preceding::i[@class='fa fa-user']")
	WebElement Usersoption;
	
	@FindBy(xpath = "//button[text()='End tour']")
	WebElement Endtouroption;
	

	public QAlegendHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnUserManagementOption() {
	 
		PageUtilities.clickOnElement(UserManagementoption);

	}
	public void clickOnUserAction() {
		PageUtilities.clickOnElement(Usersoption);
	}
	public void clickOnEndTour() {
		PageUtilities.clickOnElement(Endtouroption);
	}
}

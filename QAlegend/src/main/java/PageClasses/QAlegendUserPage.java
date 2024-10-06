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

public class QAlegendUserPage {

	WebDriver driver;
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement UserAddOption;
	
	@FindBy(id = "surname")
	WebElement Surnamebox;
	
	@FindBy(id = "first_name")
	WebElement Firstnamebox;
	
	@FindBy(id = "last_name")
	WebElement Lastnamebox;
	
	@FindBy(id="email")
	WebElement Emailbox;
	
	@FindBy(id="username")
	WebElement Usernamebox;
	
	@FindBy(id="password")
	WebElement Passwordbox;
	
	@FindBy(id = "confirm_password")
	WebElement Confirmpasswordbox;
	
	@FindBy(id = "cmmsn_percent")
	WebElement Salescommissionbox;
	
	@FindBy(id = "submit_user_button")
	WebElement Submituserbuttonoption;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement searchButton;
	
	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_user_button']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement areYouSureDeletebutton;
	
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement DeletedErrorDetector;
	
	
	
	
	public QAlegendUserPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}






	public void clickOnUserAddOption() {
		
		PageUtilities.clickOnElement(UserAddOption);
	}
	
	public String insertUserQAlegend(String filepath, String sheetname) throws IOException {
		String prefix=ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String firstname=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet1")+FakerUtility.randomNumberGenerator();
		String lastname=ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String email=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String username=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String password=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,5,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String confirmpassword=FakerUtility.randomNumberGenerator()+ExcelUtility.getString(1,6,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String salescommissionpercentage=ExcelUtility.getNumeric(1,7,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		PageUtilities.enterText(Surnamebox, prefix);
		PageUtilities.enterText(Firstnamebox, firstname);
		PageUtilities.enterText(Lastnamebox, lastname);
		PageUtilities.enterText(Emailbox, email);
		PageUtilities.enterText(Usernamebox, username);
		PageUtilities.enterText(Passwordbox, password);
		PageUtilities.enterText(Confirmpasswordbox, confirmpassword);
		PageUtilities.enterText(Salescommissionbox, salescommissionpercentage);
		return username;
				
		
		
	}
	public void clickOnSaveButton() {
		PageUtilities.clickOnElement(Submituserbuttonoption);
	}

	public void enterUserToSearch(String username) {
		WaitUtility.waitForElementVisibility(searchButton, 5);
		PageUtilities.enterText(searchButton, username);
	
}
	public void deleteUser() {
		PageUtilities.clickOnElement(deleteButton);
		PageUtilities.clickOnElement(areYouSureDeletebutton);
	}
	public String validatingTheMessage() {
		return(PageUtilities.getElementText(DeletedErrorDetector));
	}
}










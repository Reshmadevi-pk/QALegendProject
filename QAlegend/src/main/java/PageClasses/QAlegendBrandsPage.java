package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QAlegendBrandsPage {
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Brands']")
	WebElement BrandButton;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement Addbrandbutton;
	
    @FindBy(id = "name")
    WebElement Brandname;
    
    @FindBy(id = "description")
    WebElement ShortDescription;
    
    @FindBy(xpath = "//button[text()='Save']")
    WebElement Brandsavebutton;
    
    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement brandSearchbutton;
    
    @FindBy(xpath = "(//tr[@role='row']//td)[1]")
    WebElement brandMessagedisplay;


public QAlegendBrandsPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void clickOnBrandOption() {
	
	//PageUtilities.clickOnElement(BrandButton);
	BrandButton.click();
}
public void clickOnAddBrandOption() {
	//PageUtilities.clickOnElement(Addbrandbutton);
	Addbrandbutton.click();
}
public void insertBrandDetails(String brandname,String shortdescrip) {
	PageUtilities.enterText(Brandname, brandname);
	PageUtilities.enterText(ShortDescription, shortdescrip);
}
public void clickOnSaveBrandButton() {
	//PageUtilities.clickOnElement(Brandsavebutton);
	Brandsavebutton.click();
}
public void enterBrandsearch(String Brandname) {
	WaitUtility.waitForElementVisibility(brandSearchbutton, 5);
	//PageUtilities.enterText(brandSearchbutton, Brandname);
	brandSearchbutton.sendKeys(Brandname);
}
public  boolean brandMessageDisplay() {
	return(PageUtilities.isElementDisplayed(brandMessagedisplay));
			
			
			
			
			
			
}
}
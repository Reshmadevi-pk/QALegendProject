package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendProductsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//i[@class='fa fa-cubes'])[1]")
	WebElement Productsbutton;
	
	@FindBy(xpath = "(//i[@class='fa fa-list'])[1]")
	WebElement Listproductsbutton;
	
	@FindBy(xpath = "//a[@class='btn btn-primary pull-right']")
	WebElement Addproducts;
	
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement Productname;
	
	
	@FindBy(xpath = "//select[@id='brand_id']")
	WebElement Brand;
	
	@FindBy(xpath = "(//select[@class='form-control select2 select2-hidden-accessible'])[2]")
	WebElement Unit;
	
	
	@FindBy(id = "//*[@name='category_id']")
	WebElement Category;
	
	@FindBy(id = "select2-barcode_type-container")
	WebElement Barcode;
	
	
	@FindBy(id = "alert_quantity")
	WebElement Alertquantity;
	
	@FindBy(id = "select2-tax_type-container")
	WebElement SellingPriceTaxType;
	
	@FindBy(id = "select2-type-container")
	WebElement ProductType;
	
	@FindBy(id = "single_dpp")
	WebElement ExcTax;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Productssavebutton;
	
	public QAlegendProductsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void clickOnProductsOption() {
		
		PageUtilities.clickOnElement(Productsbutton);
	}
	public void clickOnListProductsOption() {
		PageUtilities.clickOnElement(Listproductsbutton);
	}
	public void clickOnAddProductsOption() {
		PageUtilities.clickOnElement(Addproducts);
	}
	public void insertProductsDetails(String name,String brand,String productunit,String category,String barcode,
			String alertquantity,String sellingpricetax,String producttype,String exctac) {
		
		PageUtilities.enterText(Productname, name);
		PageUtilities.dropdownSelectByVisibleText(Brand, brand);
		PageUtilities.dropdownSelectByVisibleText(Unit, productunit);
		PageUtilities.dropdownSelectByVisibleText(Category, category);
		PageUtilities.dropdownSelectByVisibleText(Barcode, barcode);
		PageUtilities.enterText(Alertquantity, alertquantity);
		PageUtilities.dropdownSelectByVisibleText(SellingPriceTaxType, sellingpricetax);
		PageUtilities.dropdownSelectByVisibleText(ProductType, producttype);
		PageUtilities.enterText(ExcTax, exctac);
		
		
	}
	
}	
	
	
	
	
	
	
	
	

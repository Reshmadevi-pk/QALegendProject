package QAlegendTestCases;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QAlegendBrandsPage;
import PageClasses.QAlegendContactsPage;
import PageClasses.QAlegendCustomerGroupsPage;
import PageClasses.QAlegendCustomersPage;
import PageClasses.QAlegendHomePage;
import PageClasses.QAlegendLoginPage;

import PageClasses.QAlegendProductsPage;
import PageClasses.QAlegendRolesPage;
import PageClasses.QAlegendSalesCommissionPage;
import PageClasses.QAlegendUserPage;
import PageClasses.QAlegendVariations;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.WaitUtility;

public class TestCases extends BaseClass{
	
	WebDriver driver;
	QAlegendLoginPage loginpage;
	QAlegendHomePage homepage;
	QAlegendUserPage userpage;
	QAlegendRolesPage rolepage;
	QAlegendSalesCommissionPage salescommissionpage;
	QAlegendContactsPage contactspage;
	QAlegendCustomersPage customerpage;
	QAlegendCustomerGroupsPage customergroupspage;
	QAlegendProductsPage productspage;
	QAlegendBrandsPage brandspage;
	QAlegendVariations variationpage;
	Properties prop;//prop obj declaration properties is class
	FileReader reader;
	
	@BeforeMethod(groups = {"smoketest","regression"})
	@Parameters({"Browser"})
	public void initialization(String browser) throws Exception
	{
	prop=new Properties();
	reader=new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.properties");
	prop.load(reader);
	driver = browserIntialization(browser);// open browser
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize(); // to maximize the page
    loginpage=new QAlegendLoginPage(driver);	
    homepage=new QAlegendHomePage(driver);
    userpage=new QAlegendUserPage(driver);
    rolepage=new QAlegendRolesPage(driver);
    salescommissionpage=new QAlegendSalesCommissionPage(driver);
    contactspage=new QAlegendContactsPage(driver);
    customerpage=new QAlegendCustomersPage(driver);
    customergroupspage=new QAlegendCustomerGroupsPage(driver);
    brandspage=new QAlegendBrandsPage(driver);
    variationpage=new QAlegendVariations(driver);
    productspage=new QAlegendProductsPage(driver);
 
   
}
	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"smoketest"})
	public void createUser() throws IOException, InterruptedException {      
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		homepage.clickOnUserAction();
		userpage.clickOnUserAddOption();
		//userpage.insertUserQAlegend("Mrs","Reshma", "Devi", "Reshmadevi20@gmail.com", "Reshma", "Reshma@28", "Reshma@28","2");
		String username=userpage.insertUserQAlegend(excelFilePath,"Sheet1");
		userpage.clickOnSaveButton();
		userpage.enterUserToSearch("Reshma");
		userpage.deleteUser();
		userpage.enterUserToSearch("Reshma");
		Assert.assertEquals(userpage.validatingTheMessage(), "No matching records found");
		
	
	}
	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"smoketest"})
	public void addRole() throws InterruptedException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		rolepage.clickOnRolesOption();
		rolepage.clickOnAddRolesOption();
		String rolename="ReshmaTester"+FakerUtility.randomNumberGenerator();
		rolepage.enterRoleNameOption(rolename);
		rolepage.clickOnUserTypeOption();
		rolepage.clickOnRolesSaveOption();
		Thread.sleep(2000);
		rolepage.enterRoleToSearch(rolename);
		Assert.assertEquals(rolepage.roleDisplayMessageOption(), true);

	}
	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"smoketest"})
	public void commissionPage() throws IOException, InterruptedException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		salescommissionpage.salesCommissionAgentOption();
		salescommissionpage.clickOnAddSalesCommissionOption();
		String email=salescommissionpage.insertSalesCommisionDetails(excelFilePath,"Sheet2");
		salescommissionpage.clickOnCommissionSaveOption();
		Thread.sleep(2000);
		salescommissionpage.enterSalesCommissionSearch(email);
		Assert.assertEquals(salescommissionpage.rolesMessageDisplay(), true);
		
	}
	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"smoketest"})
	public void contactsPage() throws IOException, InterruptedException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		contactspage.clickOnContactsOption();
		contactspage.clickOnSuppliersOption();
		contactspage.clickOnAddSupplierOption();
		String businessname=contactspage.insertSuppliersDetails(excelFilePath,"Sheet3");
	    contactspage.supplierSaveOption();
	    Thread.sleep(2000);
	    contactspage.enterSupplierSearch(businessname);
	    Assert.assertEquals(contactspage.supplierRolesDisplayOption(), true);
	    
	}
	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"smoketest"})
	public void customersPage() throws IOException, InterruptedException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		contactspage.clickOnContactsOption();
		customerpage.clickOnCustomerOption();
		customerpage.clickonAddCustomerOption();
		String name=customerpage.insertCustomerDetails(excelFilePath,"Sheet4");
		customerpage.clickOnCustomerSaveButton();
	    Thread.sleep(2000);
		customerpage.enterCustomerSerach(name);
		Assert.assertEquals(customerpage.customerMessageDisplay(), true);
		
	}



	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"smoketest"})
	public void variationPage() throws IOException, InterruptedException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		productspage.clickOnProductsOption();
		variationpage.clickOnVariationsoption();
		variationpage.clickOnAddVariationsoption();
		String Variationnametab=prop.getProperty("VariationName")+FakerUtility.randomNumberGenerator();
		String Addvariationvaluestab=prop.getProperty("Addvariationvalues")+FakerUtility.randomNumberGenerator();
		variationpage.insertVariationDetails(Variationnametab, Addvariationvaluestab);
		variationpage.clickOnSaveVariationOption();
		variationpage.enterVariationSearch(Variationnametab);
		Assert.assertEquals(variationpage.variationMessageDisplayButton(), true);

	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"smoketest"})
	public void brandsPage() throws IOException, InterruptedException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		productspage.clickOnProductsOption();
		brandspage.clickOnBrandOption();
		brandspage.clickOnAddBrandOption();
		String brandnameadd=prop.getProperty("Brandname");
		String shortdescriptionadd=prop.getProperty("Shortdescription");	
		brandspage.insertBrandDetails(brandnameadd, shortdescriptionadd);
		brandspage.clickOnSaveBrandButton();
		Thread.sleep(2000);
		brandspage.enterBrandsearch(brandnameadd);
		Assert.assertEquals(brandspage.brandMessageDisplay(), true);
	
	
	}
	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"smoketest"})
	public void customersGroupsPage() throws InterruptedException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		contactspage.clickOnContactsOption();
		customergroupspage.clickOnCustomerGroupOption();
		customergroupspage.clickOnAddCustomerGroupOption();
		String customer=prop.getProperty("CustomerGroupName")+FakerUtility.randomNumberGenerator();
		String calculationpercent=prop.getProperty("CalculationPercentage");
		customergroupspage.insertCustomerGroupsDetails(customer, calculationpercent);
		customergroupspage.clickOnCustomerGroupSaveOption();
        customergroupspage.enterCustomergroups(customer);
		Assert.assertEquals(customergroupspage.customergroupMessageDisplayed(), true);	
		
	}
	@Test
	public void productsPage() throws IOException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		productspage.clickOnProductsOption();
		productspage.clickOnListProductsOption();
		productspage.clickOnAddProductsOption();
		Random rand=new Random();
		int randomnumber=rand.nextInt(10000);
		String productname=ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		String brand=ExcelUtility.getString(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		String unit=ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		String category=ExcelUtility.getString(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		String barcodetype=ExcelUtility.getString(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		String alertquantity=ExcelUtility.getNumeric(1,6,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		String sellingpricetaxtype=ExcelUtility.getString(1,7,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		String producttypeproduct=ExcelUtility.getString(1,8,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		String exctax=ExcelUtility.getNumeric(1,9,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		productspage.insertProductsDetails(productname, brand, unit, barcodetype, alertquantity, sellingpricetaxtype, producttypeproduct, exctax);
		
	}
}
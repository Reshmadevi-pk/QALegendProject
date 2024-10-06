package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendLoginPage {

 WebDriver driver;
 @FindBy(id = "username")
 WebElement usernametextbox;
 
 @FindBy(id = "password")
 WebElement passwordtextbox;
 
 @FindBy(xpath ="//button[@class='btn btn-primary']")
 WebElement loginbutton;
 
 
 
 
 
 
 public QAlegendLoginPage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);	
	// TODO Auto-generated constructor stub
}
 



public void loginToQAlegend(String username,String password) {
	 
	 PageUtilities.enterText(usernametextbox, username);
	 PageUtilities.enterText(passwordtextbox, password);
	 PageUtilities.clickOnElement(loginbutton);
}
}
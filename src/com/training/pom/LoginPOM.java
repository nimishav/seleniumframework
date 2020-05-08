package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

//import static org.testng.AssertJUnit.assertTrue;
//import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.Assert;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[@class='caret']")
	private WebElement MyAccount; 
	
	 //Thread.sleep(2000);
     
	@FindBy(linkText="Login")
     private WebElement login;
     
	@FindBy(name="email")
    private WebElement email;
	
	@FindBy(name="password")
    private WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginbtn;
	

	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginbtn.click(); 
	}
	
	//**********************************************************************
	//http://uniform.upskills.in Page Objects
	//**********************************************************************
	
	public void MyAccountlinkClick() {
		this.MyAccount.click(); 
	}
	
	public void loginlinkClick() {
		this.login.click(); 
	}
	
	//**********************************************************************
	//http://uniform.upskills.in/index.php?route=account/account - Page Objects
	//**********************************************************************
	
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement changPassword;
	
	public void clickchangPassword() {
		this.changPassword.click();
	}
		
	//**********************************************************************
		//http://uniform.upskills.in/index.php?route=account/password - Page Objects
	//**********************************************************************
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement chngpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement chngpasswordcnf;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement Continuebtn;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement errmsg;
	
	public void chngpassword(String chngpassword) {
		
		this.chngpassword.sendKeys(chngpassword);
	}
	
	public void chngpasswordcnf(String chngpasswordcnf) { 
		this.chngpasswordcnf.sendKeys(chngpasswordcnf); 
	}
	
	
	public void Continuebtn() {
		this.loginbtn.click(); 
	}
	
	public void errmsg() {
		System.out.print(this.errmsg.getText()); 
		
	}
	
	
	public void UFM_007() {
		
		String actual1=this.errmsg.getText(); 
		String expected1="Password confirmation does not match password!";
		//assert.assertEquals(actual, expected, "Error Text is Matching");
		//assert.assertEquals("actual", "Password confirmation does not match password! Error message should be get displayed beside Confirm Password textbox");
		//assert.assertEquals(actual1, expected1);
		org.testng.Assert.assertEquals(actual1, expected1);
	}
	
	
	//**********************************************************************
	//http://uniform.upskills.in/index.php?route=account/Uniform Store - Page Objects
//**********************************************************************
	@FindBy(xpath="//a[contains(text(),'Uniform Store')]")
	private WebElement UniformStore;
	
	@FindBy(xpath="//a[contains(text(),'REGULAR T-SHIRTS (Rust)')]")
	private WebElement RustTShirtAddCart;
	
	public void UniformStore() {
		this.UniformStore.click(); 
	}
	public void MousehoverAddCart() {
		Actions act = new Actions(driver);
	        act.moveToElement(RustTShirtAddCart).perform();
		
	}
	
	public void RustTShirtAddCart() {
		this.RustTShirtAddCart.click(); 
	}
	
	//**********************************************************************
	//Add to Cart Page Objects
	//**********************************************************************
	@FindBy(xpath="//select[@id='input-option376']")
	 private WebElement sizeSelect ;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement Addcartbtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement AddToCartSucessMessage;
	
	public void SelectsizeSelect() {
		Select sel = new Select(sizeSelect);     
	     //sel.selectByVisibleText("United States");
	     sel.selectByValue("969");
		
	}
 
	public void AddcartbtnClick() {
		this.Addcartbtn.click(); 
	}
	
		public void UFM_008_Add_to_Cart() {
		//org.testng.Assert.assertFalse(AddToCartSucessMessage);
		//org.testng.Assert.assertTrue(AddToCartSucessMessage);
			
			Boolean AddToCartSucessMessage1 = AddToCartSucessMessage.isDisplayed();
		       
			org.testng.Assert.assertTrue(AddToCartSucessMessage1);	
		
	}
		
		//**********************************************************************
		//View Cart Page Objects
		//**********************************************************************

		@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
		 private WebElement cart ;
		
		@FindBy(xpath="//strong[contains(text(),'View Cart')]")
		private WebElement ViewCart ; 
		
		
		@FindBy(xpath="//button[@class='btn btn-danger']")
		private WebElement RemoveItemFromCart ; 
		
		
		@FindBy(xpath="//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
		private WebElement EmptyCart;
		
		
		@FindBy(xpath="//div[@class='table-responsive']//table[@class='table table-bordered']")
		private WebElement cartWebTable;
		
		public void CartClick() {
			this.cart.click(); 
		}
		public void ViewCartClick() {
			this.ViewCart.click(); 
		}
		
		
		public void RemoveItemFromCartClick() {
			this.RemoveItemFromCart.click(); 
		}
		
		
		
		public void UFM_009_Empty_Cart() {
				Boolean EmptyCartMessage = EmptyCart.isDisplayed();      
				org.testng.Assert.assertTrue(EmptyCartMessage);	
			
		}
		
		public void cartWebTable() {
			
		}
}
	
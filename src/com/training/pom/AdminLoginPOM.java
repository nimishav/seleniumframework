package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertEquals;
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
import org.testng.asserts.SoftAssert;

import common.Assert;

public class AdminLoginPOM {
	private WebDriver driver; 
	
	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Login Page Element
	@FindBy(xpath="//input[@id='input-username']")
	private WebElement username; 
	
	//Login Page Element
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	//Login Page Element
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginbtn;
	
	//Dashboard Page Elements 
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catlog;
	
	
	//Links Under Catalog
		//Product Link 
		@FindBy(xpath="//a[contains(text(),'Products')]")
		private WebElement productlink;
		//Categories Link
		@FindBy(tagName="//a[contains(text(),'Categories')]") 
		private WebElement Categories;
		//Recurring_Profiles Link 
		@FindBy(tagName="//a[contains(text(),'Recurring Profiles')]") 
		private WebElement Recurring_Profiles;
		//Filters Link 
		@FindBy(tagName="//a[contains(text(),'Filters')]") 
		private WebElement Filters;
		//Attributes Link 
		@FindBy(tagName="//a[@class='parent'][contains(text(),'Attributes')]") 
		private WebElement Attributes;
		//Attributes Options 
		@FindBy(tagName="//a[contains(text(),'Options')]") 
		private WebElement Options;
	
	//Product List Element
	@FindBy(xpath="//h3[@class='panel-title']")
	private WebElement panelheading;
	
	@FindBy(xpath="//input[@id='input-name']")
	public WebElement productnameinput;
	
	@FindBy (xpath="//tbody//tr[1]//td[1]//input[1]")
	public WebElement productCheckbox;
	
	@FindBy (xpath="//button[@class='btn btn-danger']")
	public WebElement deleteButton;
	
	@FindBy (xpath="//button[@id='button-filter']")
	private WebElement filterBtn;
	
	@FindBy(xpath="//body//td[3]") 
	List<WebElement> productnamefromwebtable;
	
	@FindBy(xpath="//body//td[5]") 
	List<WebElement> pricefromwebtable;
	 
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement pricetextbox;
	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement productname;
	
	@FindBy(xpath="//select[@id='input-status']")
	private WebElement status;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantity;
	
	@FindBy (xpath="//a[@class='btn btn-primary']")
	private WebElement addproductbtn;
	
	@FindBy (xpath="//input[@id='input-name1']")
	private WebElement addproductname;
	
	@FindBy (xpath="//input[@id='input-meta-title1']")
	private WebElement addmegatitle;
	
	@FindBy (linkText="Data")
	private WebElement Datatab;
	
	@FindBy (linkText="Links")
	private WebElement Linkstab;
	
	@FindBy (xpath="//input[@id='input-model']")
	private WebElement addmodel;
	
	@FindBy (xpath="//input[@id='input-price']")
	private WebElement addprice;
	
	@FindBy (xpath="//input[@id='input-quantity']")
	private WebElement addquantity;
	
	@FindBy (xpath="//input[@id='input-category']")
	private WebElement drpcategory;
	
	@FindBy (xpath="//a[contains(text(),'Design')]")
	private WebElement Designtab;
	
	@FindBy (name="product_layout[0]")
	private WebElement prddrp;
	
	@FindBy (xpath="//i[@class='fa fa-save']")
	private WebElement save;
	
	@FindBy (xpath="//tr[2]//td[8]//a[1]")
	private WebElement edit;
	
	@FindBy (xpath="//div[@class='alert alert-success']")
	private WebElement editsucess;
	

	
		//Login Page Methods
		public void sendusername(String username) {
			this.username.clear();
			this.username.sendKeys(username);
		}
		
		public void sendpassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
		}
		
		public void clickLoginBtn() {
			this.loginbtn.click(); 
		}
		
		public void catlog() {
			Actions act = new Actions(driver);
		    act.moveToElement(catlog).perform();
		    
		}
		public void productlinkclick() {
			productlink.click();
		}
		
		public void panelheadingcheck() {
			String actual1=panelheading.getText();
			System.out.println (actual1);
			String expected1="Product List";
			org.testng.Assert.assertEquals(actual1, expected1);
		}
		
		public void productnameinput(String productnameinput) {
			//this.productnameinput.clear();
			this.productnameinput.sendKeys(productnameinput);
		}	
		
		public void productnameinputchk(String productnameinputchk) {
			//this.productnameinput.clear();
			String productnameinputactual=productname.getAttribute("value");
			String expected1=productnameinputchk;
	    	org.testng.Assert.assertEquals(productnameinputactual, expected1);
		}
		
		public void filterBtn() {
			this.filterBtn.click(); 
		}
		
		 public void linkchk() {
 			//this.productnameinput.clear();
 			org.testng.Assert.assertNotNull(productlink);
 			org.testng.Assert.assertNotNull(Categories);
 			org.testng.Assert.assertNotNull(Recurring_Profiles);
 			org.testng.Assert.assertNotNull(Filters);
 			org.testng.Assert.assertNotNull(Attributes);
 			org.testng.Assert.assertNotNull(Options);
 			
 			
 		}
		
	    public void productnamefromwebtablechk(String productnameinput) {
	    	System.out.println(productnamefromwebtable.size());
	    	
	    	for (WebElement webElement : productnamefromwebtable) {
	            String productname = webElement.getText();
	            	  if (productname.contains("Product Name")) 
	            	  {
	            	System.out.println("ignore first row");
	            	  }
	            else
	            		{
	     	            String expected1=productnameinput;
	     	    		org.testng.Assert.assertEquals(productname, expected1);
	            		}
	    			}
	    		}
	            
	            public void pricetextbox(String pricetextbox) {
	    			//this.productnameinput.clear();
	    			this.pricetextbox.sendKeys(pricetextbox);
	    		}	
	            
	            
	            public void pricetextboxinputchk(String pricetextboxinputchk) {
	    			//this.productnameinput.clear();
	    			String productnameinputactual=pricetextbox.getAttribute("value");
	    			String expected1=pricetextboxinputchk;
	    	    	org.testng.Assert.assertEquals(productnameinputactual, expected1);
	    			
	    		}
	            
	            
	            public void pricefromwebtabletablechk(String priceinput) {
	            	
	    	    	System.out.println(productnamefromwebtable.size());
	    	    	for (WebElement webElement : pricefromwebtable) {
	    	            String price = webElement.getText();
	    	            if (price.contains("Price")) 
	    	            {
	    	            	//System.out.println("ignore first row");
	    	            }
	    	            else
	    	            {
	    	     	         String expected1=priceinput;
	    	     	    	 org.testng.Assert.assertEquals(price, expected1);
	    	     	    }
	    	    	  }
	               }
	           
	            
	            public void StatusSelect(String Status) {
	        		Select sel = new Select(status);     
	        	     sel.selectByVisibleText(Status);
	            }
	            
	            public void StatusSelectchk(String Status) {
	            	String statusselected=status.getAttribute("value");
	    			String expected1=Status;
	    	    	org.testng.Assert.assertEquals(statusselected, expected1);	            	
	            }
	            
	            public void model(String model) {
	    			this.model.sendKeys(model);
	    		}	
	            
	            public void quantity(String quantity) {
	    			this.quantity.sendKeys(quantity);
	    		}
	            
	            public void addproductbtn() {
	            	this.addproductbtn.click();
	            }
	            
	            public void addproductname(String addproductname) {
	            	this.addproductname.sendKeys(addproductname);
	            }
	            
	            public void addmegatitle(String addmegatitle) {
	            	this.addmegatitle.sendKeys(addmegatitle);
	            }
	            
	            public void Datatab() {
	            	this.Datatab.click();
	            }
	            
	            public void addmodel(String addmodel) {
	            	this.addmodel.sendKeys(addmodel);
	            }
	            
	            public void addprice(String addprice) {
	            	this.addprice.sendKeys(addprice);
	            }
	            
	            public void addquantity(String addquantity) {
	            	this.addquantity.clear();
	            	this.addquantity.sendKeys(addquantity);
	            }
	            
	            public void Linkstab() {
	            	this.Linkstab.click();
	            }
	            
	            public void drpcategorySelect(String drpcategoryval) {
	        		 this.drpcategory.sendKeys(drpcategoryval);
	            }
	            
	            public void Designtab() {
	            	this.Designtab.click();
	            }
	            
	            public void prddrpSelect(String prddrpval) {
	        		Select sel = new Select(prddrp);     
	        	     sel.selectByVisibleText(prddrpval);
	            }
	            
	            public void save() {
	            	this.save.click();
	            }
	            
	            public void edit() {
	            	this.edit.click();
	            }
	            
	            public void productsavecheck() {
	    			String actual1=editsucess.getText();
	    			System.out.println (actual1);
	    			//String expected1="Success: You have modified products!";
	    			org.testng.Assert.assertTrue(actual1.contains("Success"));  
	    		}
	            
	           
}
	

	

	
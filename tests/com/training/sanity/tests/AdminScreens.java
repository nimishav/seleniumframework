package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminScreens {

	private WebDriver driver;
	private String baseUrl;
	private com.training.pom.AdminLoginPOM AdminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
	
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

				
				//***************************
				//UNF_041
				//To verify whether application allows the user to remove added product details from cart
				//***************************
				@Test(priority =1, enabled=true)
				public void AdminProductTest() throws InterruptedException {
				// open the browser 
				driver = DriverFactory.getDriver(DriverNames.CHROME);
				AdminLoginPOM = new com.training.pom.AdminLoginPOM(driver); 
				baseUrl = properties.getProperty("baseURL");
				screenShot = new ScreenShot(driver);
				driver.get(baseUrl);	
				//Login
				Thread.sleep(1000);
				AdminLoginPOM.sendusername("admin");
				AdminLoginPOM.sendpassword("admin@123");
				AdminLoginPOM.clickLoginBtn(); 
				screenShot.captureScreenShot("UNF_041_Login");
				Thread.sleep(1000);
				AdminLoginPOM.catlog();
				
				Thread.sleep(1000);
				AdminLoginPOM.productlinkclick();
				Thread.sleep(1000);
				//assertion for Product List Page
				AdminLoginPOM.panelheadingcheck();
				AdminLoginPOM.productnameinput("Blazer Girls(7-8)");
				Thread.sleep(2000);
				//assertion for Product input
				AdminLoginPOM.productnameinputchk("Blazer Girls(7-8)");
				AdminLoginPOM.filterBtn();
				screenShot.captureScreenShot("UNF_041_Productnamefilter");
				//assertion for Filtered result
				AdminLoginPOM.productnamefromwebtablechk("Blazer Girls(7-8)");
				
				AdminLoginPOM.pricetextbox("3000.0000");
				AdminLoginPOM.pricetextboxinputchk("3000.0000");
				AdminLoginPOM.filterBtn();
				screenShot.captureScreenShot("UNF_041_Pricefilter");
				AdminLoginPOM.pricetextboxinputchk("3000.0000");
				AdminLoginPOM.pricefromwebtabletablechk("3000.0000");
				
				AdminLoginPOM.StatusSelect("Enabled");
				AdminLoginPOM.filterBtn();
				
				AdminLoginPOM.model("BLG-112");
				AdminLoginPOM.filterBtn();
				Thread.sleep(1000);
				AdminLoginPOM.quantity("1");
				AdminLoginPOM.filterBtn();
				
				screenShot.captureScreenShot("UNF_041_filter");
				
				
				}
				
				//***************************
				//UNF_042
				//To Verify whether application allows admin to add product by entering valid credentials in mandatory fields only
				//***************************
				@Test(priority =1, enabled=true)
				public void AddProductTest() throws InterruptedException {
				// open the browser 
				driver = DriverFactory.getDriver(DriverNames.CHROME);
				AdminLoginPOM = new com.training.pom.AdminLoginPOM(driver); 
			    baseUrl = properties.getProperty("baseURL");
			    screenShot = new ScreenShot(driver);
				driver.get(baseUrl);	
				//Login
				Thread.sleep(1000);
				AdminLoginPOM.sendusername("admin");
				AdminLoginPOM.sendpassword("admin@123");
				AdminLoginPOM.clickLoginBtn(); 
				screenShot.captureScreenShot("UNF_042_Login");
				Thread.sleep(1000);
				AdminLoginPOM.catlog();
				
				Thread.sleep(1000);
				AdminLoginPOM.productlinkclick();
				AdminLoginPOM.addproductbtn();
				AdminLoginPOM.addproductname("Shirt");
				AdminLoginPOM.addmegatitle("Shirt for girls");
				screenShot.captureScreenShot("UNF_042_SC1");
				AdminLoginPOM.Datatab();
				AdminLoginPOM.addmodel("SHG-010");
				Thread.sleep(1000);
				AdminLoginPOM.addquantity("50");
				
				screenShot.captureScreenShot("UNF_042_SC2");
				
				Thread.sleep(1000);
				
				AdminLoginPOM.Linkstab();
				AdminLoginPOM.drpcategorySelect("470");
				screenShot.captureScreenShot("UNF_042_SC3");
				
				AdminLoginPOM.Designtab();
				AdminLoginPOM.prddrpSelect("Default");
				AdminLoginPOM.save();
				AdminLoginPOM.productsavecheck();
				screenShot.captureScreenShot("UNF_042_SC4");
				}
				
				//***************************
				//UNF_043
				//To verify whether application allows admin to edit Quantity details of a product
				//***************************
				
				@Test(priority =1, enabled=true)
				public void EditProductTest() throws InterruptedException {
				// open the browser 
				driver = DriverFactory.getDriver(DriverNames.CHROME);
				AdminLoginPOM = new com.training.pom.AdminLoginPOM(driver); 
				baseUrl = properties.getProperty("baseURL");
				screenShot = new ScreenShot(driver);
				driver.get(baseUrl);	
	
				//Login
				Thread.sleep(1000);
				AdminLoginPOM.sendusername("admin");
				AdminLoginPOM.sendpassword("admin@123");
				AdminLoginPOM.clickLoginBtn(); 
				screenShot.captureScreenShot("UNF_043_Login");
				Thread.sleep(1000);
				AdminLoginPOM.catlog();
				Thread.sleep(1000);
				AdminLoginPOM.linkchk();
				AdminLoginPOM.productlinkclick();
				Thread.sleep(1000);
				//assertion for Product List Page
				AdminLoginPOM.panelheadingcheck();
				AdminLoginPOM.productnameinput("Blazer Girls(7-8)");
				AdminLoginPOM.filterBtn();
				AdminLoginPOM.edit();
				
				screenShot.captureScreenShot("UNF_043_SC1");
				AdminLoginPOM.Datatab();
				AdminLoginPOM.addquantity("100");
				AdminLoginPOM.save();
				AdminLoginPOM.productsavecheck();
				screenShot.captureScreenShot("UNF_043_SC2");
				
				}
				
								
}
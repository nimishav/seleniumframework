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

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
		
        //***********************
		//UFM_007
		//To verify whether application displays error message upon mis matching password & 
	    //confirm password of Change Your Password page
		//***********************
				@Test(priority =1, enabled=true)
				public void ChangePasswordMSGTest() throws InterruptedException {
			
				loginPOM.MyAccountlinkClick();
				Thread.sleep(1000);
				loginPOM.loginlinkClick();	

				//Login
				loginPOM.sendemail("nimisha.vaidya@gmail.com");
				loginPOM.sendPassword("ABCDEF123;");
				loginPOM.clickLoginBtn(); 
				screenShot.captureScreenShot("UFM_007_Login");
				Thread.sleep(1000);
				
				//Change Password
				loginPOM.clickchangPassword();
				Thread.sleep(1000);
				loginPOM.chngpassword("ABCDEF123;");
				loginPOM.chngpasswordcnf("ABCDEF123");
				loginPOM.Continuebtn(); 
				screenShot.captureScreenShot("UFM_007_ChangePassword");
				loginPOM.errmsg();
				loginPOM.UFM_007();
				}

		//***************************
		//UFM__008
		//To verify whether application allows the user to add product details into cart
		//***************************
				@Test(priority =2, enabled=true)
				public void AddToCartTest() throws InterruptedException {
					
				loginPOM.MyAccountlinkClick();
				Thread.sleep(1000);
				loginPOM.loginlinkClick();
				screenShot.captureScreenShot("UFM_008_loginlinkClick");
		
				//Login
				Thread.sleep(1000);
				loginPOM.sendemail("nimisha.vaidya@gmail.com");
				loginPOM.sendPassword("ABCDEF123;");
				loginPOM.clickLoginBtn(); 
				screenShot.captureScreenShot("UFM_008_Login");
				
				Thread.sleep(1000);
				loginPOM.UniformStore();
				
				Thread.sleep(1000);
				loginPOM.MousehoverAddCart();	
				loginPOM.RustTShirtAddCart();
				screenShot.captureScreenShot("UFM_008_RustTShirtAddCart");
				loginPOM.SelectsizeSelect();
				loginPOM.AddcartbtnClick();
				screenShot.captureScreenShot("UFM_008_AddCart1");
				loginPOM.UFM_008_Add_to_Cart();
				loginPOM.CartClick();
				Thread.sleep(1000);
				screenShot.captureScreenShot("UFM_008_ViewCart01");
				Thread.sleep(1000);
				loginPOM.ViewCartClick();
				screenShot.captureScreenShot("UFM_008_ViewCart02");
				
				}
		
			//***************************
			//UFM__009
			//To verify whether application allows the user to remove added product details from cart
			//***************************
				@Test (priority =1, enabled=true)
				public void RemoveItemFromCartTest() throws InterruptedException {
					
				loginPOM.MyAccountlinkClick();
				Thread.sleep(1000);
				loginPOM.loginlinkClick();
				screenShot.captureScreenShot("UFM_009_loginlinkClick");

				//Login
				Thread.sleep(1000);
				loginPOM.sendemail("nimisha.vaidya@gmail.com");
				loginPOM.sendPassword("ABCDEF123;");
				loginPOM.clickLoginBtn(); 
				screenShot.captureScreenShot("UFM_009_Login");
				
				Thread.sleep(1000);
				loginPOM.UniformStore();
				
				Thread.sleep(1000);
				loginPOM.MousehoverAddCart();	
				loginPOM.RustTShirtAddCart();
				screenShot.captureScreenShot("UFM_009_RustTShirtAddCart");
				loginPOM.SelectsizeSelect();
				loginPOM.AddcartbtnClick();
				screenShot.captureScreenShot("UFM_009_AddCart1");
				loginPOM.UFM_008_Add_to_Cart();
				loginPOM.CartClick();
				Thread.sleep(1000);
				screenShot.captureScreenShot("UFM_009_ViewCart01");
				Thread.sleep(1000);
				loginPOM.ViewCartClick();
				screenShot.captureScreenShot("UFM_009_ViewCart02");
				loginPOM.RemoveItemFromCartClick();
				loginPOM.UFM_009_Empty_Cart();
				
			}
}

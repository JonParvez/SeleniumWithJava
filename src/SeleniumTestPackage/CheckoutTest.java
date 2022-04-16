package SeleniumTestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutTest {

	public static void main(String[] args) throws InterruptedException {
		SignUpPOM signUpObj;
	    CheckOutPOM checkOutObj;
	    ProductPOM productObj;

	    //SETUP
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//TEST
		try {
			signUpObj = new SignUpPOM(driver);
			
			//sign up for user 1
			signUpObj.SignUp("nahidasultana6@gmail.com", "Nahida", "Sultana", "nahida", "Dhaka", "Dhaka", "Texas", "11111", "+1202-555-0410");
			Thread.sleep(2000);
			//sign up for user 2
			signUpObj.SignUp("nahidasultana7@gmail.com", "Nahida", "Sultana", "nahida", "Dhaka", "Dhaka", "Texas", "11111", "+1202-555-0410");
			Thread.sleep(2000);
			
			//sign in for user 1
			signUpObj.SignIn("nahidasultana6@gmail.com", "nahida");
			Thread.sleep(3000);
			
			//Products adding to cart
			productObj = new ProductPOM(driver);
			productObj.AddToCart();
			Thread.sleep(2000);
			
			//Proceed to checkout and confirm order
			checkOutObj = new CheckOutPOM(driver);
			checkOutObj.CheckOut();
		    Thread.sleep(3000);
		    
		    //sign out
		    signUpObj.SignOut();
		    Thread.sleep(3000);
		    
		    //sign in for user 2
			signUpObj.SignIn("nahidasultana7@gmail.com", "nahida");
			Thread.sleep(3000);
			
			//Products adding to cart
			productObj = new ProductPOM(driver);
			productObj.AddToCart();
			Thread.sleep(2000);
			
			//Proceed to checkout and confirm order
			checkOutObj = new CheckOutPOM(driver);
			checkOutObj.CheckOut();
		    Thread.sleep(3000);
		    
		    //sign out
		    signUpObj.SignOut();
		    Thread.sleep(3000);
		    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
		}
	    
        //EXIT
        driver.quit();
       
    }
}

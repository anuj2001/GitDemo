package RahulShettyAcademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.Checkout;
import RahulShettyAcademy.pageobjects.ConfirmationPage;
import RahulShettyAcademy.pageobjects.LandingPage;
import RahulShettyAcademy.pageobjects.ProductCatalogue;
public class ErrorValidation extends BaseTest {
		@Test(groups= {"Error Handling"})
		public void loginErrorValidation() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("agupta14_be20@thapar.edu", "@Neheart");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
			
		}
		
		@Test
		public void productErrorValidation() throws InterruptedException, IOException{
			// TODO Auto-generated method stub
			String productName="ZARA COAT 3";
			ProductCatalogue productCatalogue = landingPage.loginApplication("agupta14_be20@thapar.edu", "@Neheart1");
			List<WebElement> products=productCatalogue.getProductsList();
			WebElement prod=productCatalogue.getProductByName(productName);
			productCatalogue.addProductToCart("ZARA COAT 420");
			CartPage cartPage = productCatalogue.goToCartPage();
			Boolean match=cartPage.verifyProductDisplay(productName);
			Assert.assertTrue(match);			
			}

}

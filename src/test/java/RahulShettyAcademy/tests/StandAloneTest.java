package RahulShettyAcademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.Checkout;
import RahulShettyAcademy.pageobjects.ConfirmationPage;
import RahulShettyAcademy.pageobjects.LandingPage;
import RahulShettyAcademy.pageobjects.OrderPage;
import RahulShettyAcademy.pageobjects.ProductCatalogue;
public class StandAloneTest extends BaseTest {
		String productName="ZARA COAT 3";
		@Test(dataProvider="getData",groups="Purchase")
		public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products=productCatalogue.getProductsList();
		WebElement prod=productCatalogue.getProductByName(input.get("product"));
		productCatalogue.addProductToCart(input.get("product"));
		
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match=cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);

//		Checkout checkout=cartPage.goToCheckout();
//		checkout.SelectCountry("India");
//		ConfirmationPage confirmation=checkout.Submit();
//		
//		String confirmMessage = confirmation.getConfirmationMessage();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
////		driver.close();
		
		}
		
		@Test(dependsOnMethods= {"submitOrder"})
		public void OrderHistory() {
			ProductCatalogue productCatalogue = landingPage.loginApplication("agupta14_be20@thapar.edu", "@Neheart1");
			OrderPage orderPage=productCatalogue.goToOrderPage();
			Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
		}
		
		public String getScreenshot(String testCaseName) throws IOException {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File file=new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		}
		@DataProvider
		public Object[][] getData() {
			HashMap<String, String> map=new HashMap<String,String>();
			map.put("email", "agupta14_be20@thapar.edu");
			map.put("password", "@Neheart1");
			map.put("product", "ZARA COAT 3");
			
			HashMap<String, String> map1=new HashMap<String,String>();
			map1.put("email", "anuj76913@gmail.com");
			map1.put("password", "@Neheart1");
			map1.put("product", "ADIDAS ORIGINAL");
			return new Object[][] {{map},{map1}};
		}
		
}

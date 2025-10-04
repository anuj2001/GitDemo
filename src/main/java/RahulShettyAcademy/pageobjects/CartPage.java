package RahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".items")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement Checkout;
	
	By productsBy = By.cssSelector("h3");

	public Boolean verifyProductDisplay(String productName) {
		return cartProducts.stream().anyMatch(product->product.findElement(productsBy).getText().equals(productName));
	}
	
	public Checkout goToCheckout() {
		Checkout.click();
		Checkout checkout=new Checkout(driver);
		return checkout;
	}
}

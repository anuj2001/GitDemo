package RahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".w-10");
	By toastMessage = By.cssSelector(".toast-message");
	public List<WebElement> getProductsList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	public WebElement getProductByName(String productName) {
		return getProductsList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
}

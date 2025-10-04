package RahulShettyAcademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class Checkout extends AbstractComponents {
	WebDriver driver;
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement EnterCountry;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	By autosuggestiveDropdown = By.cssSelector(".ta-results");
	
	public void SelectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(EnterCountry, countryName).build().perform();
		waitForElementToAppear(autosuggestiveDropdown);
		SelectCountry.click();
	}
	
	public ConfirmationPage Submit() {
		submit.click();
		ConfirmationPage confirm=new ConfirmationPage(driver);
		return confirm;
	}
}

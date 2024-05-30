package locatorsPgFact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class STCTVPgObj {

	WebDriver driver;
	public STCTVPgObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="translation-btn")
	WebElement trnsBtn;
	
	@FindBy(className="country-current")
	WebElement crntCtry;
	
	@FindBy(id="sa")
	WebElement saCtry;
	
	@FindBy(id="kw")
	WebElement kwCtry;
	
	@FindBy(id="bh")
	WebElement bhCtry;
	
	@FindBy(id="name-lite")
	WebElement nmeLte;
	
	@FindBy(id="currency-lite")
	WebElement currLte;
	
	@FindBy(id="name-classic")
	WebElement nmeCl;
	
	@FindBy(id="currency-classic")
	WebElement currCl;
	
	@FindBy(id="name-premium")
	WebElement nmePrem;
	
	@FindBy(id="currency-premium")
	WebElement currPrem;
	
	public WebElement transalationBtn() {
		return trnsBtn;
	}
	
	public WebElement currentCountry() {
		return crntCtry;
	}
	
	public WebElement saudiCountry() {
		return saCtry;
	}
	
	public WebElement kuwaitCountry() {
		return kwCtry;
	}
	
	public WebElement bahrainCountry() {
		return bhCtry;
	}
	
	public WebElement planNameLite() {
		return nmeLte;
	}
	
	public WebElement litePlanPrice() {
		return currLte;
	}
	
	public WebElement planNameClassic() {
		return nmeCl;
	}
	
	public WebElement classicPlanPrice() {
		return currCl;
	}
	
	public WebElement planNamePremium() {
		return nmePrem;
	}
	
	public WebElement premiumPlanPrice() {
		return currPrem;
	}
}

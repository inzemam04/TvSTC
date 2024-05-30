package subDtlSTCTV;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cmnMthds.MthdsCmn;
import locatorsPgFact.STCTVPgObj;

public class STCTVSubcriptionPlanDetails {

	WebDriver driver;
	STCTVPgObj pgObj;
	@BeforeClass
	public void launchBrowser() throws IOException {
		MthdsCmn cmnMthds=new MthdsCmn();
		String browser=cmnMthds.getPropertyData();
		driver=cmnMthds.getDriver(browser);
		this.driver=driver;
		pgObj=new STCTVPgObj(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //due to waiting a few seconds.10sec
	}
	
	@Test(priority=0)
	@Parameters({"url"})
	public void launchWebSiteUrl(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=1)
	public void changeLngToEng() {
		pgObj.transalationBtn().click();
	}
	
	@Test(dataProvider="getData",dependsOnMethods= {"launchWebSiteUrl","changeLngToEng"})
	public void validateCountrySubscriptionPriceandCurrency(String Ctry,String ltPr, String clPr,String premPr) {
		pgObj.currentCountry().click();
		if(Ctry.equalsIgnoreCase("Saudi")) {
			pgObj.saudiCountry().click();
		}else if(Ctry.equalsIgnoreCase("Kuwait")) {
			pgObj.kuwaitCountry().click();
		}else if(Ctry.equalsIgnoreCase("Bahrain")) {
			pgObj.bahrainCountry().click();
		}
		Assert.assertEquals(pgObj.litePlanPrice().getText().split("/")[0],ltPr, "Lite Subscription Plan Price and Currency is not validated Successfully.");
		Assert.assertEquals(pgObj.classicPlanPrice().getText().split("/")[0], clPr, "Classic Subscription Plan Price and Currency is not validated Successfully.");
		Assert.assertEquals(pgObj.premiumPlanPrice().getText().split("/")[0], premPr, "Premium Subscription Plan Price and Currency is not validated Successfully.");
	}
	
	@AfterClass
	public void ClosingBrowser() {
		driver.quit();
	}
	
	@DataProvider 
	public Object[][] getData(){
		Object[][] data=new Object[3][4];
		data[0][0]="Saudi";
		data[0][1]="15 SAR";
		data[0][2]="25 SAR";  //parameterization 
		data[0][3]="60 SAR";
		data[1][0]="Kuwait";
		data[1][1]="1.2 KWD";
		data[1][2]="2.5 KWD";
		data[1][3]="4.8 KWD";
		data[2][0]="Bahrain";
		data[2][1]="2 BHD";
		data[2][2]="3 BHD";
		data[2][3]="6 BHD";
		return data; // stored expected data in dataProvider
	}
	
	
}

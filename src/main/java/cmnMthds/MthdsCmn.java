package cmnMthds;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MthdsCmn {
	

	WebDriver driver;
	static String usrDir=System.getProperty("user.dir");
	public static String getPropertyData() throws IOException {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(usrDir+"\\src\\test\\resources\\config\\config.properties");
		prop.load(fis);
		return prop.getProperty("browser");
	}
	
	public WebDriver getDriver(String drvrNme) {
		if(drvrNme.contains("Chrome")) {
			driver=new ChromeDriver();
		}else if(drvrNme.contains("Firefox")) {
			driver=new FirefoxDriver();
		}else if(drvrNme.contains("Edge")) {
			driver=new EdgeDriver();
		}else if(drvrNme.contains("Safari")) {
			driver = new SafariDriver(); 
		}else {
			driver=new InternetExplorerDriver();
		}
		return driver;
	}
	
	

}
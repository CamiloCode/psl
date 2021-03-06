package selenium.artifact.maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class AutomationTest {

	@Test
	public void TestFireFox(){

		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");	
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		
		//nice record
		driver.get("http://automatizacion.herokuapp.com/ocontreras/");		
		PageObject.agendarCitas(driver).click();
		PageObject.datePicker(driver).sendKeys("01/16/2017");
		PageObject.patientID(driver).sendKeys("1120");
		PageObject.doctorID(driver).sendKeys("1121");
		PageObject.saveButton(driver).click();
		String test = PageObject.goodText(driver).getText();
		System.out.println(test);
		
		//wrong record
		driver.get("http://automatizacion.herokuapp.com/ocontreras/");		
		PageObject.agendarCitas(driver).click();
		PageObject.datePicker(driver).sendKeys("01/16/2017");
		PageObject.patientID(driver).sendKeys("1120");
		PageObject.doctorID(driver).sendKeys("1122");
		PageObject.saveButton(driver).click();
		test = PageObject.errorText(driver).getText();
		System.out.println(test);
		driver.quit();

	}


	public void TestChrome(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		// To remove message "You are using an unsupported command-line flag: --ignore-certificate-errors.
		// Stability and security will suffer."
		// Add an argument 'test-type'
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		//capabilities.setCapability("chrome.binary","chromedriver.exe");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.get("http://automatizacion.herokuapp.com/ocontreras/");
		driver.quit();

	}

}
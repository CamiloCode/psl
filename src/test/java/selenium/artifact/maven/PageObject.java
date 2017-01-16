package selenium.artifact.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

	private static WebElement element = null;

	public static WebElement agendarCitas(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.cssSelector(".list-group-item:nth-of-type(6)")));
		element = driver.findElement(By.cssSelector(".list-group-item:nth-of-type(6)"));
		return element;

	}

	public static WebElement datePicker(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker")));
		element = driver.findElement(By.id("datepicker"));
		return element;

	}
	
	public static WebElement patientID(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.cssSelector("label[for=patient-identification] + input")));
		element = driver.findElement(By
				.cssSelector("label[for=patient-identification] + input"));
		return element;

	}
	
	public static WebElement doctorID(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.cssSelector("label[for=doctor-identification] + input")));
		element = driver.findElement(By
				.cssSelector("label[for=doctor-identification] + input"));
		return element;

	}
	
	public static WebElement saveButton(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.cssSelector("a.btn.btn-primary.pull-right")));
		element = driver.findElement(By
				.cssSelector("a.btn.btn-primary.pull-right"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		return element;

	}
	
	public static WebElement errorText(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBe(By.cssSelector(".panel-title"), "Error:"));
		element = driver.findElement(By
				.cssSelector(".panel-body p"));
		return element;

	}
	
	public static WebElement goodText(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBe(By.cssSelector(".panel-title"), "Guardado:"));
		element = driver.findElement(By
				.cssSelector(".panel-body p"));
		return element;

	}
}

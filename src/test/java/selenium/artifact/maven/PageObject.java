package selenium.artifact.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

	private static WebElement element = null;

	public static WebElement agendarCitas(WebDriver driver){

		element = driver.findElement(By.cssSelector(".list-group-item:nth-of-type(6)"));
		return element;

	}

	public static WebElement datePicker(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker")));
		element = driver.findElement(By.id("datepicker"));
		return element;

	}
}

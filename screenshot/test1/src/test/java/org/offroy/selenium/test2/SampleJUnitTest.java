package org.offroy.selenium.test2;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.offroy.selenium.test1.JUnitTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumscreensnapper.SeleniumScreenSnapper;

public class SampleJUnitTest extends JUnitTestBase {

	@Before
	public void initPageObjects() {
	}

	@Test
	public void testPageScreenshot() {
		driver.get(baseUrl);
		WebElement searchbox = driver.findElement(By.name("q"));

		SeleniumScreenSnapper screenSnapper = new SeleniumScreenSnapper(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		screenSnapper.createSnapAndThumbnail(searchbox);

		searchbox.sendKeys("cheese");

		WebElement searchButton = wait.until(visibilityOfElementLocated(By.name("btnG")));

		searchButton.click();

		wait.until(visibilityOfElementLocated(By.className("navend")));

		List<WebElement> results = driver.findElements(By.className("g"));

		screenSnapper.createSnapAndThumbnail(results);
	}
}

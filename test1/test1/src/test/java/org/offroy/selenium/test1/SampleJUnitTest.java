package org.offroy.selenium.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.offroy.selenium.test1.pages.HomePage;
import org.openqa.selenium.support.PageFactory;

public class SampleJUnitTest extends JUnitTestBase {

	private HomePage homepage;

	@Before
	public void initPageObjects() {
		homepage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test
	public void testHomePageHasAHeader() throws IOException, InterruptedException {

		driver.get(baseUrl);
		Assert.assertFalse("".equals(homepage.header.getText()));
	}

}

package org.offroy.selenium.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.offroy.selenium.test1.util.PropertyLoader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import ru.stqa.selenium.factory.WebDriverFactory;

/**
 * Base class for all the JUnit-based test classes
 */
public class JUnitTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @ClassRule
  public static ExternalResource webDriverProperties = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      baseUrl = PropertyLoader.loadProperty("site.url");
      gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
      capabilities = PropertyLoader.loadCapabilities();
    };
  };

  @Rule
  public ExternalResource webDriver = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
    	//testPath();
      driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    };
	private void testPath() throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "start","echo 1");
	    pb.redirectErrorStream(true);
	    Process proc = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            //Handle what you want it to do here
            line = reader.readLine();
        }
        System.out.println("here");

	}

  };
}

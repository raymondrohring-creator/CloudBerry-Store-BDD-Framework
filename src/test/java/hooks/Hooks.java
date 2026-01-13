package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import testBase.BaseClass;

public class Hooks extends BaseClass {
	
	
	
	@Before
	public void beforeScenario(Scenario scenario) {

	    String os = System.getProperty("os", "mac");

	    // 1) Read from testng.xml parameter (if running suite)
	    String browser = null;
	    try {
	        browser = Reporter.getCurrentTestResult()
	                .getTestContext()
	                .getCurrentXmlTest()
	                .getParameter("browser");
	    } catch (Exception ignored) { }

	    // 2) Fallback to -Dbrowser=...
	    if (browser == null || browser.trim().isEmpty()) {
	        browser = System.getProperty("browser", "chrome");
	    }

	    log.info("===== START SCENARIO: {} | OS: {} | Browser: {} =====", scenario.getName(), os, browser);
	    openApp(os, browser);
	}
	
	
	
	
	

	/*
	 * @Before public void beforeScenario(Scenario scenario) { // Defaults if not
	 * passed: mvn test -Dos=windows -Dbrowser=chrome String os =
	 * System.getProperty("os", "windows"); String browser =
	 * System.getProperty("browser", "chrome");
	 * 
	 * log.info("===== START SCENARIO: {} =====", scenario.getName()); openApp(os,
	 * browser); }
	 */

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                // Attach screenshot into Cucumber report & Extent report
                byte[] png = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(png, "image/png", "Failure Screenshot");

                // Also save screenshot to /screenshots using your existing method
                captureScreen("FAILED_" + scenario.getName().replaceAll("\\s+", "_"));
            }
        } finally {
            closeApp();
            log.info("===== END SCENARIO: {} =====", scenario.getName());
        }
    }
}

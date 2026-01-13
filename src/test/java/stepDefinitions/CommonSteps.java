package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import testBase.BaseClass;

public class CommonSteps extends BaseClass {

    @Given("user opens the application")
    public void user_opens_the_application() {
        getDriver().get(p.getProperty("appURL"));
        log.info("Opened application URL: {}", p.getProperty("appURL"));
    }

    @Then("application home page should be displayed")
    public void application_home_page_should_be_displayed() {
        String title = getDriver().getTitle();
        log.info("Home page title: {}", title);
        Assert.assertTrue(title != null && !title.trim().isEmpty(), "Home page title is empty - page may not have loaded");
    }

    @Then("page title should contain {string}")
    public void page_title_should_contain(String expected) {
        String title = getDriver().getTitle();
        log.info("Asserting title contains: {} | actual: {}", expected, title);
        Assert.assertTrue(title.toLowerCase().contains(expected.toLowerCase()),
                "Expected title to contain [" + expected + "] but was [" + title + "]");
    }
}

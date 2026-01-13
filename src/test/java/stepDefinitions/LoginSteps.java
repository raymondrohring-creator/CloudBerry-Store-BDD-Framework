package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import testBase.BaseClass;

public class LoginSteps extends BaseClass {

    private HomePage home;
    private LoginPage login;

    @When("user navigates to login page")
    public void user_navigates_to_login_page() {
        home = new HomePage(getDriver());
        home.clickMyAccount();
        home.goToLogin();
        log.info("Navigated to Login page");
    }

    @When("user enters valid email and password")
    public void user_enters_valid_email_and_password() {
        String email = p.getProperty("email");
        String pwd = p.getProperty("password");

        login = new LoginPage(getDriver());
        login.setEmail(email);
        login.setPwd(pwd);

        log.info("Entered credentials from config.properties (email length: {}, pwd length: {})",
                email == null ? 0 : email.length(),
                pwd == null ? 0 : pwd.length());
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        login.clickLogin();
        log.info("Clicked Login button");
    }
    
    
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        // Optional but helpful: wait for page to load after login
        wait.until(ExpectedConditions.urlContains("account"));

        By myAccountHeader = By.xpath("//h1[normalize-space()='My Account']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountHeader));

        Assert.assertTrue(getDriver().findElement(myAccountHeader).isDisplayed(),
                "My Account header not visible after login");
    }
    
	/*
	 * @Then("user should be logged in successfully") public void
	 * user_should_be_logged_in_successfully() { WebDriverWait wait = new
	 * WebDriverWait(getDriver(), Duration.ofSeconds(15));
	 * wait.until(ExpectedConditions.visibilityOf(login.getMyAccountConfirmation()))
	 * ; Assert.assertTrue(login.getMyAccountConfirmation().isDisplayed(),
	 * "My Account header not visible after login"); }
	 */

	/*
	 * @Then("user should be logged in successfully") public void
	 * user_should_be_logged_in_successfully() {
	 * Assert.assertTrue(login.getMyAccountConfirmation().isDisplayed(),
	 * "My Account confirmation was not displayed");
	 * log.info("Login verified using My Account confirmation element"); }
	 */

    // Convenience step used by other features
    @When("user logs in")
    public void user_logs_in() {
        user_navigates_to_login_page();
        user_enters_valid_email_and_password();
        user_clicks_login_button();
        user_should_be_logged_in_successfully();
    }
}

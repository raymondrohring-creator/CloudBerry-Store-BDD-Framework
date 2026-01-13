package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.AffiliatePage;
import testBase.BaseClass;

public class AffiliateSteps extends BaseClass {

    private AffiliatePage affiliate;

    @When("user navigates to affiliate page")
    public void user_navigates_to_affiliate_page() throws InterruptedException {
        affiliate = new AffiliatePage(getDriver());
        affiliate.navigateToAffiliateForm();
        log.info("Navigated to affiliate form");
    }

    @When("user submits affiliate registration details")
    public void user_submits_affiliate_registration_details() throws InterruptedException {
        // Using safe defaults; you can parameterize later via Scenario Outline
        affiliate.fillAffiliateDetails(
                "CloudBerry Test Company",
                "https://cloudberry.services",
                "12345",
                "CloudBerry QA"
        );
        log.info("Submitted affiliate registration details");
    }

    @Then("affiliate registration should be successful")
    public void affiliate_registration_should_be_successful() {
        Assert.assertTrue(affiliate.isAffiliateAdded(), "Affiliate registration success message not displayed");
        log.info("Affiliate registration verified");
    }
}

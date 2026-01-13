package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement link_Laptops;

    @FindBy(xpath = "//a[normalize-space()='Show All Laptops & Notebooks']")
    WebElement link_ShowAll;

    @FindBy(xpath = "//a[normalize-space()='HP LP3065']")
    WebElement product_HP;

    public void clickLaptopsAndNotebooks() throws InterruptedException {
    	
    	// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link_Laptops);

		// Optional: Add a small wait after scrolling to let it stabilize
		Thread.sleep(500);

		// Now click

    	
    	
    	
        link_Laptops.click();
    }

    public void clickShowAll() {
        link_ShowAll.click();
    }

    public void selectHPProduct() {
        By hpProduct = By.xpath("//a[normalize-space()='HP LP3065']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(hpProduct));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);

        // Wait until clickable
        try {
            wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        } catch (Exception e) {
            // Fallback: JS click (handles overlays/sticky headers)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        }
    }
}

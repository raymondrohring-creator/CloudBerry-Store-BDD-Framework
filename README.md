# CloudBerry Store – Hybrid-to-BDD Automation Framework

A **Java-based Hybrid to BDD test automation framework** for the CloudBerry Store web application, built with **Selenium 4, Cucumber 7, TestNG, and Extent Reports**.
This framework supports **readable Gherkin scenarios**, **scalable step definitions**, and **rich execution reporting** for UI regression testing.

---

## 🧩 Technology Stack

| Layer         | Technology       |
| ------------- | ---------------- |
| Language      | Java 21          |
| UI Automation | Selenium 4.23    |
| BDD Engine    | Cucumber 7.18    |
| Test Runner   | TestNG 7.10      |
| Reporting     | Extent Reports 5 |
| Build Tool    | Maven            |
| Logging       | Log4j2           |

---

## 📂 Project Structure

```
CloudBerry_BDD_Framework
│
├── pom.xml
├── testng.xml
├── src
│   └── test
│       ├── java
│       │   ├── runners
│       │   │   └── TestRunner.java
│       │   ├── hooks
│       │   │   └── Hooks.java
│       │   └── stepDefinitions
│       │       ├── LoginSteps.java
│       │       ├── ShoppingSteps.java
│       │       ├── AffiliateSteps.java
│       │       └── CommonSteps.java
│       └── resources
│           └── features
│               ├── TC01_LaunchApplication.feature
│               ├── TC02_Login.feature
│               ├── TC03_AddToCart.feature
│               ├── TC04_CompletePurchase.feature
│               └── TC05_AddToWishList.feature
│
├── target
│   ├── cucumber-report.html
│   ├── cucumber.json
│   └── ExtentReport
```

---

## 🧪 What This Framework Tests

This framework automates key CloudBerry Store workflows including:

* Application launch
* User login
* Adding items to cart
* Completing a purchase
* Adding items to a wishlist
* Affiliate scenarios

Each flow is expressed in **Gherkin BDD format** and backed by Selenium-driven step definitions.

---

## 🧾 Sample Feature File

From `TC02_Login.feature`:

```gherkin
Feature: Login to CloudBerry Store

  @regression
  Scenario: User logs in successfully
    Given the user launches the CloudBerry application
    When the user logs in with valid credentials
    Then the user should be logged in successfully
```

---

## 🔧 Sample Step Definition

From `LoginSteps.java`:

```java
@When("the user logs in with valid credentials")
public void userLogsIn() {
    loginPage.enterUsername();
    loginPage.enterPassword();
    loginPage.clickLogin();
}
```

This design cleanly separates **test intent (feature files)** from **implementation (Java steps)**.

---

## 🧪 Test Runner Configuration

The project uses a **Cucumber + TestNG hybrid runner**:

```java
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
```

### What this means

* Only scenarios tagged `@regression` will run
* Reports are generated in:

  * `target/cucumber-report.html`
  * `target/ExtentReport/`

---

## ▶ Running the Tests

### 1. Prerequisites

Make sure you have:

* Java 21+
* Maven 3.8+
* Chrome / Edge browser
* WebDriver binaries (or WebDriverManager)

---

### 2. Run via Maven

```bash
mvn clean test
```

Or run with TestNG suite:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## 📊 Test Reports

After execution, open:

```
target/cucumber-report.html
```

or

```
target/ExtentReport/index.html
```

You will get:

* Scenario-level pass/fail
* Step-level execution
* Screenshots on failure (if enabled in Hooks)
* Execution time & environment

---

## 🧩 Hooks & Test Lifecycle

The `Hooks.java` class is used to:

* Start and quit the WebDriver
* Capture screenshots on failure
* Initialize reports
* Clean up after each scenario

This ensures every scenario is **isolated and repeatable**.

---

## 🏗 Hybrid-to-BDD Design

This framework blends:

* **Hybrid automation** (page objects, reusable utilities, test base)
* with **BDD** (Gherkin + step definitions)

Result:

* Business users read feature files
* QA engineers write Java steps
* Developers get clean, actionable reports

---

## ➕ Adding New Tests

1. Add a new `.feature` file in:

   ```
   src/test/resources/features
   ```

2. Write scenarios using `Given / When / Then`

3. Implement step definitions in:

   ```
   src/test/java/stepDefinitions
   ```

4. Tag the scenario:

   ```gherkin
   @regression
   ```

5. Run:

   ```bash
   mvn test
   ```

---

## 🤝 Contribution Model

* Step definitions are grouped by business area:

  * Login
  * Shopping
  * Affiliate
* Features map directly to business workflows
* Common actions go into `CommonSteps`

This keeps the framework **clean, scalable, and enterprise-ready**.

---

## 🧠 Why This Framework Is Enterprise-Grade

* Tag-driven execution (`@regression`)
* TestNG parallelism ready
* BDD for business visibility
* Extent Reports for leadership
* Modular step definitions
* Selenium 4 modern browser control

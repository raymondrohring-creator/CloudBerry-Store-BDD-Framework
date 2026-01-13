# CloudBerry - Hybrid Selenium to BDD (Cucumber) Framework

## What’s included
- Your existing **Hybrid framework core** reused:
  - `testBase.BaseClass` (ThreadLocal driver, openApp/closeApp, screenshots)
  - All `pageObjects.*`
- Converted to **BDD**:
  - 6 Feature files (TC01..TC06)
  - Step Definitions
  - Hooks (Before/After) integrated with BaseClass
  - TestNG-based Cucumber Runner
- **Extent Reports (Spark)** with Cucumber 7 Adapter

## How to run
From project root:

```bash
mvn test -Dos=mac -Dbrowser=chrome
```

Defaults:
- os=mac
- browser=chrome

Update credentials in:
`src/test/resources/config.properties`

## Reports
- Cucumber HTML: `target/cucumber-report.html`
- Extent Spark: `target/ExtentReport/ExtentSpark.html`

## Notes
- `config.properties` uses:
  - `execution_env=local`
  - `appURL=https://demo.nopcommerce.com/`
- If you run remote execution, update BaseClass settings + any grid URL needed.

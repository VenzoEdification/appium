package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Report;

public class Hooks {

    @Before(order = 0)
    public void initReport() {
        // Initialize ExtentReports only once
        if (Report.getTest() == null) {
            Report.initReport();
        }
    }

    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName();
        Report.createTest(scenarioName);
        Report.logInfo("🚀 Starting scenario: " + scenarioName);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            Report.logFail("❌ Scenario failed: " + scenario.getName());
            // You can attach screenshot here if available
        } else {
            Report.logPass("✅ Scenario passed: " + scenario.getName());
        }
        Report.clearTest();
    }

    @After(order = 1)
    public void tearDown() {
        Report.flushReport();  // Write everything to file
    }
}

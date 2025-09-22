package hooks;

import io.cucumber.java.*;
import utils.Excelutil;
import utils.Report;
//import utils.ScreenshotUtils;

import java.util.Map;

public class Hooks {

    // Optional: store test data globally
    private Map<String, String> testData;

    // 1️⃣ Initialize ExtentReports once before all scenarios
    @BeforeAll
    public static void setupReport() {
        Report.initReport();
    }

    // 2️⃣ Before each scenario
    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName();

        // Create test node in ExtentReports
        Report.createTest(scenarioName);
        Report.logInfo("Scenario started: " + scenarioName);
        Report.logInfo("App launched and scenario started");


    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            Report.logFail("Scenario FAILED: " + scenario.getName());
        } else {
            Report.logPass("Scenario PASSED: " + scenario.getName());
        }

        // Clear the current test from ThreadLocal
        Report.clearTest();
    }

    // 5️⃣ After all scenarios: flush report to HTML
    @AfterAll
    public static void flushReport() {
        Report.flushReport();
    }
}

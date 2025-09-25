package hooks;

import io.cucumber.java.*;
import utils.Report;
//import utils.ScreenshotUtils;

import java.util.Map;

public class Hooks {

    private Map<String, String> testData;

    @BeforeAll
    public static void setupReport() {
        Report.initReport();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName();

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

        Report.clearTest();
    }

    @AfterAll
    public static void flushReport() {

        Report.flushReport();
    }
}

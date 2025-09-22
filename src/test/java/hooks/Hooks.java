package hooks;

import io.cucumber.java.*;
import utils.Excelutil;
import utils.Report;

import java.util.Map;
//import utils.ScreenshotUtils;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName= scenario.getName();
        Report.createTest(scenario.getName());
        Report.logInfo("Scenario started: " + scenario.getName());
        Report.logInfo(" App launched and scenario started");

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
}

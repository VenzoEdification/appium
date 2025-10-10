package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/talentXFeature/TC011_ContractorLogin.feature",
                "src/test/resources/talentXFeature/TC013_CEWithoutAadhar.feature"

        },
        glue = {"stepDefinition/talentX", "hooks"},
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class ContractorUserRunner extends AbstractTestNGCucumberTests {
}

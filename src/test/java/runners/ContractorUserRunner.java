package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
               "src/test/resources/talentXFeature/TC012_CEWithAadhar.feature"
         //    "src/test/resources/talentXFeature/TC013_CEWithoutAadhar.feature"
           //  "src/test/resources/talentXFeature/TC014_Contractorverified.feature"
           //    "src/test/resources/talentXFeature/TC015_CEUnverified.feature"


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

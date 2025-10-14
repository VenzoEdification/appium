package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
               // "src/test/resources/talentXFeature/TC011_CEWithAadhar.feature"
              "src/test/resources/talentXFeature/TC013_CEWithoutAadhar.feature"
                //"src/test/resources/talentXFeature/TC014_COntractorverified.feature"
             //   "src/test/resources/talentXFeature/TC015_CEverified.feature"


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

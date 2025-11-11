package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {

       //   "src/test/resources/talentXFeature/TC009_Signup.feature"
       //  "src/test/resources/talentXFeature/TC010_Jobapply.feature"

               "src/test/resources/talentXFeature/TC001_Login.feature",
                "src/test/resources/talentXFeature/TC002_Personal.feature",
               "src/test/resources/talentXFeature/TC003_Education.feature",
             "src/test/resources/talentXFeature/TC004_Experience.feature",
                "src/test/resources/talentXFeature/TC005_CE.feature",
              "src/test/resources/talentXFeature/TC006_GovernmentId's.feature",
               "src/test/resources/talentXFeature/TC007_BankAccount.feature",
                "src/test/resources/talentXFeature/TC008_NomineeInformation.feature"
        },
        glue = {"stepDefinition/talentX", "hooks"},
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class TalentUserRunner extends AbstractTestNGCucumberTests {
}

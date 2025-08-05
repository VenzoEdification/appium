package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.AfterClass;
import utils.Report;

@CucumberOptions(features = {"src/test/resources/talentXFeature/Login.feature","src/test/resources/talentXFeature/Profile.feature"}, glue = {"stepDefinition/talentX"},
        plugin = {"pretty",
//        "html:Report/cucumberReport.html"
        "html:Report/TestReport.html",
        "json:target/cucumber.json",
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
)
public class TalentxRunner extends AbstractTestNGCucumberTests{
    @AfterClass
    public static void tearDown() {
        // Flush the Extent Reports after tests are done
        Report.flushReports();
    }



}
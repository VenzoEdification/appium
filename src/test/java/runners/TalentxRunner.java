package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import utils.Report;

@CucumberOptions(features = {"src/test/resources/talentXFeature/TC001_Login.feature",
        "src/test/resources/talentXFeature/TC002_Profile.feature",
        "src/test/resources/talentXFeature/TC003_Personal.feature"},  glue = {"stepDefinition/talentX", "hooks"},
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true


)
public class TalentxRunner extends AbstractTestNGCucumberTests{
    @BeforeClass
    public static void setupReport() {
        System.out.println(">> Initializing Extent Report...");
        Report.initReport();
    }
    @AfterClass
    public static void tearDown() {
        // Flush the Extent Reports after tests are done
        Report.flushReport();
    }



}
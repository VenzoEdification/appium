package runners;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import utils.Report;
import utils.SharedDriver;

import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.util.Objects;

@CucumberOptions(features = {"src/test/resources/talentXFeature"}, glue = {"stepDefinition.talentX"},
        plugin = {"pretty",
//        "html:Report/cucumberReport.html"
        "html:test-output/SampleReport.html",
        "json:target/cucumber.json",
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
)
public class TestRunner extends AbstractTestNGCucumberTests{
    @AfterClass
    public static void tearDown() {
        // Flush the Extent Reports after tests are done
        Report.flushReports();
    }


//    @AfterClass
//    public static void tearDown() {
//        if (Objects.nonNull(DriverManager.getDriver())) {
//            Drivers.quitDriver();
//        }
//        stopAppiumServer();
//    }
}
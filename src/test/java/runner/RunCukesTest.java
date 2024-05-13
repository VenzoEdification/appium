package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources"}, glue = {"com/steps"})
public class RunCukesTest extends AbstractTestNGCucumberTests{

}

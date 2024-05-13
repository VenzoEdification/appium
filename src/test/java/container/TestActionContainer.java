package container;

import org.openqa.selenium.WebDriver;

import com.common.util.*;
import com.cucumber.actions.testStepsActions;


public class TestActionContainer {
	private com.common.util.sharedDriver sharedDriver;
	public testStepsActions loginActions;
//	public inboxAction inbact;
	
    public TestActionContainer() {
        try {
            sharedDriver = new sharedDriver();
            WebDriver driver = com.common.util.sharedDriver.driver;
            loginActions = new testStepsActions(driver);
//            inbact = new inboxAction(driver);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

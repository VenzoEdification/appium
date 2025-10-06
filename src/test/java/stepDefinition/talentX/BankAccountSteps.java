package stepDefinition.talentX;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.CommandLineArgs;
import pages.BankAccount;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import utils.extent.CommonMethods;

public class BankAccountSteps extends BankAccount {
    private Map<String, String> testData;

    public BankAccountSteps() throws MalformedURLException {
    }

    @Then("Click Bank Account Tab")
    public void click_bank_account_tab() throws IOException {
        try {
            ClickBankAccount();
            Report.logInfo("Bank Account is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Bank Account: " + e.getMessage());
            throw e;
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/Profile.xlsx", "BankAccount", 1);
        System.out.println("Loaded Test Data: " + testData);

    }

    @Then("Click Account Holder Name")
    public void click_account_holder_name() {
        try {
            ClickAccountHolderName();
            Report.logInfo("Account Holder Name is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click account holder name: " + e.getMessage());
            throw e;
        }

    }

    @When("Enter Account Holder Name {string}")
    public void enter_account_holder_name(String key) {
        try {
            String value = testData.get(key);
            EnterAccountHolderName(value);
            Report.logInfo("Enter Account Holder Name: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Account Holder Name: " + e.getMessage());
            throw e;
        }


    }

    @Then("Click Bank Name")
    public void click_bank_name() {
        try {
            ClickBankName();
            Report.logInfo("Bank Name is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Bank name: " + e.getMessage());
            throw e;
        }

    }

    @When("Enter Bank Name {string}")
    public void enter_bank_name(String key) {
        try {
            String value = testData.get(key);
            EnterBankName(value);
            Report.logInfo("Enter Bank Name: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Bank Name: " + e.getMessage());
            throw e;
        }

    }

    @Then("Click Branch Name")
    public void click_branch_name() {
        try {
            ClickBranchName();
            Report.logInfo("Branch Name is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Branch name: " + e.getMessage());
            throw e;
        }

    }

    @When("Enter Branch Name {string}")
    public void enter_branch_name(String key) {
        try {
            String value = testData.get(key);
            EnterBranchName(value);
            Report.logInfo("Enter Branch Name: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Branch Name: " + e.getMessage());
            throw e;
        }

    }

    @Then("Click IFSC Code")
    public void click_ifsc_code() {
        try {
            ClickIFSC();
            Report.logInfo("IFSC is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click IFSC: " + e.getMessage());
            throw e;
        }

    }

    @When("Enter IFSC Code {string}")
    public void enter_ifsc_code(String key) {
        try {
            String value = testData.get(key);
            EnterIFSC(value);
            Report.logInfo("Enter IFSC Code: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter IFSC: " + e.getMessage());
            throw e;
        }

    }

    @Then("Click Account Number")
    public void click_account_number() {
        try {
            EnterAccountNumber();
            Report.logInfo("Enter Account Number is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Account Number: " + e.getMessage());
            throw e;
        }

    }

    @When("Enter Account Number")
    public void enter_account_number() {
        try {
            EnterAccountNumber();
            Report.logInfo("Enter Account Number: " + CommonMethods.generateAccount(10));
        } catch (Exception e) {
            Report.logFail("Failed to enter Account Number: " + e.getMessage());
            throw e;
        }

    }


    @Then("Click Retype Account Number")
    public void click_retype_account_number() {
        try {
          ClickRetypeAccountNumber();
            Report.logInfo("RetypeAccount Number is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click RetypeAccount Number: " + e.getMessage());
            throw e;
        }

    }

    @When("Enter Retype Account Number")
    public void enter_retype_account_number() {
        try {
            EnterAccountNumber();
            Report.logInfo("Enter RetypeAccount Number: " +CommonMethods.generateAccount(10));
        } catch (Exception e) {
            Report.logFail("Failed to enter Account Number: " + e.getMessage());
            throw e;
        }


    }

}

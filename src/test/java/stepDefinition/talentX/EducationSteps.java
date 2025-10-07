package stepDefinition.talentX;

import io.cucumber.java.en.Then;
import pages.Education;
import utils.Report;

import java.net.MalformedURLException;

public class EducationSteps extends Education {
    public EducationSteps() throws MalformedURLException {
    }

    @Then("Click Education Tab")
    public void clickEducationTab() {
        try {
            ClickEducationTab();
            Report.logInfo("Education  is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Education: " + e.getMessage());
            throw e;
        }

    }

    @Then("Click  Highest Education Level")
    public void clickHighestEducationLevel() {
        try {
            ClickEducationLevel();
            Report.logInfo("Education Level  is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Education Level: " + e.getMessage());
            throw e;
        }
    }

    @Then("Select Highest Educational Level")
    public void selectHighestEducationalLevel() {
        try {
            SelectEducationLevel();
            Report.logInfo(("Education Level is Selected "));

        }catch(Exception e){
            Report.logFail("Failed to Select education level" +e.getMessage());
             throw e;
        }
    }

    @Then("Click Educational field")
    public void clickEducationalField() {
        try {
           ClickEducationField();
            Report.logInfo(("Education Field is Clicked "));

        }catch(Exception e){
            Report.logFail("Failed to click education Field" +e.getMessage());
            throw e;
        }
    }

    @Then("Select Educational field")
    public void selectEducationalField() {
        try {
           SelectEducationField();
            Report.logInfo("Education Field  is Selected");
        } catch (Exception e) {
            Report.logFail("Failed to click Education Field: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Upload File{int}")
    public void clickUploadFile(int arg0) {
        try {
            ClickUploadfile();
            Report.logInfo("Upload File is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Upload file: " + e.getMessage());
            throw e;
        }

    }



    @Then("click Ok button")
    public void clickOkButton() throws InterruptedException {
        try {
            ClickCameraOkButton();
            Report.logInfo("Ok Button is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Ok Button " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Upload document{int}")
    public void clickUploadDocument(int arg0) throws InterruptedException {
        try {
            UploadDocument1();
            UploadDocument2();
            UploadDocument3();
            Report.logInfo("Documents is Uploaded");
        } catch (Exception e) {
            Report.logFail("Failed to upload documents " + e.getMessage());
            throw e;
        }
    }
}

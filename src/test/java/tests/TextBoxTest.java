package tests;

import helpers.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import steps.TextBoxSteps;
import steps.components.ConfigurationComponent;

public class TextBoxTest {

    TestData testData = new TestData();
    TextBoxSteps textBoxSteps = new TextBoxSteps();
    static ConfigurationComponent configurationComponent = new ConfigurationComponent();

    @BeforeAll
    static void beforeAll() {
        configurationComponent.configurationBrowser();
    }

    @Test
    void fullTextBoxForm() {
        textBoxSteps.openPage()
                .setFullName(testData.firstName+" "+testData.lastName)
                .setUserEmail(testData.userEmail)
                .setCurrentAddress(testData.userAddress)
                .setPermanentAddress(testData.userAddress)
                .submit();

        textBoxSteps.checkResult("Name", testData.firstName+" "+testData.lastName)
                .checkResult("Email", testData.userEmail)
                .checkResult("Current Address", testData.userAddress)
                .checkResult("Permananet Address", testData.userAddress);
    }
}

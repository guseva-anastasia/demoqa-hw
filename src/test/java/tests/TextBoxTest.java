package tests;

import helpers.TestData;
import org.junit.jupiter.api.Test;
import steps.TextBoxSteps;

public class TextBoxTest extends TestBase{

    TestData testData = new TestData();
    TextBoxSteps textBoxSteps = new TextBoxSteps();

    @Test
    void fullTextBoxFormTest() {
        textBoxSteps.openPage()
                .setFullName(testData.firstName+" "+testData.lastName)
                .setUserEmail(testData.userEmail)
                .setCurrentAddress(testData.userAddress)
                .setPermanentAddress(testData.userPermanentAddress)
                .submit();

        textBoxSteps.checkResult("Name", testData.firstName+" "+testData.lastName)
                .checkResult("Email", testData.userEmail)
                .checkResult("Current Address", testData.userAddress)
                .checkResult("Permananet Address", testData.userPermanentAddress);
    }
}

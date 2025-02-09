package tests;

import config.CredentialsConfig;
import helpers.TestData;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase{

    TestData testData = new TestData();
    TextBoxPage textBoxPage = new TextBoxPage();

    @Tag("text_box_tests")
    @Test
    void fullTextBoxFormTest() {
        textBoxPage.openPage()
                .setFullName(testData.firstName+" "+testData.lastName)
                .setUserEmail(testData.userEmail)
                .setCurrentAddress(testData.userAddress)
                .setPermanentAddress(testData.userPermanentAddress)
                .submit();

        textBoxPage.checkResult("Name", testData.firstName+" "+testData.lastName)
                .checkResult("Email", testData.userEmail)
                .checkResult("Current Address", testData.userAddress)
                .checkResult("Permananet Address", testData.userPermanentAddress);
    }
}

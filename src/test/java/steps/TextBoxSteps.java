package steps;

import com.codeborne.selenide.SelenideElement;
import steps.components.CheckSubmittingFormComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxSteps {
    private final SelenideElement fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit");;

    CheckSubmittingFormComponent checkSubmittingFormComponent = new CheckSubmittingFormComponent();

    public TextBoxSteps openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxSteps removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxSteps setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxSteps setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxSteps setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public TextBoxSteps setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    public void submit() {
        submitInput.click();
    }

    public TextBoxSteps checkResult(String key, String value) {
        checkSubmittingFormComponent.outputText(key, value);
        return this;
    }

}

package steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import steps.components.CheckSubmittingFormComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static tests.TestBase.*;

public class TextBoxSteps {
    private final SelenideElement fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit");

    CheckSubmittingFormComponent checkSubmittingFormComponent = new CheckSubmittingFormComponent();

    @Step("Открываем страницу "+TEXTBOX)
    public TextBoxSteps openPage() {
        open("/"+TEXTBOX);
        return this;
    }

    @Step("Удаляем баннеры")
    public TextBoxSteps removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Заполняем Full Name")
    public TextBoxSteps setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }
    @Step("Заполняем Email")
    public TextBoxSteps setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }
    @Step("Заполняем Current Address")
    public TextBoxSteps setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    @Step("Заполняем Permanent Address")
    public TextBoxSteps setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    @Step("Нажимаем на кнопку submit")
    public void submit() {
        submitInput.pressEnter();
    }

    @Step("Проверяем корректность сохранения данных пользователя")
    public TextBoxSteps checkResult(String key, String value) {
        checkSubmittingFormComponent.outputText(key, value);
        return this;
    }

}

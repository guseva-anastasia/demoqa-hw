package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static tests.TestBase.*;

public class TextBoxPage {
    private final SelenideElement fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit");

    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @Step("Открываем страницу "+TEXTBOX)
    public TextBoxPage openPage() {
        open(TEXTBOX);
        return this;
    }

    @Step("Удаляем баннеры")
    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Заполняем Full Name")
    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }
    @Step("Заполняем Email")
    public TextBoxPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }
    @Step("Заполняем Current Address")
    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    @Step("Заполняем Permanent Address")
    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    @Step("Нажимаем на кнопку submit")
    public void submit() {
        submitInput.pressEnter();
    }

    @Step("Проверяем корректность сохранения данных пользователя")
    public TextBoxPage checkResult(String key, String value) {
        resultTableComponent.outputText(key, value);
        return this;
    }

}

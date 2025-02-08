package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import steps.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static tests.TestBase.TEXTBOX;

public class RegistrationPageSteps {

    public SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    userNumberInput = $("#userNumber"),
    genderWrapper = $("#genterWrapper"),
    dateOfBirthInput = $("#dateOfBirthInput"),
    subjectInput = $("#subjectsInput"),
    hobbiesInput = $("#hobbiesWrapper"),
    uploadPictureInput = $("#uploadPicture"),
    addressInput = $("#currentAddress"),
    stateInput = $("#react-select-3-input"),
    cityInput = $("#react-select-4-input"),
    submitInput = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем страницу Practice Form")
    public RegistrationPageSteps openPage() {
    open("/automation-practice-form");
          return this;
    }

    @Step("Удаляем баннеры")
    public RegistrationPageSteps removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Заполняем имя")
    public RegistrationPageSteps setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем фамилию")
    public RegistrationPageSteps setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем Email")
    public RegistrationPageSteps setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Указываем пол")
    public RegistrationPageSteps setUserGender (String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Заполняем номер телефона")
    public RegistrationPageSteps setUserNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Указываем дату рождения")
    public RegistrationPageSteps setDateOfBirth (String day, String month, String year) {

        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);

        return this;
    }

    @Step("Указываем предметы")
    public RegistrationPageSteps setSubject (String value) {

        subjectInput.setValue(value).pressEnter();

        return this;
    }
    @Step("Указываем хобби")
    public RegistrationPageSteps setHobbies (String value) {

        hobbiesInput.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем изображение")
    public RegistrationPageSteps setPicture (String value) {

        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    @Step("Заполняем текущий адрес")
    public RegistrationPageSteps setAddress (String value) {

        addressInput.setValue(value);

        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPageSteps setState (String value) {

        stateInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем город")
    public RegistrationPageSteps setCity (String value) {

        cityInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Нажимаем на кнопку submit")
    public RegistrationPageSteps setSubmit () {

        submitInput.scrollIntoView(false).click();

        return this;
    }

    @Step("Проверяем выделение красным обязательных полей")
    public RegistrationPageSteps checkLineHasRedColor (SelenideElement value) {

        value.shouldHave(Condition.cssValue("border-color","rgb(220, 53, 69)"));

        return this;
    }

}

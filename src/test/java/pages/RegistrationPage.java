package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

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
    submitInput = $("#submit"),
    modalContent = $(".modal-content");


    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем страницу Practice Form")
    public RegistrationPage openPage() {
    open("/automation-practice-form");
          return this;
    }

    @Step("Удаляем баннеры")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Заполняем имя")
    public RegistrationPage setFirstName (String value) {
        firstNameInput.scrollTo().setValue(value);

        return this;
    }

    @Step("Заполняем фамилию")
    public RegistrationPage setLastName (String value) {
        lastNameInput.scrollTo().setValue(value);

        return this;
    }

    @Step("Заполняем Email")
    public RegistrationPage setUserEmail (String value) {
        userEmailInput.scrollTo().setValue(value);

        return this;
    }

    @Step("Указываем пол")
    public RegistrationPage setUserGender (String value) {
        genderWrapper.scrollTo().$(byText(value)).click();

        return this;
    }

    @Step("Заполняем номер телефона")
    public RegistrationPage setUserNumber (String value) {
        userNumberInput.scrollTo().setValue(value);

        return this;
    }

    @Step("Указываем дату рождения")
    public RegistrationPage setDateOfBirth (String day, String month, String year) {

        dateOfBirthInput.scrollTo().click();
        calendarComponent.setDate(day,month,year);

        return this;
    }

    @Step("Указываем предметы")
    public RegistrationPage setSubject (String value) {

        subjectInput.scrollTo().setValue(value).pressEnter();

        return this;
    }
    @Step("Указываем хобби")
    public RegistrationPage setHobbies (String value) {

        hobbiesInput.scrollTo().$(byText(value)).click();

        return this;
    }

    @Step("Загружаем изображение")
    public RegistrationPage setPicture (String value) {

        uploadPictureInput.scrollTo().uploadFromClasspath(value);

        return this;
    }

    @Step("Заполняем текущий адрес")
    public RegistrationPage setAddress (String value) {

        addressInput.scrollTo().setValue(value);

        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage setState (String value) {

        stateInput.scrollTo().setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage setCity (String value) {

        cityInput.scrollTo().setValue(value).pressEnter();

        return this;
    }

    @Step("Нажимаем на кнопку submit")
    public RegistrationPage setSubmit () {

        submitInput.scrollTo().click();

        return this;
    }

    @Step("Проверяем отсутствие модального окна с результатом")
    public RegistrationPage checkMissingResultTable () {

        modalContent.shouldNot(appear);

        return this;
    }

}

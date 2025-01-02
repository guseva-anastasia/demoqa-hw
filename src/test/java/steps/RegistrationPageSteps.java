package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import steps.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

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

    public RegistrationPageSteps openPage() {
    open("/automation-practice-form");
          return this;
    }

    public RegistrationPageSteps removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPageSteps setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPageSteps setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPageSteps setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPageSteps setUserGender (String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPageSteps setUserNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPageSteps setDateOfBirth (String day, String month, String year) {

        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);

        return this;
    }

    public RegistrationPageSteps setSubject (String value) {

        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPageSteps setHobbies (String value) {

        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPageSteps setPicture (String value) {

        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPageSteps setAddress (String value) {

        addressInput.setValue(value);

        return this;
    }

    public RegistrationPageSteps setState (String value) {

        stateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPageSteps setCity (String value) {

        cityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPageSteps setSubmit () {

        submitInput.click();

        return this;
    }

    public RegistrationPageSteps checkLineHasRedColor (SelenideElement value) {

        value.shouldHave(Condition.cssValue("border-color","rgb(220, 53, 69)"));

        return this;
    }

}

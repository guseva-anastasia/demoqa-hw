package tests;

import helpers.Attach;
import helpers.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.RegistrationPageSteps;
import steps.components.CheckSubmittingFormComponent;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RegistrationPageTests extends TestBase{

    RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
    CheckSubmittingFormComponent checkSubmittingFormComponent = new CheckSubmittingFormComponent();
    TestData testData = new TestData();


    @Tag("registration")
    @Test
    void successfulRegistrationTest() {
        registrationPageSteps.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setUserGender(testData.gender)
                .setUserNumber(testData.telephoneNumber)
                .setDateOfBirth(testData.BirthDay, testData.BirthMonth, testData.BirthYear)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .setPicture(testData.picture)
                .setAddress(testData.userAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .setSubmit();
        checkSubmittingFormComponent.checkRegistrationResultTable("Student Name",testData.firstName+" "+testData.lastName)
                .checkRegistrationResultTable("Student Email", testData.userEmail)
                .checkRegistrationResultTable("Gender", testData.gender)
                .checkRegistrationResultTable("Mobile", testData.telephoneNumber)
                .checkRegistrationResultTable("Date of Birth", testData.BirthDay+" "+testData.BirthMonth+","+testData.BirthYear)
                .checkRegistrationResultTable("Subjects", testData.subject)
                .checkRegistrationResultTable("Hobbies", testData.hobbies)
                .checkRegistrationResultTable("Picture", testData.picture)
                .checkRegistrationResultTable("Address", testData.userAddress)
                .checkRegistrationResultTable("State and City", testData.userState+" "+testData.userCity);
    }

    @Tag("registration")
    @Test
    void registrationWithOnlyRequiredFieldsTest () {
        registrationPageSteps.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserGender(testData.gender)
                .setUserNumber(testData.telephoneNumber)
                .setDateOfBirth(testData.BirthDay, testData.BirthMonth, testData.BirthYear)
                .setSubmit();
        checkSubmittingFormComponent.checkRegistrationResultTable("Student Name",testData.firstName+" "+testData.lastName)
                .checkRegistrationResultTable("Gender", testData.gender)
                .checkRegistrationResultTable("Mobile", testData.telephoneNumber)
                .checkRegistrationResultTable("Date of Birth", testData.BirthDay+" "+testData.BirthMonth+","+testData.BirthYear);

    }

    @Tag("registration")
    @Test
    void registrationWithNotValidPhoneNumberTest(){
        registrationPageSteps.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserGender(testData.gender)
                .setUserNumber(testData.shortTelephoneNumber)
                .setDateOfBirth(testData.BirthDay, testData.BirthMonth, testData.BirthYear)
                .setSubmit()
                .checkLineHasRedColor(registrationPageSteps.userNumberInput);
    }

    @Tag("registration")
    @Test
    void submitWithEmptyFormTest(){
        registrationPageSteps.openPage()
                .removeBanner()
                .setSubmit()
                .checkLineHasRedColor(registrationPageSteps.firstNameInput)
                .checkLineHasRedColor(registrationPageSteps.lastNameInput)
                .checkLineHasRedColor(registrationPageSteps.userNumberInput);
    }

}

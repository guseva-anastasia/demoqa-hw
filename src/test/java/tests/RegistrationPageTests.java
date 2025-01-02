package tests;

import helpers.TestData;
import org.junit.jupiter.api.Test;
import steps.RegistrationPageSteps;
import steps.components.CheckSubmittingFormComponent;

public class RegistrationPageTests extends TestBase{

    String shortPhoneNumber = "892234353";
    String file = "Cat.jpg";

    RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
    CheckSubmittingFormComponent checkSubmittingFormComponent = new CheckSubmittingFormComponent();
    TestData testData = new TestData();

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
                .setPicture(file)
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
                .checkRegistrationResultTable("Picture", file)
                .checkRegistrationResultTable("Address", testData.userAddress)
                .checkRegistrationResultTable("State and City", testData.userState+" "+testData.userCity);
    }

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

    @Test
    void registrationWithNotValidPhoneNumberTest(){
        registrationPageSteps.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserGender(testData.gender)
                .setUserNumber(shortPhoneNumber)
                .setDateOfBirth(testData.BirthDay, testData.BirthMonth, testData.BirthYear)
                .setSubmit()
                .checkLineHasRedColor(registrationPageSteps.userNumberInput);
    }

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

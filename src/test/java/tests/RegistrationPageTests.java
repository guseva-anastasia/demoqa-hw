package tests;

import helpers.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;

public class RegistrationPageTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    TestData testData = new TestData();


    @Tag("registration_tests")
    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setUserGender(testData.gender)
                .setUserNumber(testData.telephoneNumber)
                .removeBanner()
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .setPicture(testData.picture)
                .setAddress(testData.userAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .setSubmit();
        resultTableComponent.checkRegistrationResultTable("Student Name",testData.firstName+" "+testData.lastName)
                .checkRegistrationResultTable("Student Email", testData.userEmail)
                .checkRegistrationResultTable("Gender", testData.gender)
                .checkRegistrationResultTable("Mobile", testData.telephoneNumber)
                .checkRegistrationResultTable("Date of Birth", testData.birthDay+" "+testData.birthMonth+","+testData.birthYear)
                .checkRegistrationResultTable("Subjects", testData.subject)
                .checkRegistrationResultTable("Hobbies", testData.hobbies)
                .checkRegistrationResultTable("Picture", testData.picture)
                .checkRegistrationResultTable("Address", testData.userAddress)
                .checkRegistrationResultTable("State and City", testData.userState+" "+testData.userCity);
    }

    @Tag("registration_tests")
    @Test
    void registrationWithOnlyRequiredFieldsTest () {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserGender(testData.gender)
                .setUserNumber(testData.telephoneNumber)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubmit();
        resultTableComponent.checkRegistrationResultTable("Student Name",testData.firstName+" "+testData.lastName)
                .checkRegistrationResultTable("Gender", testData.gender)
                .checkRegistrationResultTable("Mobile", testData.telephoneNumber)
                .checkRegistrationResultTable("Date of Birth", testData.birthDay+" "+testData.birthMonth+","+testData.birthYear);

    }

    @Tag("registration_tests")
    @Test
    void registrationWithNotValidPhoneNumberTest(){
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserGender(testData.gender)
                .setUserNumber(testData.shortTelephoneNumber)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubmit()
                .checkMissingResultTable();
    }

    @Tag("registration_tests")
    @Test
    void submitWithEmptyFormTest(){
        registrationPage.openPage()
                .removeBanner()
                .setSubmit()
                .checkMissingResultTable();
    }

}

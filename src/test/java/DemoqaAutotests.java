import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaAutotests {

    String firstName = "Anastasiia";
    String lastName = "Fofanova";
    String email = "afofanova@gmail.com";
    String gender = "Female";
    String phoneNumber = "9998887776";
    String month = "November";
    String year = "1995";
    String day = "11";
    String subjects = "Computer Science";
    String hobbies = "Music";
    String address = "Кудыкина гора д. 13";
    String state = "NCR";
    String city = "Noida";


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(day)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/../resources/Cat.jpg"));
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        $(".table-responsive").shouldHave(text(firstName+" "+lastName));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(phoneNumber));
        $(".table-responsive").shouldHave(text(day+" "+month+","+year));
        $(".table-responsive").shouldHave(text(subjects));
        $(".table-responsive").shouldHave(text(hobbies));
        $(".table-responsive").shouldHave(text(address));
        $(".table-responsive").shouldHave(text(state+" "+city));


    }

}

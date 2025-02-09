package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    public SelenideElement tableResponsive = $(".table-responsive");


    public ResultTableComponent checkRegistrationResultTable (String key, String value) {
        tableResponsive.$(byText(key)).closest("tr").shouldHave(text(value));

        return this;
    }

    public  void outputText(String key, String value){
        $("#output").$(withText(key)).shouldHave(text(value));
    }

}

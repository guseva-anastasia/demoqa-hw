package steps.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    public SelenideElement monthInput = $(".react-datepicker__month-select");
    public SelenideElement yearInput = $(".react-datepicker__year-select");
    public ElementsCollection dayInput = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");

    public void setDate (String day, String month, String year) {
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        dayInput.findBy(text(day)).click();
    }

}

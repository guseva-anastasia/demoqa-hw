package steps.components;

import com.codeborne.selenide.Configuration;

public class ConfigurationComponent {
    public void configurationBrowser (){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen=true;
    }
}

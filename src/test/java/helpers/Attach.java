package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.openqa.selenium.logging.LogType.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Attach {
    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl(getSessionId())
                + "' type='video/mp4'></video></body></html>";
    }

    @Attachment("Screenshot after test")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment("Browser logs ")
    public static String getBrowserLogs() {
        return String.join("\n\n", Selenide.getWebDriverLogs(BROWSER));
    }


    public static URL getVideoUrl(String sessionId) {
        String videoUrl = "https://" + System.getProperty("remoteHost") + "/video/" + sessionId + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }
}

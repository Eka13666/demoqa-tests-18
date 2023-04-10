package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import java.util.Map;

public class TestBase {
  RegistrationPage registrationPage = new RegistrationPage();

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = System.getProperty("base_url");
    Configuration.browser = System.getProperty("browser");
    Configuration.browserSize = System.getProperty("browserSize");
    Configuration.browserVersion = System.getProperty("browserVersion");
    Configuration.remote = "https://user1:1234@" + System.getProperty("remote");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
            "enableVNC", true,  // включает режим окошко_в_окошке
            "enableVideo", true         // включает запись видео
    ));

    Configuration.browserCapabilities = capabilities;
  }
  @BeforeEach
  void addListener() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
  }
}

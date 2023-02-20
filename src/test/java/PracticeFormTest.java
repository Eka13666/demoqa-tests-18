import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
  }
  @Test
  void fillFormTest() {
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");

    $("#firstName").setValue("Eka");
    $("#lastName").setValue("Ekova");
    $("#userEmail").setValue("testtttt@mail.ru");
    $(byText("Female")).click();
    $("#userNumber").setValue("8909990909");
    $(".react-datepicker-wrapper").click();
    $(".react-datepicker__year-select").$(byText("1991")).click();
    $(".react-datepicker__month-select").$(byText("October")).click();
    $(".react-datepicker__day.react-datepicker__day--013").click();
    $("#subjectsInput").setValue("Information technology").pressEnter();
    $("#hobbiesWrapper").$(byText("Music")).click();
    $("#uploadPicture").uploadFromClasspath("pictures/img1.jpeg");
    $("#currentAddress").setValue("Address 1, 21");
    $("#state").click();
    $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
    $("#city").click();
    $("#stateCity-wrapper").$(byText("Lucknow")).click();
    $("#submit").click();

    $(".modal-body").shouldHave(text("Eka Ekova"), text("testtttt@mail.ru"),
            text("Female"), text("8909990909"), text("13 October,1991"), text("Information technology"),
            text("Music"), text("img1.jpeg"), text("Address 1, 21"), text("Uttar Pradesh Lucknow"));
  }
}
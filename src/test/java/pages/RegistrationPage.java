package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
  CalendarComponent calendarComponent = new CalendarComponent();
  RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

  private SelenideElement
          firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          emailInput = $("#userEmail"),
          genderInput = $("#genterWrapper"),
          phoneInput = $("#userNumber"),
          subjectsInput = $("#subjectsInput"),
          subjectsClick = $("#subjectsWrapper .subjects-auto-complete__option"),
          hobbiesInput = $("#hobbiesWrapper"),
          pictureUpload = $("#uploadPicture"),
          addressInput = $("#currentAddress"),
          stateInput = $("#state"),
          stateCityWrapper = $("#stateCity-wrapper"),
          cityInput = $("#city"),
          cityWrapper = $("#stateCity-wrapper"),
          submitButton = $("#submit");


  @Step("Открыть главную страницу")
  public RegistrationPage openPage() {
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");

    return this;
  }

  @Step("Ввести имя пользователя")
  public RegistrationPage setFirstName (String value) {
    firstNameInput.setValue(value);

    return this;
  }

  @Step("Ввести фамилию пользователя")
  public RegistrationPage setLastName (String value) {
    lastNameInput.setValue(value);

    return this;
  }

  @Step("Ввести email пользователя")
  public RegistrationPage setEmail (String value) {
    emailInput.setValue(value);

    return this;
  }

  @Step("Указать пол пользователя")
  public RegistrationPage setGender (String value) {
    genderInput.$(byText(value)).click();

    return this;
  }

  @Step("Указать телефон пользователя")
  public RegistrationPage setPhone (String value) {
    phoneInput.setValue(value);

    return this;
  }

  @Step("Указать дату рождения пользователя")
  public RegistrationPage setBirthDate (String day, String month, String year) {
    calendarComponent.setDate(day, month, year);

    return this;
  }

  @Step("Указать предмет пользователя")
  public RegistrationPage setSubjects (String value) {
    subjectsInput.setValue(value);
    subjectsClick.click();

    return this;
  }

  @Step("Указать хобби пользователя")
  public RegistrationPage setHobbies (String value) {
    hobbiesInput.$(byText(value)).click();

    return this;
  }

  @Step("Загрузить изображение")
  public RegistrationPage setPicture (String value) {
    pictureUpload.uploadFromClasspath(value);

    return this;
  }

  @Step("Ввести адрес пользователя")
  public RegistrationPage setAddress (String value) {
    addressInput.setValue(value).click();

    return this;
  }

  @Step("Указать штат пользователя")
  public RegistrationPage setState (String value) {
   stateInput.click();
   stateCityWrapper.$(byText(value)).click();

    return this;
  }

  @Step("Указать город пользователя")
  public RegistrationPage setCity (String value) {
    cityInput.click();
    cityWrapper.$(byText(value)).click();

    return this;
  }

  @Step("Подтвердить действие")
  public RegistrationPage clickSubmit () {
    submitButton.click();

    return this;
  }

  @Step("Проверка сообщения в модальном окне")
  public RegistrationPage verifyResultsModalAppears() {
    registrationResultsModal.verifyModalAppears();

    return this;
  }

  @Step("Проверка соответствия всех введённых значений")
  public RegistrationPage verifyResult (String key, String value) {
    registrationResultsModal.verifyResult(key, value);

    return this;
  }

}

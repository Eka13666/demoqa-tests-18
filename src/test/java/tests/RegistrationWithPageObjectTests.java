package tests;

import org.junit.jupiter.api.Test;



public class RegistrationWithPageObjectTests extends TestBase{

    @Test
    void fillFormTest() {

      String userName = "Eka";
      String userLastName = "Ekova";
      String userEmail = "testtttt@mail.ru";
      String userGender = "Female";
      String userPhone = "8909990909";
      String userBirth_day = "13";
      String userBirth_month = "October";
      String userBirth_year = "1991";
      String userSubjects = "History";
      String userHobbies = "Music";
      String userPictureLocation = "pictures/img1.jpeg";
      String userAddress = "Address 1, 21";
      String userState = "Uttar Pradesh";
      String userCity = "Lucknow";

      registrationPage.openPage()
               .setFirstName(userName)
               .setLastName(userLastName)
               .setEmail(userEmail)
               .setGender(userGender)
               .setPhone(userPhone)
               .setBirthDate(userBirth_day, userBirth_month, userBirth_year)
               .setSubjects(userSubjects)
               .setHobbies(userHobbies)
               .setPicture(userPictureLocation)
               .setAddress(userAddress)
               .setState(userState)
               .setCity(userCity)
               .clickSubmit();

      registrationPage.verifyResultsModalAppears()
              .verifyResult("Student Name", userName + " " + userLastName)
              .verifyResult("Student Email", userEmail)
              .verifyResult("Gender", userGender)
              .verifyResult("Mobile", userPhone)
              .verifyResult("Date of Birth", userBirth_day + " " + userBirth_month + "," + userBirth_year)
              .verifyResult("Subjects", userSubjects)
              .verifyResult("Hobbies", userHobbies)
              .verifyResult("Address", userAddress)
              .verifyResult("State and City", userState + " " + userCity);

    }
  }

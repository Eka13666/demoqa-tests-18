package tests;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class RegistrationWithRandomUtilsTests extends TestBase{

    @Test
    void fillFormTest() {

      String userName = getRandomString(10),
              userLastName = getRandomString(10),
              userEmail = getRandomEmail(),
              userGender = "Female",
              userPhone = "8909990909",
              userBirth_day = "13",
              userBirth_month = "October",
              userBirth_year = "1991",
              userSubjects = "History",
              userHobbies = "Music",
              userPictureLocation = "pictures/img1.jpeg",
              userAddress = "Address 1, 21",
              userState = "Uttar Pradesh",
              userCity = "Lucknow";

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

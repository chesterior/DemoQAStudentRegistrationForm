package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TextBoxWithPageObjectsAndFakerTests extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = "Male",
            userNumber = faker.phoneNumber().subscriberNumber(10),
            subject = "h",
            hobby = "Reading",
            picture = "src/test/resources/sports-motocross.jpg",
            currentAddress = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal",
            day = "28",
            month = "August",
            year = "1900";

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.userEmail(userEmail);
        registrationPage.userGender(gender);
        registrationPage.userNumber(userNumber);

        registrationPage.calendar.setDate(day, month, year);

        registrationPage.subjects(subject);
        registrationPage.hobbies(hobby);
        registrationPage.uploadPicture(picture);
        registrationPage.userAddress(currentAddress);

        registrationPage.chooseState(state);
        registrationPage.chooseCity(city);

        registrationPage.submit();

        registrationPage.checkResults(firstName, lastName, userEmail, gender,
                userNumber, day, month, year,
                subject, hobby, currentAddress, state, city);
    }
}

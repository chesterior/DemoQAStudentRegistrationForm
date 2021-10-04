package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static guru.qa.tests.TestData.firstName;
import static guru.qa.tests.TestData.lastName;


public class TextBoxWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        $("#userEmail").setValue("freeman@yandex.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9215121322");

        registrationPage.calendar.setDate("28", "August", "1900");

        $("#subjectsInput").setValue("h").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/sports-motocross.jpg"));
        $("#currentAddress").setValue("city SPB, Turistskay street");

        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        $("tbody").shouldHave(text(firstName + " " + lastName),
                text("freeman@yandex.ru"),
                text("Male"),
                text("9215121322"),
                text("22 August,1900"),
                text("Hindi"),
                text("Reading"),
                text("sports-motocross.jpg"),
                text("city SPB, Turistskay street"),
                text("Haryana Karnal"));
    }
}

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }


    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Django");
        $("#lastName").setValue("Free");
        $("#userEmail").setValue("freeman@yandex.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9215121322");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1900");
        $(".react-datepicker__day.react-datepicker__day--022").click();

        $("#subjectsInput").setValue("h").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/sports-motocross.jpg"));
        $("#currentAddress").setValue("city SPB, Turistskay street");

        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        $("tbody").shouldHave(text("Django Free"),
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

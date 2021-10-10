package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            selectGender = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            chooseHobby = $("#hobbiesWrapper"),
            selectPicture = $("#uploadPicture"),
            userAddressInput = $("#currentAddress"),
            selectState = $("#state"),
            selectCity = $("#city"),
            selectSubmit = $("#submit"),
            results = $("tbody");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value) {

        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {

        lastNameInput.setValue(value);
    }

    public void userEmail(String value) {

        userEmailInput.setValue(value);
    }

    public void userGender(String gender) {

        selectGender.$(byText(gender)).click();
    }

    public void userNumber(String value) {

        userNumberInput.setValue(value);
    }

    public void subjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
    }

    public void hobbies(String hobby) {

        chooseHobby.$(byText(hobby)).click();
    }

    public void uploadPicture(String picture) {
        selectPicture.uploadFile(new File(picture));
    }

    public void userAddress(String value) {

        userAddressInput.setValue(value);
    }

    public void chooseState(String state){
        selectState.scrollTo().click();
        $(byText(state)).click();
    }

    public void chooseCity(String city){
        selectCity.scrollTo().click();
        $(byText(city)).click();
    }

    public void submit() {
        selectSubmit.click();
    }

    public void checkResults(String firstName, String lastName, String userEmail, String gender, String userNumber,
                             String day, String month, String year,
                             String subject, String hobby, String currentAddress, String state, String city){
        results.shouldHave(
                text(firstName + " " + lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
                text(day + " " + month + "," + year),
                text(subject),
                text(hobby),
                text("sports-motocross.jpg"),
                text(currentAddress),
                text(state  + " " + city));
    }
}

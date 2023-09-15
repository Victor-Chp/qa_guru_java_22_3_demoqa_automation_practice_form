import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("John");
        $("#lastName").setValue("Howard");
        $("#userEmail").setValue("john@gmail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1983");
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__day--016").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("account.png");
        $("#currentAddress").setValue("Lenina str, 100-200");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("John Howard"),
                text("john@gmail.com"),
                text("1234567890"),
                text("16 April,1983"),
                text("History"),
                text("Sports"),
                text("account.png"),
                text("Lenina str, 100-200"),
                text("Rajasthan Jaipur")
        );

    }
}

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "none";
    }

    @Test
    void successfulRegistrationTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Aleksandr");
        $("#lastName").setValue("Exile");
        $("#userEmail").setValue("AleksandrExile@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        //$("label[for=gender-radio-1").click();
        $("#userNumber").setValue("900112299");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--009:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
       // $("label[for=hohobbiesWrapperbbies-checkbox-1").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/9.png");
        $("#currentAddress").setValue("www.Leningrad.spb.ru");
        //$("#gender-radio-1").parent().click();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();
    }
}
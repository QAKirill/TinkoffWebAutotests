package tinkoff.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginForm = $("[automation-id=login-form]"),
            phoneInput = $(loginForm).$("[automation-id=phone-input]"),
            buttonSubmit = $(loginForm).$("[automation-id=button-submit]");

    public LoginPage checkLoginPage(){
        loginForm.exists();
        phoneInput.shouldBe(visible);
        buttonSubmit.shouldBe(visible);

        return this;
    }
}

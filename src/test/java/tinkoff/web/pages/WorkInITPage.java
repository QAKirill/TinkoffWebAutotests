package tinkoff.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WorkInITPage {
    SelenideElement
            mainFrame = $("[role=main]"),
            respondButton = $("[data-qa-type=uikit\\/button\\.content]"),
            inputFio = $("[data-qa-type=uikit\\/portalWrapper]")
                    .$("[data-qa-type=uikit\\/inputFio\\.inputBox]"),
            inputCity = $("[data-qa-type=uikit\\/portalWrapper]")
                    .$("[data-qa-type=uikit\\/inputAutocomplete\\.inputBox]"),
            inputEmail = $("[data-qa-type=uikit\\/portalWrapper]")
                    .$("[data-field-name=email]"),
            inputPhone = $("[data-qa-type=uikit\\/portalWrapper]")
                    .$("[data-qa-type=uikit\\/inputPhone]"),
            inputResume = $("[data-qa-type=uikit\\/portalWrapper]")
                    .$("input[data-qa-type=uikit\\/attachFile\\.input]"),
            checkBoxAgreement = $("#checkbox_agreement"),
            submitButton = $("[name=submit]");


    public WorkInITPage checkHeader(){
        mainFrame.$("p").shouldHave(text("Работа в ИТ Тинькофф"));
        mainFrame.$("[data-schema-path=subtitle]").$("p").shouldHave(text(
                "Приглашаем в команду разработчиков, аналитиков, продакт-менеджеров и других специалистов. " +
                        "Пройдите собеседование, получите оффер и развивайте продукты Тинькофф вместе с нами"
        ));

        return this;
    }

    public WorkInITPage openVacancies(){
        mainFrame.$(byText("Смотреть вакансии")).click();
        return this;
    }

    public WorkInITPage setFilters(){
        open("https://www.tinkoff.ru/career/it/?specialtyUrl=" +
                "testirovanie&experiencesUrl=senior&citiesUrl=moskva&citiesUrl=udalennaya-rabota");

        return this;
    }

    public WorkInITPage findCoolVacancy(String value){
        $("table").$(byText(value)).click();
        $(withText("Достойная зарплата")).shouldBe(exist); //проверка на крутость вакансии!

        return this;
    }

    public WorkInITPage respondButtonClick(){
        respondButton.click();
        return this;
    }

    public WorkInITPage checkApplyVacancyForm(){
        inputFio.shouldBe(visible);
        inputCity.shouldBe(visible);
        inputEmail.shouldBe(visible);
        inputPhone.shouldBe(visible);
        inputResume.shouldBe(exist);
        checkBoxAgreement.shouldBe(visible);
        submitButton.shouldBe(visible);

        return this;
    }
}
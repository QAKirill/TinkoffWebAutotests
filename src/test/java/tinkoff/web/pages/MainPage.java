package tinkoff.web.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement
            navigationPanel = $("[data-test=navigation]"),
            debitCards = $("[data-test$=text-item-0-1]"),
            workInIT = $("[data-test=menu-item-3]"),
            insurancePage = $("[data-test$=text-item-3-2]"),
            subscriptionPro = $("[data-test$=text-item-0-6]"),
            savingsAccount = $("[data-test$=text-item-0-5]");

    public MainPage openPage() {
        open("/");

        Assertions.assertEquals
                ("Тинькофф — Кредитные и дебетовые карты, кредиты для бизнеса и физических лиц",
                        Selenide.title());

        return this;
    }

    public MainPage checkNavigationPanel() {
        navigationPanel
                .shouldHave(text("Частным лицам"))
                .shouldHave(text("Бизнесу"))
                .shouldHave(text("Премиум"))
                .shouldHave(text("Еще"))
                .shouldHave(text("Личный кабинет"));

        return this;
    }

    public MainPage openDebitCards(){
        navigationPanel.$("[data-test=menu-item-0]").hover();
        debitCards.click();

        return this;
    }

    public MainPage openWorkInIT(){
        navigationPanel.$("[data-test=menu-item-3]").hover();
        workInIT.$("[data-test$=text-item-3-0]").click();

        return this;
    }

    public MainPage openTravelInsurance(){
        navigationPanel.$("[data-test=menu-item-0]").hover();
        insurancePage.click();

        return this;
    }

    public MainPage openSubscriptionPro(){
        navigationPanel.$("[data-test=menu-item-0]").hover();
        subscriptionPro.click();

        return this;
    }

    public MainPage openSavingsAccount(){
        navigationPanel.$("[data-test=menu-item-0]").hover();
        savingsAccount.click();

        return this;
    }

}
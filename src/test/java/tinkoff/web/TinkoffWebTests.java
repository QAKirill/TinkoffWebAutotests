package tinkoff.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tinkoff.web.pages.DebitCardsPage;
import tinkoff.web.pages.MainPage;
import tinkoff.web.pages.TravelInsurancePage;
import tinkoff.web.pages.WorkInITPage;

import static io.qameta.allure.Allure.step;

public class TinkoffWebTests extends TestBase{

    MainPage mainPage = new MainPage();

    @Test
    @Tag("remote")
    @DisplayName("Проверка формы заказа дебетовой карты")
    void applyTinkoffBlackDebitCardFormTest() {
        DebitCardsPage debitCardsPage = new DebitCardsPage();

        step("Открыть дебетовые карты", () ->
        mainPage.openPage()
                .checkNavigationPanel()
                .openDebitCards());

        step("Проверка формы", () ->
        debitCardsPage
                .checkHeader()
                .openPremiumCards()
                .applyForADebitCard()
                .checkApplyForm());
    }

    @Test
    @Tag("remote")
    @DisplayName("Проверка формы отклика на вакансию")
    void applyForACoolVacancyTest() {
        WorkInITPage workInITPage = new WorkInITPage();

        step("Открыть страницу вакансий", () ->
        mainPage.openPage()
                .checkNavigationPanel()
                .openWorkInIT());

        step("Проверка формы", () ->
        workInITPage
                .checkHeader()
                .openVacancies()
                .setFilters()
                .findCoolVacancy("Инженер по автоматизации тестирования на Java")
                .respondButtonClick()
                .checkApplyVacancyForm());
    }

    @Test
    @Tag("remote")
    @DisplayName("Проверка формы расчета страховки")
    void checkTravelInsuranceCalculationFormTest() {
        TravelInsurancePage travelInsurancePage = new TravelInsurancePage();

        step("Открыть страницу страхования путешественников", () ->
        mainPage.openPage()
                .checkNavigationPanel()
                .openTravelInsurance());

        step("Проверка формы", () ->
        travelInsurancePage
                .checkHeader()
                .calculateCostButtonClick()
                .checkCalculationForm());
    }

    @Test
    @Tag("remote")
    @DisplayName("Fake test - always fails")
    void fakeTest1() {
        step("Успешно падаем", () ->
                Assertions.assertTrue(false));
    }
}

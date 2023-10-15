package tinkoff.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tinkoff.web.pages.*;

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

        step("Проверка заголовка h1", () ->
                debitCardsPage.checkHeader());

        step("Нажать Премиальные и выбрать Tinkoff Black Premium", () ->
                debitCardsPage
                        .openPremiumCards()
                        .applyForADebitCard());

        step("Проверка формы заказа дебетовой карты", () ->
        debitCardsPage.checkApplyForm());
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

        step("Проверка заголовка h1", () ->
                workInITPage.checkHeader());

        step("Открыть Вакансии", () ->
                workInITPage.openVacancies());

        step("Отфильтровать вакансии", () ->
                workInITPage.setFilters());

        step("Открыть самую первую вакансию и откликнуться на неё", () ->
                workInITPage
                        .findFirstVacancy()
                        .respondButtonClick());

        step("Проверка формы отклика на вакансию", () ->
        workInITPage.checkApplyVacancyForm());
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

        step("Проверка заголовка h1", () ->
                travelInsurancePage.checkHeader());

        step("Нажать кнопку Рассчитать стоимость", () ->
                travelInsurancePage.calculateCostButtonClick());

        step("Проверка формы расчета страховки", () ->
        travelInsurancePage.checkCalculationForm());
    }

    @Test
    @Tag("remote")
    @DisplayName("Сумма оплаты за выбранные подписки рассчитывается корректно")
    void checkProSubscriptionSum() {
        SubscriptionProPage subscriptionProPage = new SubscriptionProPage();
        step("Открыть страницу подписки PRO", () ->
                mainPage.openPage()
                        .checkNavigationPanel()
                        .openSubscriptionPro());

        step("Проверка заголовка h1", () ->
                subscriptionProPage.checkHeader());

        step("Нажать кнопку Попробовать бесплатно", () ->
                subscriptionProPage.tryForFreeButtonClick());

        step("Переключение чекбоксов", () ->
                subscriptionProPage
                        .proCheckboxClick()
                        .vkMusicCheckboxClick()
                        .premierCheckboxClick()
                        .iviCheckboxClick());

        step("Проверка суммы", () ->
                subscriptionProPage.checkSum("1056"));
    }

    @Test
    @Tag("remote")
    @DisplayName("Чтобы открыть накопительный счет необходимо залогиниться")
    void needLoginBeforeOpenSavingsAccountTest() {
        SavingsAccountPage savingsAccountPage = new SavingsAccountPage();
        LoginPage loginPage = new LoginPage();

        step("Открыть страницу сберегательного счета", () ->
                mainPage.openPage()
                        .checkNavigationPanel()
                        .openSavingsAccount());

        step("Нажать кнопку Открыть накопительный счет", () ->
                savingsAccountPage.openSAButtonClick());

        step("Нажать кнопку Открыть в личном кабинете", () ->
                savingsAccountPage.openInLKButtonClick());

        step("Проверить открывшуюся форму входа в Личный Кабинет", () ->
                loginPage.checkLoginPage());
    }

    @Test
    @Tag("remote")
    @DisplayName("Fake test - always fails")
    void fakeTest1() {
        step("Успешно падаем", () ->
                Assertions.assertTrue(false));
    }

    @Test
    @DisplayName("Fake test - always passes")
    void fakeNotRemoteTest() {
        step("Успешный успех", () ->
                Assertions.assertTrue(true));
    }
}

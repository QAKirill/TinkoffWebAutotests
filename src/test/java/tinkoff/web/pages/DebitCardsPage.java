package tinkoff.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DebitCardsPage {

    private SelenideElement
            menuBar = $("[role=menubar]"),
            banner = $("[role=banner]"),
            headerChooseCardType = $("#form").$(byText("Выберите вид карты")),
            frameIndividualDesign = $("#form").$("[data-field-name=individual_design]"),
            multiselectCashback = $("#form").$("[data-field-name=cashback_list]"),
            inputFio = $("#form").$("[data-field-name=fio]"),
            inputMobilePhone = $("#form").$("[data-field-name=phone_mobile]"),
            inputEmail = $("#form").$("[data-field-name=email]"),
            inputDateOfBirth = $("#form").$("[data-field-name=birthdate]"),
            selectResident = $("#form").$("[data-field-name=non_resident]"),
            buttonSubmit = $("#form").$("[name=submit]"),
            heading = $("[role=heading]");

    public DebitCardsPage openPremiumCards(){
        menuBar.$(By.linkText("Премиальные")).click();
        banner.$(byText("Премиальная карта Tinkoff Black Premium")).should(exist);

        return this;
    }

    public DebitCardsPage applyForADebitCard(){
        banner.$(byText("Оформить карту")).click();

        return this;
    }

    public DebitCardsPage checkApplyForm(){
        headerChooseCardType.shouldBe(visible);
        frameIndividualDesign.shouldBe(visible);
        multiselectCashback.shouldBe(visible);
        inputFio.shouldBe(visible);
        inputMobilePhone.shouldBe(visible);
        inputEmail.shouldBe(visible);
        inputDateOfBirth.shouldBe(visible);
        selectResident.shouldBe(visible);
        buttonSubmit.shouldBe(visible);

        return this;
    }

    public DebitCardsPage checkHeader(){
        heading.$("h1").shouldHave(text("Дебетовые карты"));
        heading.$("p").shouldHave(text(
                "Дебетовая карта — лучший способ оплачивать покупки и получать кэшбэк. " +
                        "С дебетовыми картами Тинькофф Банка клиенты получают кэшбэк " +
                        "рублями или бонусами за каждую покупку"
        ));

        return this;
    }
}

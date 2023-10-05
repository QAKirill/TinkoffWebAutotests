package tinkoff.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TravelInsurancePage {
    SelenideElement
            mainFrame = $("[role=main]"),
            calculateCost = $("[role=main]").$("[type=button]"),
            countrySelect = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]").$("[role=listbox]"),
            annualPolicyCheckbox = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[name=vzr_annual_policy_flg]"),
            alreadyTravelingCheckbox = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[name=vzr_already_travelling_flg]"),
            calendar = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[data-field-name=vzr_calendar]"),
            currency = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[data-field-name=vzr_currency]"),
            coverageSum = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[data-field-name=vzr_coverage_sum]"),
            coverageType = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[data-field-name=vzr_coverage_type]"),
            goForwardButton = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]").$("[name=goForward]");

    public TravelInsurancePage checkHeader(){
        mainFrame.$("h1").$("p").shouldHave(Condition.text(
                "Медицинское страхование для путешествий за границу"));

        return this;
    }

    public TravelInsurancePage calculateCostButtonClick(){
        calculateCost.click();

        return this;
    }

    public TravelInsurancePage checkCalculationForm(){
        countrySelect.shouldBe(visible);
        annualPolicyCheckbox.shouldBe(visible);
        alreadyTravelingCheckbox.shouldBe(visible);
        calendar.shouldBe(visible);
        currency.shouldBe(visible);
        coverageSum.shouldBe(visible);
        coverageType.shouldBe(visible);
        goForwardButton.shouldBe(visible);

        return this;
    }
}

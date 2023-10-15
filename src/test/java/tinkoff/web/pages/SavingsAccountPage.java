package tinkoff.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SavingsAccountPage {
    private SelenideElement
            mainFrame = $("[role=main]"),
            openSAButton = $("[role=main]").$("[type=button]"),
            openInLKButton = $("[data-test=click-area-blue]");

    public SavingsAccountPage checkHeaders() {
        mainFrame.$("h1").$("p").shouldHave(Condition.text(
                "Прибавим до 7% к накоплениям на счете"));

        return this;
    }

    public SavingsAccountPage openSAButtonClick(){
        openSAButton.click();
        return this;
    }

    public SavingsAccountPage openInLKButtonClick(){
        openInLKButton.click();
        return this;
    }
}

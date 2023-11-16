package tinkoff.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class SubscriptionProPage {
    private SelenideElement
            mainFrame = $("[role=main]"),
            tryForFreeButton = $("[role=main]").$("[type=button]"),
            proCheckbox = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[value=pro]"),
            vkMusicCheckbox = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[value=vk_music]"),
            premierCheckbox = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[value=premier]"),
            iviCheckbox = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]")
                    .$("[value=ivi]"),
            sumField = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.content").
                    $("[data-qa-type=uikit\\/sidebar\\.subtitle]"),
            subscriptionTitle = $("[data-qa-type=uikit\\/screenTwinCols\\.withSidebar\\.form]").$("[data-field-name=subscriptions_title]");

    public SubscriptionProPage checkHeader() {
        mainFrame.$("h1").$("p").shouldHave(Condition.text(
                "Еще больше выгоды от Тинькофф по подписке"));

        return this;
    }

    public SubscriptionProPage tryForFreeButtonClick(){
        tryForFreeButton.click();
        subscriptionTitle.scrollTo();
        return this;
    }

    public SubscriptionProPage proCheckboxClick(){
        proCheckbox.click(); //хз почему так работает, но нужно два раза кликать
        proCheckbox.click();
        return this;
    }

    public SubscriptionProPage vkMusicCheckboxClick(){
        vkMusicCheckbox.click();
        return this;
    }

    public SubscriptionProPage premierCheckboxClick(){
        premierCheckbox.click();
        return this;
    }

    public SubscriptionProPage iviCheckboxClick(){
        iviCheckbox.click();
        return this;
    }

    public SubscriptionProPage checkSum(String value){
        String tmp = value + " ₽";
        Assertions.assertEquals(tmp, sumField.getText());
        return this;
    }
}


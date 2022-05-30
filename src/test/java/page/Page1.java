package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class Page1 {
    private SelenideElement heading = $(withText("Путешествие дня"));
    private SelenideElement buttonPay = $(withText("Купить"));
    private SelenideElement buttonPayWithCredit = $(withText("Купить в кредит"));

    public Page1() {
        heading.shouldBe(visible);
    }

    public PayWithCard pay() {

        buttonPay.click();
        return new PayWithCard();
    }

    public PayWithCredit payWithCredit() {

        buttonPayWithCredit.click();
        return new PayWithCredit();
    }
}



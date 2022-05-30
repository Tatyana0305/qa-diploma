package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PayWithCredit {
    private SelenideElement headingPayWithCredit = $(withText("Кредит по данным карты"));
    private final SelenideElement cardNumber = $("input[placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $("input[placeholder='08']");
    private final SelenideElement year = $("input[placeholder='22']");
    private final SelenideElement cardholder = $(withText("Владелец")).parent().$(".input__control");
    private final SelenideElement cvc = $("input[placeholder='999']");
    SelenideElement continueButton = $$(".button__content").find(exactText("Продолжить"));


    public PayWithCredit() {
        headingPayWithCredit.shouldBe(visible);
    }


    public void fillCardValue(DataHelper.CardValue cardValue) {
        cardNumber.setValue(cardValue.getCardNumber());
        month.setValue(cardValue.getMonth());
        year.setValue(cardValue.getYear());
        cardholder.setValue(cardValue.getHolder());
        cvc.setValue(cardValue.getCvc());

        continueButton.click();
    }


    public void successOrder() {
        $(withText("Операция одобрена Банком.")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void failedOrder() {
        $(withText("Ошибка! Банк отказал в проведении операции.")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void emptyField() {
        $(withText("Поле обязательно для заполнения")).shouldBe(visible);
    }

    public void inCorrectFormat() {
        $(withText("Неверный формат")).shouldBe(visible);
    }

    public void invalidDate() {
        $(withText("Неверно указан срок действия карты")).shouldBe(visible);
    }

    public void expiredData() {
        $(withText("Истёк срок действия карты")).shouldBe(visible);
    }
}


package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.Page1;

import static com.codeborne.selenide.Selenide.open;

public class Tests {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUpSutUrl() {
        open(System.getProperty("sut.url"));
    }

    @Test
    public void shouldPayWithApprovedCard() {
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedValue();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(approvedValue);
        payWithCard.successOrder();

    }

    @Test
    public void shouldPayWithDeclinedCard() {
        val page1 = new Page1();
        val declinedValue = DataHelper.getDeclinedValue();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(declinedValue);
        payWithCard.failedOrder();

    }

    @Test
    public void shouldPayInCreditWithApprovedCard() {
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedValue();
        val payWithCredit = page1.pay();
        payWithCredit.fillCardValue(approvedValue);
        payWithCredit.failedOrder();
    }

    @Test
    public void shouldPayInCreditWithDeclinedCard() {
        val page1 = new Page1();
        val declinedValue = DataHelper.getDeclinedValue();
        val payWithCredit = page1.pay();
        payWithCredit.fillCardValue(declinedValue);
        payWithCredit.failedOrder();
    }

    @Test
    public void shouldPayCardWithIncorrectValue1() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue1();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue1() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue1();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    public void shouldPayCardWithIncorrectValue2() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue2();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue2() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue2();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue3() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue3();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue3() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue3();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue4() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue4();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue4() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue4();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    public void shouldPayCardWithIncorrectValue5() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue5();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.invalidDate();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue5() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue5();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.invalidDate();

    }

    @Test
    public void shouldPayCardWithIncorrectValue6() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue6();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.invalidDate();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue6() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue6();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.invalidDate();

    }

    @Test
    public void shouldPayCardWithIncorrectValue7() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue7();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue7() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue7();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue8() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue8();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue8() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue8();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue9() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue9();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.expiredData();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue9() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue9();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.expiredData();

    }

    @Test
    public void shouldPayCardWithIncorrectValue010() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue010();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue010() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue010();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue011() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue011();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue011() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue011();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue012() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue012();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue012() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue012();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    public void shouldPayCardWithIncorrectValue013() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue013();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue013() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue013();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    public void shouldPayCardWithIncorrectValue014() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue014();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue015() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue015();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    public void shouldPayCardWithIncorrectValue016() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue016();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.emptyField();
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue016() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue017();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.emptyField();
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue017() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue017();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.emptyField();
        payWithCard.inCorrectFormat();
    }

    @Test
    public void shouldPayCreditWithIncorrectValue017() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue017();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();
        payWithCredit.emptyField();

    }

    @Test
    public void shouldPayCardWithIncorrectValue018() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue018();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.emptyField();
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue018() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue018();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.emptyField();
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue019() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue019();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue019() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue019();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue020() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue020();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue020() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue020();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue021() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue021();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue021() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue021();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    public void shouldPayCardWithIncorrectValue022() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue022();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.emptyField();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue022() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue022();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.emptyField();

    }

    @Test
    public void shouldPayCardWithIncorrectValue023() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue023();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();
        payWithCard.emptyField();

    }

    @Test
    public void shouldPayCreditWithIncorrectValue023() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue023();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();
        payWithCredit.emptyField();

    }

}
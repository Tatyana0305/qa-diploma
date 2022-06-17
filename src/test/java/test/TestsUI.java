package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SQL;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import page.Page1;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUI {


    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
    @DisplayName("Должно быть сообщение об успешной оплате с одобренной картой")
    public void shouldPayWithApprovedCard() {
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedValue();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(approvedValue);
        payWithCard.successOrder();
        String actual = SQL.getStatusPayCard();
        assertEquals("APPROVED", actual);

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате отклоненной картой")
    public void shouldPayWithDeclinedCard() {
        val page1 = new Page1();
        val declinedValue = DataHelper.getDeclinedValue();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(declinedValue);
        payWithCard.failedOrder();
        String actual = SQL.getStatusPayCard();
        assertEquals("DECLINED", actual);

    }

    @Test
    @DisplayName("Должно быть сообщение об успешной оплате в кредит с одобренной картой")
    public void shouldPayInCreditWithApprovedCard() {
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedValue();
        val payWithCredit = page1.pay();
        payWithCredit.fillCardValue(approvedValue);
        payWithCredit.successOrder();
        String actual = SQL.getStatusPayCredit();
        assertEquals("APPROVED", actual);
    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит отклоненной картой")
    public void shouldPayInCreditWithDeclinedCard() {
        val page1 = new Page1();
        val declinedValue = DataHelper.getDeclinedValue();
        val payWithCredit = page1.pay();
        payWithCredit.fillCardValue(declinedValue);
        payWithCredit.failedOrder();
        String actual = SQL.getStatusPayCredit();
        assertEquals("DECLINED", actual);
    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если в номере карты все нули")
    public void shouldPayCardWithIncorrectValue1() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue1();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит одобренной картой если в номере карты все нули")
    public void shouldPayCreditWithIncorrectValue1() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue1();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в номере карты символы")
    public void shouldPayCardWithIncorrectValue2() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue2();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате в кредит одобренной картой если в номере карты символы")
    public void shouldPayCreditWithIncorrectValue2() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue2();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в номере карты буквы")
    public void shouldPayCardWithIncorrectValue3() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue3();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в номере карты буквы")
    public void shouldPayCreditWithIncorrectValue3() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue3();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате картой не из набора")
    public void shouldPayCardWithIncorrectValue4() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue4();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит картой не из набора")
    public void shouldPayCreditWithIncorrectValue4() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue4();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате картой если месяц = 13")
    public void shouldPayCardWithIncorrectValue5() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue5();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате в кредит если месяц = 13")
    public void shouldPayCreditWithIncorrectValue5() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue5();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате картой если месяц прошедший")
    public void shouldPayCardWithIncorrectValue6() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue6();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате в кредит если месяц прошедший")
    public void shouldPayCreditWithIncorrectValue6() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue6();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в поле месяц символы")
    public void shouldPayCardWithIncorrectValue7() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue7();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в поле месяц символы")
    public void shouldPayCreditWithIncorrectValue7() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue7();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в поле месяц буквы")
    public void shouldPayCardWithIncorrectValue8() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue8();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в поле месяц буквы")
    public void shouldPayCreditWithIncorrectValue8() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue8();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате картой если год прошедший")
    public void shouldPayCardWithIncorrectValue9() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue9();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате в кредит если год прошедший")
    public void shouldPayCreditWithIncorrectValue9() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue9();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в поле год символы")
    public void shouldPayCardWithIncorrectValue010() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue010();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в поле год символы")
    public void shouldPayCreditWithIncorrectValue010() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue010();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в поле год буквы")
    public void shouldPayCardWithIncorrectValue011() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue011();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в поле год буквы")
    public void shouldPayCreditWithIncorrectValue011() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue011();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если владелец заполнен латиницей")
    public void shouldPayCardWithIncorrectValue012() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue012();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит если владелец заполнен латиницей")
    public void shouldPayCreditWithIncorrectValue012() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue012();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если владелец заполнен символами")
    public void shouldPayCardWithIncorrectValue013() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue013();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит если владелец заполнен символами")
    public void shouldPayCreditWithIncorrectValue013() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue013();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если владелец заполнен цифрами")
    public void shouldPayCardWithIncorrectValue014() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue014();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит если владелец заполнен цифрами")
    public void shouldPayCreditWithIncorrectValue014() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue014();
        val payWithCard = page1.payWithCredit();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если CVC = 000")
    public void shouldPayCreditWithIncorrectValue015() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue015();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит если CVC = 000")
    public void shouldPayCardWithIncorrectValue015() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue015();
        val payWithCredit = page1.pay();
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
        val incorrectValue = DataHelper.getIncorrectValue016();
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

    @Test
    public void shouldPayCardWithCorrectValue024() {
        val page1 = new Page1();
        val correctValue = DataHelper.getCorrectValue024();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(correctValue);
        payWithCard.successOrder();

    }

    @Test
    public void shouldPayCreditWithCorrectValue024() {
        val page1 = new Page1();
        val correctValue = DataHelper.getCorrectValue024();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(correctValue);
        payWithCredit.successOrder();

    }

}
package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SQL;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import page.Page1;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

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
    void shouldSuccessPayWithApprovedDebitCard() {
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedValue();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(approvedValue);
        payWithCard.successOrder();
        String actual = SQL.getStatusPayment();
        assertEquals("APPROVED", actual);
    }

    @Test
    @DisplayName("Должно быть сообщение об успешной оплате в кредит с одобренной картой")
    public void shouldPayInCreditWithApprovedCard() {
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedValue();
        val payWithCredit = page1.pay();
        payWithCredit.fillCardValue(approvedValue);
        payWithCredit.successOrder();
        assertEquals("APPROVED", SQL.getStatusCredit());

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате отклоненной картой")
    public void shouldFailureWithDeclinedCard() {
        val page1 = new Page1();
        val declinedValue = DataHelper.getDeclinedValue();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(declinedValue);
        payWithCard.failedOrder();
        assertEquals("DECLINED", SQL.getStatusPayment());


    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит отклоненной картой")
    public void shouldFailureCreditWithDeclinedCard() {
        val page1 = new Page1();
        val declinedValue = DataHelper.getDeclinedValue();
        val payWithCredit = page1.pay();
        payWithCredit.fillCardValue(declinedValue);
        payWithCredit.failedOrder();
        assertEquals("DECLINED", SQL.getStatusPayment());
    }


    //

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если в номере карты все нули")
    public void shouldFailurePaymentIfZeroesInCardNumber() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue1();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит одобренной картой если в номере карты все нули")
    public void shouldFailureCreditIfZeroesInCardNumber() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue1();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в номере карты символы")
    public void shouldFailurePaymentIfSymbolsInCardNumber() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue2();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате в кредит одобренной картой если в номере карты символы")
    public void shouldFailureCreditIfSymbolsInCardNumber() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue2();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в номере карты буквы")
    public void shouldFailurePaymentIfLettersInCardNumber() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue3();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в номере карты буквы")
    public void shouldFailureCreditIfLettersInCardNumber() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue3();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате картой не из набора")
    public void shouldFailurePaymentIfCardNumberOutOfBase() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue4();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит картой не из набора")
    public void shouldFailureCreditIfCardNumberOutOfBase() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue4();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате картой если месяц = 13")
    public void shouldFailurePaymentIfMonthOverBorder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue5();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате в кредит если месяц = 13")
    public void shouldFailureCreditIfMonthOverBorder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue5();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате картой если месяц прошедший")
    public void shouldFailurePaymentIfPastMonth() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue6();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате в кредит если месяц прошедший")
    public void shouldFailureCreditIfPastMonth() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue6();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в поле месяц символы")
    public void shouldFailurePaymentIfSymbolInMonth() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue7();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в поле месяц символы")
    public void shouldFailureCreditIfSymbolInMonth() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue7();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в поле месяц буквы")
    public void shouldFailurePaymentIfLettersInMonth() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue8();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в поле месяц буквы")
    public void shouldFailureCreditIfLettersInMonth() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue8();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате картой если год прошедший")
    public void shouldFailurePaymentIfPastYear() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue9();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНО УКАЗАН СРОК ДЕЙСТВИЯ КАРТЫ при оплате в кредит если год прошедший")
    public void shouldFailureCreditIfPastYear() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue9();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.invalidDate();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в поле год символы")
    public void shouldFailurePaymentIfSymbolsInYear() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue010();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в поле год символы")
    public void shouldFailureCreditIfSymbolsInYear() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue010();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой если в поле год буквы")
    public void shouldFailurePaymentIfLettersInYear() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue011();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕВЕРНЫЙ ФОРМАТ при оплате одобренной картой в кредит если в поле год буквы")
    public void shouldFailureCreditIfLettersInYear() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue011();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если владелец заполнен латиницей")
    public void shouldFailurePaymentIfCyrillicLettersInHolder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue012();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит если владелец заполнен латиницей")
    public void shouldFailureCreditIfCyrillicLettersInHolder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue012();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если владелец заполнен символами")
    public void shouldFailurePaymentIfSymbolsInHolder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue013();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит если владелец заполнен символами")
    public void shouldFailureCreditIfSymbolsInHolder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue013();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если владелец заполнен цифрами")
    public void shouldFailurePaymentIfNumbersInHolder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue014();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит если владелец заполнен цифрами")
    public void shouldFailureCreditIfNumbersInHolder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue014();
        val payWithCard = page1.payWithCredit();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате одобренной картой если CVC = 000")
    public void shouldFailurePaymentIfZeroesInCVC() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue015();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об отказе при оплате в кредит если CVC = 000")
    public void shouldFailureCreditIfZeroesInCVC() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue015();
        val payWithCredit = page1.pay();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.failedOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате картой если CVC = +++")
    public void shouldFailurePaymentIfSymbolsInCVC() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue016();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате в кредит если CVC = +++")
    public void shouldFailureCreditIfSymbolsInCVC() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue016();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате картой если CVC заполнено буквами")
    public void shouldFailurePaymentIfLettersInCVC() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue017();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();
    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате в кредит если CVC заполнено буквами")
    public void shouldFailureCreditIfLettersInCVC() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue017();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должны быть сообщения НЕКОРРЕКТНЫЙ ФОРМАТ и ПОЛЕ ОБЯЗАТЕЛЬНО ДЛЯ ЗАПОЛНЕНИЯ при оплате картой если все поля пустые")
    public void shouldFailurePaymentIfEmptyAllFields() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue018();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.emptyField();
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должны быть сообщения НЕКОРРЕКТНЫЙ ФОРМАТ и ПОЛЕ ОБЯЗАТЕЛЬНО ДЛЯ ЗАПОЛНЕНИЯ при оплате в кредит если если все поля пустые")
    public void shouldFailureCreditIfEmptyAllFields() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue018();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.emptyField();
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате картой если номер карты пустой")
    public void shouldFailurePaymentIfEmptyCardNumber() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue019();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате в кредит если если номер карты пустой")
    public void shouldFailureCreditIfEmptyCardNumber() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue019();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате картой если поле месяц пустое")
    public void shouldFailurePaymentIfEmptyMonth() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue020();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате в кредит если поле месяц пустое")
    public void shouldFailureCreditIfEmptyMonth() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue020();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате картой если поле год пустое")
    public void shouldFailurePaymentIfEmptyYear() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue021();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ при оплате в кредит если поле год пустое")
    public void shouldFailureCreditIfEmptyYear() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue021();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ и ПОЛЕ ОБЯЗАТЕЛЬНО ДЛЯ ЗАПОЛНЕНИЯ при оплате картой если поле владелец пустое")
    public void shouldFailurePaymentIfEmptyHolder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue022();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.emptyField();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ и ПОЛЕ ОБЯЗАТЕЛЬНО ДЛЯ ЗАПОЛНЕНИЯ при оплате в кредит если поле владелец пустое")
    public void shouldFailureCreditIfEmptyHolder() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue022();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.emptyField();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ и ПОЛЕ ОБЯЗАТЕЛЬНО ДЛЯ ЗАПОЛНЕНИЯ при оплате картой если поле CVC пустое")
    public void shouldFailurePaymentIfEmptyCVC() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue023();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(incorrectValue);
        payWithCard.inCorrectFormat();
        payWithCard.emptyField();

    }

    @Test
    @DisplayName("Должно быть сообщение НЕКОРРЕКТНЫЙ ФОРМАТ и ПОЛЕ ОБЯЗАТЕЛЬНО ДЛЯ ЗАПОЛНЕНИЯ при оплате в кредит если поле CVC пустое")
    public void shouldFailureCreditIfEmptyCVC() {
        val page1 = new Page1();
        val incorrectValue = DataHelper.getIncorrectValue023();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(incorrectValue);
        payWithCredit.inCorrectFormat();
        payWithCredit.emptyField();

    }

    @Test
    @DisplayName("Должно быть сообщение об успешной оплате с одобренной картой если месяц текущий, а год будущий")
    public void shouldPayWithApprovedCardIfCurrentMonth() {
        val page1 = new Page1();
        val correctValue = DataHelper.getCorrectValue024();
        val payWithCard = page1.pay();
        payWithCard.fillCardValue(correctValue);
        payWithCard.successOrder();

    }

    @Test
    @DisplayName("Должно быть сообщение об успешной оплате в кредит с одобренной картой если месяц текущий, а год будущий")
    public void shouldSuccessCreditWithApprovedCardIfCurrentMonth() {
        val page1 = new Page1();
        val correctValue = DataHelper.getCorrectValue024();
        val payWithCredit = page1.payWithCredit();
        payWithCredit.fillCardValue(correctValue);
        payWithCredit.successOrder();

    }


}
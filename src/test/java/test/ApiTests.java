package test;

import data.SQL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.Api.payCard;
import static data.DataHelper.getCardNumber;
import static data.SQL.deleteTables;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ApiTests {

    private static final int amount = 45_000_00;
    private final String pay = "/pay";
    private final String payWithCredit = "/credit";

    @AfterEach
    void setDownDB() {
        deleteTables();
    }

    @Test
    @DisplayName("Наличие поля Amount при оплате одобреной картой")
    void shouldHaveAmountWithDebitApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), pay, 200);
        assertEquals(amount, SQL.getAmountDebitCard());
    }

    @Test
    @DisplayName("Наличие статуса APPROVED при оплате одобренной дебетовой картой")
    void shouldHaveStatusWithDebitApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), pay, 200);
        assertEquals("APPROVED", SQL.getStatusPayCard());
    }

    @Test
    @DisplayName("Наличие поля PaymentId при оплате одобренной дебетовой картой")
    void shouldHavePaymentIdWithDebitApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), pay, 200);
        assertNotNull(SQL.getPaymentId());
    }

    @Test
    @DisplayName("Должно быть поле TransactionId при оплате одобренной дебетовой картой")
    void shouldHaveTransactionIdWithDebitApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), pay, 200);
        assertNotNull(SQL.getTransactionIdPayCard());
    }

    @Test
    @DisplayName("Поля PaymentId и TransactionId должны быть равны при оплате одобренной дебетовой картой")
    void shouldEqualPaymentAndTransactionIdWithDebitApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), pay, 200);
        assertEquals(SQL.getPaymentId(), SQL.getTransactionIdPayCard());
    }

    @Test
    @DisplayName("Должно отсутствовать поле CreditId при оплате одобренной дебетовой картой")
    void shouldNotHaveCreditIdWithDebitApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), pay, 200);
        assertNull(SQL.getCreditId());
    }

    @Test
    @DisplayName("Должен быть статус DECLINED при оплате одобренной дебетовой картой")
    void shouldHaveStatusWithDebitDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), pay, 200);
        assertEquals("DECLINED", SQL.getStatusPayCard());
    }

    @Test
    @DisplayName("Должно отсутствовать поле Amount при оплате отклоненной дебетовой картой")
    void shouldNotHaveAmountWithDebitDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), pay, 200);
        assertNull(SQL.getAmountDebitCard());
    }

    @Test
    @DisplayName("Должно отсутствовать поле PaymentId при оплате отклоненной дебетовой картой")
    void shouldNotHavePaymentIdWithDebitDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), pay, 200);
        assertNull(SQL.getPaymentId());
    }

    @Test
    @DisplayName("Должно отсутствовать поле TransactionId при оплате отклоненной дебетовой картой")
    void shouldNotHaveTransactionIdWithDebitDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), pay, 200);
        assertNull(SQL.getTransactionIdPayCard());
    }

    @Test
    @DisplayName("Должно отсутствовать поле CreditId при оплате отклоненной дебетовой картой")
    void shouldNotHaveCreditIdWithDebitDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), pay, 200);
        assertNull(SQL.getCreditId());
    }

    @Test
    @DisplayName("Должна вернуться ошибка при оплате неизвестной дебетовой картой")
    void shouldReturnFailWithDebitUnknownCard() {
        payCard(getCardNumber().getCardNumberRandom(), pay, 500);
    }


    @Test
    @DisplayName("Должен быть статус APPROVED при оплате одобренной кредитной картой")
    void shouldHaveStatusWithCreditApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), payWithCredit, 200);
        assertEquals("APPROVED", SQL.getStatusPayCredit());
    }

    @Test
    @DisplayName("Должно быть поле BankId при оплате одобренной кредитной картой")
    void shouldHaveBankIdWithCreditApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), payWithCredit, 200);
        assertNotNull(SQL.getBankIdCreditCard());
    }

    @Test
    @DisplayName("Должно быть поле CreditId при оплате одобренной кредитной картой")
    void shouldHaveCreditIdWithCreditApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), payWithCredit, 200);
        assertNotNull(SQL.getCreditId());
    }

    @Test
    @DisplayName("Должно отсутствовать поле PaymentId при оплате одобренной кредитной картой")
    void shouldNotHavePaymentIdWithCreditApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), payWithCredit, 200);
        assertNull(SQL.getPaymentId());
    }

    @Test
    @DisplayName("Должен быть статус DECLINED при оплате отклоненной кредитной картой")
    void shouldHaveStatusWithCreditDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), payWithCredit, 200);
        assertEquals("DECLINED", SQL.getStatusPayCredit());
    }

    @Test
    @DisplayName("Должно отсутствовать поле BankId при оплате отклоненной кредитной картой")
    void shouldNotHaveBankIdWithCreditDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), payWithCredit, 200);
        assertNull(SQL.getBankIdCreditCard());
    }

    @Test
    @DisplayName("Должно отсутствовать поле CreditId при оплате отклоненной кредитной картой")
    void shouldNotHaveCreditIdWithCreditApprovedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), payWithCredit, 200);
        assertNull(SQL.getCreditId());
    }

    @Test
    @DisplayName("Должно отсутствовать поле PaymentId при оплате отклоненной кредитной картой")
    void shouldNotHavePaymentIdWithCreditDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), payWithCredit, 200);
        assertNull(SQL.getPaymentId());
    }

    @Test
    @DisplayName("Должна вернуться ошибка при оплате неизвестной кредитной картой")
    void shouldReturnFailWithCreditUnknownCard() {
        payCard(getCardNumber().getCardNumberRandom(), payWithCredit, 500);
    }

}
package test;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static data.Api.*;
import static data.DataHelper.getApprovedValue;
import static data.DataHelper.getDeclinedValue;

public class ApiTests {

    @Test
    void shouldGetStatusValidApprovedCardPayment() {
        val validApprovedCard = getApprovedValue();
        val status = PaymentPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void shouldGetStatusValidDeclinedCardPayment() {
        val validDeclinedCard = getDeclinedValue();
        val status = PaymentPageForm(validDeclinedCard);
        assertTrue(status.contains("DECLINED"));
    }

    @Test
    void shouldGetStatusValidApprovedCardCreditRequest() {
        val validApprovedCard = getApprovedValue();
        val status = CreditRequestPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void shouldGetStatusValidDeclinedCardCreditRequest() {
        val validDeclinedCard = getDeclinedValue();
        val status = CreditRequestPageForm(validDeclinedCard);
        assertTrue(status.contains("DECLINED"));
    }
}

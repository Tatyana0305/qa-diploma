package test;

import data.SQL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.Api.payCard;
import static data.DataHelper.getCardNumber;
import static data.SQL.deleteTables;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTests {


    private final String pay = "/pay";
    private final String payWithCredit = "/credit";

    @AfterEach
    void setDownDB() {
        deleteTables();
    }


    @Test
    @DisplayName("Наличие статуса APPROVED при оплате одобренной дебетовой картой")
    void shouldHaveStatusWithDebitApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), pay, 200);
        assertEquals("APPROVED", SQL.getStatusPayment());
    }

    @Test
    @DisplayName("Должен быть статус APPROVED при оплате одобренной кредитной картой")
    void shouldHaveStatusWithCreditApprovedCard() {
        payCard(getCardNumber().getCardNumberApproved(), payWithCredit, 200);
        assertEquals("APPROVED", SQL.getStatusCredit());
    }

    @Test
    @DisplayName("Должен быть статус DECLINED при оплате отклоненной дебетовой картой")
    void shouldHaveStatusWithDebitDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), pay, 200);
        assertEquals("DECLINED", SQL.getStatusCredit());
    }

    @Test
    @DisplayName("Должен быть статус DECLINED при оплате отклоненной кредитной картой")
    void shouldHaveStatusWithCreditDeclinedCard() {
        payCard(getCardNumber().getCardNumberDeclined(), payWithCredit, 200);
        assertEquals("DECLINED", SQL.getStatusCredit());
    }

    @Test
    @DisplayName("Должна вернуться ошибка при оплате неизвестной дебетовой картой")
    void shouldReturnFailWithDebitUnknownCard() {
        payCard(getCardNumber().getCardNumberRandom(), pay, 500);
    }

    @Test
    @DisplayName("Должна вернуться ошибка при оплате неизвестной кредитной картой")
    void shouldReturnFailWithCreditUnknownCard() {
        payCard(getCardNumber().getCardNumberRandom(), payWithCredit, 500);
    }


}
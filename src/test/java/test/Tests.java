package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.Test;
import page.Page1;

import static com.codeborne.selenide.Selenide.open;

public class Tests {
    @Test
    public void shouldPayWithApprovedCard() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedValue();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.successOrder();
    }

    @Test
    public void shouldPayWithDeclinedCard() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val declinedValue = DataHelper.getDeclinedValue();
        val page2 = page1.pay();
        val page21 = page2.valueDeclined(declinedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayInCreditWithApprovedCard() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedValue();
        val page3 = page1.payWithCredit();
        val page31 = page3.valueApproved(approvedValue);
        page31.successOrder();
    }

    @Test
    public void shouldPayInCreditWithDeclinedCard() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val declinedValue = DataHelper.getDeclinedValue();
        val page3 = page1.payWithCredit();
        val page31 = page3.valueDeclined(declinedValue);
        page31.failedOrder();

    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue1() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue1();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue2() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue2();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }
    @Test
    public void shouldPayApprovedCardWithIncorrectValue3() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue3();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }
    @Test
    public void shouldPayApprovedCardWithIncorrectValue4() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue4();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue5() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue5();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }
    @Test
    public void shouldPayApprovedCardWithIncorrectValue6() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue6();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue7() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue7();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue8() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue8();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue9() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue9();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue010() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue010();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue011() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue011();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue012() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue012();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue013() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue013();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue014() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue014();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue015() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue015();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue016() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue016();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayApprovedCardWithIncorrectValue017() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue017();
        val page2 = page1.pay();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue1() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue1();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue2() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue2();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue3() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue3();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue4() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue4();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue5() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue5();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue6() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue6();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue7() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue7();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue8() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue8();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue9() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue9();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue010() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue010();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue011() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue011();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue012() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue012();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue013() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue013();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue014() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue014();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue015() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue015();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue016() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue016();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

    @Test
    public void shouldPayWithCreditByApprovedCardWithIncorrectValue017() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";
        val page1 = new Page1();
        val approvedValue = DataHelper.getApprovedIncorrectValue017();
        val page2 = page1.payWithCredit();
        val page21 = page2.valueApproved(approvedValue);
        page21.failedOrder();
    }

}

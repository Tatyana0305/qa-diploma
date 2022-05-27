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
}

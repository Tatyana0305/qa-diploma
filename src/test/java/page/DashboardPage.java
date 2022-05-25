package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private SelenideElement heading = $x("//*[text()=\"Путешествие дня\"]");

    public DashboardPage() {
        heading.shouldBe(visible);
    }
}


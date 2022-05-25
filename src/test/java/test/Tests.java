package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class Tests {
    @Test
    public void shouldByTourWithCorrectValue() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1908х900";


    }
}

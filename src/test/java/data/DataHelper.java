package data;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@NoArgsConstructor

public class DataHelper {
    static Faker faker = new Faker(new Locale("en"));

    public static String generateHolder() {
        String holder = faker.name().fullName();
        return holder;
    }

    public static String[] cvc = new String[]{
            "123", "234", "345", "456", "567", "678", "789"
    };

    public static String generateCvc() {
        Random generator = new Random();
        int randomIndex = generator.nextInt(6);
        return cvc[randomIndex];
    }

    public static String generateFutureMonth() {
        String month = LocalDate.now().plusMonths(8).format(DateTimeFormatter.ofPattern("MM"));
        return month;
    }

    public static String generateFutureYear() {
        String year = LocalDate.now().plusYears(2).format(DateTimeFormatter.ofPattern("yy"));
        return year;
    }

    public static String generatePastMonth() {
        String month = LocalDate.now().minusMonths(3).format(DateTimeFormatter.ofPattern("MM"));
        return month;
    }

    public static String generatePastYear() {
        String year = LocalDate.now().minusYears(34).format(DateTimeFormatter.ofPattern("yy"));
        return year;
    }

    public static String generateCurrentMonth() {
        String month = LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
        return month;
    }

    public static String generateCurrentYear() {
        String year = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
        return year;
    }

    @Value
    public static class CardNumber {
        private String cardNumberApproved;
        private String cardNumberDeclined;
        private String cardNumberRandom;
    }

    public static CardNumber getCardNumber() {
        return new CardNumber("4444 4444 4444 4441", "4444 4444 4444 4442", "4444 4444 4444 4443");
    }

    @Value
    public static class CardValue {
        String cardNumber;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static CardValue getApprovedValue() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generateFutureYear(), generateHolder(), generateCvc());
    }

    public static CardValue getDeclinedValue() {
        return new CardValue(getCardNumber().cardNumberDeclined, generateFutureMonth(), generateFutureYear(), generateHolder(), generateCvc());

    }

    public static CardValue getIncorrectValue1() {
        return new CardValue("0000 0000 0000 0000 0000", generateFutureMonth(), generateFutureYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue2() {
        return new CardValue("++++ ++++ ++++ ++++", generateFutureMonth(), generateFutureYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue3() {
        return new CardValue("ssss ssss ssss ssss", generateFutureMonth(), generateFutureYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue4() {
        return new CardValue(getCardNumber().cardNumberRandom, generateFutureMonth(), generateFutureYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue5() {
        return new CardValue(getCardNumber().cardNumberApproved, "13", generateCurrentYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue6() {
        return new CardValue(getCardNumber().cardNumberApproved, generatePastMonth(), generateCurrentYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue7() {
        return new CardValue(getCardNumber().cardNumberApproved, "++", generateFutureYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue8() {
        return new CardValue(getCardNumber().cardNumberApproved, "ss", generateFutureYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue9() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generatePastYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue010() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), "++", generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue011() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), "ss", generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue012() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generateFutureYear(), "Петров Иван", generateCvc());
    }

    public static CardValue getIncorrectValue013() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generateFutureYear(), "+++ ++++", generateCvc());
    }

    public static CardValue getIncorrectValue014() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generateFutureYear(), "111 11111", generateCvc());
    }

    public static CardValue getIncorrectValue015() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generateFutureYear(), generateHolder(), "000");
    }

    public static CardValue getIncorrectValue016() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generateFutureYear(), generateHolder(), "sss");
    }

    public static CardValue getIncorrectValue017() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generateFutureYear(), generateHolder(), "+++");
    }

    public static CardValue getIncorrectValue018() {
        return new CardValue("", "", "", "", "");
    }

    public static CardValue getIncorrectValue019() {
        return new CardValue("", generateFutureMonth(), generateFutureYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue020() {
        return new CardValue(getCardNumber().cardNumberApproved, "", generateFutureYear(), generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue021() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), "", generateHolder(), generateCvc());
    }

    public static CardValue getIncorrectValue022() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generateFutureYear(), "", generateCvc());
    }

    public static CardValue getIncorrectValue023() {
        return new CardValue(getCardNumber().cardNumberApproved, generateFutureMonth(), generateFutureYear(), generateHolder(), "");
    }

}

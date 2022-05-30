package data;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;

@NoArgsConstructor

public class DataHelper {
    static Faker faker = new Faker(new Locale("en"));

    public static String holder() {
        String holder = faker.name().fullName();
        return holder;
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
        return new CardValue("4444 4444 4444 4441", "08", "22", faker.name().fullName(), "123");
    }

    public static CardValue getDeclinedValue() {
        return new CardValue("4444 4444 4444 4442", "08", "22", faker.name().fullName(), "123");

    }

    public static CardValue getIncorrectValue1() {
        return new CardValue("0000 0000 0000 0000 0000", "08", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue2() {
        return new CardValue("++++ ++++ ++++ ++++", "08", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue3() {
        return new CardValue("ssss ssss ssss ssss", "08", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue4() {
        return new CardValue("1111 1111 1111 1111", "08", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue5() {
        return new CardValue("4444 4444 4444 4441", "13", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue6() {
        return new CardValue("4444 4444 4444 4441", "01", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue7() {
        return new CardValue("4444 4444 4444 4441", "++", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue8() {
        return new CardValue("4444 4444 4444 4441", "ss", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue9() {
        return new CardValue("4444 4444 4444 4441", "08", "11", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue010() {
        return new CardValue("4444 4444 4444 4441", "08", "++", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue011() {
        return new CardValue("4444 4444 4444 4441", "08", "ss", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue012() {
        return new CardValue("4444 4444 4444 4441", "08", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue013() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "+++ ++++", "123");
    }

    public static CardValue getIncorrectValue014() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "111 11111", "123");
    }

    public static CardValue getIncorrectValue015() {
        return new CardValue("4444 4444 4444 4441", "08", "22", faker.name().fullName(), "000");
    }

    public static CardValue getIncorrectValue016() {
        return new CardValue("4444 4444 4444 4441", "08", "22", faker.name().fullName(), "+++");
    }

    public static CardValue getIncorrectValue017() {
        return new CardValue("4444 4444 4444 4441", "08", "22", faker.name().fullName(), "sss");
    }

    public static CardValue getIncorrectValue018() {
        return new CardValue("", "", "", "", "");
    }

    public static CardValue getIncorrectValue019() {
        return new CardValue("", "08", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue020() {
        return new CardValue("4444 4444 4444 4441", "", "22", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue021() {
        return new CardValue("4444 4444 4444 4441", "08", "", faker.name().fullName(), "123");
    }

    public static CardValue getIncorrectValue022() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "", "123");
    }

    public static CardValue getIncorrectValue023() {
        return new CardValue("4444 4444 4444 4441", "08", "22", faker.name().fullName(), "");
    }

}

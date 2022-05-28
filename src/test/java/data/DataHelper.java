package data;

import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor

public class DataHelper {

    @Value
    public static class CardValue {
        String cardNumber;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static CardValue getApprovedValue() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "Petrov Ivan", "123");
    }

    public static CardValue getDeclinedValue() {
        return new CardValue("4444 4444 4444 4442", "08", "22", "Petrov Ivan", "123");

    }

    public static CardValue getIncorrectValue1() {
        return new CardValue("0000 0000 0000 0000 0000", "08", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue2() {
        return new CardValue("++++ ++++ ++++ ++++", "08", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue3() {
        return new CardValue("ssss ssss ssss ssss", "08", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue4() {
        return new CardValue("1111 1111 1111 1111", "08", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue5() {
        return new CardValue("4444 4444 4444 4441", "13", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue6() {
        return new CardValue("4444 4444 4444 4441", "01", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue7() {
        return new CardValue("4444 4444 4444 4441", "++", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue8() {
        return new CardValue("4444 4444 4444 4441", "ss", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue9() {
        return new CardValue("4444 4444 4444 4441", "08", "11", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue010() {
        return new CardValue("4444 4444 4444 4441", "08", "++", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue011() {
        return new CardValue("4444 4444 4444 4441", "08", "ss", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue012() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "Петров Иван", "123");
    }

    public static CardValue getIncorrectValue013() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "+++ ++++", "123");
    }

    public static CardValue getIncorrectValue014() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "111 11111", "123");
    }

    public static CardValue getIncorrectValue015() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "Petrov Ivan", "000");
    }

    public static CardValue getIncorrectValue016() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "Petrov Ivan", "+++");
    }

    public static CardValue getIncorrectValue017() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "Petrov Ivan", "sss");
    }

    public static CardValue getIncorrectValue018() {
        return new CardValue("", "", "", "", "");
    }

    public static CardValue getIncorrectValue019() {
        return new CardValue("", "08", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue020() {
        return new CardValue("4444 4444 4444 4441", "", "22", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue021() {
        return new CardValue("4444 4444 4444 4441", "08", "", "Petrov Ivan", "123");
    }

    public static CardValue getIncorrectValue022() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "", "123");
    }

    public static CardValue getIncorrectValue023() {
        return new CardValue("4444 4444 4444 4441", "08", "22", "Petrov Ivan", "");
    }

}

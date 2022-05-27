package data;

import lombok.Data;
import lombok.Value;

@Data


public class DataHelper {

    @Value
    public static class ValueApproved {
        String cardNumber;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static ValueApproved getApprovedValue() {
        return new ValueApproved("4444 4444 4444 4441", "08", "22", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue1() {
        return new ValueApproved("0000 0000 0000 0000 0000", "08", "22", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue2() {
        return new ValueApproved("++++ ++++ ++++ ++++", "08", "22", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue3() {
        return new ValueApproved("ssss ssss ssss ssss", "08", "22", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue4() {
        return new ValueApproved("1111 1111 1111 1111", "08", "22", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue5() {
        return new ValueApproved("4444 4444 4444 4441", "13", "22", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue6() {
        return new ValueApproved("4444 4444 4444 4441", "01", "22", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue7() {
        return new ValueApproved("4444 4444 4444 4441", "++", "22", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue8() {
        return new ValueApproved("4444 4444 4444 4441", "ss", "22", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue9() {
        return new ValueApproved("4444 4444 4444 4441", "08", "11", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue010() {
        return new ValueApproved("4444 4444 4444 4441", "08", "++", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue011() {
        return new ValueApproved("4444 4444 4444 4441", "08", "ss", "Petrov Ivan", "123");
    }

    public static ValueApproved getApprovedIncorrectValue012() {
        return new ValueApproved("4444 4444 4444 4441", "08", "22", "Петров Иван", "123");
    }

    public static ValueApproved getApprovedIncorrectValue013() {
        return new ValueApproved("4444 4444 4444 4441", "08", "22", "+++ ++++", "123");
    }

    public static ValueApproved getApprovedIncorrectValue014() {
        return new ValueApproved("4444 4444 4444 4441", "08", "22", "111 11111", "123");
    }

    public static ValueApproved getApprovedIncorrectValue015() {
        return new ValueApproved("4444 4444 4444 4441", "08", "22", "111 11111", "000");
    }

    public static ValueApproved getApprovedIncorrectValue016() {
        return new ValueApproved("4444 4444 4444 4441", "08", "22", "111 11111", "+++");
    }

    public static ValueApproved getApprovedIncorrectValue017() {
        return new ValueApproved("4444 4444 4444 4441", "08", "22", "111 11111", "sss");
    }


    @Value
    public static class ValueDeclined {
        String cardNumber;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static ValueDeclined getDeclinedValue() {
        return new ValueDeclined("4444 4444 4444 4442", "08", "22", "Petrov Ivan", "123");
    }

}
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
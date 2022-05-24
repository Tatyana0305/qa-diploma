package data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class HolderInfo {
        String name;
    }

    public static HolderInfo getCorrectName() {
        return new HolderInfo("Petrov Ivan");
    }

    public static HolderInfo getInCorrectName1() {
        return new HolderInfo("Петров Иван");
    }

    public static HolderInfo getInCorrectName2() {
        return new HolderInfo("111 1111");
    }

    public static HolderInfo getInCorrectName3() {
        return new HolderInfo("+++ ++++");
    }

    @Value
    public static class ValidityCard {
        String month;
        String year;

        public static DataHelper.ValidityCard getCorrectValidity() {
            return new DataHelper.ValidityCard("08", "22");
        }

        public static DataHelper.ValidityCard getInCorrectValidity1() {
            return new DataHelper.ValidityCard("01", "22");
        }

        public static DataHelper.ValidityCard getInCorrectValidity2() {
            return new DataHelper.ValidityCard("13", "22");
        }

        public static DataHelper.ValidityCard getInCorrectValidity3() {
            return new DataHelper.ValidityCard("01", "21");
        }

        public static DataHelper.ValidityCard getInCorrectValidity4() {
            return new DataHelper.ValidityCard("01", "11");
        }
    }

    @Value
    public static class CVCCode {
        String cvc;

        public static DataHelper.CVCCode getCorrectCVCCode() {
            return new DataHelper.CVCCode("123");
        }

        public static DataHelper.CVCCode getInCorrectCVCCode1() {
            return new DataHelper.CVCCode("000");
        }

        public static DataHelper.CVCCode getInCorrectCVCCode2() {
            return new DataHelper.CVCCode("+++");
        }

        public static DataHelper.CVCCode getInCorrectCVCCode3() {
            return new DataHelper.CVCCode("aaa");
        }

    }
}
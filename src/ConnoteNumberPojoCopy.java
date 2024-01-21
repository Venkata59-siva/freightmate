
public class ConnoteNumberPojo {
    private String carrierName;
    private String accountNumber;
    private int digits;
    private int lastUsedIndex;
    private int rangeStart;
    private int rangeEnd;

    public ConnoteNumberPojo(String carrierName, String accountNumber, int digits, int lastUsedIndex, int rangeStart, int rangeEnd) {
        this.carrierName = carrierName;
        this.accountNumber = accountNumber;
        this.digits = digits;
        this.lastUsedIndex = lastUsedIndex;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDigits() {
        return digits;
    }

    public int getLastUsedIndex() {
        return lastUsedIndex;
    }

    public int getRangeStart() {
        return rangeStart;
    }

    public int getRangeEnd() {
        return rangeEnd;
    }

    @Override
    public String toString() {
        return "ConnoteNumberDto" +
                " {" +
                "carrierName:'" + carrierName + '\'' +
                ", accountNumber:'" + accountNumber + '\'' +
                ", digits:" + digits +
                ", lastUsedIndex:" + lastUsedIndex +
                ", rangeStart:" + rangeStart +
                ", rangeEnd:" + rangeEnd +
                '}';
    }
}

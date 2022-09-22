

public class ConsignmentNoteNumberGenerator {

    public static void main(String[] args) {
        // ConnoteNumber pojo object creation
        ConnoteNumberPojo connoteInput = new ConnoteNumberPojo("FreightmateCourierCo", "123ABC", 10, 19604, 19000, 20000);
        System.out.println(connoteInput);

        ConsignmentNoteNumberGenerator connoteServicGeneratore = new ConsignmentNoteNumberGenerator(); // ConsignmentNoteNumberGenerator object creation
        String uniqueConnoteNumber =  connoteServicGeneratore.generateConnoteNumber(connoteInput); // call generateConnoteNumber() method  for generate Connote Number of given previous Connote Number
        System.out.println("The new Consignment Note Number: " + uniqueConnoteNumber);
    }
    
    public  String  generateConnoteNumber(ConnoteNumberPojo connote) {
        int previousIndex = connote.getLastUsedIndex();
        int digits = connote.getDigits();
        String connoteNumber = "";
        if (previousIndex >= connote.getRangeStart() && previousIndex < connote.getRangeEnd()) {
            String prefix = getPrefix(connote.getCarrierName());
            int currentIndex = previousIndex + 1; //consignment index must be incremented from last used index
            String consignmentIndex = String.format("%0" + digits + "d", currentIndex); // padded 0's to make index as given index i.e. 10
            int checkSum = generateCheckSum(consignmentIndex, digits);
            connoteNumber = prefix + connote.getAccountNumber() + consignmentIndex + String.valueOf(checkSum);
        } else {
            connoteNumber = "The given last Connote Number was not in Range " + connote.getRangeStart() + "-" + connote.getRangeEnd();
        }
        return connoteNumber;
    }

    // 
    private String getPrefix(String carrierName) {
        char[] carrierNames = carrierName.toCharArray();
        String prefix = "";
        for (int i = 0; i < carrierNames.length; i++) {
            if (Character.isUpperCase(carrierNames[i])) {
                prefix += carrierNames[i];
            }
        }
        return prefix;
    }

    // method calculate checksum of given consignment index with number of digits
    private int generateCheckSum(String consignmentIndex, int digit) {
        int checkSum = 0;
        int firstCheckSum = 0;
        int secondCheckSum = 0;
        char[] consignmentChar = consignmentIndex.toCharArray();

        // calculate checksum of every second number in the index from the right starting at the first element
        for (int i = consignmentChar.length - 1; i >= 0; i = i - 2) {
            firstCheckSum += Integer.parseInt(String.valueOf(consignmentChar[i]));
        }

        // calculate checksum of every second number in the index from the right starting at the second element
        for (int i = consignmentChar.length - 2; i >= 0; i = i - 2) {
            secondCheckSum += Integer.parseInt(String.valueOf(consignmentChar[i]));
        }

        /* multiply first and second check sum by 3 and 7 respectively and sum up
            and difference with digits multiple of 10
        */
        checkSum = Math.abs((digit * 10) - (firstCheckSum * 3 + secondCheckSum * 7));
        return checkSum;
    }

}

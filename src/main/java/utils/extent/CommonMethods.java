package utils.extent;

import java.security.SecureRandom;
import java.util.Random;

public class CommonMethods {
    private static final Random random = new Random();
    private static final SecureRandom rnd = new SecureRandom();
    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomEmail = new StringBuilder();
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            randomEmail.append(characters.charAt(index));
        }

        return randomEmail.toString() + "@gmail.com";

    }
    public static String generateRandomESIC() {
        StringBuilder esic = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            esic.append(random.nextInt(10));
        }
        return esic.toString();
    }
    public static String generateRandomPAN() {
        Random random = new Random();
        StringBuilder panBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char randomLetter = (char) (random.nextInt(26) + 'A');
            panBuilder.append(randomLetter);
        }

        for (int i = 0; i < 4; i++) {
            int randomDigit = random.nextInt(10);
            panBuilder.append(randomDigit);
        }
        char lastLetter = (char) (random.nextInt(26) + 'A');
        panBuilder.append(lastLetter);

        return panBuilder.toString();
    }
    public static String generateRandomPF() {
        StringBuilder pf = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            pf.append(random.nextInt(12));  // append digits 0-9
        }
        return pf.toString();
    }
    public static String generateAccount(int length) {
        if (length <= 0) throw new IllegalArgumentException("length must be > 0");
        StringBuilder sb = new StringBuilder(length);
        // ensure first digit != '0'
        sb.append((char)('1' + rnd.nextInt(9)));
        for (int i = 1; i < length; i++) {
            sb.append((char)('0' + rnd.nextInt(10)));
        }
        return sb.toString();
    }
    public static String generateMobileNumber() {
        Random random = new Random();
        String[] startDigits = {"6", "7", "8", "9"}; // Valid starting digits for Indian mobiles
        String mobileNumber = startDigits[random.nextInt(startDigits.length)];
        for (int i = 0; i < 9; i++) {
            mobileNumber += random.nextInt(10);
        }
        return mobileNumber;
    }
    public static String generateAadhaarNumber() {
        Random random = new Random();
        StringBuilder aadhaarNumber = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            aadhaarNumber.append(random.nextInt(10));
        }
        return aadhaarNumber.toString();
    }


}


package utils.extent;

public class CommonMethods {
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
}


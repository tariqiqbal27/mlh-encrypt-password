import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PasswordEncrypt {

    private String EncryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] messageDigestBytes = messageDigest.digest(password.getBytes());
            BigInteger num = new BigInteger(1, messageDigestBytes);
            String hashText = num.toString(16);
            while (hashText.length() < 32)
                hashText = "0" + hashText;

            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] ar) {

        PasswordEncrypt obj = new PasswordEncrypt();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter Password: ");
        String password = in.nextLine();
        String encPassword = obj.EncryptPassword(password);

        System.out.print("Encrypted Password: " + encPassword);
    }

}
package encryptdecrypt.encryptor;

public class ConcreteUnicodeEncryptionStrategy implements EncryptionStrategy {
    @Override
    public String encrypt(String unencryptedString, int shift) {
        StringBuilder encryptedString = new StringBuilder();

        for (char c : unencryptedString.toCharArray()) {
            char encryptedChar = (char) (c + shift);
            encryptedString.append(encryptedChar);
        }
        return encryptedString.toString();
    }
    @Override
    public String decrypt(String encryptedString, int shift) {
        return encrypt(encryptedString, -shift);
    }
}

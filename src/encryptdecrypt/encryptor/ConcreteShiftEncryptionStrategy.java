package encryptdecrypt.encryptor;

import encryptdecrypt.Math;

public class ConcreteShiftEncryptionStrategy implements EncryptionStrategy {
    @Override
    public String encrypt(String unencriptedString, int shift) {
        StringBuilder encryptedString = new StringBuilder();

        for (char c : unencriptedString.toCharArray()) {
            char encryptedChar = c;
            if (c >= 'a' && c <= 'z') {
                encryptedChar = (char) (Math.mod(c - 'a' + shift, 26) + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                encryptedChar = (char)  (Math.mod(c - 'A' + shift, 26) + 'A');
            }
            encryptedString.append(encryptedChar);
        }
        return encryptedString.toString();
    }
    @Override
    public String decrypt(String encryptedString, int shift) {
        return encrypt(encryptedString, - shift);
    }
}

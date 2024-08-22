package encryptdecrypt.encryptor;

public interface EncryptionStrategy {
    String encrypt(String unencryptedString, int shift);
    String decrypt(String encryptedString, int shift);
}

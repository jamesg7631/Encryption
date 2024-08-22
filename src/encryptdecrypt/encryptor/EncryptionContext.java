package encryptdecrypt.encryptor;

public class EncryptionContext {
    private EncryptionStrategy method;
    public void setMethod(EncryptionStrategy method) {
        this.method = method;
    }

    public void encrypt(String unencryptedString, int shift) {
        System.out.println(this.method.encrypt(unencryptedString, shift));
    }

    public void decrypt(String encryptedString, int shift) {
        System.out.println(this.method.decrypt(encryptedString, shift));
    }
}

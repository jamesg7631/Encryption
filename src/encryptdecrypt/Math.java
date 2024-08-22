package encryptdecrypt;

public class Math {

    public static int mod(int x, int y) {
        int remainder = x % y;

        if (remainder < 0) {
            return remainder + y;
        } else {
            return remainder;
        }
    }
}

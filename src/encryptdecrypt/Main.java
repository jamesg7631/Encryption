package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ProgramConfig programConfig = new ProgramConfig(args);
        programConfig.execute();// Might be work making the set fields private and using them directly in the constructor
    }
}

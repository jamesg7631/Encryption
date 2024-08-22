package encryptdecrypt;

import encryptdecrypt.encryptor.ConcreteShiftEncryptionStrategy;
import encryptdecrypt.encryptor.ConcreteUnicodeEncryptionStrategy;
import encryptdecrypt.encryptor.EncryptionContext;
import encryptdecrypt.encryptor.EncryptionStrategy;
import output.CommandLineOutputFileStrategy;
import output.OutputFileStrategy;
import output.WriteToFileOutputFileStrategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProgramConfig {
    private String mode;
    private int key;
    private String data;
    private EncryptionStrategy algorithm;
    private String baseDirectory;
    private OutputFileStrategy writeToOutputFile;
    private String[] commandLineArgs;
    public ProgramConfig(String[] commandLineArgs) {
        this.commandLineArgs = commandLineArgs;
        this.baseDirectory = "C:\\Users\\james\\IdeaProjects\\Encryption-Decryption (Java)\\Encryption-Decryption (Java)\\task\\";
        setMode();
        setKey();
        setData();
        setAlgorithm();
        setWriteToOutputFile();
    }
    private void setMode() {
        int modeIndex = findIndexFirstOccurrence("-mode");
        if (modeIndex != -1) {
            this.mode = commandLineArgs[modeIndex + 1];
        } else {
            this.mode = "enc";
        }
    }
    private void setKey() {
        int keyIndex = findIndexFirstOccurrence("-key");
        if (keyIndex != -1) {
            this.key = Integer.parseInt(commandLineArgs[keyIndex + 1]);
        } else {
            this.key = 0;
        }
    }
    private void setAlgorithm() {
        int algorithmIndex = findIndexFirstOccurrence("-alg");
        if (algorithmIndex != -1) {
            if (commandLineArgs[algorithmIndex + 1].equals("shift")) {
                this.algorithm = new ConcreteShiftEncryptionStrategy();
            } else if (commandLineArgs[algorithmIndex + 1].equals("unicode")) {
                this.algorithm = new ConcreteUnicodeEncryptionStrategy();
            }
        } else {
            this.algorithm = new ConcreteUnicodeEncryptionStrategy();
        }
    }
    private void setData() {
        int dataIndex = findIndexFirstOccurrence("-data");
        int inIndex = findIndexFirstOccurrence("-in");

        if (dataIndex != -1) {
            this.data = commandLineArgs[dataIndex + 1];
        } else if (inIndex != -1) {
            try {
                this.data = new String(Files.readAllBytes(Paths.get(baseDirectory + commandLineArgs[inIndex + 1])));
            } catch (IOException e) {
                this.data = "";
            }
        } else {
            this.data = "";
        }
    }
    private void setWriteToOutputFile() {
        int outputFileIndex = findIndexFirstOccurrence("-out");
        if (outputFileIndex == -1) {
            this.writeToOutputFile = new CommandLineOutputFileStrategy();
        } else {
            this.writeToOutputFile = new WriteToFileOutputFileStrategy(commandLineArgs[outputFileIndex + 1], this.baseDirectory);
        }
    }
    private int findIndexFirstOccurrence(String searchFor) {
        for (int i = 0; i < this.commandLineArgs.length; i++) {
            if (searchFor.equals(this.commandLineArgs[i])) {
                return i;
            }
        }
        return -1;
    }
    public String process() {
        String output = "";
        if (this.mode.equals("dec")) {
            output = algorithm.decrypt(data, key);
        } else {
            output = algorithm.encrypt(data, key);
        }
        return output;
    }
    public void execute() {
        String output = process();
        this.writeToOutputFile.output(output);
    }
}

package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileOutputFileStrategy implements OutputFileStrategy{

    final private String outputFileName;
    final private String baseDirectory;

    public WriteToFileOutputFileStrategy(String outputFileName, String baseDirectory) {
        this.outputFileName = outputFileName;
        this.baseDirectory = baseDirectory;
    }
    @Override
    public void output(String data) {
        File outputFile = new File(baseDirectory + outputFileName);
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(data);
        } catch (IOException e) {
            return;
        }
    }
}

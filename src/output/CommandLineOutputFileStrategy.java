package output;

public class CommandLineOutputFileStrategy implements OutputFileStrategy{
    @Override
    public void output(String data) {
        System.out.println(data);
    }
}

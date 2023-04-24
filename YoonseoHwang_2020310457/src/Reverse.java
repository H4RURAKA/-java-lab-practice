import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reverse {

    public static void main(String[] args) {
        String inputPath = "./input.txt";
        String outputPath = "./output.txt";

        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String data;
            while ((data = br.readLine()) != null) {
                lines.add(data);
            }
        } catch (IOException e) {
            System.err.println("File not Found!");
            System.exit(0);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            for (int i = lines.size() - 1; i >= 0; i--) {
                bw.write(lines.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Output File Write error");
        }
    }
}

import java.io.*;
import java.util.Locale;

public class Main {


    public static void avg() {
        try {
            File fileQ2 = new File("C:\\Users\\mutlu_45j\\IdeaProjects\\lab10\\src\\Question2.txt");
            BufferedReader csvReader_ = new BufferedReader(new FileReader(fileQ2));
            int i = 0;
            double sum = 0;
            String row;
            while ((row = csvReader_.readLine()) != null) {
                double row_d = Double.parseDouble(row.trim());
                sum += row_d;
                i++;
            }
            csvReader_.close();
            double avg = sum / i;
            File task2 = new File("C:\\Users\\mutlu_45j\\IdeaProjects\\lab10\\src\\task2.txt");
            if (task2.exists()) {
                task2.delete();
                task2.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(task2, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(Double.toString(avg));
            bWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void frequency() {
        try {
            File fileQ1 = new File("C:\\Users\\mutlu_45j\\IdeaProjects\\lab10\\src\\Question1.txt");
            BufferedReader csvReader = new BufferedReader(new FileReader(fileQ1));
            int[] freq = new int[26];
            String row;
            while ((row = csvReader.readLine()) != null) {
                row = row.toUpperCase(Locale.ROOT);
                for (int i = 0; i < row.length(); i++) {
                    int ch = row.charAt(i);
                    if (ch >= 65 && ch <= 90)
                        freq[ch - 65]++;
                }
            }
            File task1 = new File("C:\\Users\\mutlu_45j\\IdeaProjects\\lab10\\src\\task1.txt");
            if (task1.exists()) {
                task1.delete();
                task1.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(task1, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < freq.length; i++) {
                bWriter.write((char) (i + 65) + ":" + freq[i] + "\n");
            }
            bWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        frequency();
        avg();


    }
}



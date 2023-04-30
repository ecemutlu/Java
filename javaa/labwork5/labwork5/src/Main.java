import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


//https://mkyong.com/java/how-to-format-filetime-in-java/
//https://stackoverflow.com/questions/4917326/how-to-iterate-over-the-files-of-a-certain-directory-in-java
public class Main {

    private static <T extends Number> int findFrequency(T[] array, T value) {
        int result = 0;
        for (T element : array) {
            if (Objects.equals(element, value))
                result++;
        }
        return result;
    }

    private static void searchDirectory(String directoryPath, String extension) {
        File dir = new File(directoryPath);
        File[] list = dir.listFiles();
        String ext = "." + extension;
        if (list != null) {
            for (File file : list) {
                if (!file.isDirectory() && file.getName().toLowerCase(Locale.ROOT).endsWith(ext))
                    System.out.println(file.getName());
            }
        } else {
            System.out.println(directoryPath + " not a valid directory");
        }
    }

    private static void recursiveSearch(String directoryPath, List<String> allFiles, List<String> foundFiles) throws IOException {
        File dir = new File(directoryPath);
        File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (!file.isDirectory()) {
                    allFiles.add(file.getName());
                    Path filePath = Paths.get(file.getAbsolutePath());
                    BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
                    LocalDateTime localDateTime = attr.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    if (localDateTime.getYear() == 2022)
                        foundFiles.add(file.getName());
                } else
                    recursiveSearch(file.getAbsolutePath(), allFiles, foundFiles);
            }
        } else {
            System.out.println(directoryPath + " not a valid directory");
        }
    }


    public static void main(String[] args) throws IOException {
        Integer[] intarr = {1, 7, 9, 1, 7, 1, 8};
        System.out.println(findFrequency(intarr, 1));

        Double[] doublearr = {1.2, 1.3, 1.2, 5.7, 6.7};
        System.out.println(findFrequency(doublearr, 1.2));

       String[] strarr = {"e", "eee", "gjgj"};

        searchDirectory("C:\\Users\\mutlu_45j\\IdeaProjects\\Inheritance\\src", "java");

        List<String> allFiles = new ArrayList<>();
        List<String> foundFiles = new ArrayList<>();
        recursiveSearch("C:\\Users\\mutlu_45j\\Downloads", allFiles, foundFiles);
        System.out.println(foundFiles.size() + "/" + allFiles.size());
    }


}


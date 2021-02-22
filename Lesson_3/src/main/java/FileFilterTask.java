import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileFilterTask {

    private static final String EXTENSION_TXT = ".txt";

    public static void main(String[] args) {
        File file = new File("C://");

        System.out.println("Задание 2.1:");
        new FileFilterTask().filterFolders(file).forEach(str -> System.out.println(str.getName()));
        System.out.println();

        System.out.println("Задание 2.2:");
        new FileFilterTask().filterFiles(file).forEach(str -> System.out.println(str.getName()));
    }

    private List<File> filterFolders(File file) {
        return Arrays.asList(file.listFiles((File f) -> f.isDirectory()));
    }

    private List<File> filterFiles(File file) {
        List<File> filterFilesList = Arrays.asList(file.listFiles((File dir) ->
                dir.isFile() && dir.getName().endsWith(EXTENSION_TXT)));
        return filterFilesList;
    }
}

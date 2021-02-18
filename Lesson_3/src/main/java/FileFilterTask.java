import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileFilterTask {

    public static void main(String[] args) {

        File file = new File("C://");

        System.out.println("Задание 2.1:");
        new FileFilterTask().filterFolders(file).forEach(str -> System.out.println(str.getName()));
        System.out.println();

        System.out.println("Задание 2.2:");
        new FileFilterTask().filterFiles(file).forEach(str -> System.out.println(str.getName()));

    }

    private List<File> filterFolders(File file) {

        List<File> filterFoldersList = Arrays.asList(file.listFiles((File f) -> f.isDirectory()));
        return filterFoldersList;
    }

    private List<File> filterFiles(File file) {
        List<File> filterFilesList = Arrays.asList(file.listFiles((File dir) -> !dir.isDirectory() && getFileExtension(dir.getName()).equals("txt")));
        return filterFilesList;
    }

    private String getFileExtension(String extension) {
        if (extension.lastIndexOf(".") != -1 && extension.lastIndexOf(".") != 0) {
            return extension.substring(extension.lastIndexOf(".") + 1);
        }
        return null;
    }
}

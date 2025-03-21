import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static LocalDate myObj = LocalDate.now();
    static String mainDirectoryLocation = "C:\\" + myObj;
    public static void CreateDirectory(String Location) {
        File directory = new File(Location);
        if (directory.mkdir()) {
            System.out.println("Directory Succesfully Created at" + Location);
        } else {
            System.out.println("Failed to create Directory at at" + Location);
        }
    }

    public static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation) throws IOException {
        Files.walk(Paths.get(sourceDirectoryLocation)).forEach(source -> {
            Path destination = Paths.get(destinationDirectoryLocation, source.toString().substring(sourceDirectoryLocation.length()));
            try {
                Files.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
public static void BackupExample (String BackupLocation) throws IOException {
// change these two String variables to the name of the Backed up file and the Location of the files to backup respectively
       String CreatedDirectoryName = "BackupExampleTest";
       String SourceDirectoryLocation = "C:\\Users\\isaac\\Documents\\My Games\\Binding of Isaac Afterbirth+";
        CreateDirectory(BackupLocation + "\\" + CreatedDirectoryName);
        copyDirectory(SourceDirectoryLocation, mainDirectoryLocation + "\\" + CreatedDirectoryName);
}

    public static void main(String[] args) throws IOException {
       CreateDirectory(mainDirectoryLocation);
       BackupExample(mainDirectoryLocation);
    }
}

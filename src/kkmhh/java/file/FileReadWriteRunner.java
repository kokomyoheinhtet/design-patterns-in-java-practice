package kkmhh.java.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadWriteRunner {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("./resources/sample.txt");
            String fileContent = Files.readString(path);
            System.out.println("File content: " + fileContent);
            String newFileContent = fileContent.replace("{name}", "kkmhh");

            Path newPath = Paths.get("./resources/sample_new.txt");
            Files.writeString(newPath, newFileContent);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

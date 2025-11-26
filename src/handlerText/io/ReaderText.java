package handlerText.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderText {
    public static String[] read(String file) {
        try {
            Path path = Paths.get(file);
            String[] content = Files.readAllLines(path).toArray(new String[0]);
//            Files.writeString(path, "asdasdad");
            Files.readString(path).trim().split(", ");
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

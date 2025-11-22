package handlerText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderText {
    public static String[] read(String file){
        try{
            Path path = Paths.get(file);
            String[] content = Files.readAllLines(path).toArray(new String[0]);
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

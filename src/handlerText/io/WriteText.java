package handlerText.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteText {

    public static void write(String file, String data){
        try{
            Path path = Paths.get(file);
            Files.writeString(path, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

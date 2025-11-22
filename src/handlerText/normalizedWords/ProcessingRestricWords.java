package handlerText.normalizedWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProcessingRestricWords {

    // TODO(mudar para estrutura de dados propria)
    private static final Set<String> INVARIABLES = new HashSet<>();

    public static void generated(String file) throws IOException {
        Path path = Paths.get(file);
        String[] content = Files.readAllLines(path).toArray(new String[0]);

        // TODO(mudar para estrutura de dados propria)
        INVARIABLES.addAll(Arrays.stream(content).toList());
    }

    public static Boolean verify(String word){
        return INVARIABLES.contains(word);
    }

}

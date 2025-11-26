package handlerText.normalizedWords;

import structures.HashTable;
import structures.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ProcessingRestricWords {
    private static final HashTable INVARIABLES = new HashTable();
//    private static ProcessingRestricWords uniqueInstance = new ProcessingRestricWords();
    private static boolean isGenerated = false;

//    private ProcessingRestricWords(){}
//
//    public static ProcessingRestricWords getInstance(){
//        return uniqueInstance;
//    }


    public static void generated(String file) throws IOException {
        if(isGenerated) return;

        Path path = Paths.get(file);
        String[] content = Files.readAllLines(path).toArray(new String[0]);

        Arrays.stream(content).forEach( word -> {
            INVARIABLES.insert(NomalizedWord.normalizeAccents(word), 0);
        });
        isGenerated = true;
    }

    public static Boolean verify(String word){
        Word data = INVARIABLES.search(word);
        return data != null;
    }

}

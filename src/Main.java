import handlerText.io.ReaderText;
import handlerText.io.WriteText;
import handlerText.normalizedWords.NomalizedWord;
import handlerText.normalizedWords.RegexTextProcessing;
import handlerText.remissiveIndex.Remissive;
import structures.HashTable;

import java.io.IOException;
import java.util.Arrays;


public class Main {

    public static void printToWordSeparator(String[] text) throws IOException {

        for(int i = 0; i < text.length; i++){
            String[] wordsText = RegexTextProcessing.separtorWord(text[i], "src/data/restric_words.txt");

            System.out.println(Arrays.toString(wordsText));

        }
        System.out.println();
    }

    public static void reimissiveRun(String input, String search, String output, String log) throws IOException {
        String[] text = ReaderText.read(input);
        String[] wordsSearch = ReaderText.read(search);
        String[] normalizedWordsSearch = NomalizedWord.normalizeInWords(wordsSearch);

        HashTable table = Remissive.generate(text);

        String normalizedIndexWords = table.inOrder();

        String toWordsAndLines = Remissive.toWordsAndLines(normalizedWordsSearch);


        WriteText.write(log, normalizedIndexWords);
        WriteText.write(output, toWordsAndLines);
    }


    public static void main(String[] args) throws IOException {
        reimissiveRun(
                "src/data/texts/ex1/texto1",
                "src/data/texts/ex1/search1.txt",
                "src/data/texts/ex1/output1.txt",
                "src/data/texts/ex1/log_normalize1.txt"
        );

        reimissiveRun(
                "src/data/texts/ex2/texto2",
                "src/data/texts/ex2/search2.txt",
                "src/data/texts/ex2/output2.txt",
                "src/data/texts/ex2/log_normalize2.txt"
        );

        reimissiveRun(
                "src/data/texts/ex3/texto3",
                "src/data/texts/ex3/search3.txt",
                "src/data/texts/ex3/output3.txt",
                "src/data/texts/ex3/log_normalize3.txt"
        );

        reimissiveRun(
                "src/data/texts/ex4/texto4",
                "src/data/texts/ex4/search4.txt",
                "src/data/texts/ex4/output4.txt",
                "src/data/texts/ex4/log_normalize4.txt"
        );

        reimissiveRun(
                "src/data/texts/ex5/texto5",
                "src/data/texts/ex5/search5.txt",
                "src/data/texts/ex5/output5.txt",
                "src/data/texts/ex5/log_normalize5.txt"
        );

        reimissiveRun(
                "src/data/texts/ex6/texto6",
                "src/data/texts/ex6/search6.txt",
                "src/data/texts/ex6/output6.txt",
                "src/data/texts/ex6/log_normalize6.txt"
        );

        reimissiveRun(
                "src/data/texts/ex7/texto7",
                "src/data/texts/ex7/search7.txt",
                "src/data/texts/ex7/output7.txt",
                "src/data/texts/ex7/log_normalize7.txt"
        );

        reimissiveRun(
                "src/data/texts/ex8/texto8",
                "src/data/texts/ex8/search8.txt",
                "src/data/texts/ex8/output8.txt",
                "src/data/texts/ex8/log_normalize8.txt"
        );
    }
}
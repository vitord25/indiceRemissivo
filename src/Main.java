import handlerText.ReaderText;
import handlerText.normalizedWords.RegexTextProcessing;
import handlerText.normalizedWords.NomalizedWord;
import handlerText.remissiveIndex.Remissive;
import structures.HashTable;
import structures.Word;

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


    public static void main(String[] args) throws IOException {

        String[] text1 = ReaderText.read("src/data/texts/texto1");
        String[] text2 = ReaderText.read("src/data/texts/texto2");
        String[] text3 = ReaderText.read("src/data/texts/texto3");
        String[] text4 = ReaderText.read("src/data/texts/texto4");

//        printToWordSeparator(text1);
//        printToWordSeparator(text2);
//        printToWordSeparator(text3);
//
//        printToWordSeparator(text4);

        HashTable table = Remissive.generate(text4);

        String result = table.inOrder();

        System.out.println(result);

        String[] words = new String[]{"normalização", "acentuação", "de"};
        Remissive.printToWords(words, table);
    }
}
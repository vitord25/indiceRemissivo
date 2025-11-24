import handlerText.ReaderText;
import handlerText.normalizedWords.RegexTextProcessing;
import handlerText.normalizedWords.NomalizedWord;
import structures.HashTable;
import structures.Word;

import java.io.IOException;
import java.util.Arrays;


public class Main {

    public static HashTable generateRemissiveIndex(String[] text) throws IOException {
        HashTable table = new HashTable();
        for (int i = 0; i < text.length; i++) {
            String[] wordsText = RegexTextProcessing.separtorWord(text[i], "src/data/restric_words.txt");
            for (int j = 0; j < wordsText.length; j++) {
                table.insert(wordsText[j], i + 1);
            }

        }

        return table;
    }

    public static void searchInRemissiveIndex(String[] words, HashTable table){
        for (String w : words){
            Word word = table.search(w);
            if(word != null){
                System.out.print(word + " " + word.getOccurrences());
                System.out.println();
            }
        }
    }

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

        HashTable table = generateRemissiveIndex(text4);

        StringBuilder s = table.inOrder();

        System.out.println(s.toString().replaceAll("(?m)^\\s*$\\n?", ""));

        String[] words = new String[]{"normalização", "acentuação", "de"};
        searchInRemissiveIndex(words, table);
    }
}
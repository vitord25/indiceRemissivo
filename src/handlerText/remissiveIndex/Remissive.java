package handlerText.remissiveIndex;

import handlerText.normalizedWords.RegexTextProcessing;
import structures.BinaryTree;
import structures.HashTable;
import structures.Word;

import java.io.IOException;



public class Remissive {

    public static HashTable table = new HashTable();

    public static HashTable generate(String[] text) throws IOException {
        for (int i = 0; i < text.length; i++) {
            String[] wordsText = RegexTextProcessing.separtorWord(text[i], "src/data/restric_words.txt");
            for (int j = 0; j < wordsText.length; j++) {
                table.insert(wordsText[j], i + 1);
            }

        }

        return table;
    }

    public static String toWordsAndLines(String[] words){
        BinaryTree searchTree = new BinaryTree();
        for (String w : words){
            Word word = table.search(w);
            if(word != null){
                searchTree.insert(word);
            }
        }

        return searchTree.wordValueOccurencesInOrder().toString();
    }
}

import handlerText.ReaderText;
import handlerText.RegexTextProcessing;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void printToWordSeparator(String[] text){
        for(int i = 0; i < text.length; i++){
            String[] wordsText = RegexTextProcessing.separatorWord(text[i]);

            System.out.println(Arrays.toString(wordsText));

        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] text1 = ReaderText.read("src/data/texto1");
        String[] text2 = ReaderText.read("src/data/texto2");
        String[] text3 = ReaderText.read("src/data/texto3");

        printToWordSeparator(text1);
        printToWordSeparator(text2);
        printToWordSeparator(text3);


    }
}
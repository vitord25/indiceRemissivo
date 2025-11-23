package handlerText.normalizedWords;

import java.io.IOException;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTextProcessing {

    public static String[] handleWordText(String text) {
         // regex for remove what's not words
        Pattern pattern = Pattern.compile("[^\\p{L}-]|\\b\\p{L}\\b|-", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text.toLowerCase());

        String replaced = matcher
                .replaceAll(" ")
                .replaceAll("\\s{2,}", " ")
                .trim();

        String[] words = replaced.split(" ");

        return NomalizedWord.normalizeInWords(words);
    }

    public static String[] separtorWord(String text){
        return handleWordText(text);
    }

    public static String[] separtorWord(String text, String fileRetricWord) throws IOException{
        ProcessingRestricWords.generated(fileRetricWord);

        return handleWordText(text);
    }
}

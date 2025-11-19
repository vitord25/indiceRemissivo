package handlerText;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTextProcessing {

    public static String[] separatorWord(String text){
        Pattern pattern = Pattern.compile("[^\\p{L}-]|\\b\\p{L}\\b|-", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        String replaced = matcher
                .replaceAll(" ")
                .replaceAll("\\s{2,}", " ")
                .trim();

        String[] words = replaced.split(" ");

        return normalizeInWords(words);
    }

    private static String[] normalizeInWords(String[] words){
        String[] newArr = new String[words.length];

        for(int i = 0; i < words.length; i++){
            String normalized = normalize(words[i]);
            String normSingular = singular(normalized);
            newArr[i] = normSingular;
        }

        return newArr;
    }

    private static String normalize(String word){
        if (word == null || word.isEmpty()) return word;

        String first = word.substring(0, 1);
        first = Normalizer.normalize(first, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        String rest = word.substring(1);

        return first + rest;
    }

    private static String singular(String w) {
        if (w.endsWith("ões")) return w.replace("ões", "ao");
        if (w.endsWith("ães")) return w.replace("ães", "ao");
        if (w.endsWith("ãos")) return w.replace("ãos", "ao");
        if (w.endsWith("ais")) return w.substring(0, w.length() - 1);
        if (w.endsWith("éis")) return w.substring(0, w.length() - 2) + "el";
        if (w.endsWith("is") && w.length() > 3) return w.substring(0, w.length() - 2);
        if (w.endsWith("s") && w.length() > 3) return w.substring(0, w.length() - 1);
        return w;
    }

}

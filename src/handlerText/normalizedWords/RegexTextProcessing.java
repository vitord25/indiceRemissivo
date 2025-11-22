package handlerText;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTextProcessing {

    public static String[] separatorWord(String text){

        // regex for remove what's not words
        Pattern pattern = Pattern.compile("[^\\p{L}-]|\\b\\p{L}\\b|-", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text.toLowerCase());

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

        // NFD to decompose accent in to the first letter
        // regex to remove accents in NFD decompose
        first = Normalizer.normalize(first, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        String rest = word.substring(1);

        return first + rest;
    }

    private static String singular(String w) {
        if (w.endsWith("ões")) return w.replace("ões", "ão");
        if (w.endsWith("ães")) return w.replace("ães", "ão");
        if (w.endsWith("ãos")) return w.replace("ãos", "ão");
        if (w.endsWith("ais") && w.length() > 3) return w.replace("ais", "al");
        if (w.endsWith("éis") && w.length() > 3 ) return w.replace("éis", "el");
        if (w.endsWith("eis") && w.length() > 3) {
            String unSufix = w.replace("eis", "");
            if(unSufix.length() < 3) return w.substring(0, w.length() - 1);
            if(unSufix.length() > 3) return w.replace("eis", "el");
        }
        if(w.endsWith("ares") || w.endsWith("eres") || w.endsWith("zes") || w.endsWith("ses")) return w.substring(0, w.length() - 2);

        if(w.endsWith("es") && w.length() > 3){
            String base = w.substring(0, w.length() - 2);
            if (base.matches(".*[aeiou]")) return w;
            if(!base.matches(".*[rlz]")) return w.substring(0, w.length() - 1);
            return base;
        }
        if (w.endsWith("is") && w.length() > 3) return w.substring(0, w.length() - 2);
        if (w.endsWith("s") && w.length() > 3) return w.substring(0, w.length() - 1);
        return w;
    }
}

package handlerText.normalizedWords;

import java.text.Normalizer;

public class NomalizedWord {
    public static String[] normalizeInWords(String[] words){
        String[] newArr = new String[words.length];

        for(int i = 0; i < words.length; i++){
            String normalized = normalizeAccents(words[i]);
            String normSingular = singular(normalized);
            newArr[i] = normSingular;
        }

        return newArr;
    }

    public static String normalizeAccents(String word){
        if (word == null || word.isEmpty()) return word;

        String first = word.substring(0, 1);

        // NFD to decompose accent in to the first letter
        // regex to remove accents in NFD decompose
        first = Normalizer.normalize(first, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        String rest = word.substring(1);

        return first + rest;
    }

    public static String singular(String w) {
        if(ProcessingRestricWords.verify(w)) return w;

        if (w.endsWith("ões")) return w.replace("ões", "ão");
        if (w.endsWith("ães")) return w.replace("ães", "ão");
        if (w.endsWith("ãos")) return w.replace("ãos", "ão");

        if (w.endsWith("is") && w.length() > 3) {
            String unSufix = w.replace("is", "");

            if(unSufix.length() < 3) return w.substring(0, w.length() - 1);
            if(unSufix.length() > 3)  return w.substring(0, w.length() - 1) + "l";
        }

        if (w.endsWith("ais") && w.length() > 3) return w.replace("ais", "al");
        if (w.endsWith("éis") && w.length() > 3 ) return w.replace("éis", "el");


        if (w.endsWith("eis") && w.length() > 3) {
            String unSufix = w.replace("eis", "");

            if(unSufix.length() < 3 && w.matches(".*[aeiou]s")) return w.replace("eis", "il");
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

        if (w.endsWith("s") && w.length() > 3) return w.substring(0, w.length() - 1);

        return w;
    }
}

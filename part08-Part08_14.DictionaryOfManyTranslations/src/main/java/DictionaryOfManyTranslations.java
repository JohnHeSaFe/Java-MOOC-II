import java.util.HashMap;
import java.util.ArrayList;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dictionary;

    public DictionaryOfManyTranslations() {
        dictionary = new HashMap<>();
    }

    public void add(String word, String translation) {
        if (dictionary.get(word) == null) {
            dictionary.put(word, new ArrayList<>());
        }
        dictionary.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {
        if (dictionary.get(word) == null) {
            return new ArrayList<>();
        }
        return dictionary.get(word);
    }

    public void remove(String word) {
        dictionary.remove(word);
    }
}

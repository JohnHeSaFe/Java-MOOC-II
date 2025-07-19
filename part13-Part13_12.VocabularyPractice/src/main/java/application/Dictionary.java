package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Dictionary {
    private List<String> words;
    private Map<String, String> translations;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();

        addWord("neko", "cat");
        addWord("inu", "dog");
        addWord("mizu", "water");
        addWord("kaze", "wind");
        addWord("hi", "fire");
        addWord("yuki", "snow");
        addWord("sora", "sky");
        addWord("yama", "mountain");
        addWord("hana", "flower");
        addWord("umi", "sea");
    }

    public String getTranslation(String word) {
        return this.translations.get(word);
    }

    public void addWord(String word, String transtation) {
        if (!this.translations.containsKey(word)) {
            words.add(word);
        }

        this.translations.put(word, transtation);
    }

    public String getRandomWord() {
        int randomIndex = new Random().nextInt(words.size());
        return words.get(randomIndex);
    }
}

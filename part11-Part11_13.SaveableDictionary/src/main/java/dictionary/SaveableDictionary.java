package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {
    private String file;
    private Map<String, String> dictionary;

    public SaveableDictionary() {
        dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        dictionary = new HashMap<>();
        this.file = file;
    }

    public void add(String words, String translation) {
        if (dictionary.containsKey(words) || dictionary.containsValue(translation)) {
            return;
        }
        dictionary.put(words, translation);
    }

    public String translate(String word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }
        Iterator<String> iterator = dictionary.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (dictionary.get(key).equals(word)) {
                return key; 
            }
        }
        return null;
    }

    public void delete(String word) {
        dictionary.remove(word);
        Iterator<String> iterator = dictionary.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (dictionary.get(key).equals(word)) {
                iterator.remove();
            }
        }
    }

    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(file))) {
            while (scanner.hasNextLine()) {
                String [] line = scanner.nextLine().split(":");
                add(line[0], line[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {
        try (PrintWriter writer = new PrintWriter(file)) {
            Iterator<String> iterator = dictionary.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                writer.println(key + ":" + dictionary.get(key));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

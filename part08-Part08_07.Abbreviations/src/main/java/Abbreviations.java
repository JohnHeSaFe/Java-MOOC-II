import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> abbreviations;

    public Abbreviations() {
        abbreviations = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviation = sanitizedString(abbreviation);
        explanation = sanitizedString(explanation);

        if (hasAbbreviation(abbreviation)) {
            return;
        }

        abbreviations.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        return abbreviations.containsKey(sanitizedString(abbreviation));
    }

    public String findExplanationFor(String abbreviation) {
        return abbreviations.get(sanitizedString(abbreviation));
    }
    
    private String sanitizedString(String string) {
        return string.toLowerCase().trim();
    }

}

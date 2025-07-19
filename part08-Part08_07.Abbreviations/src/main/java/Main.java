
public class Main {

    public static void main(String[] args) {
        // Test your program here!
        Abbreviations abbreviations = new Abbreviations();
        abbreviations.addAbbreviation("lol", "laughing out loud");
        abbreviations.addAbbreviation("etc", "and so on");
        System.out.println(abbreviations.hasAbbreviation("lol"));
        System.out.println(abbreviations.hasAbbreviation("etc"));
        System.out.println(abbreviations.findExplanationFor("etc"));
    }
}

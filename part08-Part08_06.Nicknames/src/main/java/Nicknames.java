
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap<String,String> nicknames = new HashMap<>();

        nicknames.put("Matthew", "matt");
        nicknames.put("Michael", "mix");
        nicknames.put("Authur", "artie");

        for (String key : nicknames.keySet()) {
            System.out.println("Nickname of " + key + " is " + nicknames.get(key));
        }
    }
}

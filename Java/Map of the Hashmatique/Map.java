import java.util.HashMap;
import java.util.Set;
public class Map {
    public static void main(String[] args) {
    HashMap<String, String> hashmatiqueMap = new HashMap<String, String>();

    // Add in at least 4 songs that are stored by title

    hashmatiqueMap.put("Unstoppable", "All smiles, I know what it takes to fool this town , I'll do it 'til the sun goes down and all through the night time");
    hashmatiqueMap.put("I'm Still Here", "I'm fighting a battle , I'm fighting my shadow , Heard fears like they're cattle");
    hashmatiqueMap.put("Genius ", "Do you think I'm stupid? , Do you think I'm batshit crazy, having you on my mind? , Do you think I'm helpless?");
    hashmatiqueMap.put("The Greatest", "Uh-oh, runnin' out of breath, but I ,  Oh, I, I got stamina");


    // Pull out one of the songs by its track title

    String title = hashmatiqueMap.get("I'm Still Here");
    System.out.println(title);


    // Print out all the track names and lyrics

    Set<String> keys = hashmatiqueMap.keySet();
    for(String key : keys) {
        System.out.println(key +" : "+ hashmatiqueMap.get(key)); 
    }
    }

}
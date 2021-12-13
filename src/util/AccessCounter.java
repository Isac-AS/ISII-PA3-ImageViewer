package util;

import java.util.HashMap;

public class AccessCounter {
    
    static final private AccessCounter INSTANCE = new AccessCounter();
    private final HashMap<String, Integer> accesses = new HashMap<>();
    
    private AccessCounter () {}
    
    public static AccessCounter getInstance() {
        return INSTANCE;
    }
    
    public Integer increment (String key) {
        final Integer counter;
        if (this.accesses.containsKey(key)) {
            counter = this.accesses.get(key) + 1 ;
        }
        else {
            counter = 1;
        }
        this.accesses.put(key, counter);
        return counter;
    }
}
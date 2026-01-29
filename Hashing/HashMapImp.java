package Hashing;

import java.util.HashMap;
import java.util.Set;

public class HashMapImp {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        //O(1)
        hm.put("India", 100);
        hm.put("Usa", 304);
        hm.put("China", 324);
        System.out.println(hm);
        //O(1)
        // int population = hm.get("India");
        // hm.containsKey("Russia");
        // hm.remove("China");

        //iteration
        Set<String> keys = hm.keySet();
        for (String string : keys) {
            System.out.println(string + ":" + hm.get(string));
        }
    }
}

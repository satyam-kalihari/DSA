package Hashing;

import java.util.HashMap;

public class HashMapImp {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        //O(1)
        hm.put("India", 100);
        hm.put("Usa", 304);
        hm.put("China", 324);
        System.out.println(hm);
        //O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.containsKey("Russia"));
        System.out.println(hm.remove("China"));
    }
}

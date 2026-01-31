package Hashing;

import java.util.HashMap;

public class ItineraryForTickets {

    public static String getStart(HashMap<String, String> tickets){

        HashMap<String, String> reverse = new HashMap<>();
        for (String key : tickets.keySet()) {
            reverse.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!reverse.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Mumbai", "Delhi");
        tickets.put("Delhi", "Goa");
        tickets.put("Goa", "Chennai");
        tickets.put("Chennai", "Bengaluru");

        String start = getStart(tickets);
        System.out.print(start);
        for (@SuppressWarnings("unused") String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
    }
}

package Hashing;

import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K,V> {
        private class Node {
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private LinkedList<Node> buckets[];

        public HashMap(){
            this.size = 0;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }
    }
}

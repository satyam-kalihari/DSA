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

        private int n;//size of HashMap(total number of nodes)
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        public int hashFun(K key){
            int bi = key.hashCode();//can return 1234/-1234
            return Math.abs(bi) % N;//size of array of LL is 4
        }

        public int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        public void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bucketIdx = hashFun(key);
            int dataIdx = searchInLL(key, bucketIdx);//will return a valid idx or -1 if not present

            if (dataIdx != -1) {//key already there
                Node node = buckets[bucketIdx].get(dataIdx);
                node.value = value;
            }
            else{
                buckets[bucketIdx].add(new Node(key, value));
                n++;
            }

            double lmbda = (double)n/N;
            if (lmbda > 2) {
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFun(key);
            int idx = searchInLL(key, bi);
            if (idx != -1) {
                return true;
            }
            return false;
        }

        public V remove(K key){
            int bi = hashFun(key);
            int idx = searchInLL(key, bi);
            if (idx != -1) {
                V value = buckets[bi].remove(idx).value;
                n--;
                return value;
            }   
            return null;
        }

        public V get(K key){
            int bi = hashFun(key);
            int idx = searchInLL(key, bi);
            if (idx != -1) {
                return buckets[bi].get(idx).value;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Usa", 304);
        hm.put("China", 324);

        System.out.println(hm.remove("China"));
    }
}

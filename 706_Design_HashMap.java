/*
 * 706. Design HashMap
 * Problem Link:https://leetcode.com/problems/design-hashmap/
 * Design a HashMap without using any built-in hash table libraries.
 * 
 * Implement the MyHashMap class:
 * 
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap. If
 * the key already exists in the map, update the corresponding value.
 * int get(int key) returns the value to which the specified key is mapped, or
 * -1 if this map contains no mapping for the key.
 * void remove(key) removes the key and its corresponding value if the map
 * contains the mapping for the key.
 */
//Beats 34% | Using an Array
// class MyHashMap {
//     int [] map;
//     public MyHashMap() {
//         map = new int[1000001];
//         for(int i=0; i<map.length; i++)    map[i] = -1;       
//     }

//     public void put(int key, int value) {
//         map[key] = value;
//     }

//     public int get(int key) {
//         return map[key];
//     }

//     public void remove(int key) {
//         map[key] = -1;
//     }
// }

//Beats 55% | TC = O(1) | SC = size of array declared | Using Array but avoiding first "for loop" to assign -1 value at all the keys.
// class MyHashMap {
//     int [] map;
//     public MyHashMap() {
//         map = new int[1000001];
//         // for(int i=0; i<map.length; i++)    map[i] = -1;       
//     }

//     public void put(int key, int value) {
//         map[key] = value+1;
//     }

//     public int get(int key) {
//         return map[key]-1;
//     }

//     public void remove(int key) {
//         map[key] = 0;
//     }
// }

//Beats 76% | Close to how the HashMap actually works.
class MyHashMap {
    LinkedList<Entry>[] map;
    public static int SIZE = 769;

    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = key % SIZE;
        if (map[bucket] == null) {
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key, value));
        } else {
            for (Entry entry : map[bucket]) {
                if (entry.key == key) {
                    entry.val = value;
                    return;
                }
            }
            map[bucket].add(new Entry(key, value));
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = map[bucket];
        if (entries == null)
            return -1;
        for (Entry entry : entries) {
            if (entry.key == key)
                return entry.val;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int bucket = key % SIZE;
        Entry toRemove = null;
        if (map[bucket] == null)
            return;
        else {
            for (Entry entry : map[bucket]) {
                if (entry.key == key) {
                    toRemove = entry;
                }
            }
            if (toRemove == null)
                return;
            map[bucket].remove(toRemove);
        }
    }
}

class Entry {
    public int key;
    public int val;

    public Entry(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
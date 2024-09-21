package Data_Structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// INSTRUCTIONS:
/*
 * Write a class that has the following methods:
 * insert(int n): Inserts n only if n is not a duplicate (value is already stored in class)
 * remove(int n): removes n if n exists in the class
 * getRandom(): returns a random value from the class
 * Assume that there are no memory limitations
 * each class is used at an equal rate
 * class should be able to perform these methods efficiently with MILLIONS of values stored
 */
public class GoogleClass {
    /*
     * MY APPROACH:
     * Use a HashMap to store values int n as the keys and values as an "index" e.g
     * 0, 1, 2 of the key
     * Use another HashMap that is the original HashMap but flipped for getRandom
     * method to get a random key "index" within hmap.size()
     * 
     */

    // key: integer value that you wish to insert
    // value: 'index' e.g {42: 0, 12: 1, 5: 2 ... }

    private HashMap<Integer, Integer> hmap;
    private ArrayList<Integer> dataIndex;

    public GoogleClass() {
        hmap = new HashMap<>();
        dataIndex = new ArrayList<>();
    }

    // If insert successful returns True
    // If insert unsuccessful returns False
    public boolean insert(int n) {
        // check for duplicate
        if (checkDuplicate(n))
            return false;
        else {
            int size = hmap.size();
            hmap.put(n, size);
            dataIndex.add(size, n);
            return true;
        }
    }

    // If remove successful returns True
    // If not, returns False
    public boolean remove(int n) {
        // returns if hashmap doesnt have value n
        if (hmap.get(n) == null)
            return false;

        int index = hmap.get(n);
        hmap.remove(n);
        dataIndex.remove(index);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(hmap.size());
        return dataIndex.get(randomIndex);
    }

    // True if duplicate exists
    // False if no duplicates
    private boolean checkDuplicate(int n) {
        return hmap.get(n) != null;
    }

    public String toString() {
        return "hmap: " + hmap.toString() + "\nlist: " + dataIndex.toString();
    }
}

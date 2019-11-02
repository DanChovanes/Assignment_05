package hashbrown;

public class HashTable {

    private DataEntry[] hash;
    private int arraySize; //you'll never guess why this variable was named this.

    HashTable(int size) {
        arraySize = size;
        hash = new DataEntry[arraySize];
    }

    public void printTable() {

        System.out.print("HashBrown roundup: ");
        System.out.println();

        for(int i = 0; i < arraySize; i++)

            if(hash[i] != null) {
                System.out.print("Initial value: " + hash[i].getKey() + ", \t");
                System.out.print("Located at index: " + hash[i].getIndex());
                System.out.println();
            }

    }

    public int hash1(int key) { return key % arraySize; } //the internet tells me this is the default hash

    public int hash2(int key) { return 5 - key % 5; } //you gave us this one in class

    public void insert(int key, DataEntry item) {

        int hashVal = hash1(key);
        int increment = hash2(key);

        while(hash[hashVal] != null) {
            hashVal += increment;
            hashVal %= arraySize;
        }

        hash[hashVal] = item;
    }
}

//this was pieced together from Uncle Google, talking to classmates, and stuff we did in class.
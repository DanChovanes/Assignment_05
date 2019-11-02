package hashbrown;

public class DataEntry {

    private String iData;
    private int index;

    public DataEntry(String s, int i) {
        iData = s;
        index = i;
    }

    public String getKey() { return iData; }

    public int getIndex() { return index; }
}

//this was retrieved from geeksforgeeks
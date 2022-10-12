package data_structures.hashtables;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable {

    private ArrayList<KeyValues>[] data;

    public MyHashTable(int length) {
        this.data = new ArrayList[length];
    }

    private int hash(String key){
        int hash = 0;
        for(int i = 0; i < key.length(); i++){
            hash = (hash + key.charAt(i)*i) % data.length;
        }

        return hash;
    }

    public ArrayList<KeyValues>[] set(String key, Object value){
        int address = hash(key);

        if(data[address] == null){
            data[address] = new ArrayList<>();
        }

        data[address].add(new KeyValues(key, value));
        return data;
    }

    public void get(String key){
        int address = hash(key);
        final ArrayList<KeyValues> currentBucket = data[address];

        if(currentBucket != null){
            for(int i = 0; i < currentBucket.size(); i++){
                if(currentBucket.get(i).getKey().equals(key)){
                    System.out.println(data[address].get(i).getValues());
                }
            }
        }
    }

    public List<String> keys(){
        List<String> keysArrays = new ArrayList<>();

        for(int i = 0; i < data.length; i++){
            if(data[i] != null){
                for(int j = 0; j < data[i].size(); j++){
                    keysArrays.add(data[i].get(j).getKey());
                }
            }
        }

        return keysArrays;
    }

    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable(50);
        myHashTable.set("grapes", 5000);
        myHashTable.set("apples", 100);

        myHashTable.get("grapes");

        System.out.println(myHashTable.keys());;
    }
}

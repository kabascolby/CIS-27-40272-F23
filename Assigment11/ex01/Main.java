package ex01;

public class Main {
    public static void main(String[] args) {
        int size = 5;
        HashTable hashTable = new HashTable(size);

        String keys = "EXAMQUESTION";
        for (int i = 0; i < keys.length(); i++) {
            hashTable.insert(keys.charAt(i));
        }

        // hashTable.printTable();
        System.out.println(hashTable);
    }
}
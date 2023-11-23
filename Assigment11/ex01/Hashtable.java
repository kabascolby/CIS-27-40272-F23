package ex01;

class HashTable {
    private Node[] table;
    private int size;

    HashTable(int size) {
        this.table = new Node[size];
        this.size = size;
    }

    int hash(int key) {
        return (11 * key) % size;
    }

    int hash(String key) {

    }

    void insert(int key) {
        int index = hash(key);
        Node node = new Node(key);
        if (table[index] == null) {
            table[index] = node;
        } else {
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder buckets = new StringBuilder();
        for (int i = 0; i < size; i++) {
            buckets.append("List " + i + ": ");
            Node temp = table[i];
            while (temp != null) {
                buckets.append(temp);
                temp = temp.next;
            }
            buckets.append("\n");
        }
        return buckets.toString();
    }

    void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println("List " + i + ": ");
            Node current = table[i];
            while (current != null) {
                System.out.print(current.key + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
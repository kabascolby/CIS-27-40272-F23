package ex01;

class Node<T> {
    T key;
    Node next;

    Node(T key) {
        this.key = key;
        this.next = null;
    }

    @Override
    public String toString() {
        return "[ " + key + " ] ";
    }

}
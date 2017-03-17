package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 * Односвязный список
 */
public class MyLinkedList extends List implements Stack, Queue  {

    /**
     * private - используется для сокрытия этого класса от других.
     * Класс доступен только изнутри того, где он объявлен
     * <p>
     * static - позволяет использовать Node без создания экземпляра внешнего класса
     */
    private static class Node {
        Node prev;
        Node next;
        int val;

        Node(Node prev, Node next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    private Node first;
    private Node last;

    MyLinkedList() {}

    @Override
    void add(int item) {
        if (last == null) {
            first = new Node(null,null, item);
            last = first;
        } else {
            Node tmp = new Node(this.last,null,item);
            this.last.next = tmp;
            this.last = tmp;
        }
        this.size++;
    }

    @Override
    int remove(int idx) throws NoSuchElementException {
        checkIndexRange(idx);
        Node current = first;
        int ptr = 0;
        while (ptr != idx) {
            current = current.next;
            ptr++;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (ptr == 0) {
            first = current.next;
            first.prev = null;
        }
        if (ptr == this.size - 1) {
            last = current.prev;
            last.next = null;
        }
        this.size--;
        return current.val;
    }

    @Override
    int get(int idx) throws NoSuchElementException {
        checkIndexRange(idx);
        if (idx == this.size - 1) {
            return this.last.val;
        } else {
            Node current = first;
            int ptr = 0;
            while (ptr != idx) {
                current = current.next;
                ptr++;
            }
            return current.val;
        }
    }

    public int pop() {
        return get(this.size - 1);
    }

    public void push(int value) {
        add(value);
    }

    public void enqueue(int value) {
        add(value);
    }

    public int dequeu() {
        return get(0);
    }

}

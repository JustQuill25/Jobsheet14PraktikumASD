package Praktikum123;

import java.util.ArrayList;

class DoubleLinkedList01 {
    private Node01 head;
    private int size;

    DoubleLinkedList01() {
        head = null;
        size = 0;
    }

    public void addFirst(int item, int jarak) {
        if (isEmpty()) {
            head = new Node01(null, item, jarak, null);
        } else {
            Node01 newNode = new Node01(null, item, jarak, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Node01 current = head;
        while (current != null) {
            if (current.data == index) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    public int get(int index) {
        Node01 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int getJarak(int index) {
        Node01 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.jarak;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public ArrayList<Integer> getAllData() {
        ArrayList<Integer> data = new ArrayList<>();
        Node01 current = head;
        while (current != null) {
            data.add(current.data);
            current = current.next;
        }
        return data;
    }

    public void updateJarak(int item, int newJarak) {
        Node01 current = head;
        while (current != null) {
            if (current.data == item) {
                current.jarak = newJarak;
                break;
            }
            current = current.next;
        }
    }
}

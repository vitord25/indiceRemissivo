package structures;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private static class Node {
        public int element;
        public Node next;

        public Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node first;
    private Node last;
    private int n_elements;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.n_elements = 0;
    }

    public void insertStart(int elemento) {
        Node novoNode = new Node(elemento);
        if (first == null) {
            first = novoNode;
            last = novoNode;
        } else {
            novoNode.next = first;
            first = novoNode;
        }
        n_elements++;
    }

    public void removeStart() {
        if (first == null) {
            throw new NoSuchElementException("A lista está vazia");
        } else {
            first = first.next;
            n_elements--;
            if (n_elements == 0) {
                last = null;
            }
        }
    }

    public void insertFinal(int elemento) {
        Node novoNode = new Node(elemento);
        if (last == null) {
            first = novoNode;
            last = novoNode;
        } else {
            last.next = novoNode;
            last = novoNode;
        }
        n_elements++;
    }

    public void removeFinal() {
        if (last == null) {
            throw new NoSuchElementException("A lista está vazia");
        } else {
            if (first == last) {
                first = null;
                last = null;
            } else {
                Node now = first;
                while (now.next != last) {
                    now = now.next;
                }
                now.next = null;
                last = now;
            }
            n_elements--;
        }
    }

    public void insertPosition(int element, int position) {
        if (position < 0 || position > n_elements) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        if (position == 0) {
            insertStart(element);
        } else if (position == n_elements) {
            insertFinal(element);
        } else {
            Node novoNode = new Node(element);
            Node now = first;
            for (int i = 0; i < position - 1; i++) {
                now = now.next;
            }
            novoNode.next = now.next;
            now.next = novoNode;
            n_elements++;
        }
    }

    public void removePosition(int position) {
        if (position < 0 || position >= n_elements) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (position == 0) {
            removeStart();
        } else if (position == n_elements - 1) {
            removeFinal();
        } else {
            Node now = first;
            for (int i = 0; i < position - 1; i++) {
                now = now.next;
            }
            now.next = now.next.next;
            n_elements--;
        }
    }

    public boolean search(int value){
        Node now = first;
        while (now != null){
            if(now.element == value){
                return true;
            }
            now = now.next;
        }

        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node now = first;
        while (now != null) {
            result.append(now.element);
            result.append(" ");
            now = now.next;
        }

        return result.toString();
    }
}

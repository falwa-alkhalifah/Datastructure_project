/**
 * Custom implementation of LinkedList data structure
 * @param <T> Generic type parameter
 */
public class LinkedList<T> {
    
    // Node class for LinkedList
    private class Node {
        private T data;
        private Node next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private int size;
    
    /**
     * Constructor for LinkedList
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Insert an element at the end of the list
     * @param data Element to be inserted
     */
    public void insert(T data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    /**
     * Remove an element from the list
     * @param data Element to be removed
     * @return true if element was found and removed, false otherwise
     */
    public boolean remove(T data) {
        if (head == null) {
            return false;
        }
        
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        
        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        
        return false;
    }
    
    /**
     * Check if the list contains a specific element
     * @param data Element to search for
     * @return true if element is found, false otherwise
     */
    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Get the size of the list
     * @return Number of elements in the list
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if the list is empty
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Get an array representation of the list
     * @return Array containing all elements in the list
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node current = head;
        int index = 0;
        
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        
        return array;
    }
    
    /**
     * Get element at specified index
     * @param index Index of the element to retrieve
     * @return Element at the specified index
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    /**
     * String representation of the list
     * @return String containing all elements in the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
}

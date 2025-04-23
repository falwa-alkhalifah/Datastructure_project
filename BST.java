/**
 * Binary Search Tree implementation
 * @param <T> Generic type parameter that extends Comparable
 */
public class BST<T extends Comparable<T>> {
    
    // Node class for BST
    private class Node {
        private T data;
        private Node left;
        private Node right;
        
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root;
    private int size;
    
    /**
     * Constructor for BST
     */
    public BST() {
        this.root = null;
        this.size = 0;
    }
    
    /**
     * Insert an element into the BST
     * @param data Element to be inserted
     */
    public void insert(T data) {
        root = insertRec(root, data);
        size++;
    }
    
    /**
     * Helper method for recursive insertion
     * @param root Current root node
     * @param data Element to be inserted
     * @return Updated root node
     */
    private Node insertRec(Node root, T data) {
        if (root == null) {
            return new Node(data);
        }
        
        int compareResult = data.compareTo(root.data);
        
        if (compareResult < 0) {
            root.left = insertRec(root.left, data);
        } else if (compareResult > 0) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }
    
    /**
     * Search for an element in the BST
     * @param data Element to search for
     * @return true if element is found, false otherwise
     */
    public boolean contains(T data) {
        return containsRec(root, data);
    }
    
    /**
     * Helper method for recursive search
     * @param root Current root node
     * @param data Element to search for
     * @return true if element is found, false otherwise
     */
    private boolean containsRec(Node root, T data) {
        if (root == null) {
            return false;
        }
        
        int compareResult = data.compareTo(root.data);
        
        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return containsRec(root.left, data);
        } else {
            return containsRec(root.right, data);
        }
    }
    
    /**
     * Get the value associated with a key in the BST
     * @param key Key to search for
     * @return Value associated with the key, or null if key not found
     */
    public T get(T key) {
        return getRec(root, key);
    }
    
    /**
     * Helper method for recursive get
     * @param root Current root node
     * @param key Key to search for
     * @return Value associated with the key, or null if key not found
     */
    private T getRec(Node root, T key) {
        if (root == null) {
            return null;
        }
        
        int compareResult = key.compareTo(root.data);
        
        if (compareResult == 0) {
            return root.data;
        } else if (compareResult < 0) {
            return getRec(root.left, key);
        } else {
            return getRec(root.right, key);
        }
    }
    
    /**
     * Remove an element from the BST
     * @param data Element to be removed
     * @return true if element was found and removed, false otherwise
     */
    public boolean remove(T data) {
        int originalSize = size;
        root = removeRec(root, data);
        return size < originalSize;
    }
    
    /**
     * Helper method for recursive removal
     * @param root Current root node
     * @param data Element to be removed
     * @return Updated root node
     */
    private Node removeRec(Node root, T data) {
        if (root == null) {
            return null;
        }
        
        int compareResult = data.compareTo(root.data);
        
        if (compareResult < 0) {
            root.left = removeRec(root.left, data);
        } else if (compareResult > 0) {
            root.right = removeRec(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                size--;
                return root.right;
            } else if (root.right == null) {
                size--;
                return root.left;
            }
            
            // Node with two children
            root.data = findMin(root.right);
            root.right = removeRec(root.right, root.data);
        }
        
        return root;
    }
    
    /**
     * Find the minimum value in a subtree
     * @param node Root of the subtree
     * @return Minimum value in the subtree
     */
    private T findMin(Node node) {
        T minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }
    
    /**
     * Get the size of the BST
     * @return Number of elements in the BST
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if the BST is empty
     * @return true if BST is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Get an in-order traversal of the BST as a LinkedList
     * @return LinkedList containing all elements in the BST in sorted order
     */
    public LinkedList<T> inOrderTraversal() {
        LinkedList<T> result = new LinkedList<>();
        inOrderTraversalRec(root, result);
        return result;
    }
    
    /**
     * Helper method for recursive in-order traversal
     * @param root Current root node
     * @param result LinkedList to store the traversal result
     */
    private void inOrderTraversalRec(Node root, LinkedList<T> result) {
        if (root != null) {
            inOrderTraversalRec(root.left, result);
            result.insert(root.data);
            inOrderTraversalRec(root.right, result);
        }
    }
    
    /**
     * String representation of the BST (in-order traversal)
     * @return String containing all elements in the BST in sorted order
     */
    @Override
    public String toString() {
        return inOrderTraversal().toString();
    }
}

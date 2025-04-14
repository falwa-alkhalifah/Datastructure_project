
    class BSTNode <T> {
    public String key;
    public T data;
    public BSTNode<T> left, right;

    public BSTNode(String k, T val) {
        key = k;
        data = val;
        left = right = null;
    }

    public BSTNode(String k, T val, BSTNode<T> l, BSTNode<T> r) {
        key = k;
        data = val;
        left = l;
        right = r;
    }
 }

public class BST <T> {
    BSTNode<T> root, current;

    public BST() {
        root = current = null;
    }
    public boolean empty() {
        return root == null;
    }
    public boolean full() {
        return false;
    }
    public T retrieve () {
        return current.data;
    }
    public boolean findkey(String k) {
    BSTNode<T> p = root , q = root;
    
    if(empty())
        return false;
    
    while(p != null) {
        q = p;
        if(k.compareTo(p.key) == 0) {
            current = p;
            return true;
        }
        else if(k.compareTo(p.key) < 0)
            p = p.left;
        else
            p = p.right;
    }
    current = q;
    return false;
    }
    
    public boolean insert(String k, T val) {
        BSTNode<T> p, q = current;
      
        if(findkey(k)) {
            current = q;  
            return false; 
        }
        
        p = new BSTNode<T>(k, val);
        if (empty()) {
            root = current = p;
            return true;
        }
        else {
            if (k.compareTo(current.key) < 0)
                current.left = p;
            else
                current.right = p;
            current = p;
            return true;
        }
        
    }
    
    public boolean removeKey(String k) {
        BSTNode<T> p = root;
        BSTNode<T> q = null; 
        boolean found = false;

        while ((p != null)&&(!found)) {
            int res = k.compareTo(p.key);
            if (res < 0) {
                q = p;
                p = p.left;
            } else if (res > 0) {
                q = p;
                p = p.right;
            } else 
                found=true;
        }
         if(found){           
            if ((p.left != null) && (p.right != null)) { // Case 3: two
                // children
                // Search for the min in the right subtree
                BSTNode<T> min = p.right;
                q = p;
                while (min.left != null) {
                q = min;
                min = min.left;
                }
                p.key = min.key;
                p.data = min.data;
                deleteNode(min,q);
            }
            else //case 1 and 2
                deleteNode(p,q);
            current = root;
            return true;
         }
         return false; 
    }
    
    private void deleteNode(BSTNode<T> n,BSTNode<T> parent){
        BSTNode<T> child;
        if(n.left!=null)
            child=n.left;
        else
            child=n.right;

        if (parent == null) { 
            root = child;  
       } else {
        if (n.key.compareTo(parent.key) < 0)
                parent.left = child;
            else 
                parent.right = child;
        }
       }
    
    public void inOrder(){
        if(root == null)
            System.out.println("empty");
        
        inOrder(root);
    }
    
    public void inOrder(BSTNode<T> p){
        if(p == null)
            return;
        inOrder(p.left);
        System.out.print(p.key + " ");
        System.out.println(p.data);
        inOrder(p.right);
    }


}



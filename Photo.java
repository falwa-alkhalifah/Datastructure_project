
package com.mycompany.datastructure;

public class Photo {
    
    String path;
    LinkedList<String> tags;
    
    public Photo(String path, LinkedList<String> tags){
        this.path = path;
        this.tags = tags;
    }
    public String getPath(){
        return path;
    }

    public LinkedList<String> getTags(){
        return tags;
    }
    
    public void displayPhto(){
        System.out.println("path: "+path);
        System.out.println("tags: ");
        tags.display();
    }

}

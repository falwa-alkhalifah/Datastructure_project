

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
    
 public void display(){
        System.out.println("\npath: "+path);
        System.out.print("tags: ");
        tags.display();
        System.out.println("\n---------------------");
    }

}

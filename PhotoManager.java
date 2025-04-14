
public class PhotoManager {
   
 LinkedList<Photo> photos;    

    public PhotoManager(){
        photos = new LinkedList<Photo>();
    }
    
    public LinkedList<Photo> getPhotos(){
        return photos;
    }
    
    public void addPhoto(Photo p){
        
        if(Photo_Exist(photos,p))//to prevent duplicate
            return;
        photos.insert(p);
    }
    
    public void deletePhoto(String path){
        
        if(photos.empty())
            return;
        
        photos.findfirst();
        while(!photos.last()){
            
            if(photos.retrieve().path.equals(path)){
                photos.remove();
                break;
            }

            photos.findnext();
        }
        if(photos.retrieve().path.equals(path))
               photos.remove();
        
    }
    
    //check if ther is duplicate photos
    public boolean Photo_Exist(LinkedList<Photo> L, Photo P){
        //if the list is empty
        if(L.empty())
            return false;
        //loop through the list
        L.findfirst();
        while(!L.last()){
            
            if(L.retrieve().path.equals(P.path))
                return true;
            L.findnext();
        }
        //the last one
        if(L.retrieve().path.equals(P.path))
            return true;
        
        return false;

    }
}

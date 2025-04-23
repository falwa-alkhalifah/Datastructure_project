/**
 * PhotoManager class manages a collection of photos
 */
public class PhotoManager {
    private LinkedList<Photo> photos;
    
    /**
     * Constructor
     */
    public PhotoManager() {
        this.photos = new LinkedList<>();
    }
    
    /**
     * Return all managed photos
     * @return LinkedList of all photos
     */
    public LinkedList<Photo> getPhotos() {
        return photos;
    }
    
    /**
     * Add a photo
     * @param p Photo to be added
     */
    public void addPhoto(Photo p) {
        photos.insert(p);
    }
    
    /**
     * Delete a photo
     * @param path Path of the photo to be deleted
     */
    public void deletePhoto(String path) {
        int size = photos.size();
        for (int i = 0; i < size; i++) {
            Photo photo = photos.get(i);
            if (photo.getPath().equals(path)) {
                photos.remove(photo);
                break;
            }
        }
    }
    
    /**
     * Find photos that contain all the specified tags
     * @param tags List of tags to search for
     * @return LinkedList of photos that contain all the specified tags
     * @param nbComps Reference to count the number of tag comparisons
     */
    public LinkedList<Photo> findPhotosByTags(LinkedList<String> tags, int[] nbComps) {
        LinkedList<Photo> result = new LinkedList<>();
        
        // If no tags specified, return all photos
        if (tags.isEmpty()) {
            return photos;
        }
        
        // Check each photo for all required tags
        int photoCount = photos.size();
        for (int i = 0; i < photoCount; i++) {
            Photo photo = photos.get(i);
            boolean containsAllTags = true;
            
            // Check if the photo contains all required tags
            int tagCount = tags.size();
            for (int j = 0; j < tagCount; j++) {
                String tag = tags.get(j);
                nbComps[0]++; // Increment comparison counter
                
                if (!photo.hasTag(tag)) {
                    containsAllTags = false;
                    break;
                }
            }
            
            if (containsAllTags) {
                result.insert(photo);
            }
        }
        
        return result;
    }
    
    /**
     * Find a photo by its path
     * @param path Path of the photo to find
     * @return The photo if found, null otherwise
     */
    public Photo findPhotoByPath(String path) {
        int size = photos.size();
        for (int i = 0; i < size; i++) {
            Photo photo = photos.get(i);
            if (photo.getPath().equals(path)) {
                return photo;
            }
        }
        return null;
    }
}

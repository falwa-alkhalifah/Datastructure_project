/**
 * Photo class represents a photo with its path and associated tags
 */
public class Photo {
    private String path;
    private LinkedList<String> tags;
    
    /**
     * Constructor
     * @param path The full file name (path) of the photo
     * @param tags List of tags associated with the photo
     */
    public Photo(String path, LinkedList<String> tags) {
        this.path = path;
        this.tags = tags;
    }
    
    /**
     * Return the full file name (the path) of the photo.
     * A photo is uniquely identified by its path.
     * @return The path of the photo
     */
    public String getPath() {
        return path;
    }
    
    /**
     * Return all tags associated with the photo
     * @return LinkedList of tags
     */
    public LinkedList<String> getTags() {
        return tags;
    }
    
    /**
     * Check if the photo contains a specific tag
     * @param tag Tag to check
     * @return true if the photo contains the tag, false otherwise
     */
    public boolean hasTag(String tag) {
        return tags.contains(tag);
    }
    
    /**
     * Check if the photo contains all the specified tags
     * @param requiredTags List of tags to check
     * @return true if the photo contains all the tags, false otherwise
     */
    public boolean hasAllTags(LinkedList<String> requiredTags) {
        for (int i = 0; i < requiredTags.size(); i++) {
            String tag = requiredTags.get(i);
            if (!hasTag(tag)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * String representation of the photo
     * @return String containing the path and tags of the photo
     */
    @Override
    public String toString() {
        return "Photo[path=" + path + ", tags=" + tags + "]";
    }
    
    /**
     * Check if two photos are equal (based on path)
     * @param obj Object to compare with
     * @return true if the photos have the same path, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Photo photo = (Photo) obj;
        return path.equals(photo.path);
    }
}

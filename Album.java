/**
 * Album class represents a collection of photos that satisfy a specific condition
 */
public class Album {
    private String name;
    private String condition;
    private PhotoManager manager;
    private int nbComps;
    
    /**
     * Constructor
     * @param name Name of the album
     * @param condition Condition for photos to be included in the album
     * @param manager PhotoManager that contains the photos
     */
    public Album(String name, String condition, PhotoManager manager) {
        this.name = name;
        this.condition = condition;
        this.manager = manager;
        this.nbComps = 0;
    }
    
    /**
     * Return the name of the album
     * @return Name of the album
     */
    public String getName() {
        return name;
    }
    
    /**
     * Return the condition associated with the album
     * @return Condition of the album
     */
    public String getCondition() {
        return condition;
    }
    
    /**
     * Return the manager
     * @return PhotoManager of the album
     */
    public PhotoManager getManager() {
        return manager;
    }
    
    /**
     * Return all photos that satisfy the album condition
     * @return LinkedList of photos that satisfy the condition
     */
    public LinkedList<Photo> getPhotos() {
        // Reset comparison counter
        nbComps = 0;
        
        // If condition is empty, return all photos
        if (condition == null || condition.trim().isEmpty()) {
            return manager.getPhotos();
        }
        
        // Parse the condition
        LinkedList<String> tags = parseCondition(condition);
        
        // Find photos that match the condition
        int[] compCounter = new int[1];
        compCounter[0] = 0;
        LinkedList<Photo> result = manager.findPhotosByTags(tags, compCounter);
        
        // Update comparison counter
        nbComps = compCounter[0];
        
        return result;
    }
    
    /**
     * Return the number of tag comparisons used to find all photos of the album
     * @return Number of tag comparisons
     */
    public int getNbComps() {
        return nbComps;
    }
    
    /**
     * Parse the condition string into a list of tags
     * @param condition Condition string (e.g., "tag1 AND tag2 AND tag3")
     * @return LinkedList of tags
     */
    private LinkedList<String> parseCondition(String condition) {
        LinkedList<String> tags = new LinkedList<>();
        
        // If condition contains "AND", split by "AND"
        if (condition.contains("AND")) {
            String[] tagArray = condition.split("\\s*AND\\s*");
            for (String tag : tagArray) {
                tags.insert(tag.trim());
            }
        } else {
            // Otherwise, it's a single tag
            tags.insert(condition.trim());
        }
        
        return tags;
    }
}

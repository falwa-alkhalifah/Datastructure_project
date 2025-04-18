public class InvIndexPhotoManager {
    private BST<LinkedList<Photo>> index;
    private LinkedList<Photo> allPhotos;

    public InvIndexPhotoManager() {
        index = new BST<>();
        allPhotos = new LinkedList<>();
    }

    public void addPhoto(Photo p) {
        allPhotos.insert(p);
        LinkedList<String> tags = p.getTags();

        for (int i = 0; i < tags.size(); i++) {
            String tag = tags.get(i);
            LinkedList<Photo> photos = index.find(tag);

            if (photos == null) {
                photos = new LinkedList<>();
                photos.insert(p);
                index.insert(tag, photos);
            } else {
                photos.insert(p);
            }
        }
    }

    public void deletePhoto(String path) {
        for (int i = 0; i < allPhotos.size(); i++) {
            if (allPhotos.get(i).getPath().equals(path)) {
                Photo toRemove = allPhotos.get(i);
                allPhotos.remove(i);

                LinkedList<String> tags = toRemove.getTags();
                for (int j = 0; j < tags.size(); j++) {
                    String tag = tags.get(j);
                    LinkedList<Photo> photos = index.find(tag);
                    if (photos != null) {
                        for (int k = 0; k < photos.size(); k++) {
                            if (photos.get(k).getPath().equals(path)) {
                                photos.remove(k);
                                break;
                            }
                        }

                        // إذا صارت القائمة فاضية، نحذف الوسم من الـ index
                        if (photos.size() == 0) {
                            index.remove(tag);
                        }
                    }
                }

                break;
            }
        }
    }

    public BST<LinkedList<Photo>> getPhotos() {
        return index;
    }

    public LinkedList<Photo> getAllPhotos() {
        return allPhotos;
    }
}

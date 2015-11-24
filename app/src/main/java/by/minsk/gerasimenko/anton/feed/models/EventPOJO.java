package by.minsk.gerasimenko.anton.feed.models;

/**
 * Created by gerasimenko on 24.11.2015.
 */
public class EventPOJO {

    private int id;
    private String title;
    private String text;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

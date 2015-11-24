package by.minsk.gerasimenko.anton.feed.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by gerasimenko on 30.09.2015.
 */

@DatabaseTable(tableName="Events")
public class Event implements Serializable {
    @DatabaseField(dataType = DataType.INTEGER) private int id;
    @DatabaseField(dataType = DataType.INTEGER) private int eventId;
    @DatabaseField(dataType = DataType.STRING) private String title;
    @DatabaseField(dataType = DataType.STRING) private String text;
    @DatabaseField(dataType = DataType.STRING) private String urlImage;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public static Event getEmpty() {
        return empty;
    }

    private final static Event empty = new Event();

    public static Event getEvent(EventPOJO newsPOJO){

        Event instance = new Event();


        return  instance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

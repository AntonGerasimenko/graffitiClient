package by.minsk.gerasimenko.anton.feed.models;

/**
 * Created by gerasimenko on 08.10.2015.
 */
public enum FuncConnect {
    ALL_NEWS,
    CURR_NEWS;

    private int id;

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }
}

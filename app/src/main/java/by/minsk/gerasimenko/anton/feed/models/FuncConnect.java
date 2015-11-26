package by.minsk.gerasimenko.anton.feed.models;

/**
 * Created by gerasimenko on 08.10.2015.
 */
public enum FuncConnect {
    ALL_NEWS,
    CURR_NEWS;

    private int id;
    private int lastTime;

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }
}

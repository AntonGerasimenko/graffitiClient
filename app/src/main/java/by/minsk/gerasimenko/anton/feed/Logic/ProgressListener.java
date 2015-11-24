package by.minsk.gerasimenko.anton.feed.Logic;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.models.Event;

/**
 * Created by gerasimenko on 09.10.2015.
 */
public interface ProgressListener {

    void fin(List<Event> news);
}

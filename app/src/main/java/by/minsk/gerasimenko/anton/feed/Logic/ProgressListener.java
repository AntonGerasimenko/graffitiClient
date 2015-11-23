package by.minsk.gerasimenko.anton.feed.Logic;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.models.News;

/**
 * Created by gerasimenko on 09.10.2015.
 */
public interface ProgressListener {

    void fin(List<News> news);
}

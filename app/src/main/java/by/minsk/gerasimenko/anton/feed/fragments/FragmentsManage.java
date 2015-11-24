package by.minsk.gerasimenko.anton.feed.fragments;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.models.Event;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public interface FragmentsManage {

    void showWelcome();
    void showList(List<Event> list);
    void showNews(Event news);
    void setTitleActionBar(String tag);

}

package by.minsk.gerasimenko.anton.feed.fragments;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.models.News;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public interface FragmentsManage {

    void showWelcome();
    void showList(List<News> list);
    void showNews(News news);
    void setTitleActionBar(String tag);

}

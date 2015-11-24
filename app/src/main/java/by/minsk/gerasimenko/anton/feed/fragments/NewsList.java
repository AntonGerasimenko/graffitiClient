package by.minsk.gerasimenko.anton.feed.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.DB.DBService;
import by.minsk.gerasimenko.anton.feed.R;
import by.minsk.gerasimenko.anton.feed.Logic.adapters.NewsListAdapt;
import by.minsk.gerasimenko.anton.feed.models.Event;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class NewsList extends ListFragment {

    public static final String TAG = "ShortList";
    private FragmentsManage manager;

    private List<Event> list;

    public static NewsList newInstance(List<Event> list ){
        assert (list!=null);

        NewsList instance = new NewsList();
        instance.list = list;

        return instance;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        Log.d("Fragments_Load","NewsList");

        if (savedInstanceState!=null) {

            list = DBService.getAll();
        }
        manager = (FragmentsManage) getActivity();
        ListAdapter adapter = new NewsListAdapt(getActivity(), R.layout.item_short_list,list);
        setListAdapter(adapter);
        manager.setTitleActionBar(TAG);

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Event news = list.get(position);
        manager.showNews(news);
    }
}

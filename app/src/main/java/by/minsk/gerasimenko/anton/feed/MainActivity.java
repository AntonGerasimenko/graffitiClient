package by.minsk.gerasimenko.anton.feed;



import android.os.Bundle;


import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.view.View;


import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.fragments.FragmentsManage;
import by.minsk.gerasimenko.anton.feed.fragments.NewsFragm;
import by.minsk.gerasimenko.anton.feed.fragments.EventsList;
import by.minsk.gerasimenko.anton.feed.fragments.Welcome;
import by.minsk.gerasimenko.anton.feed.models.Event;

public  class MainActivity extends SherlockFragmentActivity implements FragmentsManage {

    private ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = getSupportActionBar();
        if (savedInstanceState==null)      showWelcome();
    }

    @Override
    public void showWelcome(){

        Fragment welcome = new Welcome();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container, welcome, Welcome.TAG).commit();
    }

    @Override
    public void showList(List<Event> listNews){

        findViewById(R.id.progressBar3).setVisibility(View.GONE);
        Fragment list = EventsList.newInstance(listNews);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, list, EventsList.TAG);
        ft.addToBackStack(EventsList.TAG).commit();
    }

    @Override
    public void showNews(Event news) {

      /*  Fragment fragment = NewsFragm.newInstance(news);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment, NewsFragm.TAG);
        ft.addToBackStack(NewsFragm.TAG).commit();*/
    }

    @Override
    public void setTitleActionBar(String tag) {
        assert (tag!=null);

        switch (tag) {
            case Welcome.TAG:
                bar.setTitle(R.string.welcome);
                break;
            case EventsList.TAG:
                bar.setTitle(R.string.list_news);
                break;
           /* case NewsFragm.TAG:
                bar.setTitle(R.string.current_news);
                break;*/
        }
    }
}

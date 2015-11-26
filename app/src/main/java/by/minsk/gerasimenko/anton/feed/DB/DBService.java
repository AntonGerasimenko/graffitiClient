package by.minsk.gerasimenko.anton.feed.DB;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.minsk.gerasimenko.anton.feed.models.EventPOJO;
import by.minsk.gerasimenko.anton.feed.models.Event;

/**
 * Created by gerasimenko on 08.10.2015.
 */
public class DBService {

    public static void put(List<EventPOJO> newses) {
        try {
            Dao<Event,String> dao = DBManager.getInstance().getHelper().getNewsDao();

            List<Event> list = new ArrayList<>();
            for(EventPOJO eventPOJO:newses){
                list.add(Event.getEvent(eventPOJO));
            }
            dao.create(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Set<Integer> getDownloadedId(){
        Set<Integer> out = new HashSet<>();

        for (Event news:getAll()) {
            out.add(news.getId());
        }
        return out;
    }

    public static List<Event> getAll(){
        try {
            Dao<Event,String>     dao = DBManager.getInstance().getHelper().getNewsDao();
            return  dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    public static Set <Integer> getLoadedEvents() {
        Set <Integer> out = new HashSet<>();

        for (Event news:getAll()) {
            out.add(news.getId());
        }
        return out;
    }

  /*  public static void addTextNews(int id,String htmlText) {
        try {
            Dao<Event,String> dao = DBManager.getInstance().getHelper().getNewsDao();



            QueryBuilder<Event,String> builder = dao.queryBuilder();
            builder.where().eq("_id", id);
            List<Event> newses = dao.query(builder.prepare());

            if (newses!= null) {
                Event correct = newses.get(0);
                DeleteBuilder<Event,String> deleteBuilder = dao.deleteBuilder();
                deleteBuilder.where().eq("_id",correct.get_id());
                deleteBuilder.delete();

                correct.setHtmlNews(htmlText);

                dao.create(correct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public static List<Event> getNews(int id) {
        List<Event> newses = null;
        try {
            Dao<Event, String> dao = DBManager.getInstance().getHelper().getNewsDao();


            QueryBuilder<Event, String> builder = dao.queryBuilder();
            builder.where().eq("_id", id);
            newses = dao.query(builder.prepare());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return newses!=null ? newses: Collections.<Event>emptyList();
    }

    public static int getLastTime() {
        int time=0;
        try {
            Dao<Event, String> dao = DBManager.getInstance().getHelper().getNewsDao();
            QueryBuilder<Event, String> builder = dao.queryBuilder();
            builder
                    .limit(1L)
                    .orderBy("id", false);
            List<Event> events =  dao.query(builder.prepare());
            if (events != null && !events.isEmpty()) {

                Event event = events.get(0);
                time = event.getTimeEvent();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return time;
    }
}

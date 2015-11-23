package by.minsk.gerasimenko.anton.feed.DB;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.minsk.gerasimenko.anton.feed.models.News;
import by.minsk.gerasimenko.anton.feed.models.NewsPOJO;

/**
 * Created by gerasimenko on 08.10.2015.
 */
public class DBService {

    public static void put(List<NewsPOJO> newses) {
        try {
            Dao<News,String> dao = DBManager.getInstance().getHelper().getNewsDao();

            List<News> list = new ArrayList<>();
            for(NewsPOJO newsPOJO:newses){
                list.add(News.getNews(newsPOJO));
            }
            dao.create(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Set<Integer> getDownloadedId(){
        Set<Integer> out = new HashSet<>();

        for (News news:getAll()) {
            out.add(news.get_id());
        }
        return out;
    }

    public static List<News> getAll(){
        try {
            Dao<News,String>     dao = DBManager.getInstance().getHelper().getNewsDao();
            return  dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static void addTextNews(int id,String htmlText) {
        try {
            Dao<News,String> dao = DBManager.getInstance().getHelper().getNewsDao();



            QueryBuilder<News,String> builder = dao.queryBuilder();
            builder.where().eq("_id", id);
            List<News> newses = dao.query(builder.prepare());

            if (newses!= null) {
                News correct = newses.get(0);
                DeleteBuilder<News,String> deleteBuilder = dao.deleteBuilder();
                deleteBuilder.where().eq("_id",correct.get_id());
                deleteBuilder.delete();

                correct.setHtmlNews(htmlText);

                dao.create(correct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<News> getNews(int id) {
        List<News> newses = null;
        try {
            Dao<News, String> dao = DBManager.getInstance().getHelper().getNewsDao();


            QueryBuilder<News, String> builder = dao.queryBuilder();
            builder.where().eq("_id", id);
            newses = dao.query(builder.prepare());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return newses!=null ? newses: Collections.<News>emptyList();
    }
}

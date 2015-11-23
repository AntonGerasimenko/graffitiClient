package by.minsk.gerasimenko.anton.feed.Network;



import android.os.Handler;
import android.os.Message;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import by.minsk.gerasimenko.anton.feed.DB.DBService;
import by.minsk.gerasimenko.anton.feed.Logic.ProgressListener;
import by.minsk.gerasimenko.anton.feed.models.FuncConnect;
import by.minsk.gerasimenko.anton.feed.models.News;
import by.minsk.gerasimenko.anton.feed.models.NewsPOJO;

/**
 * Created by gerasimenko on 02.10.2015.
 */
public class Connect {

    private final String url = "http://127.0.0.1";

    private static Handler handler;

    public void latestNews(final FuncConnect type, final ProgressListener listener) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                connect(type);
                handler.sendEmptyMessage(0);
            }
        });
        thread.start();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (type.equals(FuncConnect.CURR_NEWS)){
                    List <News> list = DBService.getNews(type.getId());
                    listener.fin(list);
                } else if (type.equals(FuncConnect.ALL_NEWS)) {

                    List <News> list = DBService.getAll();
                    listener.fin(list);
                }

                super.handleMessage(msg);
            }
        };
   }

    private void connect(FuncConnect type) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(this.url);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            Generator g = new Generator();
            g.generateRequest(out,type);
            out.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            handleResponse(type,in);

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (urlConnection!= null)  urlConnection.disconnect();
        }
    }

    private List<NewsPOJO> extractDownloadNews(List<NewsPOJO> input) {
        List<NewsPOJO> out = new ArrayList<>();
        Set<Integer> ids = DBService.getDownloadedId();

        for(NewsPOJO newsPOJO:input) {

            int id = newsPOJO.getId();
            if (!ids.contains(id)) {
                out.add(newsPOJO);
            }
        }
        return out;
    }

    private void handleResponse(FuncConnect type,InputStream stream) {
        Parser parser = new Parser();
        switch (type) {
            case ALL_NEWS:
                List<NewsPOJO> response =  parser.parse(stream);
                response = extractDownloadNews(response);
                DBService.put(response);
                break;
            case CURR_NEWS:
                String htmlText = parser.parseText(stream);
                int id = type.getId();
                DBService.addTextNews(id, htmlText);
                break;
        }
    }
}

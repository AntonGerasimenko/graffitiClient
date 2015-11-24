package by.minsk.gerasimenko.anton.feed.Logic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.R;
import by.minsk.gerasimenko.anton.feed.models.Event;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class NewsListAdapt extends ArrayAdapter <Event> {

    private List<Event> objects;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build();


    {

        imageLoader.init(ImageLoaderConfiguration.createDefault(getContext()));
    }


    public NewsListAdapt(Context context, int resource, List<Event> objects) {
        super(context, resource, objects);

        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_short_list, parent, false);
        }

        TextView title =(TextView) convertView.findViewById(R.id.title);
        TextView textEvent = (TextView) convertView.findViewById(R.id.text);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);

        Event event = objects.get(position);

        viewImage(event.getUrlImage(),image);

        title.setText(/*Convert.date(news.get())*/event.getTitle());
        textEvent.setText(event.getText());

        return convertView;
    }

    private void viewImage(String imageUrl,ImageView imageView ) {



        imageLoader.displayImage(imageUrl, imageView,options);
    }
}

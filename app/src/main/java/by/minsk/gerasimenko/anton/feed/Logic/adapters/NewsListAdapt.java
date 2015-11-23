package by.minsk.gerasimenko.anton.feed.Logic.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.disc.DiskCache;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.Logic.Convert;
import by.minsk.gerasimenko.anton.feed.R;
import by.minsk.gerasimenko.anton.feed.models.News;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class NewsListAdapt extends ArrayAdapter <News> {

    private List<News> objects;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build();


    {

        imageLoader.init(ImageLoaderConfiguration.createDefault(getContext()));
    }


    public NewsListAdapt(Context context, int resource, List<News> objects) {
        super(context, resource, objects);

        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_short_list, parent, false);
        }

        TextView date =(TextView) convertView.findViewById(R.id.date);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);

        News news = objects.get(position);

        viewImage(news.getUrlImage(),image);

        date.setText(Convert.date(news.getDate()));
        title.setText(news.getTitle());

        return convertView;
    }

    private void viewImage(String imageUrl,ImageView imageView ) {



        imageLoader.displayImage(imageUrl, imageView,options);
    }
}

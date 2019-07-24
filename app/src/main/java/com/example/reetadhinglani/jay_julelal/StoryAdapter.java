package com.example.reetadhinglani.jay_julelal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by ankit on 13/08/2018.
 */
public class StoryAdapter extends BaseAdapter
{
    private Context ctx;
    private String[] stories;
    private WidgetContainer container;
    public StoryAdapter(Context ctx, String[] stories)
    {
        this.ctx = ctx;
        this.stories = stories;
    }

    @Override
    public int getCount()
    {
        return stories.length;
    }

    @Override
    public Object getItem(int index)
    {
        return stories[index];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View CurrentView, ViewGroup viewGroup)
    {
        View MyView = CurrentView;
        if(MyView==null)
        {
            LayoutInflater inflater = LayoutInflater.from(ctx);
            MyView = inflater.inflate(R.layout.story_raw,null);
            container =new WidgetContainer();
            container.lblstorytitle = (TextView)MyView.findViewById(R.id.lblstorytitle);
            MyView.setTag(container);
        }
        else
        {
            container = (WidgetContainer)MyView.getTag();
        }
        container.lblstorytitle.setText(stories[position]);

        return MyView;
    }

    class WidgetContainer
    {
        public TextView lblstorytitle;
    }
}

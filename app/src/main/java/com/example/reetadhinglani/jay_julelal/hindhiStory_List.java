package com.example.reetadhinglani.jay_julelal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class hindhiStory_List extends AppCompatActivity {

    DataStorage storage;
    Context ctx=this;
    String FileName ="easylearn";
    String[] storieshindhi;
    ListView lststories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi_story__list);
        storage = new DataStorage(ctx, FileName);
        lststories = (ListView)findViewById(R.id.lststory);
        GetDataFromDataSource();
        ShowData();
        SetEvents();
    }

    private void SetEvents()
    {
        lststories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Intent i = new Intent(ctx,hindhiStoryDetail.class);
                i.putExtra("position",position); //integer version
                i.putExtra("StoryName",storieshindhi[position]);
                startActivity(i);
            }
        });
    }

    private void ShowData()
    {
        StoryAdapter adapter = new StoryAdapter(ctx,storieshindhi);
        lststories.setAdapter(adapter);
    }

    private void GetDataFromDataSource()
    {
        storieshindhi = getResources().getStringArray(R.array.storieshindhi);
    }
}

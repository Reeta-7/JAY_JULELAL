package com.example.reetadhinglani.jay_julelal;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class StoryDetail extends AppCompatActivity implements TextToSpeech.OnInitListener {

    int position;
    private TextToSpeech tts;
    private Button btnspeak;
    DataStorage storage;
    String FileName ="easylearn";
    TextView lblstoryname,lblstorytext;
    ImageView img,img1;
    int FileIds[] = {R.raw.historyofjhulelal,R.raw.lifestoryofjhulelal,R.raw.historyofchaliosaheb,R.raw.chaliosahebcelebration,R.raw.historyofchetichand,R.raw.chetichandcelebration,R.raw.bheranasaheb,R.raw.palav,R.raw.sloganofjhulela
           };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        position = getIntent().getExtras().getInt("position");
        allocatememory();
        String FileContent = storage.ReadFileFromApp(FileIds[position]);
        lblstorytext.setText(FileContent);
        lblstoryname.setText(getIntent().getExtras().getString("StoryName"));

    }


    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS){
            int result = tts.setLanguage(Locale.US);
            if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this, "This language is not supported", Toast.LENGTH_SHORT).show();
            }
            else {


            }
        }
        else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onDestroy() {
        if(tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
    private void speakThis() {
        String text= lblstorytext.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH,null);

    }
    private void allocatememory()
    {
        tts = new TextToSpeech(this,this);
        storage = new DataStorage(this,FileName);
        lblstoryname = (TextView)findViewById(R.id.lblstoryname);
        lblstorytext = (TextView)findViewById(R.id.lblstorytext);
    }


}

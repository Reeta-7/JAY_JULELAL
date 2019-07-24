package com.example.reetadhinglani.jay_julelal;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class hindhiStoryDetail extends AppCompatActivity implements TextToSpeech.OnInitListener {

    int position;
    private TextToSpeech tts;
    private Button btnspeak;
    DataStorage storage;
    String FileName ="easylearn";
    TextView lblstoryname,lblstorytext;
    ImageView img,img1;
    int FileIds[] = {R.raw.historyofjhulelalhindhi,R.raw.lifestoryofjhulelalhindhi,R.raw.historyofchaliosahebhindhi,R.raw.chaliosahebcelebrationhindi,R.raw.historyofchetichandhindhi,R.raw.chaliosahebcelebrationhindi,R.raw.bheranasahebhindi,R.raw.palavhindhi,R.raw.sloganofjhulelahindhi
           };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindhi_story_detail);

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

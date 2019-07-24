package com.example.reetadhinglani.jay_julelal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;

public class select_lang extends AppCompatActivity {
    Button btneng, btnhindhi;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_lang);
        btneng = (Button) findViewById(R.id.btnenglish);
        btnhindhi = (Button) findViewById(R.id.btnhindi);
        spinner = (Spinner) findViewById(R.id.spinner);
        btneng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLangauge();
            }
        });
    }
    private void changeLangauge() {


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);



    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        if(pos == 0) {
            Intent SwitchIntent;
            SwitchIntent = new Intent(select_lang.this, Story_List.class);startActivity(SwitchIntent); //what to be done here to chnage the app's language?

        }else if(pos==1) {
            Intent hindiintent = new Intent(select_lang.this, hindhiStory_List.class);
            startActivity(hindiintent);}

        }


    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}

//
// later().inflate(R.menu.main_menu, popupMenu.getMenu());
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.english:
//                        Intent SwitchIntent;
//                        SwitchIntent = new Intent(select_lang.this, Story_List.class);
//                        startActivity(SwitchIntent);
//                        break;
//                    case R.id.hindi:
//                        Intent hindiintent = new Intent(select_lang.this, hindhiStory_List.class);
//                        startActivity(hindiintent);
//                        break;
//                }
//                return true;
//            }
//        });
//        popupMenu.show();
//    }
//}

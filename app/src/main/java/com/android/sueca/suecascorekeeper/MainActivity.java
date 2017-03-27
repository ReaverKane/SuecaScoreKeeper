package com.android.sueca.suecascorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This sets the Buttons to select the proper activities.
    public void rulesBtn(View v) {
        Intent rulesSwt = new Intent(this, Rules.class);
        startActivity(rulesSwt);
    }
    public void scoreBtn (View v){
        Intent scoreSwt = new Intent(this, Score.class);
        startActivity(scoreSwt);
    }
}

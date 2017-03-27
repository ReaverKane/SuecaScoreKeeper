package com.android.sueca.suecascorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.android.sueca.suecascorekeeper.R.string.them;
import static com.android.sueca.suecascorekeeper.R.string.us;

public class Score extends AppCompatActivity {

    int usScore = 0;
    int themScore = 0;
    int usGames = 0;
    int themGames = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        displayScoreUs(usScore);
        displayGamesUs(usGames);
        displayScoreThem(themScore);
        displayGamesThem(themGames);
    }

    public void oneBtnUs(View v) {
        usScore = usScore + 1;
        if (usScore >= 4) {
            usGames = usGames + 1;
            usScore = 0;
            themScore = 0;
        }
        displayScoreThem(themScore);
        displayGamesThem(themGames);
        displayScoreUs(usScore);
        displayGamesUs(usGames);
    }

    public void twoBtnUs(View v) {
        usScore = usScore + 2;
        if (usScore >= 4) {
            usGames = usGames + 1;
            usScore = 0;
            themScore = 0;
        }
        displayScoreThem(themScore);
        displayGamesThem(themGames);
        displayScoreUs(usScore);
        displayGamesUs(usGames);
    }

    public void fourBtnUs(View v) {
        usScore = usScore + 4;
        if (usScore >= 4) {
            usGames = usGames + 1;
            usScore = 0;
            themScore = 0;
        }
        displayScoreThem(themScore);
        displayGamesThem(themGames);
        displayScoreUs(usScore);
        displayGamesUs(usGames);
    }

    public void oneBtnThem(View v) {
        themScore = themScore + 1;
        if (themScore >= 4) {
            themGames = themGames + 1;
            themScore = 0;
            usScore = 0;
        }
        displayScoreThem(themScore);
        displayGamesThem(themGames);
        displayScoreUs(usScore);
        displayGamesUs(usGames);

    }

    public void twoBtnThem(View v) {
        themScore = themScore + 2;
        if (themScore >= 4) {
            themGames = themGames + 1;
            themScore = 0;
            usScore = 0;
        }
        displayScoreThem(themScore);
        displayGamesThem(themGames);
        displayScoreUs(usScore);
        displayGamesUs(usGames);
    }

    public void fourBtnThem(View v) {
        themScore = themScore + 4;
        if (themScore >= 4) {
            themGames = themGames + 1;
            themScore = 0;
            usScore = 0;
        }
        displayScoreThem(themScore);
        displayGamesThem(themGames);
        displayScoreUs(usScore);
        displayGamesUs(usGames);
    }


    public void resetBtn(View v) {
        usScore = 0;
        usGames = 0;
        themGames = 0;
        themScore = 0;
        displayGamesUs(usGames);
        displayScoreUs(usScore);
        displayGamesThem(themGames);
        displayScoreThem(themScore);
    }

    public void homeBtn(View v) {
        Intent homeSwt = new Intent(this, MainActivity.class);
        startActivity(homeSwt);
    }

    public void displayScoreUs(int score) {
        TextView scoreView = (TextView) findViewById(R.id.us_score);
        scoreView.setText(String.valueOf(score));
    }


    public void displayScoreThem(int score) {
        TextView scoreView = (TextView) findViewById(R.id.them_score);
        scoreView.setText(String.valueOf(score));
    }


    public void displayGamesUs(int games) {
        TextView scoreView = (TextView) findViewById(R.id.us_games);
        scoreView.setText(String.valueOf(games));
    }

    public void displayGamesThem(int games) {
        TextView scoreView = (TextView) findViewById(R.id.them_games);
        scoreView.setText(String.valueOf(games));
    }
}


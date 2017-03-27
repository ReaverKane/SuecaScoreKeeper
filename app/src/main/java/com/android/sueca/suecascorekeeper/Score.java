package com.android.sueca.suecascorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.android.sueca.suecascorekeeper.R.string.them;
import static com.android.sueca.suecascorekeeper.R.string.us;

public class Score extends AppCompatActivity {
    private static final String U_SCORE = "Us Score";
    private static final String T_SCORE = "Them Score";
    private static final String U_GAMES = "Us Games";
    private static final String T_GAMES = "Them Games";
    //Declaring Global Variables for the scores
    int usScore = 0;
    int themScore = 0;
    int usGames = 0;
    int themGames = 0;

    //This shouldn't lose state on account that i kept it on portrait (too many buttons for landscape)
    //but best make sure.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(U_SCORE, usScore);
        savedInstanceState.putInt(T_SCORE, themScore);
        savedInstanceState.putInt(U_GAMES, usGames);
        savedInstanceState.putInt(T_GAMES, themGames);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        if (savedInstanceState != null) {
            usScore = savedInstanceState.getInt(U_SCORE, 0);
            themScore = savedInstanceState.getInt(T_SCORE, 0);
            usGames = savedInstanceState.getInt(U_GAMES, 0);
            themGames = savedInstanceState.getInt(T_GAMES, 0);
        }
        //Since the Text by default is blank, this sets the text to the default variables onCreate
        displayScoreUs(usScore);
        displayGamesUs(usGames);
        displayScoreThem(themScore);
        displayGamesThem(themGames);
    }

    //Add one Point to "Us" I feel there's Redundant code in the conditional part, but i'm not savvy enough to fix it.
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

    //Add two Points to "Us"
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

    //Add 4 Points to "Us"
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

    //Add 1 Point to "Them"
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

    //Add 2 Points to "Them"
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

    //Add 4 Points to "Them"
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

    //RESET
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

    // Back Button (It's Called Home because i wanted to make it a house icon, but i decided my life was complicated enough).
    public void homeBtn(View v) {
        Intent homeSwt = new Intent(this, MainActivity.class);
        startActivity(homeSwt);
    }

    //Methods for displaying stuff.
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


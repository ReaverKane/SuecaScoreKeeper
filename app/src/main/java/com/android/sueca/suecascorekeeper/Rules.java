package com.android.sueca.suecascorekeeper;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class Rules extends AppCompatActivity {
    private static final String C_INDEX = "currentIndex";
    private static final String P_COUNT = "pageCount";
    //saving some Unicode characters to use as list bullets.
    char spades = '\u2660';
    char hearts = '\u2661';
    char clubs = '\u2663';
    char diamond = '\u2662';
    // String array to be shown on textSwitcher
    String textToShow[] = {
            //Page 1
            spades + " Sueca means \"Sweedish\" in Portuguese, more accurately it's the feminine of the noun.\n\n" +
                    hearts + " It's a very popular card game, played both social and competitively\n\n" +
                    clubs + " Chance plays a role in it, but skill and cunning are key to winning.\n\n" +
                    diamond + " A \"game\" consists in a series of \"matches\" of ten \"rounds\" each (each player plays 1 card per round).",

            //Page 2
            spades + "It is a 4 player card game, players are divided into pairs, forming two teams.\n\n" +
                    hearts + " The players in each team are seated opposite to each other.\n\n" +
                    clubs + " Teams aren't allowed to talk to each other (at least about the cards, it IS a social game).\n\n" +
                    diamond + " Depending on house rules, signs and \"tells\" are permitted, allowing teams to coordinate.\n" +
                    " Also it's up for the other team players to try and \"read\" the opponent's tells to predict their moves",

            //Page 3
            spades + " Sueca is played with a normal 52 card deck minus the 8's, 9's and 10's.\n\n" +
                    hearts + " The highest cards are the aces, followed by the 7's, Kings, Jacks, and Queens (in that order), then number cards from highest to lowest.\n\n" +
                    clubs + " Dealing has very strict rules to limit the predictability of each hand.\n\n" +
                    diamond + " The first \"shuffler\" is chosen randomly, then it's the next person clockwise, and so on.",

            //Page 4
            spades + " After shuffling the \"shuffler\" passes the deck to his team mate, who cuts and passes it to his right;\n\n" +
                    hearts + " That person is the dealer. The cards can be dealt in one of two ways:\n\n" +
                    "\t" + clubs + " The dealer reveals the bottom card, keeps it, and then deals 10 cards per player, counter-clockwise;\n\n" +
                    "\t" + clubs + " or he reveals the top card, deals to himself first (9 more cards), then continues clockwise.",

            //Page 5
            spades + " The card revealed by the dealer chooses the \"trump\" suit, cards from that suit will always be higher than from other suits.\n" +
                    " (ie. If the trumph is hearts, then the 2 of hearts will beat an Ace from any other suit.)\n\n" +
                    hearts + " The person that shuffles the deck is the first person to play. He then picks a card and plays it on the table.\n\n" +
                    clubs + " The round progresses with each player playing a card clockwise, always attempting to \"beat\" the highest card on the table.\n\n" +
                    diamond + " You must try to play a card from the same suit as the first card played, unless you don't have any cards of that suit (similar to Hearts).\n" +
                    "If you don't have any of those cards you can choose to play a trump if the cards on the table are high, or play some other suit to \"dump\" low score cards",

            // Page 6
            spades + " After 10 rounds, the match ends and each team's stack of cards is counted for scoring.\n\n" +
                    hearts + " Match Score is as follows:\n\n" +
                    "\tAces = 11 Points;\n\n\t7's = 10 Points\n\n\tKings = 4 Points\n\n\tJacks = 3 Points\n\n\tQueens = 2 Points\n\n\tOther numbers = 0 Points",
            //Page 7
            spades + " After totaling each team's score, teams are awarded the following game points:\n\n" +
                    "\t" + hearts + " Match score between 61 - 90 = 1 Point;\n\n" + "\t" + hearts + " Match score over 90 = 2 Points;\n\n" + "\t" +
                    hearts + " Tied score of 60 = No points for either;\n\n" + "\t" +
                    hearts + " If a team wins 120 points (all the points available) they instantly win the game.",

            //Page 8
            spades + " You are allowed to \"cheat\" and \"renounce\" the suit in play, playing a trump or a low card to save points,\n\n" +
                    "but if a player from the other team catches you your team loses the game.\n\n" +
                    hearts + " You can confirm the \"renounce\" by checking the previous plays in each pile and determine if the player should have played that card or not.\n\n" +
                    clubs + " If a team wrongly accuses another of \"renouncing\" the match, the other team wins a point.\n\n" +
                    diamond + " The first team with 4 points wins the game."

    };
    // Total length of the string array
    int messageCount = textToShow.length;
    // to keep current Index of text
    int currentIndex = 0;
    //You don't want a page 0, so...
    int pageCount = currentIndex + 1;
    /*
     I got the goings on of the Textswitcher from http://www.androhub.com/android-textswitcher/
     My comments are signed, the rest is from the original code
     This is very likely a mess, but i'm still getting the hang of Java...- Nuno
     */
    // Originally the androhub had these declared as static, Android Studio didn't like it so i changed it. -Nuno
    private Button next;
    private TextSwitcher textswitcher;
    // This one is all me -Nuno
    private Button prev;

    //The score activity doesn't lose it's state, cause it won't rotate. But lets see if i can make this one keep its state.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(C_INDEX, currentIndex);
        savedInstanceState.putInt(P_COUNT, pageCount);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(C_INDEX, 0);
            pageCount = savedInstanceState.getInt(P_COUNT, 0);
        }

        // Call all the methods
        init();
        loadAnimations();
        setFactory();
        setListener();

        // This shows Rule 1 on start and Page 1 - Nuno
        textswitcher.setText(textToShow[currentIndex]);
        displayIndex("Page " + pageCount);
    }

    void init() {
        next = (Button) findViewById(R.id.buttonNext);
        textswitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        prev = (Button) findViewById(R.id.buttonPrev);

    }

    void loadAnimations() {

        // Declare the in and out animations and initialize them
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);

        // set the animation type of textSwitcher
        textswitcher.setInAnimation(in);
        textswitcher.setOutAnimation(out);
    }

    // Click listener method for button
    void setListener() {

        // ClickListener for NEXT button
        // When clicked on Button TextSwitcher will switch between texts
        // The current Text will go OUT and next text will come in with
        // specified animation
        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                currentIndex++;
                // If index reaches maximum reset it
                // The original code didn't have a previous button, adding one was a challenge.
                // Originally it would crash when going below 0, which eventually i fixed.
                // Then it started crashing randomly when going from max to 0 and trying to go up.
                // I fixed that by changing from the original == messageCount to >= which is actually better;
                // From past experiences in such things (lots of excel, calculators and such)
                // its usually better to have these "triggers" at an interval than an absolute, unless that's exactly what you want.
                // So if stuff takes an unexpected behavior you are already covered (which was the case).
                if (currentIndex >= messageCount)
                    currentIndex = 0;
                // Set the textSwitcher text according to current index from
                // string array
                textswitcher.setText(textToShow[currentIndex]);

                pageCount = currentIndex + 1;

                //Pages are important - Nuno
                displayIndex("Page " + pageCount);


            }
        });
        prev.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // If index reaches minimum reset it to max - Nuno
                //This method was crashing a lot until i moved the reset condition before the order to reduce the count, had to iterate A LOT to fix this.
                if (currentIndex < 1)
                    currentIndex = messageCount;

                currentIndex--;
                // Set the textSwitcher text according to current index from
                // string array
                textswitcher.setText(textToShow[currentIndex]);
                pageCount = currentIndex + 1;

                //Pages are important - Nuno
                displayIndex("Page " + pageCount);

            }
        });
    }

    // Set Factory for the textSwitcher *Compulsory part
    void setFactory() {
        textswitcher.setFactory(new ViewFactory() {

            public View makeView() {

                // Create run time textView with some attributes like gravity,
                // color, etc.
                TextView myText = new TextView(Rules.this);
                myText.setGravity(Gravity.TOP);
                myText.setTextSize(16);
                myText.setTextColor(Color.WHITE);
                myText.setPadding(16, 8, 16, 8);
                return myText;
            }
        });
    }

    //back button
    public void homeBtn(View v) {
        Intent homeSwt = new Intent(this, MainActivity.class);
        startActivity(homeSwt);
    }

    //Added display method for the pages.
    public void displayIndex(String index) {
        TextView indexView = (TextView) findViewById(R.id.index_display);
        indexView.setText(String.valueOf(index));
    }
}

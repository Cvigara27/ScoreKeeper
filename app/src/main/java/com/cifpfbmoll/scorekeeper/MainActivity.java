package com.cifpfbmoll.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreTeam1 = 0;
    private int scoreTeam2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView team1 = findViewById(R.id.t1score);
        team1.setText(String.valueOf(scoreTeam1));

        TextView team2 = findViewById(R.id.t2score);
        team2.setText(String.valueOf(scoreTeam2));

        if (savedInstanceState != null) {
            scoreTeam1 = savedInstanceState.getInt("score1");
            scoreTeam2 = savedInstanceState.getInt("score2");
            //Set the score text views
            team1.setText(String.valueOf(scoreTeam1));
            team2.setText(String.valueOf(scoreTeam2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt("score1", scoreTeam1);
        outState.putInt("score2", scoreTeam2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    public void increaseScore(View v){
        if(v == findViewById(R.id.t1increase)){
            TextView team1 = findViewById(R.id.t1score);
            scoreTeam1++;
            team1.setText(String.valueOf(scoreTeam1));
        }else if(v == findViewById(R.id.t2increase)){
            TextView team2 = findViewById(R.id.t2score);
            scoreTeam2++;
            team2.setText(String.valueOf(scoreTeam2));
        }
    }

    public void decreaseScore(View v){
        if(v == findViewById(R.id.t1decrease)){
            TextView team1 = findViewById(R.id.t1score);
            if((scoreTeam1 - 1) >= 0){
                scoreTeam1--;
            }
            team1.setText(String.valueOf(scoreTeam1));
        }else if(v == findViewById(R.id.t2decrease)){
            TextView team2 = findViewById(R.id.t2score);
            if((scoreTeam2 - 1) >= 0){
                scoreTeam2--;
            }
            team2.setText(String.valueOf(scoreTeam2));
        }
    }
}
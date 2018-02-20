package com.example.android.scorekeeperapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Gather the variable names from the string resource file
     */
    String team_a;
    int team_a_score;
    int team_b_score;
    int set_score_a;
    int set_score_b;
    int extra_points_a = 0;
    int extra_points_b = 0;
    String team_b;
    String tournament_location;
    String year_of_tournament;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        team_b = getString(R.string.team_b_name);
        team_a = getString(R.string.team_a_name);
        tournament_location = getString(R.string.location);
        year_of_tournament = getString(R.string.year);

        setContentView(R.layout.activity_main);
        displayTeams(team_a + " vs " + team_b);
        displayGameInformation(tournament_location + " | " + year_of_tournament);
        displayTeamAScore(team_a_score);
        displayTeamBScore(team_b_score);
        displayTeamASet(set_score_a);
        displayTeamBSet(set_score_b);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        team_a_score += 1;
        if (team_a_score == 1) {
            displayTeamAScore(15);
        } else if (team_a_score == 2) {
            displayTeamAScore(30);
        } else if (team_a_score == 3) {
            displayTeamAScore(40);
        } else if (team_a_score > 3) {
            extra_points_a += 1;
            displayTeamAScore(extra_points_a);
        }


        if ((team_a_score > 3) && (team_a_score - team_b_score > 1)) {
            set_score_a += 1;
            displayTeamASet(set_score_a);
            team_a_score = 0;
            team_b_score = 0;
            displayTeamBScore(team_b_score);
            displayTeamAScore(team_a_score);
        }

    }

    /**
     * Increase the score for Team A by 1 point.
     */

    public void addOneForTeamB(View v) {
        team_b_score += 1;
        if (team_b_score == 1) {
            displayTeamBScore(15);
        } else if (team_b_score == 2) {
            displayTeamBScore(30);
        } else if (team_b_score == 3) {
            displayTeamBScore(40);
        } else if (team_b_score > 3) {
            extra_points_b += 1;
            displayTeamBScore(extra_points_b);

        }

        if ((team_b_score > 3) && (team_b_score - team_a_score > 1)) {
            set_score_b += 1;
            displayTeamBSet(set_score_b);
            team_a_score = 0;
            team_b_score = 0;
            displayTeamBScore(team_b_score);
            displayTeamAScore(team_a_score);
            extra_points_a = 0;
            extra_points_b = 0;
        }
    }


    /**
     * Methods below display team and game information.
     */

    public void displayTeams(String name) {
        TextView nameView = (TextView) findViewById(R.id.teams_playing);
        nameView.setText(String.valueOf(name));
    }

    public void displayGameInformation(String name) {
        TextView nameView = (TextView) findViewById(R.id.game_information);
        nameView.setText(String.valueOf(name));
    }

    /**
     * Methods below display team scores.
     */

    public void displayTeamAScore(int score) {
        TextView ScoreView = (TextView) findViewById(R.id.team_a_score);
        ScoreView.setText(String.valueOf(score));
    }

    public void displayTeamBScore(int score) {
        TextView ScoreView = (TextView) findViewById(R.id.team_b_score);
        ScoreView.setText(String.valueOf(score));
    }

    /**
     * Methods below display Set scores.
     */

    public void displayTeamASet(int score) {
        TextView ScoreView = (TextView) findViewById(R.id.set_1_score_a);
        ScoreView.setText(String.valueOf(score));
    }

    public void displayTeamBSet(int score) {
        TextView ScoreView = (TextView) findViewById(R.id.set_1_score_b);
        ScoreView.setText(String.valueOf(score));
    }
}

package com.example.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayScore extends AppCompatActivity{

    private TextView scoreText;
    private Button playAgain;
    private MainActivity mainActivity;
//cette classe responsable pour la derniére interface qui affiche le score et aussi
    //si vous voulez de jouer une autre fois

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);

        scoreText = findViewById(R.id.scoreText);
        Bundle extras = getIntent().getExtras();
        scoreText.setText("Your Score is : " + String.valueOf(extras.getInt("score")) + " / 10");
        playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayScore.this ,MainActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onBackPressed() {
        finishAffinity();
    }


    }











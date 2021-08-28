package com.example.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart;
    private MainActivity mainActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //Quand on click sur le button il va ouvrire l'interface du QCM
            case R.id.btnStart:
                Intent intent = new Intent(this, Quiz.class);
                startActivity(intent);
                break;
            default:
                break;
        }


    }


    //Si on click sur "BACK( <- )" , il va ouvrire un dialogue qui dit "Est-que vous êtes sûr de sortir"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Do you want to exit");
        alert.setCancelable(false);

        //alert.setMessage("Your score is " + scoreValue);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();

    }

}




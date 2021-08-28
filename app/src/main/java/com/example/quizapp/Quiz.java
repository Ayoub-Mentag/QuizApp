package com.example.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.LinkedList;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
//cette classe contient les données ça veut dire les capitales du mondes , les choix..

    private TextView questionNumber ,country;
    private Button ans1, ans3, ans4, ans2;
    private LinkedList<Data> quizzes = new LinkedList<Data>();
    private int scoreValue = 0, numberOfQuestion = 1, i = 0;
    private boolean updated;
    private View quizBody;
    private ProgressBar progressBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        initView();
        insertData();
        Collections.shuffle(quizzes);
        if (numberOfQuestion == 1) {
            country.setText(quizzes.get(i).getQuestion());
            ans1.setText(quizzes.get(i).getAnswer1());
            ans2.setText(quizzes.get(i).getAnswer2());
            ans3.setText(quizzes.get(i).getAnswer3());
            ans4.setText(quizzes.get(i).getAnswer4());
            questionNumber.setText("Question " + numberOfQuestion + " / " + 10);
            updated = true;
        }


        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);


    }

    private void initView() {
        questionNumber = findViewById(R.id.questionNumber);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        progressBar = findViewById(R.id.progressBar);
        quizBody = findViewById(R.id.quizBody);
        country = findViewById(R.id.country);
    }
//cette fonction contient les données ça veut dire les capitales du mondes , les choix..

    private void insertData() {
        quizzes.add(new Data("Maroc", "Copenhague", "Rabat", "Andorre-la-Vieille", "Bakou", "Rabat"));
        quizzes.add(new Data("Albanie", "Tirana ", "Madrid", "Vienne", "Erevan", "Tirana "));
        quizzes.add(new Data("Allemagne", "Reykjavik", "Athènes", "Berlin", "Dublin", "Berlin"));
        quizzes.add(new Data("Andorre", "Andorre-la-Vieille", "Dublin", "Madrid", "Algeria", "Andorre-la-Vieille"));
        quizzes.add(new Data("Arménie", "Tunisia", "Bakou", "Bruxelles", "Erevan", "Erevan"));
        quizzes.add(new Data("Autriche", "Belgrade", "Prague", "Vienne", "Berne", "Vienne"));
        quizzes.add(new Data("Azerbaïdjan", "Stockholm", "Bakou", "Ljubjana", "Bratislava", "Bakou"));
        quizzes.add(new Data("Biélorussie", "Minsk", "Saint-Marin", "Moscou", "Londres", "Minsk"));
        quizzes.add(new Data("Belgique", "Bucarest", "Lisbonne", "Varsovie", "Bruxelles", "Bruxelles"));
        quizzes.add(new Data("Bosnie-Herzégovine", "Oslo", "Pays-Amsterdam", "Sarajevo", "Monaco", "Sarajevo"));
        quizzes.add(new Data("Bulgarie", "Sofia", "Chisinau", "La-Valette", "Skopje", "Sofia"));
        quizzes.add(new Data("Croatie", "Luxembourg", "Dublin", "Zagreb", "Oslo", "Zagreb"));
        quizzes.add(new Data("Danemark", "Rome", "Copenhague", "Vilnius", "Bakou", "Copenhague"));
        quizzes.add(new Data("Espagne", "Vaduz", "Riga", "Madrid", "Reykjavik", "Madrid"));
        quizzes.add(new Data("Estonie", "Tallin", "Sofia", "Minsk", "Sarajevo", "Tallin"));
        quizzes.add(new Data("Finlande", "Bruxelles", "Belgrade", "Prague", "Helsinki", "Helsinki"));
        quizzes.add(new Data("France", "Sofia", "Paris", "Oslo", "Bakou", "Paris"));
        quizzes.add(new Data("Géorgie", "Tbilissi", "Monaco", "Pays-Amsterdam", "Zagreb", "Tbilissi"));
        quizzes.add(new Data("Grèce", "Vaduz", "Riga", "Dublin", "Athènes", "Athènes"));
        quizzes.add(new Data("Hongrie", "Vienne", "Bakou", "Budapest", "Erevan", "Budapest"));
        quizzes.add(new Data("Irlande", "Dublin", "Sofia", "Minsk", "Halsinki", "Dublin"));

        quizzes.add(new Data("Islande", "Pekin", "Dacca", "Bogota", "Reykjavik", "Reykjavik"));
        quizzes.add(new Data("Italie", "Bagdad", "Rome", "Singapour", "Ankara", "Rome"));
        quizzes.add(new Data("Lettonie", "Seoul", "New Delhi", "Riga", "Jakarta", "Riga"));
        quizzes.add(new Data("Liechtenstein", "Tokyo", "Lima", "le Caire", "Vaduz", "Vaduz"));
        quizzes.add(new Data("Lituanie", "Kaboul", "Hanoi", "Vilnius", "Riyad", "Vilnius"));
        quizzes.add(new Data("Luxembourg", "Nairobi", "Madrid", "Kiev", "Luxembourg", "Luxembourg"));
        quizzes.add(new Data("Macédoine", "Skopje", "Damas", "Quito", "Paris", "Skopje"));
        quizzes.add(new Data("Malte", "Amman", "La-Valette", "Accra", "Harare", "La-Valette"));
        quizzes.add(new Data("Moldavie", "Doha", "Conakry", "Khartoum", "Chisinau", "Chisinau"));
        quizzes.add(new Data("Monaco", "Yaounde", "Abuja", "Monaco", "Ottawa", "Monaco"));
        quizzes.add(new Data("Norvège", "Oslo", "FreeTown", "Dakar", "Monrovia", "Oslo"));
        quizzes.add(new Data("Pays-Bas", "Port-au-Prince", "Ougadougou", "Pays-Amsterdam", "Islamabad", "Pays-Amsterdam"));
        quizzes.add(new Data("Pologne", "Lilongwe", "Varsovie", "Stockholm", "Naypyidaw", "Varsovie"));
        quizzes.add(new Data("Portugal", "Jerusalem", "Bichkek", "Lome", "Lisbonne", "Lisbonne"));
        quizzes.add(new Data("Roumanie", "Katmandou", "Bucarest", "Mascate", "Zagreb", "Bucarest"));
        quizzes.add(new Data("Royaume-Uni", "Londres", "Amserdam", "Pretoria", "Tegucigalpa", "Londres"));
        quizzes.add(new Data("Russie", "Sofia", "Berne", "Moscou", "Dakar", "Moscou"));
        quizzes.add(new Data("Saint-Marin", "Athenes", "Bangui", "Khartoum", "Saint-Marin", "Saint-Marin"));
        quizzes.add(new Data("Slovaquie", "Tirana", "Tunis", "Bratislava", "Abuja", "Bratislava"));
        quizzes.add(new Data("Slovénie", "Abou Dabi", "Douchanbe", "Ljubjana", "Damas", "Ljubjana"));
        quizzes.add(new Data("Suède", "Asmara", "Stockholm", "Lisbonne", "Dublin", "Stockholm"));
        quizzes.add(new Data("Suisse", "Copenhague", "Skopje", "San Salvador", "Berne", "Berne"));
        quizzes.add(new Data("République-Tchèque", "Prague", "Sofia", "Minsk", "Halsinki", "Prague"));
        quizzes.add(new Data("Ukraine", "Nicosie", "Maseru", "Gaborone", "Kiev", "Kiev"));
        quizzes.add(new Data("Vatican", "Bruxelles", "Vatican", "Manama", "Praia", "Vatican"));
        quizzes.add(new Data("Yougoslavie", "Vatican", "Melekeok", "Belgrade", "Reykjavik", "Belgrade"));
    }



    @Override
    public void onClick(View view) {


        if (updated) {
            Button btn = (Button) view;
            changeColor(btn);
            progressBar.incrementProgressBy(10);

            if (numberOfQuestion == 10) {
                  Intent intent = new Intent(this ,DisplayScore.class);
                  intent.putExtra("score" , scoreValue);
                  startActivity(intent);
                }

            }

            updated = false;
        }




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
//cette fonction responsable de changer le color de button  ça dépend votre réponse
//Si la réponse est correcte le colour va changer á le vert ....
    private void changeColor(Button selected) {

        if (!selected.getText().toString().equals(quizzes.get(i).getRealAnswer())) {
//            final MediaPlayer fa = MediaPlayer.create(this , R.raw.fa);
//            fa.start();
            selected.setBackgroundColor(Color.RED);
            if (quizzes.get(i).getRealAnswer().equals(quizzes.get(i).getAnswer1())){
                 ans1.setBackgroundColor(Color.GREEN);
            }else if (quizzes.get(i).getRealAnswer().equals(quizzes.get(i).getAnswer2())){
                 ans2.setBackgroundColor(Color.GREEN);
            }else if (quizzes.get(i).getRealAnswer().equals(quizzes.get(i).getAnswer3())){
                 ans3.setBackgroundColor(Color.GREEN);
            }else
                ans4.setBackgroundColor(Color.GREEN);
        }
        else {
            selected.setBackgroundColor(Color.GREEN);
//            final MediaPlayer tr = MediaPlayer.create(this , R.raw.tr);
//            tr.start();
            scoreValue++;
        }
        if (numberOfQuestion < 10) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateQuestions();
                    questionNumber.setText("Question " + numberOfQuestion + " / " + 10);
                    ans1.setBackgroundColor(0x0000_0000);
                    ans2.setBackgroundColor(0x0000_0000);
                    ans3.setBackgroundColor(0x0000_0000);
                    ans4.setBackgroundColor(0x0000_0000);
                }
            }, 1000);
        }

    }


    //cette fonction responsable de mettre á jour les questions
    private void updateQuestions() {
        numberOfQuestion++;
        if (numberOfQuestion <= 10 && numberOfQuestion != 1) {
            i++;
            country.setText(quizzes.get(i).getQuestion());
            ans1.setText(quizzes.get(i).getAnswer1());
            ans2.setText(quizzes.get(i).getAnswer2());
            ans3.setText(quizzes.get(i).getAnswer3());
            ans4.setText(quizzes.get(i).getAnswer4());
            updated = true;
        }
    }


    //cette classe qui nous aide d'insérer les données
    public class Data {
        private String question;
        private String answer1;
        private String answer2;
        private String answer3;
        private String answer4;
        private String realAnswer;

        public Data(String question, String answer1, String answer2, String answer3, String answer4, String realAnswer) {
            this.question = question;
            this.answer1 = answer1;
            this.answer2 = answer2;
            this.answer3 = answer3;
            this.answer4 = answer4;
            this.realAnswer = realAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer1() {
            return answer1;
        }

        public String getAnswer2() {
            return answer2;
        }

        public String getAnswer3() {
            return answer3;
        }

        public String getAnswer4() {
            return answer4;
        }

        public String getRealAnswer() {
            return realAnswer;
        }
    }

}













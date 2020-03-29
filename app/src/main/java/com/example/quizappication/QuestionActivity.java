package com.example.quizappication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizappication.models.Questions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;
    TextView tv, scoreTxt,tvheader;
    List<Questions> questions = new ArrayList<>();
    public static int correct = 0, wrong = 0;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getQuestions();

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);
        scoreTxt = (TextView) findViewById(R.id.scoreTxt);
        tvheader=(TextView)findViewById(R.id.tvheader);
        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setupUi(flag);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if(flag<questions.size()-1) {
                    if (questions.get(flag).getAnswer().equals(ansText)) {
                        correct++;
                        Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();

                    } else {
                        wrong++;
                        Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                    flag++;
                    setupUi(flag);
                    radio_g.clearCheck();
                }else {
                    submitbutton.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "This is the last question", Toast.LENGTH_SHORT).show();
                }

            }
        });


}

    private void setupUi(int flag) {
        if (questions != null && questions.size() > 0) {
            StringBuilder stringBuilder=new StringBuilder("Question ").append(flag+1).append(" out of ").append(questions.size());
            tvheader.setText(stringBuilder);
            tv.setText(questions.get(flag).getQuestion());
            rb1.setText(questions.get(flag).getChoices().get(0));
            rb2.setText(questions.get(flag).getChoices().get(1));
            rb3.setText(questions.get(flag).getChoices().get(2));
            rb4.setText(questions.get(flag).getChoices().get(3));
            scoreTxt.setText("Your Score : " + correct);

        }
    }

    private void getQuestions() {
        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "question.json");
        Gson gson = new Gson();
        Type listQuestions = new TypeToken<List<Questions>>() {
        }.getType();
        questions = gson.fromJson(jsonFileString, listQuestions);
    }

}

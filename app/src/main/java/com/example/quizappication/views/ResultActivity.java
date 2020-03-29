package com.example.quizappication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizappication.R;
import com.example.quizappication.ResultAdapter;
import com.example.quizappication.models.Questions;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ArrayList<Questions> questions = new ArrayList<Questions>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        questions = (ArrayList<Questions>) getIntent().getSerializableExtra("QuestionListExtra");

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(questions!=null && questions.size()>0) {
            ResultAdapter adapter = new ResultAdapter(ResultActivity.this, questions);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

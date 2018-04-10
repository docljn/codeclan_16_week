package example.codeclan.com.eightballapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        answerText = findViewById(R.id.answer_text);
//
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
//
        String answer = extras.getString("answer");
//
        answerText.setText(answer);

    }
}














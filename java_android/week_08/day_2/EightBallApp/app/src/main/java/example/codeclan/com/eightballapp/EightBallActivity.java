package example.codeclan.com.eightballapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EightBallActivity extends AppCompatActivity {

    EditText questionEditText;
    Button shakeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_ball);

        questionEditText = findViewById(R.id.question);
        shakeButton = findViewById(R.id.button);

    }

    public void onShakeButtonClicked(View button){
        EightBall eightBall = new EightBall(new Answer());
        String displayAnswer = eightBall.randomAnswer();

        Intent intent = new Intent(this, AnswerActivity.class);

        intent.putExtra("answer", displayAnswer);

        startActivity(intent);
    }









}



















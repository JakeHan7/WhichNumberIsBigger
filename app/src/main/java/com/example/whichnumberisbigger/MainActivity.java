package com.example.whichnumberisbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //instance variables for the widgets we need to
    //access programmatically
    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private int score;
    private int rightNum;
    private int leftNum;


    public static final int MAX_NUM = 1000;
    public static final int MIN_NUM= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        updateDisplay();
    }



    private void updateDisplay() {
        // set the score
        String scoreString = getResources().getString(R.string.main_score);
        textViewScore.setText(scoreString + score );

        // randomize the numbers
        leftNum = genNumber();
        rightNum= genNumber();
        while(leftNum==rightNum){
            rightNum= genNumber();
        }

        //set the button values
        buttonLeft.setText(String.valueOf(leftNum));
        buttonRight.setText(String.valueOf(rightNum));
    }

    private int genNumber() {
        int range = MAX_NUM-MIN_NUM +1;
        return MIN_NUM + (int)(Math.random() * range);
    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textview_main_score);
    }

    public void onLeftClick(View view) {
        checkAnswer(true);

    }


    public void onRightClick(View view) {

        checkAnswer( false);

        }

        public void checkAnswer(boolean leftPressed){
        String message;
        if((leftNum>rightNum && leftPressed) || (rightNum>leftNum && !leftPressed)) {
                score++;
                message = "Correct!";
            }else{
                score--;
                message = "Nope, you are wrong";
            }
            updateDisplay();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }


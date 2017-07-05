package com.example.android.gameofthronesquiz;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int NUMBER_OF_QUESTIONS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // displays result at the bottom of the app and a picture that represents it
// either happy face, sad face or super happy face :)
    public String displayResult(int score) {
        String resultText = getString(R.string.result01) + score + getString(R.string.result02) + NUMBER_OF_QUESTIONS + getString(R.string.result03);
        if (score == NUMBER_OF_QUESTIONS) {
            resultText += getString(R.string.resultMax);
            resultFull();
        } else if (score >= 0.5 * NUMBER_OF_QUESTIONS) {
            resultText += getString(R.string.resultHalf);
            resultGood();
        } else {
            resultText += getString(R.string.resultLess);
            resultBad();
        }
        return resultText;
    }

    // Checks if the right button was selected. If yes, then adds one point.
    public void calculateResult(View view) {
        int score = 0;
        // Question One Checking
        RadioButton questionOne = (RadioButton) findViewById(R.id.questionOneAnswer);
        boolean questionOneCorrect = questionOne.isChecked();
        if (questionOneCorrect) {
            score ++;
        }
        // Question Two Checking
        RadioButton questionTwo = (RadioButton) findViewById(R.id.questionTwoAnswer);
        boolean questionTwoCorrect = questionTwo.isChecked();
        if (questionTwoCorrect) {
            score ++;
        }
        // Question Three Checking
        RadioButton questionThree = (RadioButton) findViewById(R.id.questionThreeAnswer);
        boolean questionThreeCorrect = questionThree.isChecked();
        if (questionThreeCorrect) {
            score ++;
        }
        // Question Four Checking
        RadioButton questionFour = (RadioButton) findViewById(R.id.questionFourAnswer);
        boolean questionFourCorrect = questionFour.isChecked();
        if (questionFourCorrect) {
            score ++;
        }
        // Question Five Checking
        RadioButton questionFive = (RadioButton) findViewById(R.id.questionFiveAnswer);
        boolean questionFiveCorrect = questionFive.isChecked();
        if (questionFiveCorrect) {
            score ++;
        }
        // Question Six Checking
        RadioButton questionSix = (RadioButton) findViewById(R.id.questionSixAnswer);
        boolean questionSixCorrect = questionSix.isChecked();
        if (questionSixCorrect) {
            score ++;
        }

        // Question Seven Checking
        RadioButton questionSeven = (RadioButton) findViewById(R.id.questionSevenAnswer);
        boolean questionSevenCorrect = questionSeven.isChecked();
        if (questionSevenCorrect) {
            score ++;
        }
        // Question Eight Checking
        EditText questionEight = (EditText) findViewById(R.id.question8);
        String questionEightAnswer = questionEight.getText().toString();
        String correctAnswerEight = "as high as honor";
        if (questionEightAnswer.equalsIgnoreCase(correctAnswerEight)) {
            score ++;
        }

        // Question Nine Checking
        CheckBox houseManderly = (CheckBox) findViewById(R.id.q8a);
        boolean swornHouseManderly = houseManderly.isChecked();
        CheckBox houseGreyjoy = (CheckBox) findViewById(R.id.q8b);
        boolean swornHouseGreyjoy = houseGreyjoy.isChecked();
        CheckBox houseGlover = (CheckBox) findViewById(R.id.q8c);
        boolean swornHouseGlover = houseGlover.isChecked();
        CheckBox houseBolton = (CheckBox) findViewById(R.id.q8d);
        boolean swornHouseBolton = houseBolton.isChecked();
        CheckBox houseRoyce = (CheckBox) findViewById(R.id.q8e);
        boolean swornHouseRoyce = houseRoyce.isChecked();
        CheckBox houseMormont = (CheckBox) findViewById(R.id.q8f);
        boolean swornHouseMormont = houseMormont.isChecked();
        if (swornHouseManderly && swornHouseGlover && swornHouseBolton && swornHouseMormont) {
            if (!(swornHouseGreyjoy || swornHouseRoyce)) {
                score ++;
            }
        }
        // Question Ten Checking
        EditText questionTen = (EditText) findViewById(R.id.question10);
        String questionTenAnswer = questionTen.getText().toString();
        String correctAnswerTen = "Blackfish";
        if (questionTenAnswer.equals(correctAnswerTen)) {
            score ++;
        }
        Toast.makeText(this, displayResult(score), Toast.LENGTH_LONG).show();
    }

    // plays sound for question seven
    MediaPlayer musicPlayer;

    public void questionSevenPlay(View view) {
        if (musicPlayer != null) {
            musicPlayer.release();
            musicPlayer = null;
        }
        musicPlayer = MediaPlayer.create(this, R.raw.rains_of_castamere);
        musicPlayer.start();
    }

    public void questionSevenStop(View view) {
        musicPlayer.release();
    }

    // image displayed when user has all points
    public void resultFull() {
        ImageView resultImg = (ImageView) findViewById(R.id.result_image);
        resultImg.setImageResource(R.drawable.result_full);
    }

    // image displayed when user has more than half the points.
    public void resultGood() {
        ImageView resultImg = (ImageView) findViewById(R.id.result_image);
        resultImg.setImageResource(R.drawable.result_good);
    }

    // image displayed when user has more less than half the points.
    public void resultBad() {
        ImageView resultImg = (ImageView) findViewById(R.id.result_image);
        resultImg.setImageResource(R.drawable.result_bad);
    }


}

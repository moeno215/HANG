package com.example.kridshangz;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String answerWord; //Correct answer string
    private String guessWord; //User guess string
    private int remainingGuesses; //Amount of failed user guesses before failure.
    private ArrayList<String> dictionary = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readFromWordlist();
        startGame();
        defineButtons();
    }

    public void defineButtons(){
        findViewById(R.id.replay_button).setOnClickListener(buttonListener);
        findViewById(R.id.hint_button).setOnClickListener(buttonListener);
        findViewById(R.id.A_button).setOnClickListener(buttonListener);
        findViewById(R.id.B_button).setOnClickListener(buttonListener);
        findViewById(R.id.C_button).setOnClickListener(buttonListener);
        findViewById(R.id.D_button).setOnClickListener(buttonListener);
        findViewById(R.id.E_button).setOnClickListener(buttonListener);
        findViewById(R.id.F_button).setOnClickListener(buttonListener);
        findViewById(R.id.G_button).setOnClickListener(buttonListener);
        findViewById(R.id.H_button).setOnClickListener(buttonListener);
        findViewById(R.id.I_button).setOnClickListener(buttonListener);
        findViewById(R.id.J_button).setOnClickListener(buttonListener);
        findViewById(R.id.K_button).setOnClickListener(buttonListener);
        findViewById(R.id.L_button).setOnClickListener(buttonListener);
        findViewById(R.id.M_button).setOnClickListener(buttonListener);
        findViewById(R.id.N_button).setOnClickListener(buttonListener);
        findViewById(R.id.O_button).setOnClickListener(buttonListener);
        findViewById(R.id.P_button).setOnClickListener(buttonListener);
        findViewById(R.id.Q_button).setOnClickListener(buttonListener);
        findViewById(R.id.R_button).setOnClickListener(buttonListener);
        findViewById(R.id.S_button).setOnClickListener(buttonListener);
        findViewById(R.id.T_button).setOnClickListener(buttonListener);
        findViewById(R.id.U_button).setOnClickListener(buttonListener);
        findViewById(R.id.V_button).setOnClickListener(buttonListener);
        findViewById(R.id.W_button).setOnClickListener(buttonListener);
        findViewById(R.id.X_button).setOnClickListener(buttonListener);
        findViewById(R.id.Y_button).setOnClickListener(buttonListener);
        findViewById(R.id.Z_button).setOnClickListener(buttonListener);
    }

    private View.OnClickListener buttonListener = new View.OnClickListener(){
        @Override
        public void onClick (View view){ //Switch handles multiple buttons for onClickListener
            view.setClickable(false);
            view.setVisibility(View.INVISIBLE);
            switch (view.getId()){
                case R.id.replay_button:
                    resetButtons();
                    startGame();
                    break;
                case R.id.hint_button:
                    for(int i=0; i<answerWord.length(); i++){
                        if(guessWord.charAt(i) != answerWord.charAt(i)) {
                            guessLetter(Character.toUpperCase(answerWord.charAt(i)));
                            break;
                        }
                    }
                    break;
                case R.id.A_button:
                    guessLetter('A');
                    break;
                case R.id.B_button:
                    guessLetter('B');
                    break;
                case R.id.C_button:
                    guessLetter('C');
                    break;
                case R.id.D_button:
                    guessLetter('D');
                    break;
                case R.id.E_button:
                    guessLetter('E');
                    break;
                case R.id.F_button:
                    guessLetter('F');
                    break;
                case R.id.G_button:
                    guessLetter('G');
                    break;
                case R.id.H_button:
                    guessLetter('H');
                    break;
                case R.id.I_button:
                    guessLetter('I');
                    break;
                case R.id.J_button:
                    guessLetter('J');
                    break;
                case R.id.K_button:
                    guessLetter('K');
                    break;
                case R.id.L_button:
                    guessLetter('L');
                    break;
                case R.id.M_button:
                    guessLetter('M');
                    break;
                case R.id.N_button:
                    guessLetter('N');
                    break;
                case R.id.O_button:
                    guessLetter('O');
                    break;
                case R.id.P_button:
                    guessLetter('P');
                    break;
                case R.id.Q_button:
                    guessLetter('Q');
                    break;
                case R.id.R_button:
                    guessLetter('R');
                    break;
                case R.id.S_button:
                    guessLetter('S');
                    break;
                case R.id.T_button:
                    guessLetter('T');
                    break;
                case R.id.U_button:
                    guessLetter('U');
                    break;
                case R.id.V_button:
                    guessLetter('V');
                    break;
                case R.id.W_button:
                    guessLetter('W');
                    break;
                case R.id.X_button:
                    guessLetter('X');
                    break;
                case R.id.Y_button:
                    guessLetter('Y');
                    break;
                case R.id.Z_button:
                    guessLetter('Z');
                    break;
            }
        }
    };

    public void resetButtons(){
        findViewById(R.id.hint_button).setClickable(true);
        findViewById(R.id.hint_button).setVisibility(View.VISIBLE);
        findViewById(R.id.A_button).setClickable(true);
        findViewById(R.id.A_button).setVisibility(View.VISIBLE);
        findViewById(R.id.B_button).setClickable(true);
        findViewById(R.id.B_button).setVisibility(View.VISIBLE);
        findViewById(R.id.C_button).setClickable(true);
        findViewById(R.id.C_button).setVisibility(View.VISIBLE);
        findViewById(R.id.D_button).setClickable(true);
        findViewById(R.id.D_button).setVisibility(View.VISIBLE);
        findViewById(R.id.E_button).setClickable(true);
        findViewById(R.id.E_button).setVisibility(View.VISIBLE);
        findViewById(R.id.F_button).setClickable(true);
        findViewById(R.id.F_button).setVisibility(View.VISIBLE);
        findViewById(R.id.G_button).setClickable(true);
        findViewById(R.id.G_button).setVisibility(View.VISIBLE);
        findViewById(R.id.H_button).setClickable(true);
        findViewById(R.id.H_button).setVisibility(View.VISIBLE);
        findViewById(R.id.I_button).setClickable(true);
        findViewById(R.id.I_button).setVisibility(View.VISIBLE);
        findViewById(R.id.J_button).setClickable(true);
        findViewById(R.id.J_button).setVisibility(View.VISIBLE);
        findViewById(R.id.K_button).setClickable(true);
        findViewById(R.id.K_button).setVisibility(View.VISIBLE);
        findViewById(R.id.L_button).setClickable(true);
        findViewById(R.id.L_button).setVisibility(View.VISIBLE);
        findViewById(R.id.M_button).setClickable(true);
        findViewById(R.id.M_button).setVisibility(View.VISIBLE);
        findViewById(R.id.N_button).setClickable(true);
        findViewById(R.id.N_button).setVisibility(View.VISIBLE);
        findViewById(R.id.O_button).setClickable(true);
        findViewById(R.id.O_button).setVisibility(View.VISIBLE);
        findViewById(R.id.P_button).setClickable(true);
        findViewById(R.id.P_button).setVisibility(View.VISIBLE);
        findViewById(R.id.Q_button).setClickable(true);
        findViewById(R.id.Q_button).setVisibility(View.VISIBLE);
        findViewById(R.id.R_button).setClickable(true);
        findViewById(R.id.R_button).setVisibility(View.VISIBLE);
        findViewById(R.id.S_button).setClickable(true);
        findViewById(R.id.S_button).setVisibility(View.VISIBLE);
        findViewById(R.id.T_button).setClickable(true);
        findViewById(R.id.T_button).setVisibility(View.VISIBLE);
        findViewById(R.id.U_button).setClickable(true);
        findViewById(R.id.U_button).setVisibility(View.VISIBLE);
        findViewById(R.id.V_button).setClickable(true);
        findViewById(R.id.V_button).setVisibility(View.VISIBLE);
        findViewById(R.id.W_button).setClickable(true);
        findViewById(R.id.W_button).setVisibility(View.VISIBLE);
        findViewById(R.id.X_button).setClickable(true);
        findViewById(R.id.X_button).setVisibility(View.VISIBLE);
        findViewById(R.id.Y_button).setClickable(true);
        findViewById(R.id.Y_button).setVisibility(View.VISIBLE);
        findViewById(R.id.Z_button).setClickable(true);
        findViewById(R.id.Z_button).setVisibility(View.VISIBLE);
    }

    public void guessLetter(Character letter){
        char[] guessWordArray = guessWord.toCharArray();
        boolean correctGuess = false;
        TextView guessDisplay = (TextView) findViewById(R.id.guessDisplay);
        ImageView mImageView, fImageView;
        mImageView = (ImageView) findViewById(R.id.hangmanImage);
        fImageView = (ImageView) findViewById(R.id.hangmanFace);

        for (int i = 0; i < answerWord.length(); i++) {
            if (letter == answerWord.charAt(i)) {
                guessWordArray[i] = letter;
                correctGuess = true;
            }
        }
        if (correctGuess) {
            guessWord = new String(guessWordArray);
            guessDisplay.setText(displayGuessWord());   // Re-displays guess word on the screen.
            if(guessWord.equals(answerWord) && remainingGuesses!=0){
                fImageView.setVisibility(View.VISIBLE);
                remainingGuesses=0;

                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
            }
        } else {
            remainingGuesses--;
            switch (remainingGuesses) {
                case 5:
                    mImageView.setImageResource(R.drawable.hangman_stage_1);
                    break;
                case 4:
                    mImageView.setImageResource(R.drawable.hangman_stage_2);
                    break;
                case 3:
                    mImageView.setImageResource(R.drawable.hangman_stage_3);
                    break;
                case 2:
                    mImageView.setImageResource(R.drawable.hangman_stage_4);
                    break;
                case 1:
                    mImageView.setImageResource(R.drawable.hangman_stage_5);
                    break;
                case 0:
                    mImageView.setImageResource(R.drawable.hangman_stage_7);
                    guessWord = answerWord;
                    guessDisplay.setText(displayGuessWord());   // Displays answer word on loss.

                    Toast.makeText(this, "You Lose", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        if(remainingGuesses == 0) {

            findViewById(R.id.replay_button).setClickable(true);
            findViewById(R.id.replay_button).setVisibility(View.VISIBLE);
        }
    }

    private void readFromWordlist(){
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.wordlist_2);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String eachline = bufferedReader.readLine();
            while (eachline != null) {
                dictionary.add(eachline);
                eachline = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startGame(){
        TextView guessDisplay = (TextView)findViewById(R.id.guessDisplay);
        setAnswerWord();
        remainingGuesses = 6;
        ImageView mImageView, fImageView;
        fImageView = (ImageView) findViewById(R.id.hangmanFace);
        fImageView.setVisibility(View.INVISIBLE);
        mImageView = (ImageView)findViewById(R.id.hangmanImage);
        mImageView.setImageResource(R.drawable.hangman_stage_0);
        guessDisplay.setText(displayGuessWord()); //Displays current guessWord to the screen.
    }

    public void setAnswerWord() {
        Random rand = new Random();
        answerWord = dictionary.get(rand.nextInt(dictionary.size())); //Selects a random word from the dictionary.
        answerWord = answerWord.toUpperCase();
        guessWord = "";
        for(int i=0; i<answerWord.length(); i++){
            if(!Character.isLetter(answerWord.charAt(i))){
                guessWord += answerWord.charAt(i);       //Non-letter characters are revealed if in word.
            }else{
                guessWord += '_';       //Fills guessWord with underlines equal to size of answerWord
            }
        }
    }

    public String displayGuessWord() { //Converts guessWord to String with added spaces for the screen to display.
        String newGuessString = "";
        for (int i=0; i<guessWord.length(); i++) {
            newGuessString += guessWord.charAt(i);
            if(i != guessWord.length()-1){
                newGuessString += " ";
            }
        }
        return newGuessString;
    }
}

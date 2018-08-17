package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mx.utng.juniorsmed.appdaw.QuestionLibraryThree;

public class QuizThreeActivity extends AppCompatActivity {
    private QuestionLibraryThree mQuestionLibrary = new QuestionLibraryThree();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoiceOne;
    private Button mButtonChoiceTwo;
    private Button mButtonChoiceThree;
    private Button mquit;


    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private int arregloPreg[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_quiz_three);

        mScoreView = (TextView)findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_score);
        mQuestionView = (TextView)findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_question);
        mButtonChoiceOne = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_choice_one);
        mButtonChoiceTwo = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_choice_two);
        mButtonChoiceThree = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_choice_three);
        mquit = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_quit);
        arregloPreg=new int[5];

        mquit.setEnabled(false);

        mquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePoints();
            }
        });


        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoiceOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoiceOne.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizThreeActivity.this, "Correcta", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizThreeActivity.this, "Incorrecta", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoiceTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoiceTwo.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizThreeActivity.this, "Correcta", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizThreeActivity.this, "Incorrecta", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoiceThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoiceThree.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizThreeActivity.this, "Correcta", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizThreeActivity.this, "Incorrecta", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3





    }



    private void updateQuestion()
    {
        try {

            generaArregloNum();
            mQuestionView.setText(mQuestionLibrary.getQuestion(arregloPreg[mQuestionNumber]));
            mButtonChoiceOne.setText(mQuestionLibrary.getChoiceOne(arregloPreg[mQuestionNumber]));
            mButtonChoiceTwo.setText(mQuestionLibrary.getChoiceTwo(arregloPreg[mQuestionNumber]));
            mButtonChoiceThree.setText(mQuestionLibrary.getChoiceThree(arregloPreg[mQuestionNumber]));

            mAnswer = mQuestionLibrary.getCorrectAnswer(arregloPreg[mQuestionNumber]);
            mQuestionNumber++;

            if(mQuestionNumber>5){
                Toast.makeText(QuizThreeActivity.this, "SE HA FINALIZADO EL QUIZ", Toast.LENGTH_LONG).show();
                mButtonChoiceOne.setEnabled(false);
                mButtonChoiceTwo.setEnabled(false);
                mButtonChoiceThree.setEnabled(false);
                mquit.setEnabled(true);
            }


        }catch (Exception e){
            mButtonChoiceOne.setEnabled(false);
            mButtonChoiceTwo.setEnabled(false);
            mButtonChoiceThree.setEnabled(false);
            mquit.setEnabled(true);
            Toast.makeText(QuizThreeActivity.this, "Se ha finalizado el quiz", Toast.LENGTH_LONG).show();

        }
    }

    private void savePoints() {
        mScoreView.setText("" + mScore);
        //Para poder lanzar otra activity se utiliza la clase Intent
        Intent intent = new Intent(QuizThreeActivity.this,
                ScoreThreeActivity.class);
        //Creamos la información en un Bundle
        Bundle b = new Bundle();
        b.putString("puntos", mScoreView.getText().toString());

        //Se añade la información al Intent
        intent.putExtras(b);
        startActivity(intent); // Se inicia la otra Activity
        finish();
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);

    }

    private void generaArregloNum(){
        for(int i=0;i<arregloPreg.length;i++){
            // Producir nuevo int aleatorio entre 0 y 99
            int intAletorio=(int)(Math.random()*9)+1;
            for (int j=0;j<i;j++){
                if (arregloPreg[j]==intAletorio)
                    intAletorio=(int)(Math.random()*9)+1;
            }
            arregloPreg[i]=intAletorio;
            System.out.println(arregloPreg[i]);

        }

    }

}

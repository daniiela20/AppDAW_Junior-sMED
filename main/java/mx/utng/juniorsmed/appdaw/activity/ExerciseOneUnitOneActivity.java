package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.utng.juniorsmed.appdaw.fragment.ExerciseFourFragment;
import mx.utng.juniorsmed.appdaw.fragment.ExerciseOneFragment;
import mx.utng.juniorsmed.appdaw.fragment.ExerciseThreeFragment;
import mx.utng.juniorsmed.appdaw.fragment.ExerciseTwoFragment;

public class ExerciseOneUnitOneActivity extends AppCompatActivity implements
        View.OnClickListener,
        ExerciseOneFragment.OnFragmentInteractionListener,
        ExerciseTwoFragment.OnFragmentInteractionListener,
        ExerciseThreeFragment.OnFragmentInteractionListener,
        ExerciseFourFragment.OnFragmentInteractionListener
{
    private ExerciseOneFragment exerciseOneFragment; //Declaración de los objetos
    private ExerciseTwoFragment exerciseTwoFragment;
    private ExerciseThreeFragment exerciseThreeFragment;
    private ExerciseFourFragment exerciseFourFragment;
    private Button btnExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_exercise_one_unit_one);

        exerciseOneFragment = new ExerciseOneFragment(); //Instancias de cada uno de los Fragment
        exerciseTwoFragment = new ExerciseTwoFragment();
        exerciseThreeFragment = new ExerciseThreeFragment();
        exerciseFourFragment = new ExerciseFourFragment();

        btnExercises = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_exercises);
        btnExercises.setOnClickListener(this);


        getSupportFragmentManager().beginTransaction().add(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseOneFragment).commit();
    }

    @Override
    public void onClick(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_one:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseOneFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_two:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseTwoFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_three:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseThreeFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_four:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseFourFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercises:
                Uri btnExercises = Uri.parse("https://drive.google.com/open?id=1vH6kojqekjf2bDbzoESYeEpFOeu7VwFr");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, btnExercises);
                startActivity(intent1);
                break;
        }

        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

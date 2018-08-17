package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.utng.juniorsmed.appdaw.fragment.ExerciseFourUnitTwoFragment;
import mx.utng.juniorsmed.appdaw.fragment.ExerciseOneUnitTwoFragment;
import mx.utng.juniorsmed.appdaw.fragment.ExerciseThreeUnitTwoFragment;
import mx.utng.juniorsmed.appdaw.fragment.ExerciseTwoUnitTwoFragment;

public class ExerciseTwoActivity extends AppCompatActivity implements
        View.OnClickListener,
        ExerciseOneUnitTwoFragment.OnFragmentInteractionListener,
        ExerciseTwoUnitTwoFragment.OnFragmentInteractionListener,
        ExerciseThreeUnitTwoFragment.OnFragmentInteractionListener,
        ExerciseFourUnitTwoFragment.OnFragmentInteractionListener
{
    private ExerciseOneUnitTwoFragment exerciseOneUnitTwoFragment; //Declaración de los objetos
    private ExerciseTwoUnitTwoFragment exerciseTwoUnitTwoFragment;
    private ExerciseThreeUnitTwoFragment exerciseThreeUnitTwoFragment;
    private ExerciseFourUnitTwoFragment exerciseFourUnitTwoFragment;
    private Button btnExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_exercise_two);

        exerciseOneUnitTwoFragment = new ExerciseOneUnitTwoFragment();
        exerciseTwoUnitTwoFragment = new ExerciseTwoUnitTwoFragment();
        exerciseThreeUnitTwoFragment = new ExerciseThreeUnitTwoFragment();
        exerciseFourUnitTwoFragment = new ExerciseFourUnitTwoFragment();

        btnExercises = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_exercises);
        btnExercises.setOnClickListener(this);


        getSupportFragmentManager().beginTransaction().add(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseOneUnitTwoFragment).commit();

    }

    @Override
    public void onClick(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_one_unit_two:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseOneUnitTwoFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_two_unit_two:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseTwoUnitTwoFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_three_unit_two:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseThreeUnitTwoFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_four_unit_two:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseFourUnitTwoFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercises:
                Uri btnExercises = Uri.parse("https://drive.google.com/open?id=1uZkE8EsEBPe9Yikn-KyQnLuFSr8Scfoi");
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

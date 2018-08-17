package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.utng.juniorsmed.appdaw.fragment.ExerciseFourUnitThreeFragment;
import mx.utng.juniorsmed.appdaw.fragment.ExerciseOneUnitThreeFragment;
import mx.utng.juniorsmed.appdaw.fragment.ExerciseThreeUnitThreeFragment;
import mx.utng.juniorsmed.appdaw.fragment.ExerciseTwoUnitThreeFragment;

public class ExerciseThreeActivity extends AppCompatActivity implements
        View.OnClickListener,
        ExerciseOneUnitThreeFragment.OnFragmentInteractionListener,
        ExerciseTwoUnitThreeFragment.OnFragmentInteractionListener,
        ExerciseThreeUnitThreeFragment.OnFragmentInteractionListener,
        ExerciseFourUnitThreeFragment.OnFragmentInteractionListener
{
    private ExerciseOneUnitThreeFragment exerciseOneUnitThreeFragment;
    private ExerciseTwoUnitThreeFragment exerciseTwoUnitThreeFragment;
    private ExerciseThreeUnitThreeFragment exerciseThreeUnitThreeFragment;
    private ExerciseFourUnitThreeFragment exerciseFourUnitThreeFragment;
    private Button btnExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_exercise_three);

        exerciseOneUnitThreeFragment = new ExerciseOneUnitThreeFragment(); //Instancias de cada uno de los Fragment
        exerciseTwoUnitThreeFragment = new ExerciseTwoUnitThreeFragment();
        exerciseThreeUnitThreeFragment = new ExerciseThreeUnitThreeFragment();
        exerciseFourUnitThreeFragment = new ExerciseFourUnitThreeFragment();

        btnExercises = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_exercises);
        btnExercises.setOnClickListener(this);


        getSupportFragmentManager().beginTransaction().add(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseOneUnitThreeFragment).commit();
    }

    @Override
    public void onClick(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_one_unit_three:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseOneUnitThreeFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_two_unit_three:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseTwoUnitThreeFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_three_unit_three:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseThreeUnitThreeFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercise_four_unit_three:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.container_fragments, exerciseFourUnitThreeFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_exercises:
                Uri btnExercises = Uri.parse("https://drive.google.com/open?id=12PDJbxdkfRPjn_CYH_4FIuza9VOKLN71");
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

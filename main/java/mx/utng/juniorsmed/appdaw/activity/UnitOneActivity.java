package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class UnitOneActivity extends AppCompatActivity {
    private Button btnMenuThemes;
    private Button btnMenuConcepts;
    private Button btnMenuExercises;
    private Button btnMenuGames;
    private Button btnMenuVideos;
    private Button btnMenuQuizOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_unit_one);

        btnMenuThemes = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_themes);
        btnMenuThemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_themes = new Intent(getApplicationContext(), Unit1EngineeringWebActivity.class);
                startActivity(go_themes);
            }
        });

        btnMenuConcepts = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_concepts);
        btnMenuConcepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_concepts= new Intent(getApplicationContext(), ConceptsOneActivity.class);
                startActivity(go_concepts);
            }
        });

        btnMenuExercises = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_exercises);
        btnMenuExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_exercises = new Intent(getApplicationContext(), ExerciseOneUnitOneActivity.class);
                startActivity(go_exercises);
            }
        });

        btnMenuGames = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_games);
        btnMenuGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_games = new Intent(getApplicationContext(), GameTwoActivity.class);
                startActivity(go_games);
            }
        });

        btnMenuVideos = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_videos);
        btnMenuVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_videos = new Intent(getApplicationContext(), VideosUnitOneActivity.class);
                startActivity(go_videos);
            }
        });

        btnMenuQuizOne = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_quiz_one);
        btnMenuQuizOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_quiz = new Intent(getApplicationContext(), QuizOneActivity.class);
                startActivity(go_quiz);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent home = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(home);
        finish();

        return super.onKeyDown(keyCode, event);
    }
}


package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class UnitThreeActivity extends AppCompatActivity {
    private Button btnMenuThemes;
    private Button btnMenuConcepts;
    private Button btnMenuExercises;
    private Button btnMenuGames;
    private Button btnMenuVideos;
    private Button btnMenuQuizThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_unit_three);

        btnMenuThemes = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_themes);
        btnMenuThemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_themes = new Intent(getApplicationContext(), Unit3DevelopmentWebActivity.class);
                startActivity(go_themes);
            }
        });

        btnMenuConcepts = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_concepts);
        btnMenuConcepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_concepts= new Intent(getApplicationContext(), ConceptsThreeActivity.class);
                startActivity(go_concepts);
            }
        });

        btnMenuExercises = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_exercises);
        btnMenuExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_exercises = new Intent(getApplicationContext(), ExerciseThreeActivity.class);
                startActivity(go_exercises);
            }
        });

        btnMenuGames = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_games);
        btnMenuGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_games = new Intent(getApplicationContext(), GameThreeHomeActivity.class);
                startActivity(go_games);
                finish();
            }
        });

        btnMenuVideos = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_videos);
        btnMenuVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_videos = new Intent(getApplicationContext(), VideosUnitThreeActivity.class);
                startActivity(go_videos);
            }
        });

        btnMenuQuizThree = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_menu_quiz_three);
        btnMenuQuizThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_quiz = new Intent(getApplicationContext(), QuizThreeActivity.class);
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

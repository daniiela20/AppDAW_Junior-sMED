package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class GameThreeHomeActivity extends AppCompatActivity {
    private Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_game_three_home);

        btnPlay = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_play);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pag2 = new Intent(GameThreeHomeActivity.this,PlayGameThreeActivity.class);
                startActivity(pag2);
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent home_game_three = new Intent(getApplicationContext(), UnitThreeActivity.class);
        startActivity(home_game_three);
        finish();

        return super.onKeyDown(keyCode, event);
    }
}


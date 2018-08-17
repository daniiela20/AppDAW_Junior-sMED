package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mx.utng.juniorsmed.appdaw.R;

public class ScoreOneActivity extends AppCompatActivity {
    private TextView txtContent;
    private Button btnReturnOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_one);
        //Relacionar con XML
        txtContent = (TextView)findViewById(R.id.txt_content);
        //Se recupera la información del intent
        Bundle bundle = this.getIntent().getExtras();
        //Se muestra el dato en la etiqueta
        txtContent.setText(getString(R.string.msg_congratulations) + " " + bundle.getString("puntos") + " aciertos de 5");

        btnReturnOne = (Button) findViewById(R.id.btn_return_one);
        btnReturnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_unit_one = new Intent(getApplicationContext(), UnitOneActivity.class);
                startActivity(back_unit_one);
                finish();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent home = new Intent(getApplicationContext(), UnitOneActivity.class);
        startActivity(home);
        finish();

        return super.onKeyDown(keyCode, event);
    }

}



























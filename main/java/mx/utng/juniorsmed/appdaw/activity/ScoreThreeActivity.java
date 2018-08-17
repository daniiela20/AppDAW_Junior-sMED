package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreThreeActivity extends AppCompatActivity {
    private TextView txtContent;
    private Button btnReturnThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_score_three);
        //Relacionar con XML
        txtContent = (TextView)findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_content);
        //Se recupera la información del intent
        Bundle bundle = this.getIntent().getExtras();
        //Se muestra el dato en la etiqueta
        txtContent.setText(getString(mx.utng.juniorsmed.appdaw.R.string.msg_congratulations) + " " + bundle.getString("puntos")+ " aciertos de 5");

        btnReturnThree = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_return_three);
        btnReturnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent back_unit_three = new Intent(getApplicationContext(), UnitThreeActivity.class);
            startActivity(back_unit_three);
            finish();

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent home = new Intent(getApplicationContext(), UnitThreeActivity.class);
        startActivity(home);
        finish();

        return super.onKeyDown(keyCode, event);
    }
}

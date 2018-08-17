package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayGameThreeActivity extends AppCompatActivity {
    private TextView txtLife;
    private TextView txtAccountant;
    private TextView txtPoints;
    private TextView txtCorrect;
    private TextView txtIncorrect;
    private ImageView imgView;
    private EditText edtText;
    private Button btnConfirm;

    String[] resp={"Rails", "Server", "Generate", "V", "Install"};
    String[] resp2={"rails", "server", "generate", "v", "install"};
    String[] imagen={"question_one", "question_two", "question_three", "question_four", "question_five"};

    int intpunto=0;
    int intvidas=3;
    int numerogenerado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_play_game_three);

        txtCorrect = (TextView) findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_correct);
        txtIncorrect = (TextView) findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_incorrect);

        txtLife = (TextView) findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_life);
        txtAccountant = (TextView) findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_accountant);
        txtPoints = (TextView) findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_points);
        imgView = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_view);
        edtText = (EditText) findViewById(mx.utng.juniorsmed.appdaw.R.id.edt_text);
        btnConfirm = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_confirm);

        establecerImagen(numerogenerado);



            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoconfirmar = edtText.getText().toString().toLowerCase();
                    if (textoconfirmar.equals(resp[numerogenerado]) | textoconfirmar.equals(resp2[numerogenerado])) {

                        txtCorrect.setVisibility(View.VISIBLE);
                        intpunto = intpunto + 1;
                        txtPoints.setText("Puntos: " + intpunto);
                        esperarOne();

                    } else {
                        txtIncorrect.setVisibility(View.VISIBLE);
                        intvidas = intvidas - 1;
                        txtLife.setText("Vidas: " + intvidas);
                        esperarTwo();

                    }
                    if (intvidas == 0) {
                        Toast.makeText(PlayGameThreeActivity.this, "Se terminaron las vidas", Toast.LENGTH_LONG).show();
                        Intent go_home = new Intent(getApplicationContext(), GameThreeHomeActivity.class);
                        startActivity(go_home);
                        finish();
                    }
                    else if(intpunto == 5){
                        Toast.makeText(PlayGameThreeActivity.this, "Felicidades!! YA GANASTE", Toast.LENGTH_LONG).show();
                        Intent go_home = new Intent(getApplicationContext(), GameThreeHomeActivity.class);
                        startActivity(go_home);
                        finish();
                    }
                }
            });

    }

    void esperarTwo(){
        new CountDownTimer(3000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnConfirm.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                btnConfirm.setVisibility(View.VISIBLE);
                txtIncorrect.setVisibility(View.INVISIBLE);
                edtText.setText("");
                edtText.setHint("Ingrese la respuesa correcta");

            }
        }.start();
    }

    void esperarOne(){
        new CountDownTimer(3000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                //txtCorrect.setText(""+(millisUntilFinished/1000 +1));
                btnConfirm.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                btnConfirm.setVisibility(View.VISIBLE);
                if (numerogenerado<4)
                    numerogenerado=numerogenerado+1;
                txtAccountant.setText("");
                establecerImagen(numerogenerado);
                txtCorrect.setVisibility(View.INVISIBLE);
                edtText.setText("");
                edtText.setHint("Ingrese la respuesa correcta");

            }
        }.start();
    }

    void establecerImagen(int numero){
        try {
            int id = getResources().getIdentifier(imagen[numero], "drawable", getPackageName());
            imgView.setImageResource(id);
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent home = new Intent(getApplicationContext(), GameThreeHomeActivity.class);
        startActivity(home);
        finish();

        return super.onKeyDown(keyCode, event);
    }

}

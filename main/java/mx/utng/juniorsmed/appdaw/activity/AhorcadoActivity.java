package mx.utng.juniorsmed.appdaw.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class AhorcadoActivity extends AppCompatActivity {

    String arreglo_Imagenes[]={"ahorcado0","ahorcado1","ahorcado2","ahorcado3","ahorcado4","ahorcado5",
            "ahorcado6","ahorcado7","ahorcado8","ahorcadowin"};
    String arreglo_palabra[]={"HTML","CSS","BOOTSTRAP","JAVASCRIPT","AJAX"};
    String arreglo_pistas[]={"Es un lenguaje de etiquetas para nevegadores Web",
            "Se define la apariencia, formato colores de una página Web",
            "Libreria para apariencia de Web",
            "Lenguaje deprogramación popular",
            "Convergencia de varias tecnologías"};
    private ImageView imgDead;
    private TextView txtSearchWord;
    private TextView txtTrack;
    private Button btnNext;
    private Button btnSearch;
    private Button btnOut;
    private EditText edtWord;
    private String palabraGenerada;
    String mascara="";
    private int cont=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_ahorcado);

        imgDead = (ImageView)findViewById(mx.utng.juniorsmed.appdaw.R.id.img_dead);
        txtSearchWord = (TextView)findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_word);
        txtTrack = (TextView)findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_track);
        btnNext = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_next);
        btnSearch =  (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_search);
        edtWord = (EditText)findViewById(mx.utng.juniorsmed.appdaw.R.id.edt_text_one);
        btnOut = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_out);

        btnNext.setEnabled(false);
        cargarPalabra();


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarPalabra();
                btnOut.setVisibility(View.INVISIBLE);
                btnNext.setVisibility(View.INVISIBLE);
            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int tam = edtWord.getText().toString().trim().length();

                if (tam != 0) {

                char letra = edtWord.getText().toString().toUpperCase().charAt(0);


                    boolean encontrada = false;
                    for (int i = 0; i < palabraGenerada.length(); i++) {

                        if (palabraGenerada.charAt(i) == letra) {
                            char[] tempCharArray = mascara.toCharArray();
                            tempCharArray[i] = letra; // Donde 'x' es la posición que buscas.
                            mascara = String.valueOf(tempCharArray);
                            edtWord.setText("");
                            //edLetra.setHint("Escribe una letra para buscarla");
                            Toast.makeText(AhorcadoActivity.this, "Letra Correcta", Toast.LENGTH_SHORT).show();
                            encontrada = true;


                        } else {

                            //

                            //Toast
                            edtWord.setText("");
                            //edLetra.setHint("Escribe una letra para buscarla");


                            //Cambiar imagen hacer un contador
                        }
                    }
                    if (encontrada == false) {
                        cont++;
                        Toast.makeText(AhorcadoActivity.this, "Letra Incorrecta", Toast.LENGTH_SHORT).show();
                        cambio_imagen(cont);
                        if (cont == 7) {
                            //btnOut.setVisibility(View.VISIBLE);
                            btnNext.setVisibility(View.VISIBLE);
                            Toast.makeText(AhorcadoActivity.this, "Termino de Oportunidades", Toast.LENGTH_SHORT).show();
                            btnNext.setEnabled(true);

                        }

                    }

                    int comple = mascara.indexOf('*');
                    if (comple == -1) {
                        Toast.makeText(AhorcadoActivity.this, "Felicidades", Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(true);
                        cambio_imagen(9);

                        //btnOut.setVisibility(View.VISIBLE);
                        btnNext.setVisibility(View.VISIBLE);
                    }

                    txtSearchWord.setText(mascara);

                } else {
                    Toast.makeText(AhorcadoActivity.this, "Ingresar Letra", Toast.LENGTH_SHORT).show();
                }
            }


        });

    }


    public void cargarPalabra(){
        cambio_imagen(0);
        Random aleatorio = new Random(System.currentTimeMillis());
        // Producir nuevo int aleatorio entre 0 y 99
        int intAletorio = aleatorio.nextInt(4) ;
        palabraGenerada = arreglo_palabra[intAletorio];

        int tamanio = arreglo_palabra[intAletorio].length();
        mascara="";
        cont=0;
        for (int i=1;i<=tamanio;i++){
            mascara=mascara+"*";
        }
        txtSearchWord.setText(mascara);
        txtTrack.setText(arreglo_pistas[intAletorio]);
        // Toast.makeText(MainActivity.this, "Se ha generado el numero" + intAletorio, Toast.LENGTH_LONG).show();


    }
    void cambio_imagen(int numero){
        int id = getResources().getIdentifier(arreglo_Imagenes[numero],"drawable",getPackageName());
        imgDead.setImageResource(id);

    }
}

package mx.utng.juniorsmed.appdaw.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitOneFragmentFive;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitOneFragmentFour;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitOneFragmentOne;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitOneFragmentSix;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitOneFragmentThree;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitOneFragmentTwo;

public class ConceptsOneActivity extends AppCompatActivity implements
        ConceptUnitOneFragmentOne.OnFragmentInteractionListener,
        ConceptUnitOneFragmentTwo.OnFragmentInteractionListener,
        ConceptUnitOneFragmentThree.OnFragmentInteractionListener,
        ConceptUnitOneFragmentFour.OnFragmentInteractionListener,
        ConceptUnitOneFragmentFive.OnFragmentInteractionListener,
        ConceptUnitOneFragmentSix.OnFragmentInteractionListener
{
    ConceptUnitOneFragmentOne oneFragment; //Declaración de los objetos
    ConceptUnitOneFragmentTwo twoFragment;
    ConceptUnitOneFragmentThree threeFragment;
    ConceptUnitOneFragmentFour fourFragment;
    ConceptUnitOneFragmentFive fiveFragment;
    ConceptUnitOneFragmentSix sixFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_concepts_one);

        oneFragment = new ConceptUnitOneFragmentOne(); //Instancias de cada uno de los Fragment
        twoFragment = new ConceptUnitOneFragmentTwo();
        threeFragment = new ConceptUnitOneFragmentThree();
        fourFragment = new ConceptUnitOneFragmentFour();
        fiveFragment = new ConceptUnitOneFragmentFive();
        sixFragment = new ConceptUnitOneFragmentSix();



        getSupportFragmentManager().beginTransaction().add(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, oneFragment).commit();
    }

    //metodo onClick
    public void onClick(View view){
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case mx.utng.juniorsmed.appdaw.R.id.btn_one:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, oneFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_two:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, twoFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_three:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, threeFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_four:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, fourFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_five:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, fiveFragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_six:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, sixFragment);
                break;

        }
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
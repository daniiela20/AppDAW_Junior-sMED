package mx.utng.juniorsmed.appdaw.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitTwoFragmentFive;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitTwoFragmentFour;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitTwoFragmentOne;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitTwoFragmentSix;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitTwoFragmentThree;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitTwoFragmentTwo;

public class ConceptsTwoActivity extends AppCompatActivity implements
        ConceptUnitTwoFragmentOne.OnFragmentInteractionListener,
        ConceptUnitTwoFragmentTwo.OnFragmentInteractionListener,
        ConceptUnitTwoFragmentThree.OnFragmentInteractionListener,
        ConceptUnitTwoFragmentFour.OnFragmentInteractionListener,
        ConceptUnitTwoFragmentFive.OnFragmentInteractionListener,
        ConceptUnitTwoFragmentSix.OnFragmentInteractionListener
{
    ConceptUnitTwoFragmentOne one_fragment; //Declaración de los objetos
    ConceptUnitTwoFragmentTwo two_fragment;
    ConceptUnitTwoFragmentThree three_fragment;
    ConceptUnitTwoFragmentFour four_fragment;
    ConceptUnitTwoFragmentFive five_fragment;
    ConceptUnitTwoFragmentSix six_fragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_concepts_two);

        one_fragment = new ConceptUnitTwoFragmentOne(); //Instancias de cada uno de los Fragment
        two_fragment = new ConceptUnitTwoFragmentTwo();
        three_fragment = new ConceptUnitTwoFragmentThree();
        four_fragment = new ConceptUnitTwoFragmentFour();
        five_fragment = new ConceptUnitTwoFragmentFive();
        six_fragment = new ConceptUnitTwoFragmentSix();



        getSupportFragmentManager().beginTransaction().add(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, one_fragment).commit();
    }

    //metodo onClick
    public void onClick(View view){
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case mx.utng.juniorsmed.appdaw.R.id.btn_one:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, one_fragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_two:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, two_fragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_three:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, three_fragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_four:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, four_fragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_five:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, five_fragment);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_six:
                transaction.replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragments, six_fragment);
                break;

        }
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

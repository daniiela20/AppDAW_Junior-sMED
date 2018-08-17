package mx.utng.juniorsmed.appdaw.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mx.utng.juniorsmed.appdaw.R;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitThreeFragmentSix;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitThreeFragmentFive;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitThreeFragmentFour;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitThreeFragmentOne;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitThreeFragmentThree;
import mx.utng.juniorsmed.appdaw.fragment.ConceptUnitThreeFragmentTwo;

public class ConceptsThreeActivity extends AppCompatActivity implements
        ConceptUnitThreeFragmentOne.OnFragmentInteractionListener,
        ConceptUnitThreeFragmentTwo.OnFragmentInteractionListener,
        ConceptUnitThreeFragmentThree.OnFragmentInteractionListener,
        ConceptUnitThreeFragmentFour.OnFragmentInteractionListener,
        ConceptUnitThreeFragmentFive.OnFragmentInteractionListener,
        ConceptUnitThreeFragmentSix.OnFragmentInteractionListener


{
    ConceptUnitThreeFragmentOne one_fragment; //Declaración de los objetos
    ConceptUnitThreeFragmentTwo two_fragment;
    ConceptUnitThreeFragmentThree three_fragment;
    ConceptUnitThreeFragmentFour four_fragment;
    ConceptUnitThreeFragmentFive five_fragment;
    ConceptUnitThreeFragmentSix six_fragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concepts_three);

        one_fragment = new ConceptUnitThreeFragmentOne(); //Instancias de cada uno de los Fragment
        two_fragment = new ConceptUnitThreeFragmentTwo();
        three_fragment = new ConceptUnitThreeFragmentThree();
        four_fragment = new ConceptUnitThreeFragmentFour();
        five_fragment = new ConceptUnitThreeFragmentFive();
        six_fragment = new ConceptUnitThreeFragmentSix();




        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, one_fragment).commit();
    }

    //metodo onClick
    public void onClick(View view){
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btn_one:
                transaction.replace(R.id.contenedor_fragments, one_fragment);
                break;
            case R.id.btn_two:
                transaction.replace(R.id.contenedor_fragments, two_fragment);
                break;
            case R.id.btn_three:
                transaction.replace(R.id.contenedor_fragments, three_fragment);
                break;
            case R.id.btn_four:
                transaction.replace(R.id.contenedor_fragments, four_fragment);
                break;
            case R.id.btn_five:
                transaction.replace(R.id.contenedor_fragments, five_fragment);
                break;
            case R.id.btn_six:
                transaction.replace(R.id.contenedor_fragments, six_fragment);
                break;

        }
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

package mx.utng.juniorsmed.appdaw.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mx.utng.juniorsmed.appdaw.ThemesUnits;
import mx.utng.juniorsmed.appdaw.UtilitiesUnits;
import mx.utng.juniorsmed.appdaw.fragment.CommunicateFragment;
import mx.utng.juniorsmed.appdaw.fragment.DetailUnitEngineeringWebFragment;
import mx.utng.juniorsmed.appdaw.fragment.ListUnitEngineeringWebFragment;


public class Unit1EngineeringWebActivity extends AppCompatActivity implements ListUnitEngineeringWebFragment.OnFragmentInteractionListener, DetailUnitEngineeringWebFragment.OnFragmentInteractionListener, CommunicateFragment {

    ListUnitEngineeringWebFragment listThemeFragment;
    DetailUnitEngineeringWebFragment detailThemeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_unit1_engineering_web);
        if (findViewById(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment)!=null){
            UtilitiesUnits.PORTRAIT=true;
            if (savedInstanceState!=null){
                return;
            }
            listThemeFragment = new ListUnitEngineeringWebFragment();
            getSupportFragmentManager().beginTransaction().replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment, listThemeFragment).commit();
        }else {
            UtilitiesUnits.PORTRAIT=false;
        }
    }

    public void submitUnits(ThemesUnits theme){
        detailThemeFragment = (DetailUnitEngineeringWebFragment) this.getSupportFragmentManager().findFragmentById(mx.utng.juniorsmed.appdaw.R.id.fra_detail);

        if (detailThemeFragment!=null && findViewById(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment)==null){
            detailThemeFragment.assignInformation(theme);
        }else {
            detailThemeFragment = new DetailUnitEngineeringWebFragment();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("object", theme);
            detailThemeFragment.setArguments(bundleEnvio);

            getSupportFragmentManager().beginTransaction().replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment, detailThemeFragment).addToBackStack(null).commit();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

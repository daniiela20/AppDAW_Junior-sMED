package mx.utng.juniorsmed.appdaw.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mx.utng.juniorsmed.appdaw.ThemesUnits;
import mx.utng.juniorsmed.appdaw.UtilitiesUnits;
import mx.utng.juniorsmed.appdaw.fragment.CommunicateFragment;
import mx.utng.juniorsmed.appdaw.fragment.DetailUnitDevelopmentWebFragment;
import mx.utng.juniorsmed.appdaw.fragment.ListUnitDevelopmentWebFragment;

public class Unit3DevelopmentWebActivity extends AppCompatActivity implements ListUnitDevelopmentWebFragment.OnFragmentInteractionListener, DetailUnitDevelopmentWebFragment.OnFragmentInteractionListener, CommunicateFragment {

    ListUnitDevelopmentWebFragment listThemeFragment3;
    DetailUnitDevelopmentWebFragment detailThemeFragment3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_unit3_development_web);

        if (findViewById(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment)!=null){
            UtilitiesUnits.PORTRAIT=true;
            if (savedInstanceState!=null){
                return;
            }
            listThemeFragment3 = new ListUnitDevelopmentWebFragment();
            getSupportFragmentManager().beginTransaction().replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment, listThemeFragment3).commit();
        }else {
            UtilitiesUnits.PORTRAIT=false;
        }
    }

    public void submitUnits(ThemesUnits theme){
        detailThemeFragment3 = (DetailUnitDevelopmentWebFragment)this.getSupportFragmentManager().findFragmentById(mx.utng.juniorsmed.appdaw.R.id.fra_detail);

        if (detailThemeFragment3!=null && findViewById(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment)==null){
            detailThemeFragment3.assignInformation(theme);
        }else {
            detailThemeFragment3 = new DetailUnitDevelopmentWebFragment();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("object", theme);
            detailThemeFragment3.setArguments(bundleEnvio);

            getSupportFragmentManager().beginTransaction().replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment, detailThemeFragment3).addToBackStack(null).commit();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

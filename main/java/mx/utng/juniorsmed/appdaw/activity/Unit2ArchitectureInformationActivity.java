package mx.utng.juniorsmed.appdaw.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mx.utng.juniorsmed.appdaw.ThemesUnits;
import mx.utng.juniorsmed.appdaw.UtilitiesUnits;
import mx.utng.juniorsmed.appdaw.fragment.CommunicateFragment;
import mx.utng.juniorsmed.appdaw.fragment.DetailUnitArchitectureInformationFragment;
import mx.utng.juniorsmed.appdaw.fragment.ListUnitArchitectureInformationFragment;


public class Unit2ArchitectureInformationActivity extends AppCompatActivity implements ListUnitArchitectureInformationFragment.OnFragmentInteractionListener, DetailUnitArchitectureInformationFragment.OnFragmentInteractionListener, CommunicateFragment {

    ListUnitArchitectureInformationFragment listThemeFragment2;
    DetailUnitArchitectureInformationFragment detailThemeFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_unit2_architecture_information);
        if (findViewById(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment)!=null){
            UtilitiesUnits.PORTRAIT=true;
            if (savedInstanceState!=null){
                return;
            }
            listThemeFragment2 = new ListUnitArchitectureInformationFragment();
            getSupportFragmentManager().beginTransaction().replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment, listThemeFragment2).commit();
        }else {
            UtilitiesUnits.PORTRAIT=false;
        }
    }

    public void submitUnits(ThemesUnits theme){
        detailThemeFragment2 = (DetailUnitArchitectureInformationFragment) this.getSupportFragmentManager().findFragmentById(mx.utng.juniorsmed.appdaw.R.id.fra_detail);

        if (detailThemeFragment2!=null && findViewById(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment)==null){
            detailThemeFragment2.assignInformation(theme);
        }else {
            detailThemeFragment2 = new DetailUnitArchitectureInformationFragment();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("object", theme);
            detailThemeFragment2.setArguments(bundleEnvio);

            getSupportFragmentManager().beginTransaction().replace(mx.utng.juniorsmed.appdaw.R.id.contenedor_fragment, detailThemeFragment2).addToBackStack(null).commit();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

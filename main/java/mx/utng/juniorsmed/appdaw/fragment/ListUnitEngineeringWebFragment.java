package mx.utng.juniorsmed.appdaw.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import mx.utng.juniorsmed.appdaw.AdapterUnits;
import mx.utng.juniorsmed.appdaw.ThemesUnits;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListUnitEngineeringWebFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListUnitEngineeringWebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListUnitEngineeringWebFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<ThemesUnits> listThemes;
    RecyclerView recyclerThemes;

    Activity activityThemes;
    CommunicateFragment interfaceCommunicateFragments;

    public ListUnitEngineeringWebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListUnitEngineeringWebFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListUnitEngineeringWebFragment newInstance(String param1, String param2) {
        ListUnitEngineeringWebFragment fragment = new ListUnitEngineeringWebFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(mx.utng.juniorsmed.appdaw.R.layout.fragment_list_unit_engineering_web, container, false);

        listThemes = new ArrayList<>();
        recyclerThemes = (RecyclerView) view.findViewById(mx.utng.juniorsmed.appdaw.R.id.recycler_id);
        recyclerThemes.setLayoutManager(new LinearLayoutManager(getContext()));

        FillListTheme();

        AdapterUnits adapter = new AdapterUnits(listThemes);
        recyclerThemes.setAdapter(adapter);

        adapter.setOnClickListener(new  View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getContext(), "Seleccion: "+listThemes.get(recyclerThemes.getChildAdapterPosition(view)).getNameTheme(),Toast.LENGTH_SHORT).show();

                interfaceCommunicateFragments.submitUnits(listThemes.get(recyclerThemes.getChildAdapterPosition(view)));

            }
        });

        return view;
    }

    private void FillListTheme(){
        listThemes.add(new ThemesUnits(getString(mx.utng.juniorsmed.appdaw.R.string.name_theme_one),getString(mx.utng.juniorsmed.appdaw.R.string.info_introduction_web),"Introducción a las tecnologías web",getString(mx.utng.juniorsmed.appdaw.R.string.description_theme_one),getString(mx.utng.juniorsmed.appdaw.R.string.description_theme_introduction_web),getString(mx.utng.juniorsmed.appdaw.R.string.description_three_theme_introduction_web), mx.utng.juniorsmed.appdaw.R.drawable.ic_import_contacts_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.ic_import_contacts_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.tecnologi, mx.utng.juniorsmed.appdaw.R.drawable.lap, mx.utng.juniorsmed.appdaw.R.drawable.information_theme));
        listThemes.add(new ThemesUnits(getString(mx.utng.juniorsmed.appdaw.R.string.name_theme_two),getString(mx.utng.juniorsmed.appdaw.R.string.info_theme_digital_media),"Medios digitales soportados en la web",getString(mx.utng.juniorsmed.appdaw.R.string.description_digital_media),getString(mx.utng.juniorsmed.appdaw.R.string.description_theme_two),getString(mx.utng.juniorsmed.appdaw.R.string.description_three_theme_digital_media), mx.utng.juniorsmed.appdaw.R.drawable.ic_slideshow_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.ic_slideshow_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.redes4, mx.utng.juniorsmed.appdaw.R.drawable.redes1, mx.utng.juniorsmed.appdaw.R.drawable.redes3));
        listThemes.add(new ThemesUnits(getString(mx.utng.juniorsmed.appdaw.R.string.name_theme_three),getString(mx.utng.juniorsmed.appdaw.R.string.info_theme_security),"Seguridad y vulnerabilidad",getString(mx.utng.juniorsmed.appdaw.R.string.description_theme_security),getString(mx.utng.juniorsmed.appdaw.R.string.part_one_description)+getString(mx.utng.juniorsmed.appdaw.R.string.description_two_theme_security),getString(mx.utng.juniorsmed.appdaw.R.string.description_theme_three), mx.utng.juniorsmed.appdaw.R.drawable.ic_screen_lock_portrait_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.ic_screen_lock_portrait_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.code1, mx.utng.juniorsmed.appdaw.R.drawable.code2, mx.utng.juniorsmed.appdaw.R.drawable.code3));


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.activityThemes = (Activity) context;
            interfaceCommunicateFragments = (CommunicateFragment) this.activityThemes;
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

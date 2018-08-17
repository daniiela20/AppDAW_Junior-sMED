package mx.utng.juniorsmed.appdaw.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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
 * {@link ListUnitDevelopmentWebFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListUnitDevelopmentWebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListUnitDevelopmentWebFragment extends Fragment {
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

    public ListUnitDevelopmentWebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListUnitDevelopmentWebFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListUnitDevelopmentWebFragment newInstance(String param1, String param2) {
        ListUnitDevelopmentWebFragment fragment = new ListUnitDevelopmentWebFragment();
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
        View view = inflater.inflate(mx.utng.juniorsmed.appdaw.R.layout.fragment_list_unit_development_web, container, false);

        listThemes = new ArrayList<>();
        recyclerThemes = (RecyclerView) view.findViewById(mx.utng.juniorsmed.appdaw.R.id.recycler_id);
        recyclerThemes.setLayoutManager(new LinearLayoutManager(getContext()));

        FillListTheme();

        AdapterUnits adapter = new AdapterUnits(listThemes);
        recyclerThemes.setAdapter(adapter);

        adapter.setOnClickListener(new  View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getContext(), getString(mx.utng.juniorsmed.appdaw.R.string.msg_selection)+listThemes.get(recyclerThemes.getChildAdapterPosition(view)).getNameTheme(),Toast.LENGTH_SHORT).show();

                interfaceCommunicateFragments.submitUnits(listThemes.get(recyclerThemes.getChildAdapterPosition(view)));

            }
        });

        return view;
     }

    private void FillListTheme(){

        listThemes.add(new ThemesUnits(getString(mx.utng.juniorsmed.appdaw.R.string.title_theme_one_unit_three),getString(mx.utng.juniorsmed.appdaw.R.string.information_unit_three),"Integración de la aplicación web",getString(mx.utng.juniorsmed.appdaw.R.string.description_development_web),getString(mx.utng.juniorsmed.appdaw.R.string.part_two_theme_development_web),getString(mx.utng.juniorsmed.appdaw.R.string.part_three_theme_development_web), mx.utng.juniorsmed.appdaw.R.drawable.ic_laptop_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.ic_laptop_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.code3, mx.utng.juniorsmed.appdaw.R.drawable.mvc, mx.utng.juniorsmed.appdaw.R.drawable.code4));
        listThemes.add(new ThemesUnits(getString(mx.utng.juniorsmed.appdaw.R.string.title_theme_two_unit_three),getString(mx.utng.juniorsmed.appdaw.R.string.information_theme_unit_three),"Puesta en marcha",getString(mx.utng.juniorsmed.appdaw.R.string.description_theme_development_two),"","", mx.utng.juniorsmed.appdaw.R.drawable.ic_personal_video_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.ic_personal_video_black_24dp, mx.utng.juniorsmed.appdaw.R.drawable.code1, mx.utng.juniorsmed.appdaw.R.drawable.code2, mx.utng.juniorsmed.appdaw.R.drawable.code3));

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

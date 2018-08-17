package mx.utng.juniorsmed.appdaw.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mx.utng.juniorsmed.appdaw.ThemesUnits;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailUnitDevelopmentWebFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailUnitDevelopmentWebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailUnitDevelopmentWebFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private TextView txtDescription;
    private ImageView imgDetail;
    private TextView txtTitle;
    private TextView txtDescriptionTwo;
    private TextView txtDescripionThree;
    private ImageView imgFirst;
    private ImageView imgSecond;
    private ImageView imgThird;

    public DetailUnitDevelopmentWebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailUnitDevelopmentWebFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailUnitDevelopmentWebFragment newInstance(String param1, String param2) {
        DetailUnitDevelopmentWebFragment fragment = new DetailUnitDevelopmentWebFragment();
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
        View view=inflater.inflate(mx.utng.juniorsmed.appdaw.R.layout.fragment_detail_unit_development_web, container, false);

        txtDescription = (TextView) view.findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_description_theme);
        imgDetail = (ImageView) view.findViewById(mx.utng.juniorsmed.appdaw.R.id.img_detail_theme);
        txtTitle = (TextView) view.findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_title_theme);
        txtDescriptionTwo = (TextView)view.findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_description_two);
        txtDescripionThree = (TextView) view.findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_description_three);
        imgFirst = (ImageView) view.findViewById(mx.utng.juniorsmed.appdaw.R.id.img_firts_theme);
        imgSecond = (ImageView) view.findViewById(mx.utng.juniorsmed.appdaw.R.id.img_second_theme);
        imgThird = (ImageView) view.findViewById(mx.utng.juniorsmed.appdaw.R.id.img_third_theme);

        Bundle objectThemes= getArguments();
        ThemesUnits myTheme = null;
        if (objectThemes != null){
            myTheme = (ThemesUnits) objectThemes.getSerializable("object");

            assignInformation(myTheme);

        }
        return view;
    }

    public void assignInformation(ThemesUnits myTheme){
        imgDetail.setImageResource(myTheme.getImageDetail());
        txtDescription.setText(myTheme.getDescriptionTheme());
        txtDescriptionTwo.setText(myTheme.getDescriptionThemeTwo());
        txtDescripionThree.setText(myTheme.getDescripionThemeThree());
        txtTitle.setText(myTheme.getTileTheme());
        imgFirst.setImageResource(myTheme.getImageFirst());
        imgSecond.setImageResource(myTheme.getImageSecond());
        imgThird.setImageResource(myTheme.getImageThird());
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

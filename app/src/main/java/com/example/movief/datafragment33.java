package com.example.movief;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class datafragment33 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView name, hight, haircolor, skincolor, eyecolor, gender, mass, birthyear;
    CharecterDetails charecterDetails;
    public datafragment33() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            charecterDetails= (CharecterDetails) getArguments().getParcelable("data");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_charecterss_detailsss, container, false);
        name = view.findViewById(R.id.name);
        hight = view.findViewById(R.id.hight);
        haircolor = view.findViewById(R.id.haircolor);
        skincolor = view.findViewById(R.id.skincolor);
        eyecolor = view.findViewById(R.id.eyecolor);
        gender = view.findViewById(R.id.gender);
        mass = view.findViewById(R.id.mass);
        birthyear = view.findViewById(R.id.birth_year);
        String username = charecterDetails.getName();
        String hightt = charecterDetails.getHeight();
        String haircolorr = charecterDetails.getHairColor();
        String skincolorr = charecterDetails.getSkinColor();
        String eyecolorr = charecterDetails.getEyeColor();
        String genderr = charecterDetails.getGender();
        String masss = charecterDetails.getMass();
        String birthyearr = charecterDetails.getBirthYear();

        name.setText("Name:  " + username);
        hight.setText("Hight:  " + hightt);
        haircolor.setText("Hair Color:  " + haircolorr);
        skincolor.setText("Skin Color:  " + skincolorr);
        eyecolor.setText("Eye Color:  " + eyecolorr);
        gender.setText("Gender:  " + genderr);
        mass.setText("Mass:  " + masss);
        birthyear.setText("Birth Year:  " + birthyearr);
        return view;
    }
}
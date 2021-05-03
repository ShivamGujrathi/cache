package com.example.movief;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class CharecterssDetailsss extends AppCompatActivity {
    TextView name, hight, haircolor, skincolor, eyecolor, gender,mass,birthyear;
    CharecterDetails charecterDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charecterss_detailsss);
         name=findViewById(R.id.name);
        hight=findViewById(R.id.hight);
        haircolor=findViewById(R.id.haircolor);
        skincolor=findViewById(R.id.skincolor);
        eyecolor=findViewById(R.id.eyecolor);
        gender=findViewById(R.id.gender);
        mass=findViewById(R.id.mass);
        birthyear=findViewById(R.id.birth_year);

        Intent intent=getIntent();
       charecterDetails= (CharecterDetails) intent.getSerializableExtra("Data");
      String username=charecterDetails.getName();
        String hightt=charecterDetails.getHeight();
        String haircolorr=charecterDetails.getHairColor();
        String skincolorr=charecterDetails.getSkinColor();
        String eyecolorr=charecterDetails.getEyeColor();
        String genderr=charecterDetails.getGender();
        String masss=charecterDetails.getMass();
        String birthyearr=charecterDetails.getBirthYear();

     name.setText("Name:  "+username);
       hight.setText("Hight:  "+hightt);
        haircolor.setText("Hair Color:  "+haircolorr);
      skincolor.setText("Skin Color:  "+skincolorr);
        eyecolor.setText("Eye Color:  "+eyecolorr);
        gender.setText("Gender:  "+genderr);
        mass.setText("Mass:  "+masss);
        birthyear.setText("Birth Year:  "+birthyearr);

    }


    }


package com.example.joakk.aplicacion_test.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joakk.aplicacion_test.R;

public class ControlProfile extends Fragment {



   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_ventana_contrl, container, false);
   }
}

package com.cgaxtr.fea.layouts;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgaxtr.fea.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReglamentoFragment extends Fragment {


    public ReglamentoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reglamento, container, false);
    }

}

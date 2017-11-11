package com.cgaxtr.fea.layouts;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.cgaxtr.fea.ListAdapter;
import com.cgaxtr.fea.R;
import com.cgaxtr.fea.model.Player;

import java.util.ArrayList;
import java.util.List;


public class RankingFragment extends Fragment {


    public RankingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ranking, container, false);

        List<Player> list = new ArrayList<Player>();

        Player p = new Player(1 ,"Carlos", "Gómez", 15);
        list.add(p);
        p = new Player(2, "Alberto", "Olmo", 10);
        list.add(p);
        p = new Player(3,"Adrian", "Perez", 5);
        list.add(p);
        p = new Player(4,"Rodrigo", "Sanchez", 4);
        list.add(p);
        p = new Player(5,"Jesus", "Bricio", 3);
        list.add(p);
        p = new Player(6, "Sergio", "Rivera", 2);
        list.add(p);
        p = new Player(7, "Sergio", "lopez", 1);
        list.add(p);
        p = new Player(8, "Player1", "Player1", 1);
        list.add(p);
        p = new Player(9,"Player2", "Player1", 1);
        list.add(p);
        p = new Player(10,"Player3", "Player1", 1);
        list.add(p);
        p = new Player(11,"Player4", "Player1", 1);
        list.add(p);

        ListView listView = v.findViewById(R.id.list);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Player p = (Player)adapterView.getItemAtPosition(i);
                Toast.makeText(getContext(), p.getName(), Toast.LENGTH_SHORT).show();

            }
        });
        listView.setAdapter(new ListAdapter(list, this.getActivity()));

        return v;
    }

}

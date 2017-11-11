package com.cgaxtr.fea;

import android.app.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cgaxtr.fea.model.Player;

import java.util.List;


public class ListAdapter extends BaseAdapter {

    private List<Player> listPlayer;
    private Activity activity;
    private LayoutInflater inflater;

    public ListAdapter(List<Player> list, Activity activity){
        this.listPlayer = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listPlayer.size();
    }

    @Override
    public Player getItem(int i) {
        return listPlayer.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater =  (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.item_list, null);

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView lastName = (TextView) view.findViewById(R.id.lastName);
        TextView points = (TextView) view.findViewById(R.id.points);

        Player m = listPlayer.get(i);

        // Name
        name.setText(m.getName());

        // Lastname
        lastName.setText(m.getLastName());

        // rating
        points.setText("Puntos: " + String.valueOf(m.getPoints()));


        return view;
    }


}

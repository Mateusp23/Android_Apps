package com.example.adapter_poo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CidadeAdapter extends ArrayAdapter<Cidade> {

    public CidadeAdapter(@NonNull Context context, @NonNull List<Cidade> objects){
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View listCityView = convertView;
        if (listCityView == null){
            listCityView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item, parent, false);
        }

        Cidade current = getItem(position);
        TextView tvCity = listCityView.findViewById(R.id.tvCity);
        TextView tvState = listCityView.findViewById(R.id.tvState);

        tvCity.setText(current.getCidade());
        tvState.setText(current.getEstado());

        return listCityView;
    }
}

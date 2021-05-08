package com.example.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {

        this.listaFilmes = lista;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // criacao dos itens

        View itemLista = LayoutInflater.from(parent.getContext())  // inflar um xml, converter para xml
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder( itemLista );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { // exibicao dos itens

        Filme filme = listaFilmes.get( position );
        holder.titulo.setText( filme.getTituloFilme() );
        holder.genero.setText( filme.getGenero() );
        holder.ano.setText( filme.getAno() );

    }

    @Override
    public int getItemCount() { // exibe a quantidade de itens
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{ // guarda os dados nome, genero e data

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder (View itemView){
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);

        }
    }

}

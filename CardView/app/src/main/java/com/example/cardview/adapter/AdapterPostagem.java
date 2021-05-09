package com.example.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;
import com.example.cardview.model.Postagem;

import java.util.List;

public class AdapterPostagem extends RecyclerView.Adapter<AdapterPostagem.MyViewHolder> {

    private List<Postagem> postagens;

    public AdapterPostagem(List<Postagem> listaPostagens ) {
        this.postagens = listaPostagens;
    }

    @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View itemLista = LayoutInflater.from(parent.getContext())
                    .inflate(
                            R.layout.postagem_detalhe,
                            parent,
                            false
                    );

            return new MyViewHolder(itemLista); // retornar uma instancia
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Postagem postagem = postagens.get( position );

            holder.textNome.setText(postagem.getNome() );
            holder.textPostagem.setText( postagem.getPostagem() );
            holder.imagePostagem.setImageResource( postagem.getImagem() );

        }

        @Override
        public int getItemCount() {
            return postagens.size(); // retornar o tamanho de postagens
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textNome;
        private ImageView imagePostagem;
        private TextView textPostagem;


        public MyViewHolder(View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            imagePostagem = itemView.findViewById(R.id.imagePostagem);
            textPostagem = itemView.findViewById(R.id.textPostagem);

        }
    }

}

package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cardview.R;
import com.example.cardview.adapter.AdapterPostagem;
import com.example.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager( layoutManager );

        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager( this, 2 ); Grid layout
        //recyclerPostagem.setLayoutManager( layoutManager );

        //define adapter
        prepararPostagens();

        AdapterPostagem adapterPostagem = new AdapterPostagem(postagens);
        recyclerPostagem.setAdapter( adapterPostagem );

    }

    public void prepararPostagens(){

        Postagem post;

        post = new Postagem("Mateus Paulart", "#tbt da viagem muito massa!",R.drawable.imagem1);
        this.postagens.add(post);

        post = new Postagem(" Matue", "eh o trap de fortal rapazeada",R.drawable.imagem2);
        this.postagens.add(post);

        post = new Postagem("Nego Di", "eh us guri",R.drawable.imagem3);
        this.postagens.add(post);

        post = new Postagem("Orochi", "orochi o mais brabo",R.drawable.imagem4);
        this.postagens.add(post);

    }
}

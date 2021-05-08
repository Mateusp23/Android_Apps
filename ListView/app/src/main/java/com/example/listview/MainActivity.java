package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaLocais;
    private String [] itens = {
            "Angra dos Reis", "Caldas Novaas",
            "Porto Alegre", "Blumenau","Imbituba",
            "Curitiba", "Florianopolis",
            "Fortaleza", "Belo Horizonte",
            "Torres", "Guarulhos", "Cascavel",
            "Campos do Jordão", "Maceio", "Criciuma"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaLocais = findViewById(R.id.listaLocais);

        // criar adaptador para lista
        ArrayAdapter<String> adaptador = new  ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        //adiciona adaptador para lista
        listaLocais.setAdapter( adaptador );

        //adciona clique na lista
        listaLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String valorSelecionado = listaLocais.getItemAtPosition( position ).toString();
                Toast.makeText( getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();

            }
        });

    }
}

package com.example.adapter_poo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addCity();
    }

    private void addCity (){
        ArrayList<Cidade> city = new ArrayList<>();
        city.add(new Cidade("Angra dos Reis", "RJ"));
        city.add(new Cidade("Criciuma", "SC"));
        city.add(new Cidade("Porto Alegre", "RS"));
        city.add(new Cidade("Blumenau", "SC"));
        city.add(new Cidade("Curitiba", "PR"));
        city.add(new Cidade("Florianopólis", "SC"));
        city.add(new Cidade("Imbituba", "SC"));
        city.add(new Cidade("Praia do Rosa", "SC"));
        city.add(new Cidade("Praia da Ferrugem", "SC"));
        city.add(new Cidade("Praia Brava", "SC"));
        city.add(new Cidade("Fortaleza", "CE"));
        city.add(new Cidade("João Pessoa", "PB"));
        city.add(new Cidade("Maceio", "AL"));
        city.add(new Cidade("Belo Horizonte", "MG"));
        city.add(new Cidade("Uberlandia", "MG"));
        city.add(new Cidade("Vitoria", "ES"));
        city.add(new Cidade("Rio Branco", "AC"));
        city.add(new Cidade("Paraiba", "PE"));
        city.add(new Cidade("Salvador", "BA"));
        city.add(new Cidade("Torres", "RS"));
        city.add(new Cidade("Jericoacoara", "CE"));
        city.add(new Cidade("Três Cachoeiras", "RS"));
        city.add(new Cidade("Passo de Torres", "RS"));
        city.add(new Cidade("Cascavel", "PR"));
        city.add(new Cidade("Santos", "SP"));
        city.add(new Cidade("Guarulhos", "SP"));
        city.add(new Cidade("Xangri-lá", "RS"));
        city.add(new Cidade("Campinas", "SP"));
        city.add(new Cidade("Osasco", "SP"));
        city.add(new Cidade("Guarujá", "SP"));
        city.add(new Cidade("Gravataí", "RS"));
        city.add(new Cidade("Santa Maria", "RS"));

        CidadeAdapter cidadeAdapter = new CidadeAdapter(getApplicationContext(), city);
        listCity = findViewById(R.id.listCity);
        listCity.setAdapter(cidadeAdapter);

        listCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String valorSelecionado = listCity.getItemAtPosition( position ).toString();
                Toast.makeText( getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();

            }
        });
    }
}
package com.example.passandodadosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade, textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textIdade = findViewById(R.id.textIdade);
        textNome = findViewById(R.id.textNome);
        textEmail = findViewById(R.id.textEmail);

        // recuperar dados enviados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome"); // recuperando o nome com o getString
        int idade = dados.getInt("idade"); // recuperando a idade com o getInt
        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        // configurar valores recuperados
        textNome.setText( usuario.getNome() );
        textEmail.setText(usuario.getEmail());
        textIdade.setText( String.valueOf(idade)); // convertendo string em inteiro

    }
}

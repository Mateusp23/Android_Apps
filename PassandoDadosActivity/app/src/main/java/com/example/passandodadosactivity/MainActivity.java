package com.example.passandodadosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() { // evento de clique para o botao
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class); // qual activity vai ser direcionada

                //instanciar o objeto
                Usuario usuario = new Usuario("Mateus","mateusp23@rede.ulbra.br");

                //passar dados
                intent.putExtra("nome", "Mateus");
                intent.putExtra("idade", 19);
                intent.putExtra("objeto", usuario); // classe usuario convertido para bytes

                startActivity( intent ); // inicia a nova activity

            }
        });
    }
}

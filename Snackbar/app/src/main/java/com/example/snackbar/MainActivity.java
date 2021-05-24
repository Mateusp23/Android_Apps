package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir, buttonFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbrir = findViewById(R.id.buttonAbrir);
        buttonFechar = findViewById(R.id.buttonFechar);

        buttonAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(
                        v,
                        "Botão Pressionado",
                        Snackbar.LENGTH_LONG
                ).setAction("Confirmar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonAbrir.setText("botao abrir alterado");
                    }
                }).setActionTextColor( getResources().getColor(R.color.colorPrimary) ) // cor no botao de açao
                        .show();
            }
        });

    }

    /*public void abrirSnackbar(View view){ // utilizando função, mas é a mesma coisa que o codigo comentado acima
        final Snackbar snackbar = Snackbar.make(
                view,
                "Botão Pressionado",
                Snackbar.LENGTH_INDEFINITE   // duração do snackbar LENGTH_LON, LENGTH_SHORT
        ).setAction("Confirmar", new View.OnClickListener() { // ação do snackbar
            @Override
            public void onClick(View v) {
                buttonAbrir.setText("botao abrir alterado");
            }
        });

        snackbar.show();

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
     */
}

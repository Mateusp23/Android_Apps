package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor           = findViewById(R.id.editValor);
        textPorcentagem     = findViewById(R.id.textPorcentagem);
        textGorjeta         = findViewById(R.id.textGorjeta);
        textTotal           = findViewById(R.id.textTotal);
        seekBarGorjeta      = findViewById(R.id.seekBarGorjeta);

        // adicionar listenar capturar o progresso
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagem.setText( Math.round(porcentagem) + " %" );
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        String valorRecuperado = editValor.getText().toString();
        if( valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText( // exibe mensagem na tela
                    getApplicationContext(),
                    "Digite um valor para efetuar o calculo!!",
                    Toast.LENGTH_LONG
                    ).show();
        } else {
            // converter string ára double
            double valorDigitado = Double.parseDouble( valorRecuperado);

            // calcular gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //exibir gorjeta e total
            textGorjeta.setText( "R$ " + Math.round(gorjeta));
            //textGorjeta.setText( "R$ " + gorjeta);

            textTotal.setText( "R$ " +total);
        }
    }
}

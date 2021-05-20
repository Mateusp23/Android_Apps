package com.example.sekkbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarEscala;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarEscala = findViewById(R.id.seekBarEscala);
        textResultado = findViewById(R.id.textResultado);

        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // escuta a ação do usuario
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // progresso do seekbar
                textResultado.setText("Progresso: " + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { // clicou no marcador
                textResultado.setText("onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { // soltou o marcador
                textResultado.setText("onStartTrackingTouch");
            }
        });
    }

    public void recuperarProgresso (View view){
        textResultado.setText("Escolhido: " + seekBarEscala.getProgress());
    }
}

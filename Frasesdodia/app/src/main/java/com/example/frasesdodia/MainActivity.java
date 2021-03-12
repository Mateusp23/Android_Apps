package com.example.frasesdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){

        String [] frases = {
               "As pessoas costumam dizer que a motivação não dura sempre. Bem, nem o efeito do banho, por isso recomenda-se diariamente.", //0
               "Toda ação humana, quer se torne positiva ou negativa, precisa depender de motivação.", // 1
               "No meio da dificuldade encontra-se a oportunidade.", // 2
               "Eu faço da dificuldade a minha motivação. A volta por cima vem na continuação.", // 3
               "Pedras no caminho? Eu guardo todas. Um dia vou construir um castelo.",  // 4
               "É parte da cura o desejo de ser curado.",  // 5
               "O insucesso é apenas uma oportunidade para recomeçar com mais inteligência." // 6
        };

        int numero_sorteio = new Random().nextInt(7); // 0 1 2 3 4 5 6

        TextView texto = findViewById(R.id.textResultadoFrase); // transefere o textResultadoFrase para o texto
        texto.setText(frases[numero_sorteio]);
    }

}

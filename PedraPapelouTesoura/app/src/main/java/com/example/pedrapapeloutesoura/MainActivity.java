package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
       this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolha_do_usuario){

        ImageView imagemResultado = findViewById(R.id.imageResultado); // retorna uma imagem
        TextView textoResultado = findViewById(R.id.textResultado); // retorna um texto

        int numero = new Random().nextInt(3); // 0,1,2
        String [] opcoes = {"pedra","papel","tesoura"};
        String escolha_do_app = opcoes[numero];

        switch (escolha_do_app){
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra); // metodo que faz receber uma nova imagem
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
            (escolha_do_app == "tesoura" && escolha_do_usuario == "papel") ||
            (escolha_do_app == "papel" && escolha_do_usuario == "pedra") ||
            (escolha_do_app == "pedra" && escolha_do_usuario == "tesoura")
        ){ //app ganhador
            textoResultado.setText("Você perdeu, tente novamente :(");
        }else if(
                (escolha_do_usuario == "tesoura" && escolha_do_app == "papel") ||
                (escolha_do_usuario == "papel" && escolha_do_app == "pedra") ||
                (escolha_do_usuario == "pedra" && escolha_do_app == "tesoura")
        ){ //user ganhador
            textoResultado.setText("Você ganhou, Parabéns :)");
        }else{ //empate
            textoResultado.setText("Empatamos ;)");
        }

        System.out.println("item clicado: "+escolha_do_app);

    }
}

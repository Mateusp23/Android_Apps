package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirToast(View view){

        ImageView imagem = new ImageView( getApplicationContext());
        imagem.setImageResource( android.R.drawable.star_big_off ); // recursos disponiveis no próprio android

        TextView textView = new TextView( getApplicationContext());
        textView.setBackgroundResource(R.color.colorAccent); // cor do background do toast
        textView.setText(" Olá Toast!!");

        Toast toast = new Toast( getApplicationContext() );
        toast.setDuration( Toast.LENGTH_LONG);
        toast.setView(imagem );  // configura uma visualização, por ex criar um layout personalizado e utilizar dentro dos parenteses
        toast.setView(textView ); // ''
        toast.show(); // exibir a mensagem

        /*
        Toast.makeText(
                getApplicationContext(), //na classe context permite acessar recusros globais do app, telefonia e etc
                    "ação realizada com sucesso! ",
                    Toast.LENGTH_LONG // Long ou Short define a duração que o aviso fica aparecendo na tela
        ).show(); // faz com que a mensagem seja exibido
         */
    }
}

package com.example.aplicativodesorteio;

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

    public void sorteio(View v){

        TextView texto = findViewById(R.id.textResult);
        int num = new Random().nextInt(11);

        texto.setText("O número sorteado é: "+num);
    }

}
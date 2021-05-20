package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPeso, editAltura;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnCalcularOnClick(View v){

        editAltura     = findViewById(R.id.editAltura);
        editPeso   = findViewById(R.id.editPeso);
        textResultado       = findViewById(R.id.textResultado);

        int peso = Integer.parseInt(editPeso.getText().toString());
        double altura = Float.parseFloat(editAltura.getText().toString());

        double resultado = peso / (altura * altura);
        if(resultado < 19){
            //abaixo
            textResultado.setText("Abaixo do peso!");
        }
        else if(resultado > 32){
            //obeso
           textResultado.setText("Acima do peso!");
        }
        else{
            //ok
            textResultado.setText("Peso ok!");
        }
    }
}




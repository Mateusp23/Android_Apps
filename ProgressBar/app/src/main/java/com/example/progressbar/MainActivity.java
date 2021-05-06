package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarHorizontal;
    private ProgressBar progressBarCircular;
    private int progresso=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarHorizontal   = findViewById(R.id.progressBarHorizontal);
        progressBarCircular     = findViewById(R.id.progressBarCircular);

        progressBarCircular.setVisibility(View.GONE); // remove a progress bar do layout. temos visible, invisible e gone.

    }

    public void carregarProgressbar(View view){

        //ProgressBar horizontal
        this.progresso = this.progresso+1;
        progressBarHorizontal.setProgress( this.progresso );

        //ProgressBar circular
        progressBarCircular.setVisibility(View.VISIBLE); // quando apertar no button carregar vai aparecer a progress bar circular

        if( this.progresso == 10){ // quando o progresso chegar no final (que eh 10) ele vai esconder a progress bar
            progressBarCircular.setVisibility(View.GONE);
        }
    }
}

package com.example.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servico,R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre
        )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        String celular = "tel: 51999381964";
        String email = "";
        String imagem = "https://i.ytimg.com/vi/bWeGqM-MKM0/maxresdefault.jpg";
        String endereco = "https://www.google.com/maps/place/Av.+Gen.+Os%C3%B3rio,+270,+Torres+-+RS,+95560-000/@-29.3356504,-49.7318265,17z/data=!3m1!4b1!4m5!3m4!1s0x952269a053465965:0x21a6cf6a30f31573!8m2!3d-29.3356551!4d-49.7296378";
        //Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse("tel: 51999381964") );
        //Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse(celular) ); // ligação com o Dial
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(imagem) ); // imagem com view
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(endereco) ); // endereço com view

        // SEND COMPARTILHAR
        Intent intent = new Intent( Intent.ACTION_SEND );

        // envio do email como EXTRA_EMAIL e os emails que vao receber
        intent.putExtra( Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br", "mateusp23@rede.ulbra.br"} );
        // assunto do email com o SUBJET
        intent.putExtra( Intent.EXTRA_SUBJECT,  "contato pelo app");
        // mensagem da caixa de texto do email
        intent.putExtra( Intent.EXTRA_TEXT,  "mensagem automatica");

        // tipo de dado que vai ser compartilhado
        intent.setType("message/rfc822"); // tipo para envio de email
        //intent.setType("text/plain"); // texto padrao
        //intent.setType("image/png"); // image/*
        //intent.setType("application/pdf"); // pdf

        startActivity( Intent.createChooser( intent, "compartilhar") );

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

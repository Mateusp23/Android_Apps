package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekVolume;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        startSeekBar();
    }

    private void startSeekBar() {

        seekVolume = findViewById(R.id.seekVolume);

        // configruar o audio manager
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE); // recupear dados do sistema - recuperando volume

        // recuperar os valores de volume maximo e o volume atual
        int maximumVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC); // volume maximo da musica
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC); // volume atual da musica

        //configurar os valores maixmos para o SeekBar
        seekVolume.setMax( maximumVolume );

        //configurar os valores maixmos para o SeekBar
        seekVolume.setProgress( currentVolume );

        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // quando é modificado a seekbar, arrastada etc
                audioManager.setStreamVolume( AudioManager.STREAM_MUSIC, progress,
                        AudioManager.FLAG_SHOW_UI); // tipo de estream, indice ou valor e por fim a flag que é as configuraçoes
                        // FLAG_SHOW_UI mostra o volume para o usuario flags 0 nao faz nenhuma configuração
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void performSound(View view){  // executar som

        if(mediaPlayer != null){ // se estiver uma musica para tocar ele vai iniciar ela
            mediaPlayer.start();
        }
    }

    public void pauseSound(View view){ // pausar som

        if( mediaPlayer.isPlaying()) { // verifica se a musica está sendo executada
            mediaPlayer.pause(); // pausa a musica
        }
    }

    public void stopSound(View view){ // terminar som

        if( mediaPlayer.isPlaying()){
            mediaPlayer.stop(); // encerra a execução da musica
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste); // configurar novamente
        }
    }

    @Override
    protected void onDestroy() { // destruir activity e remover os recursos usados da memoria
        super.onDestroy();
        if( mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release(); // libera recursos de media que esta sendo usada, remove da memoria
            mediaPlayer = null;
        }
    }

    /*
    @Override
    protected void onStop() { // pausa a musica quando sair do app, usando o onStop do ciclo de vida da Activity
        super.onStop();
        if( mediaPlayer.isPlaying()) { // verifica se a musica está sendo executada
            mediaPlayer.pause(); // pausa a musica
        }
    }     */
}

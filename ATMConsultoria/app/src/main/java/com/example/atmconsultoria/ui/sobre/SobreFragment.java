package com.example.atmconsultoria.ui.sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "A ATM   Consultoria tem como missão apoiar organizações " +
                "que desejam alcançar o sucesso atraves da excelência em gestão " +
                "e da busca pela qualidade.";

        Element versao = new Element();
        versao.setTitle("versão 2.0");

        return new AboutPage( getActivity())
                .setImage(R.drawable.logo)
                .setDescription( descricao)

                .addGroup("Redes sociais")
                .addFacebook("mateuspaulart", "Facebook")
                .addInstagram("mateuspp23", "Instagram")
                .addTwitter("mpaulart","Twitter")
                .addGitHub("Mateusp23","GitHub")
                .addPlayStore("com.facebook.katana","PlayStore")

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Nos envie um e-mail")
                .addWebsite("https://mateusp23.github.io/Portfolio/", "Acesse meu site pessoal")

                .addItem( versao )

                .create();
    }

}

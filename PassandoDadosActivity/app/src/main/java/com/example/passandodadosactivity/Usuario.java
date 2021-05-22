package com.example.passandodadosactivity;

import java.io.Serializable;

public class Usuario implements Serializable { // utilizando o Serializable podemos passar um objeto para outra activity, ele é convertido em bytes

    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

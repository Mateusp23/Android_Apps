package com.example.adapter_poo;

public class Cidade {
    String estado;
    String cidade;

    public Cidade(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return " " + cidade +
                " " + estado;
    }
}

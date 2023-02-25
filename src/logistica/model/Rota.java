package src.logistica.model;

import java.util.ArrayList;

public class Rota {
    private int idRota;
    private String descricao, localPartida, localDestino;
    ArrayList<Posto> listaPostoCadastrado = new ArrayList(); //Os postos cadastrados poderão ser guardados aqui - Caso não seja utilizado APAGAR depois.

    public Rota(){

    }

    public Rota(String descricao, String localPartida, String localDestino) { //APENAS PARA TESTAR
        this.descricao = descricao;
        this.localPartida = localPartida;
        this.localDestino = localDestino;
    }

    //Getters e Setters
    public void setListaPostoCadastrado(ArrayList<Posto> listaPostoCadastrado) {
        this.listaPostoCadastrado = listaPostoCadastrado;
    }

    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public ArrayList<Posto> getListaPostoCadastrado() {
        return listaPostoCadastrado;
    }

    public void setListaPostoCadastrado(Posto posto) {
        this.listaPostoCadastrado.add(posto);
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "Id: " + this.idRota + "\nDescrição: " + this.descricao + "\nLocal de partida: " + this.localPartida + "\nLocal de destino: " + this.localDestino + "\n =====================";
    }
}
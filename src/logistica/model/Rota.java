package src.logistica.model;

import java.util.ArrayList;

public class Rota {
    private int id_rota;
    private String descricao, localPartida, localDestino;
//    ArrayList<Posto> listaPostoCadastrado = new ArrayList(); //Os postos cadastrados poderão ser guardados aqui - Caso não seja utilizado APAGAR depois.

    public Rota(){

    }

    public Rota(String descricao, String localPartida, String localDestino) { //APENAS PARA TESTAR
        this.descricao = descricao;
        this.localPartida = localPartida;
        this.localDestino = localDestino;
    }

    //Getters e Setters

    public int getId_rota() {
        return id_rota;
    }

    public void setId_rota(int id_rota) {
        this.id_rota = id_rota;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

//    public ArrayList<Posto> getListaPostoCadastrado() {
//        return listaPostoCadastrado;
//    }

//    public void setListaPostoCadastrado(ArrayList<Posto> listaPostoCadastrado) {
//        this.listaPostoCadastrado = listaPostoCadastrado;
//    }

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
        return "Rota{" +
                "id_rota=" + id_rota +
                ", descricao='" + descricao + '\'' +
                ", localPartida='" + localPartida + '\'' +
                ", localDestino='" + localDestino + '\'' +
                '}';
    }
}
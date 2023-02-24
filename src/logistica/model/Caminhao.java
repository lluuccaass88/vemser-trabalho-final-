package src.logistica.model;

import java.util.Scanner;

public class Caminhao {

    private Integer idCaminhao;
    private String nome;
    private String placa;

    private EmViagem emViagem; // 1 - estacionado | 2 - em viagem

    public Integer getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(Integer idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public EmViagem getEmViagem() {
        return emViagem;
    }

    public void setEmViagem(EmViagem emViagem) {
        this.emViagem = emViagem;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "idCaminhao=" + idCaminhao +
                ", nome='" + nome + '\'' +
                ", placa='" + placa + '\'' +
                ", emViagem=" + emViagem +
                '}';
    }
}

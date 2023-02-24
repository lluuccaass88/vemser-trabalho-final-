package src.logistica.model;
public class Posto {
    private int id_posto, id_rota;
    private String nomePosto;
    private double valorCombustível;

    public Posto(String nomePosto, double valorCombustível) {
        this.nomePosto = nomePosto;
        this.valorCombustível = valorCombustível;
    }

    public Posto() {
    }

    // Getters e Setters


    public int getId_rota() {
        return id_rota;
    }

    public void setId_rota(int id_rota) {
        this.id_rota = id_rota;
    }

    public String getNomePosto() {
        return nomePosto;
    }

    public void setNomePosto(String nomePosto) {
        this.nomePosto = nomePosto;
    }

    public double getValorCombustível() {
        return valorCombustível;
    }

    public void setValorCombustível(double valorCombustível) {
        this.valorCombustível = valorCombustível;
    }

    public int getId_posto() {
        return id_posto;
    }

    public void setId_posto(int id_posto) {
        this.id_posto = id_posto;
    }

    @Override
    public String toString() {
        return "Posto{" +
                "Id : " + id_posto + '\'' +
                "nomePosto='" + nomePosto + '\'' +
                ", valorCombustível=" + valorCombustível +
                '}';
    }
}
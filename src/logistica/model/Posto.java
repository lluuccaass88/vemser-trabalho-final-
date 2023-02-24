package src.logistica.model;
public class Posto {
    private int idPosto, idRota;
    private String nomePosto;
    private double valorCombustível;

    public Posto(String nomePosto, double valorCombustível) {
        this.nomePosto = nomePosto;
        this.valorCombustível = valorCombustível;
    }

    public Posto() {
    }

    // Getters e Setters


    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    public String getNomePosto() {
        return nomePosto;
    }

    public void setNomePosto(String nomePosto) {
        this.nomePosto = nomePosto;
    }

    public double getValorCombustivel() {
        return valorCombustível;
    }

    public void setValorCombustivel(double valorCombustível) {
        this.valorCombustível = valorCombustível;
    }

    public int getIdPosto() {
        return idPosto;
    }

    public void setIdPosto(int id_posto) {
        this.idPosto = id_posto;
    }

    @Override
    public String toString() {
        return "Posto{" +
                "Id : " + idPosto + '\'' +
                "nomePosto='" + nomePosto + '\'' +
                ", valorCombustível=" + valorCombustível +
                '}';
    }
}
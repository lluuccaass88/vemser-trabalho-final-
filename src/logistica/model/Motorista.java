package src.logistica.model;

public class Motorista extends Usuario {
    private String cnh;

    public Motorista(Integer id, String nome, String usuario, String senha, String cnh) {
        super(id, nome, usuario, senha);
        this.cnh = cnh;
    }
    public String getCnh() {
        return cnh;
    }
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    @Override
    public String toString() {
        return super.toString() + " Motorista { " +
                "cnh=' " + cnh + '\'' +
                " } ";
    }
}
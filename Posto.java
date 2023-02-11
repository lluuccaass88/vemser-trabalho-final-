public class Posto {
    private String nome;
    private double valorCombustível;



    public String toString(String nome, double valorCombustível) {
        return super.toString();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public double getValorCombustível() {
        return valorCombustível;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValorCombustível(double valorCombustível) {
        this.valorCombustível = valorCombustível;
    }
}
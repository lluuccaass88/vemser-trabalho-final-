public class Posto {
    private String nome;
    private double valorCombustível;

    public Posto(String nome, double valorCombustível) {
        this.nome = nome;
        this.valorCombustível = valorCombustível;
    }

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

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n Valor do combustivel: " + this.valorCombustível;
    }
}
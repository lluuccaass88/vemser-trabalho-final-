public class Caminhao {
    private String placa, modelo, marca;
    private double capacidade, kmRodados;
    private int gasolina;
    private boolean emViagem;

    public Caminhao(String placa, String modelo, String marca, double capacidade, double kmRodados, int gasolina) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.capacidade = capacidade;
        this.kmRodados = kmRodados;
        this.gasolina = gasolina;
        this.emViagem = false;
    }

    public boolean getEmViagem() {
        return emViagem;
    }

    public void setEmViagem(boolean emViagem) {
        this.emViagem = emViagem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public double getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(double kmRodados) {
        this.kmRodados = kmRodados;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }

    public boolean abastecer(int quantidade){

        gasolina += quantidade;
        return true;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", capacidade=" + capacidade +
                ", kmRodados=" + kmRodados +
                ", gasolina=" + gasolina +
                '}';
    }
}

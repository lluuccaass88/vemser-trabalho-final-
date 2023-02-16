import java.util.Scanner;

public class Caminhao {
    private String placa, modelo, marca;
    private double capacidade, kmRodados;
    private int gasolina;
    private boolean emViagem;

    Scanner inputUsuario = new Scanner(System.in);
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

    public boolean abastecer(Posto posto, int quantidade){ //Teria que chamar a função abastecer do caminhão, então preciso da classe caminhão
        if (getGasolina() == 100) {
            System.out.println("O tanque do caminhão já está cheio.");
        } else {
            while (quantidade + getGasolina() > 100) {
                System.out.println("Você não pode abastecer esta quantidade pois passaria da capacidade do tanque");
                quantidade = inputUsuario.nextInt();
            }
            setGasolina(getGasolina() + quantidade);
        }
        return false;
    }

    @Override
    public String toString() {
        return  "placa: " + placa + '\'' +
                ", modelo: " + modelo + '\'' +
                ", marca: " + marca + '\'' +
                ", capacidade: " + capacidade +
                ", Quilometros rodados: " + kmRodados +
                ", gasolina: " + gasolina;
    }
}

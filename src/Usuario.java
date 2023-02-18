package src;

public abstract class Usuario {
    private String nome, cpf;
    private double salario;
    private int idade;

    public Usuario(String nome, String cpf, double salario, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void aumentoSalario(double aumento){
        this.salario = this.salario + aumento;
    }
}

public class Motorista extends Usuario implements Imprimir{
    private String cnh;

    public Motorista(String nome, String cpf, double salario, int idade, String cnh) {
        super(nome, cpf, salario, idade);
        this.cnh = cnh;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public void imprimir() {
        System.out.printf("Nome: %s , CPF: %s , Salario: %f , Idade: %d, RG: %s", getNome(),getCpf(),getSalario(),getIdade(),getCnh());
    }
}

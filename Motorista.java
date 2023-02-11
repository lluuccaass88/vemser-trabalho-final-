public class Motorista extends Usuario implements Imprimir{
    private String cnh;

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

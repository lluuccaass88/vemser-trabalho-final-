public class Colaborador  extends Usuario implements Imprimir{
    private String rg;
    private final static double TAXA_AUMENTO = 1.5;
    public Colaborador(String nome, String cpf, double salario, int idade, String rg) {
        super(nome, cpf, salario, idade);
        this.rg = rg;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }



    public  void  aumentoSalario(double aumento){
        setSalario(getSalario() + (aumento * TAXA_AUMENTO));
    }

    @Override
    public void imprimir() {
        System.out.printf("Nome: %s , CPF: %s , Salario: %f , Idade: %d, RG: %s", getNome(),getCpf(),getSalario(),getIdade(),getRg());
    }
}

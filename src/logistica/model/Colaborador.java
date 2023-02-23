package src.logistica.model;

public class Colaborador  extends Usuario  {

    private String cpf;

    public Colaborador() { }
    public Colaborador(Integer id, String nome, String usuario, String senha, String cpf) {
        super(id, nome, usuario, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString() + " Colaborador { " +
                "cpf=' " + cpf + '\'' +
                " } ";
    }
}
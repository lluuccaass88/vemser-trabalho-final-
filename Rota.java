public class Rota {
    private String nome,descricao;

    //Impressão Rota
    public void imprimirRota(){
        System.out.println("Rota: " +nome+ "Descrição: " +descricao);
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
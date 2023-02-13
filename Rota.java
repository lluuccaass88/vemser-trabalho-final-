public class Rota {
    private String nome,descricao, localPartida, destino;

    public Rota(String nome, String descricao, String localPartida, String destino) {
        this.nome = nome;
        this.descricao = descricao;
        this.localPartida = localPartida;
        this.destino = destino;
    }


    //Getters e Setters

    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

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

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", descricao: " + descricao + '\'' +
                ", local de partida: " + localPartida + '\'' +
                ", destino: " + destino + '\'';
    }
}
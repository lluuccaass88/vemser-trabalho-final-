import java.util.ArrayList;

public class Rota {
    private String nome,descricao, localPartida, destino;
    ArrayList<Posto> listaPostoCadastrado = new ArrayList();

    public Rota(String nome, String descricao, String localPartida, String destino, ArrayList<Posto> listaPostoCadastrado) {
        this.nome = nome;
        this.descricao = descricao;
        this.localPartida = localPartida;
        this.destino = destino;
        this.listaPostoCadastrado = listaPostoCadastrado;
    }


    //Getters e Setters

    public ArrayList<Posto> getListaPostoCadastrado() {
        return listaPostoCadastrado;
    }

    public void setListaPostoCadastrado(ArrayList<Posto> listaPostoCadastrado) {
        this.listaPostoCadastrado = listaPostoCadastrado;
    }

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

    public void listaPostoCredenciado() {
        for(int i = 0; i < listaPostoCadastrado.size(); i++){
            System.out.println("Id do posto: " + i + " Nome: " + listaPostoCadastrado.get(i).getNome());
        }
    }
}
import java.util.ArrayList;

public class ManipulaRotas {
    private ArrayList<Rota> listaRota = new ArrayList();

    public void adicionaRota(Rota rota){
        this.listaRota.add(rota);
    }

    public void removerRotaPorIndice(Integer index) {
        this.listaRota.remove(index.intValue());
        System.out.println("Rota excluita...");
    }

    public void editarRota(Integer index, Rota rota) {
        Rota rotaProcurada = listaRota.get(index);
        rotaProcurada.setNome(rota.getNome());
        rotaProcurada.setDestino(rota.getDestino());
        rotaProcurada.setLocalPartida(rota.getLocalPartida());
        rotaProcurada.setDescricao(rota.getDescricao());
    }

    public void listarRotas() {
        System.out.println("========== Rotas cadastradas ==========");
        if(this.listaRota.size() >= 1){
            for (int i = 0; i < listaRota.size(); i++) {
                System.out.println("Id da rota: " + i + ": \n " + listaRota.get(i).toString());
            }
        }else{
            System.out.println("Não existem rotas cadastradas.");
        }
    }

}

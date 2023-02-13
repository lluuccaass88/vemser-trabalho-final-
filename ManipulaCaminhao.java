import java.util.ArrayList;
import java.util.List;

public class ManipulaCaminhao {
    private ArrayList<Caminhao> listaCaminhao = new ArrayList();

    public void adicionaCaminhao(Caminhao caminhao){
        this.listaCaminhao.add(caminhao);
    }

    public void removerCaminhaoroPorIndice(Integer index) {
        this.listaCaminhao.remove(index.intValue());
    }

    public void editarCaminhao(Integer index, Caminhao caminhao) {
        Caminhao CaminhaoProcurada = listaCaminhao.get(index);
        CaminhaoProcurada.setCapacidade(caminhao.getCapacidade());
        CaminhaoProcurada.setGasolina(caminhao.getGasolina());
        CaminhaoProcurada.setPlaca(caminhao.getPlaca());
    }

    public void listarCaminhao() {
        System.out.println("========== Caminhoes ==========");
        if(this.listaCaminhao.size() >= 1){
            for (int i = 0; i < listaCaminhao.size(); i++) {
                System.out.println("Caminhão: " + i + ": \n " + listaCaminhao.get(i).toString());
            }
        }else{
            System.out.println("Não existem postos cadastrados.");
        }
    }

    public void listarCaminhaoDisponivel() {
        List<Caminhao> filtrada = listaCaminhao.stream()
                .filter(elemento -> elemento.getEmViagem() == false)
                .toList();

        System.out.println("========== Caminhões Disponiveis ==========");
        if(filtrada.size() >= 1){
            for (int i = 0; i < filtrada.size(); i++) {
                System.out.println("Id do caminhão: " + i + ": \n " + filtrada.get(i).getPlaca());
            }
        }else{
            System.out.println("Não existem caminhoes disponiveis no momento.");
        }
    }

    public List<Caminhao> caminhoesLivres(){
        List<Caminhao> caminhaoDisponivel = listaCaminhao.stream()
                .filter(elemento -> elemento.getEmViagem() == false)
                .toList();

        return caminhaoDisponivel;
    }

    public Caminhao buscaCaminhaoPorId(int index){
        return listaCaminhao.get(index);
    }

    public ArrayList<Caminhao> retornaCaminhao() {
        return this.listaCaminhao;
    }

}

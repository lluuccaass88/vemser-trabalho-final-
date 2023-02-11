import java.util.ArrayList;

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
                System.out.println("Id do caminhão: " + i + ": \n " + listaCaminhao.get(i).toString());
            }
        }else{
            System.out.println("Não existem postos cadastrados.");
        }
    }
}

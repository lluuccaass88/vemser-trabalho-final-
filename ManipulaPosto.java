import java.util.ArrayList;

public class ManipulaPosto {
    private ArrayList<Posto> listaPosto = new ArrayList();

    public void adicionaPosto(Posto posto){
        this.listaPosto.add(posto);
    }

    public void removerPostoPorIndice(Integer index) {
        this.listaPosto.remove(index.intValue());
    }

    public void editarPosto(Integer index, Posto posto) {
        Posto postoProcurada = listaPosto.get(index);
        postoProcurada.setNome(posto.getNome());
        postoProcurada.setValorCombustível(posto.getValorCombustível());
    }

    public void listarPostosCredenciados() {
        System.out.println("========== Postos Credenciados ==========");
        if(this.listaPosto.size() >= 1){
            for (int i = 0; i < listaPosto.size(); i++) {
                System.out.println("Id posto: " + i + ": \n " + listaPosto.get(i).toString());
            }
        }else{
            System.out.println("Não existem postos cadastrados.");
        }
    }

}

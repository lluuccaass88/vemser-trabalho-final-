package src;

import java.util.ArrayList;
import java.util.List;

public class ManipulaViagem {
    private ArrayList<Viagem> listaViagem = new ArrayList();

    public void adicionaViagem(Viagem viagem){
        this.listaViagem.add(viagem);
    }

    public void removerViagemPorIndice(Integer index) {
        this.listaViagem.remove(index.intValue());
    }

    public void editarViagem(Integer index, Viagem viagem) {
        Viagem viagemProcurada = listaViagem.get(index);

        viagemProcurada.getCaminhao().setEmViagem(false);
        viagemProcurada.getMotorista().setEmViagem(false);

        viagemProcurada.setMotorista(viagem.getMotorista());
        viagemProcurada.setCaminhao(viagem.getCaminhao());
        viagemProcurada.setRota(viagem.getRota());
    }

    public void listarViagens() {
        System.out.println("========== Viagens ==========");
        if(this.listaViagem.size() >= 1){
            for (int i = 0; i < listaViagem.size(); i++) {
                System.out.println("Id da viagem " + i + ": \n " + listaViagem.get(i).toString() + "\n");
            }
        }else{
            System.out.println("Não existem viagens cadastradas no momento.");
        }

    }

    public Viagem BuscaViagensId(int index) {
        return listaViagem.get(index);
    }

    public void listarViagensRealizadas() {
        System.out.println("========= Viagens Reaizadas ==========");
        List<Viagem> filtrada = listaViagem.stream()
                .filter(elemento -> elemento.getFinalizada() == true)
                .toList();

        if(filtrada.size() >= 1){
            for (int i = 0; i < filtrada.size(); i++) {
                System.out.println("Id da viagem " + i + ":\n " + filtrada.get(i).toString() + "\n");
            }
        }else{
            System.out.println("Não existem viagens realizadas no momento.");
        }

    }

    public void listarViagensEmAndamento() {
        System.out.println("========= Viagens Em andamento ==========");
        List<Viagem> filtrada = listaViagem.stream()
                .filter(elemento -> elemento.getFinalizada() == false)
                .toList();

        if(filtrada.size() >= 1){
            for (int i = 0; i < filtrada.size(); i++) {
                System.out.println("Id da viagem " + i + ":\n " + filtrada.get(i).toString() + "\n");
            }
        }else{
            System.out.println("Não existem viagens em andamento no momento.");
        }
    }




}

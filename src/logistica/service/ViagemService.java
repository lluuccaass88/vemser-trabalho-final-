package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Caminhao;
import src.logistica.model.Viagem;
import src.logistica.repository.ViagemRepository;

import java.util.List;

public class ViagemService {
    private ViagemRepository viagemRepository;

    public ViagemService() {
        viagemRepository = new ViagemRepository();
    }

    // criando um objeto do tipo Caminhao
    public void adicionarViagem(Viagem viagem) {
        try {
            Viagem viagemAdicionada = viagemRepository.adicionar(viagem);
            System.out.println("Viagem adicionado com sucesso: " + viagemAdicionada);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
    }

    // removendo um obejto do tipo Caminhao passando o ID
//    public void removerCaminhao(Integer id) {
//        try {
//            boolean conseguiuRemover = caminhaoRepository.remover(id);
//            if (conseguiuRemover) {
//                System.out.println("Caminhão " + conseguiuRemover + "| com id= "
//                        + id + " removido com sucesso");
//            } else {
//                System.out.println("Não foi possível remover o " + id + " do caminhão");
//            }
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
//    // editando um objeto do tipo Caminhao passando o ID e o objeto CAMINHAO
//    public void editarCaminhao(Integer id, Caminhao caminhao) {
//        try {
//            boolean conseguiuEditar = caminhaoRepository.editar(id, caminhao);
//            if (conseguiuEditar) {
//                System.out.println("Caminhão " + conseguiuEditar + "| com id= "
//                        + id + " editado com sucesso");
//            } else {
//                System.out.println("Não foi possível editar o " + id + " do caminhão");
//            }
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
//    // listando todos os objetos do tipo Caminhao
//    public void listarCaminhoes(){
//        try {
//            List<Caminhao> listar = caminhaoRepository.listar();
//            listar.forEach(System.out::println);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
}
//    private ArrayList<Viagem> listaViagem = new ArrayList();
//
//    public void adicionaViagem(Viagem viagem){
//        this.listaViagem.add(viagem);
//    }
//
//    public void removerViagemPorIndice(Integer index) {
//        this.listaViagem.remove(index.intValue());
//    }
//
//    public void editarViagem(Integer index, Viagem viagem) {
//        Viagem viagemProcurada = listaViagem.get(index);
//
//        viagemProcurada.getCaminhao().setEmViagem(false);
//        viagemProcurada.getMotorista().setEmViagem(false);
//
//        viagemProcurada.setMotorista(viagem.getMotorista());
//        viagemProcurada.setCaminhao(viagem.getCaminhao());
//        viagemProcurada.setRota(viagem.getRota());
//    }
//
//    public void listarViagens() {
//        System.out.println("========== Viagens ==========");
//        if(this.listaViagem.size() >= 1){
//            for (int i = 0; i < listaViagem.size(); i++) {
//                System.out.println("Id da viagem " + i + ": \n " + listaViagem.get(i).toString() + "\n");
//            }
//        }else{
//            System.out.println("Não existem viagens cadastradas no momento.");
//        }
//
//    }
//
//    public Viagem BuscaViagensId(int index) {
//        return listaViagem.get(index);
//    }
//
//    public void listarViagensRealizadas() {
//        System.out.println("========= Viagens Reaizadas ==========");
//        List<Viagem> filtrada = listaViagem.stream()
//                .filter(elemento -> elemento.getFinalizada() == true)
//                .toList();
//
//        if(filtrada.size() >= 1){
//            for (int i = 0; i < filtrada.size(); i++) {
//                System.out.println("Id da viagem " + i + ":\n " + filtrada.get(i).toString() + "\n");
//            }
//        }else{
//            System.out.println("Não existem viagens realizadas no momento.");
//        }
//
//    }
//
//    public void listarViagensEmAndamento() {
//        System.out.println("========= Viagens Em andamento ==========");
//        List<Viagem> filtrada = listaViagem.stream()
//                .filter(elemento -> elemento.getFinalizada() == false)
//                .toList();
//
//        if(filtrada.size() >= 1){
//            for (int i = 0; i < filtrada.size(); i++) {
//                System.out.println("Id da viagem " + i + ":\n " + filtrada.get(i).toString() + "\n");
//            }
//        }else{
//            System.out.println("Não existem viagens em andamento no momento.");
//        }
//    }
//
//
//
//
//}

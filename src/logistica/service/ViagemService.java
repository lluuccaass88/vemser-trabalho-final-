package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Caminhao;
import src.logistica.model.EmViagem;
import src.logistica.model.Viagem;
import src.logistica.repository.CaminhaoRepository;
import src.logistica.repository.ViagemRepository;

import java.util.List;

public class ViagemService {
    private ViagemRepository viagemRepository;


    public ViagemService() {

        viagemRepository = new ViagemRepository();
    }

    // criando um objeto do tipo Caminhao
    public void adicionarViagem(Viagem viagem) {
        CaminhaoRepository caminhaoRepository = new CaminhaoRepository();
        try {
            Viagem viagemAdicionada = viagemRepository.adicionar(viagem);

            viagem.getCaminhao().setEmViagem(EmViagem.getOpcaoEmViagem(2)); //Mudando o status do caminhão de estacionado para em viagem
            caminhaoRepository.editar(viagem.getCaminhao().getIdCaminhao(), viagem.getCaminhao());

            System.out.println("Viagem adicionado com sucesso: " + viagemAdicionada);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
    }

    // removendo um obejto do tipo Viagem passando o ID
    public void finalizarViagem(Integer id) { //Precia pegar o id co caminhão que esta ligado nessa viagem
        CaminhaoRepository caminhaoRepository = new CaminhaoRepository();
        Viagem viagemFinalizada = new Viagem();

        try {

            boolean conseguiuFianlizar = viagemRepository.remover(id);
            viagemFinalizada = viagemRepository.buuscaViagemId(id);//Retorna a viagem a ser finalizada
            boolean conseguiuMudarEmViagem = caminhaoRepository.editaEmViagem(viagemFinalizada.getCaminhao().getIdCaminhao()); //Edita o status do caminhão para estacionado
            viagemFinalizada.setFinalizada(1); //Mudando o status para finalizado
            //AQUI VAI A FUNÇÃO DE EDITAR VIAGEM PARA MUDAR O STATUS DA VIAGEM NO BANCO

            if (conseguiuFianlizar && conseguiuMudarEmViagem) {
                System.out.println("Viagem " + conseguiuFianlizar + "| com id= "
                        + id + " finalizada com sucesso");
            } else {
                System.out.println("Não foi possível finalizar a " + id + " da viagem");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarViagens(){
        try {
            List<Viagem> listar = viagemRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }


    public void listarViagensFinalizadas(){
        try {
            List<Viagem> listar = viagemRepository.listar();
            List<Viagem> viagensFinalizadas = listar.stream()
                    .filter(elemento -> elemento.getFinalizada() == 1) //Descobrir cm compara o enum para listar somente os que não estiverem em viagem
                    .toList();
            viagensFinalizadas.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

















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

package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Caminhao;
import src.logistica.model.EmViagem;
import src.logistica.model.Viagem;
import src.logistica.repository.CaminhaoRepository;
import src.logistica.repository.RotaRepository;
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
            viagemFinalizada = viagemRepository.buscaViagemId(id);//Retorna a viagem a ser finalizada
            boolean conseguiuMudarEmViagem = caminhaoRepository.estacionar(viagemFinalizada.getCaminhao().getIdCaminhao()); //Edita o status do caminhão para estacionado
            viagemFinalizada.setFinalizada(1); //Mudando o status para finalizado
            viagemRepository.editar(id, viagemFinalizada);
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

    public void listarViagens() {
        try {
            List<Viagem> listar = viagemRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarViagensFinalizadas() {
        try {
            List<Viagem> listar = viagemRepository.listar();
            List<Viagem> viagensFinalizadas = listar.stream()
                    .filter(elemento -> elemento.getFinalizada() == 1)
                    .toList();
            viagensFinalizadas.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editarViagem(Integer id, Viagem viagem) {

        Viagem viagemSemEdicao = new Viagem();

        CaminhaoRepository caminhaoRepository = new CaminhaoRepository();
        RotaRepository rotaRepository = new RotaRepository();

        try {
            viagemSemEdicao = viagemRepository.buscaViagemId(id); //Busca a viagem antes de ser editada;

            boolean conseguiuMudarEstacionado = caminhaoRepository.estacionar(viagemSemEdicao.getCaminhao().getIdCaminhao()); //Edita status do caminhão para estacionado
            boolean conseguiuMudarEmViagem = caminhaoRepository.viajar(viagem.getCaminhao().getIdCaminhao()); //Edita o status do caminhão para em viagem

            boolean conseguiuEditarViagem = viagemRepository.editar(id, viagem); //Edita viagem

            if (conseguiuEditarViagem && conseguiuMudarEstacionado && conseguiuMudarEmViagem) {
                System.out.println("Viagem " + conseguiuEditarViagem + "| com id= "
                        + id + " editada com sucesso");
            } else {
                System.out.println("Não foi possível editar a " + id + " da viagem");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
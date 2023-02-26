package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Caminhao;
import src.logistica.model.EmViagem;
import src.logistica.repository.CaminhaoRepository;

import java.util.List;

public class CaminhaoService {

    private CaminhaoRepository caminhaoRepository;

    public CaminhaoService() {
        caminhaoRepository = new CaminhaoRepository();
    }

    // criando um objeto do tipo Caminhao
    public void adicionarCaminhao(Caminhao caminhao) {
        try {
            if (caminhao.getPlaca().length() < 8 || caminhao.getPlaca().length() > 10) {
                throw new Exception("Placa inválida");
            }
            Caminhao caminhaoAdicionado = caminhaoRepository.adicionar(caminhao);
            System.out.println("Caminhão adicionado com sucesso: " + caminhaoAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
    }

    // removendo um obejto do tipo Caminhao passando o ID
    public void removerCaminhao(Integer id) {
        try {
            boolean conseguiuRemover = caminhaoRepository.remover(id);
            if (conseguiuRemover) {
                System.out.println("Caminhão " + conseguiuRemover + "| com id= "
                        + id + " removido com sucesso");
            } else {
                System.out.println("Não foi possível remover o " + id + " do caminhão");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
    // editando um objeto do tipo Caminhao passando o ID e o objeto CAMINHAO

    public void editarCaminhao(Integer id, Caminhao caminhao) {
        try {
            boolean conseguiuEditar = caminhaoRepository.editar(id, caminhao);
            if (conseguiuEditar) {
                System.out.println("Caminhão " + conseguiuEditar + "| com id= "
                        + id + " editado com sucesso");
            } else {
                System.out.println("Não foi possível editar o " + id + " do caminhão");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
    // listando todos os objetos do tipo Caminhao
    public void listarCaminhoes(){
        try {
            List<Caminhao> listar = caminhaoRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarCaminhoesLivres(){
        try {
            List<Caminhao> listar = caminhaoRepository.listar();
            List<Caminhao> caminhaoDisponivel = listar.stream()
                    .filter(elemento -> elemento.getEmViagem().equals("ESTACIONADO") ) //Descobrir cm compara o enum para listar somente os que não estiverem em viagem
                    .toList();
            caminhaoDisponivel.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
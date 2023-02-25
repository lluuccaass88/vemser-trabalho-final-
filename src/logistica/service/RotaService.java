package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Rota;
import src.logistica.model.Posto;
import src.logistica.repository.RotaRepository;

import java.util.List;

public class RotaService {
    private RotaRepository rotaRepository;

    public RotaService() {
        rotaRepository = new RotaRepository();
    }

    // criando um objeto do tipo Rota
    public void adicionaRota(Rota rota) {
        try {
            Rota rotaAdicionado = rotaRepository.adicionar(rota);
            System.out.println("Rota adicionado com sucesso: " + rotaAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
    }

    // adicionar Rota_X_Posto conforme tabela de relacionamento no banco de dados
    public void adicionaRotaXPosto(Rota rota) {
        try {
            for(int i = 0; i < rota.getListaPostoCadastrado().size(); i++){
                Rota rotaAdicionado = rotaRepository.adicionarPostoXRota(rota, i);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
    }

    // removendo um obejto do tipo Colaborador passando o ID
    public void removerRota(Integer id) {
        try {

            boolean conseguiuRemoverRelacionamento = rotaRepository.removerPostoXRota(id);
            boolean conseguiuRemover = rotaRepository.remover(id);

            if (conseguiuRemover && conseguiuRemoverRelacionamento) {
                System.out.println("Rota: " + conseguiuRemover + "| com id= "
                        + id + " removido com sucesso");
            } else {
                System.out.println("Não foi possível remover o " + id + " do rota");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualizando um objeto do tipo Colaborador passando o ID e o objeto COLABORADOR
    public void editarRota(Integer id, Rota rota) {
        try {
            boolean conseguiuEditar = rotaRepository.editar(id, rota);
            if (conseguiuEditar) {
                System.out.println("Rota: " + conseguiuEditar + "| com id= "
                        + id + " editado com sucesso");
            } else {
                System.out.println("Não foi possível editar o " + id + " da rota");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // listando todos os colaboradores
    public void listarRotas() {
        try {
            List<Rota> listar = rotaRepository.listar();

            for(Rota itemRota : listar){
                System.out.println("========== Informações da rota: ==========");
                System.out.println(itemRota.toString());
                System.out.println("========== Postos Cadastrados na rota " + itemRota.getIdRota() + " ==========");
                for (Posto itemPosto : itemRota.getListaPostoCadastrado()){
                    System.out.println(itemPosto.toString());
                }
                System.out.println("\n");
            }
        } catch (BancoDeDadosException e ) {
            e.printStackTrace();
        }
    }

}
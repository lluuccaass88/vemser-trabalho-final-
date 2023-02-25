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
            // validação para saber se o CPF nao tem mais que 11 digitos - Não cpf e não pensei em nem um campo para validar...
//            if (colaborador.getCpf().length() > 11) {
//                throw new Exception("CPF inválido");
//            }
            Rota rotaAdicionado = rotaRepository.adicionar(rota);
            System.out.println("Rota adicionado com sucesso: " + rotaAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
    }

    public void adicionaRota_X_Posto(Rota rota) {
        try {
            for(int i = 0; i < rota.getListaPostoCadastrado().size(); i++){
                Rota rotaAdicionado = rotaRepository.adicionarPosto_X_Rota(rota, i);
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

            boolean conseguiuRemoverRelacionamento = rotaRepository.removerPosto_X_Rota(id);
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
                System.out.println("========== Informações da tora: ==========");
                System.out.println(itemRota.toString());
                System.out.println("========== Postos Cadastrados ==========");
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
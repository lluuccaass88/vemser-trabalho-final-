package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Posto;
import src.logistica.repository.PostoRepository;

import java.util.List;

public class PostoService {
    private PostoRepository postoRepository;

    public PostoService() {
        postoRepository = new PostoRepository();
    }

    public void adicionaPosto(Posto posto) {
        try {
            Posto postoAdicionado = postoRepository.adicionar(posto);
            System.out.println("Dados do posto adicionado: \n " + postoAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
    }

    public void removerPosto(Integer id) {
        try {
            boolean conseguiuRemoverRelacionamento = postoRepository.removerPostoXRota(id);
            boolean conseguiuRemover = postoRepository.remover(id);
            if (conseguiuRemover && conseguiuRemoverRelacionamento) {
                System.out.println("Posto romovido: " + conseguiuRemover + "| Posto com o id= "
                        + id + " removido com sucesso");
            } else {
                System.out.println("Não foi possível remover o posto com o id " + id + ".");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualizando um objeto do tipo Colaborador passando o ID e o objeto COLABORADOR
    public void editarPosto(Integer id, Posto posto) {
        try {
            boolean conseguiuEditar = postoRepository.editar(id, posto);
            if (conseguiuEditar) {
//                System.out.println("Posto " + conseguiuEditar + "| com id= "
//                        + id + " editado com sucesso");
                System.out.println("Posto com o id "
                        + id + " editado com sucesso");
            } else {
                System.out.println("Não foi possível editar o posto com o id " + id + ".");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // listando todos os colaboradores
    public void listarPosto() {
        try {
            List<Posto> listar = postoRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e ) {
            e.printStackTrace();
        }
    }

    public Posto buscarPostoId(int id) {
        try {
            Posto retornoBusca = postoRepository.buscarPorId(id);
            if(retornoBusca == null){
                System.out.println("Não foi encontrar o posto com o id " + id);
            }else{
                System.out.println("Posto: \n "+ retornoBusca);
                return retornoBusca;
            }
        } catch (BancoDeDadosException e ) {
            e.printStackTrace();
        }
        return null;
    }
}





























//    private ArrayList<Posto> listaPosto = new ArrayList();
//
//    public void adicionaPosto(Posto posto){
//        this.listaPosto.add(posto);
//    }
//
//    public void removerPostoPorIndice(Integer index) {
//        this.listaPosto.remove(index.intValue());
//    }
//
//    public void editarPosto(Integer index, Posto posto) {
//        Posto postoProcurada = listaPosto.get(index);
//        postoProcurada.setNome(posto.getNome());
//        postoProcurada.setValorCombustível(posto.getValorCombustível());
//    }
//
//    public void listarPostosCredenciados() {
//        System.out.println("========== Postos Credenciados ==========");
//        if(this.listaPosto.size() >= 1){
//            for (int i = 0; i < listaPosto.size(); i++) {
//                System.out.println("Id posto: " + i + ": \n " + listaPosto.get(i).toString() + "\n");
//            }
//        }else{
//            System.out.println("Não existem postos cadastrados.");
//        }
//    }
//
//    public ArrayList<Posto> retornaPosto() {
//        return listaPosto;
//    }
//
//    public Posto buscaPostosCredenciadosID(int index){
//        return listaPosto.get(index);
//    }
//
//
//}

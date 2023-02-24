package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Rota;
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

    // removendo um obejto do tipo Colaborador passando o ID
    public void removerRota(Integer id) {
        try {
            boolean conseguiuRemover = rotaRepository.remover(id);
            if (conseguiuRemover) {
                System.out.println("Rota " + conseguiuRemover + "| com id= "
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
                System.out.println("Rota " + conseguiuEditar + "| com id= "
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
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e ) {
            e.printStackTrace();
        }
    }

}
//
//    private ArrayList<Rota> listaRota = new ArrayList();
//
//    public void adicionaRota(Rota rota){
//        this.listaRota.add(rota);
//    }
//
//    public void removerRotaPorIndice(Integer index) {
//        this.listaRota.remove(index.intValue());
//        System.out.println("Rota excluita...");
//    }
//
//    public void editarRota(Integer index, Rota rota) {
//        Rota rotaProcurada = listaRota.get(index);
//        rotaProcurada.setNome(rota.getNome());
//        rotaProcurada.setDestino(rota.getDestino());
//        rotaProcurada.setLocalPartida(rota.getLocalPartida());
//        rotaProcurada.setDescricao(rota.getDescricao());
//    }
//
//    public void listarRotas() {
//        System.out.println("========== Rotas cadastradas ==========");
//        if(this.listaRota.size() >= 1){
//            for (int i = 0; i < listaRota.size(); i++) {
//                System.out.println("Id da rota: " + i + ": \n " + listaRota.get(i).toString());
//            }
//        }else{
//            System.out.println("Não existem rotas cadastradas.");
//        }
//    }
//
//    public void listarPostoRotas() {
//        System.out.println("========== Rotas cadastradas ==========");
//        if(this.listaRota.size() >= 1){
//            for (int i = 0; i < listaRota.size(); i++) {
//                System.out.println("Id da rota: " + i + ": " );
//                listaRota.get(i).listaPostoCredenciado();
//                System.out.println("\n");
//            }
//        }else{
//            System.out.println("Não existem rotas cadastradas nesta rota.");
//        }
//    }
//
//    public Rota buscaRotaoPorId(int index){
//        return listaRota.get(index);
//    }
//}

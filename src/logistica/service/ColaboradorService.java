package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Colaborador;
import src.logistica.repository.ColaboradorRepository;

import java.util.List;

/**
 * Para não ter que apagar essa classe , modificaremos o nome dela para ColaboradorService e implementaremos
 * a classe ColaboradorRepository que será responsável por fazer a persistência dos dados.
 */
public class ColaboradorService {

    private ColaboradorRepository colaboradorRepository;

    public ColaboradorService() {
        colaboradorRepository = new ColaboradorRepository();
    }

    // criando um objeto do tipo Colaborador
    public void adicionaColaborador(Colaborador colaborador) {
        try {
            // validação para saber se o CPF nao tem mais que 11 digitos
            if (colaborador.getCpf().length() > 11) {
                throw new Exception("CPF inválido");
            }
            Colaborador colaboradorAdicionado = colaboradorRepository.adicionar(colaborador);
            System.out.println("Colaborador adicionado com sucesso: " + colaboradorAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
    }

    // removendo um obejto do tipo Colaborador passando o ID
    public void removerColaborador(Integer id) {
        try {
            boolean conseguiuRemover = colaboradorRepository.remover(id);
            if (conseguiuRemover) {
                System.out.println("Colaborador " + conseguiuRemover + "| com id= "
                        + id + " removido com sucesso");
            } else {
                System.out.println("Não foi possível remover o " + id + " do colaborador");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualizando um objeto do tipo Colaborador passando o ID e o objeto COLABORADOR
    public void editarColaborador(Integer id, Colaborador colaborador) {
        try {
            boolean conseguiuEditar = colaboradorRepository.editar(id, colaborador);
            if (conseguiuEditar) {
                System.out.println("Colaborador " + conseguiuEditar + "| com id= "
                        + id + " editado com sucesso");
            } else {
                System.out.println("Não foi possível editar o " + id + " do colaborador");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // listando todos os colaboradores
    public void listarColaboradores() {
        try {
            List<Colaborador> listar = colaboradorRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e ) {
            e.printStackTrace();
        }
    }
}
//    private ArrayList<Colaborador> listaColaborador = new ArrayList();
//
//
//    public void adicionaColaborador(Colaborador colaborador){
//        listaColaborador.add(colaborador);
//    }
//
//    public void removerColaboradorPorIndice(Integer index) {
//
//        this.listaColaborador.remove(index.intValue());
//        System.out.println("Colaborador excluido...");
//    }
//
//    public void editarColaborador(Integer index, Colaborador colaborador) {
//        Colaborador colaboradorProcura = listaColaborador.get(index);
//        colaboradorProcura.setNome(colaborador.getNome());
//        colaboradorProcura.setCpf(colaborador.getCpf());
////        colaboradorProcura.setRg(colaborador.getRg());
////        colaboradorProcura.setSalario(colaborador.getSalario());
//    }
//
//    public ArrayList<Colaborador> retornaListaColaboradores(){
//        return listaColaborador;
//    }

//    public void listarColaboradores() {
//        System.out.println("========== Colaboradores ==========");
//
//        if(this.listaColaborador.size() >= 1){
//            for (int i = 0; i < listaColaborador.size(); i++) {
//                System.out.println("Id do colaborador: " + i + ":" );
//                listaColaborador.get(i).imprimir();
//                System.out.println("\n");
//            }
//        }else{
//            System.out.println("Não existem colabodores cadastrados.");
//        }
//    }
//
//    public void aumento(int index, double valorAumento){
////        this.listaColaborador.get(index).aumentoSalario(valorAumento);
//    }
//
//    public Colaborador buscaColaboradorId(int index){
//        return listaColaborador.get(index);
//    }
//}

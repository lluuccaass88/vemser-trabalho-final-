import java.util.ArrayList;

public class ManipulaColaborador{
    private ArrayList<Colaborador> listaColaborador = new ArrayList();


    public void adicionaColaborador(Colaborador colaborador){
        listaColaborador.add(colaborador);
    }

    public void removerColaboradorPorIndice(Integer index) {

        this.listaColaborador.remove(index.intValue());
        System.out.println("Colaborador excluido...");
    }

    public void editarColaborador(Integer index, Colaborador colaborador) {
        Colaborador colaboradorProcura = listaColaborador.get(index);
        colaboradorProcura.setNome(colaborador.getNome());
        colaboradorProcura.setCpf(colaborador.getCpf());
        colaboradorProcura.setRg(colaborador.getRg());
        colaboradorProcura.setSalario(colaborador.getSalario());
    }

    public ArrayList<Colaborador> retornaListaColaboradores(){
        return listaColaborador;
    }

    public void listarColaboradores() {
        System.out.println("========== Colaboradores ==========");

        if(this.listaColaborador.size() >= 1){
            for (int i = 0; i < listaColaborador.size(); i++) {
                System.out.println("Id do colaborador: " + i + ":" );
                listaColaborador.get(i).imprimir();
                System.out.println("\n");
            }
        }else{
            System.out.println("Não existem colabodores cadastrados.");
        }
    }

    public Colaborador buscaColaboradorId(int index){
        return listaColaborador.get(index);
    }
}

import java.util.ArrayList;

public class ManipulaMotorista {
    private ArrayList<Motorista> listaMotorista = new ArrayList();
    private ArrayList<Motorista> aux = new ArrayList();

    public void adicionaMotorista(Motorista motorista){
        listaMotorista.add(motorista);
    }

    public void removerMotoristaPorIndice(Integer index) {

        this.listaMotorista.remove(index.intValue());
        System.out.println("Motorista excluido...");
    }

    public void editarMotorista(Integer index, Motorista motorista) {
        Motorista MotoristaProcurada = listaMotorista.get(index);
        MotoristaProcurada.setNome(motorista.getNome());
        MotoristaProcurada.setCpf(motorista.getCpf());
        MotoristaProcurada.setCnh(motorista.getCnh());
        MotoristaProcurada.setSalario(motorista.getSalario());
    }


    public void listarMotoristas() {
        System.out.println("========== Motoristas ==========");

        if(this.listaMotorista.size() >= 1){
            for (int i = 0; i < listaMotorista.size(); i++) {
                System.out.println("Id do motorista: " + i + ":" );
                listaMotorista.get(i).imprimir();
                System.out.println("\n");
            }
        }else{
            System.out.println("Não existem motoristas cadastrados.");
        }
    }
}


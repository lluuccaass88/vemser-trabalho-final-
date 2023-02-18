package src;

import java.util.ArrayList;
import java.util.List;

public class ManipulaMotorista {
    private ArrayList<Motorista> listaMotorista = new ArrayList();

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


    public void listarMotoristaDisponiveis() {
        List<Motorista> filtrada = listaMotorista.stream()
                .filter(elemento -> elemento.getViagem() == false)
                .toList();

        System.out.println("========== Motoristas Disponiveis ==========");
        if(filtrada.size() >= 1){
            for (int i = 0; i < filtrada.size(); i++) {
                System.out.println("Id do caminhão: " + i + ": \n " + filtrada.get(i).getNome());
            }
        }else{
            System.out.println("Não existem motoristas disponiveis no momento.");
        }
    }

    public List<Motorista> motoristasLivres(){
        List<Motorista> caminhaoDisponivel = listaMotorista.stream()
                .filter(elemento -> elemento.getViagem() == false)
                .toList();

        return caminhaoDisponivel;
    }

    public Motorista buscaMotoristaPorId(int index){
        return listaMotorista.get(index);
    }

    public ArrayList<Motorista> retornaListaMotorista(){
        return listaMotorista;
    }

    public void aumento(int index, double valorAumento){
        this.listaMotorista.get(index).aumentoSalario(valorAumento);
    }



}


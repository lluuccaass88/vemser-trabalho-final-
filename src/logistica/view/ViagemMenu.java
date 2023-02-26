package src.logistica.view;


import src.logistica.model.*;
import src.logistica.service.CaminhaoService;
import src.logistica.service.RotaService;
import src.logistica.model.Viagem;
import src.logistica.service.ViagemService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViagemMenu {
    ViagemService viagemService = new ViagemService();
    RotaService rotaService = new RotaService();
    CaminhaoService caminhaoService = new CaminhaoService();
    Viagem viagem = new Viagem();

    public void menuViagem(Usuario usuario) {

    Viagem viagem = new Viagem();

        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                    ==========Menu Viagem==========
                    Cadastrar Viagem :          [1]
                    Listar Viagens:             [2]
                    Editar Viagem:              [3]
                    Finalizar Viagem :          [4]
                    Listar Viagens Finalizadas  [5]
                    Retornar ao Menu Principal: [0]
                    Digite sua opção:\s""");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Listando Caminhões Livres para Viagem..");
                    caminhaoService.listarCaminhoesLivres();
                    int id = sc.nextInt();
                    sc.nextLine();
                    viagem.setCaminhao(caminhaoService.retornaPorId(id));

                    System.out.println("Selecione o id da rota que deseja fazer: ");
                    rotaService.listarRotas();
                    id = sc.nextInt();
                    sc.nextLine();
                    viagem.setRota(rotaService.retornaPorId(id));

                    viagem.setUsuario(usuario);
                    viagemService.adicionarViagem(viagem);
                }
                case 2 -> {
                   viagemService.listarViagens();
                }

                case 3 -> {
                    System.out.println("Editando Viagem...");
                    System.out.println("Digite o ID da viagem que deseja editar: ");
                    int idViagem = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Informe o id do caminhão: ");
                    caminhaoService.listarCaminhoesLivres();
                    int idCaminhao = sc.nextInt();
                    sc.nextLine();
                    viagem.setCaminhao(caminhaoService.retornaPorId(idCaminhao));
                    System.out.println("Selecione o id da rota que deseja fazer: ");
                    rotaService.listarRotas();
                    int idRota = sc.nextInt();
                    sc.nextLine();
                    viagem.setRota(rotaService.retornaPorId(idRota));
                    viagem.setUsuario(usuario);
                    viagemService.editarViagem(idViagem, viagem);
                    }

                case 4 -> {
                    System.out.println("Finalizar Viagem...");
                    //viagemService.listarViagens();
                    System.out.println("Digite o ID da viagem que deseja finalizar: ");
                    boolean validacao = false;
                    while (!validacao) {
                        try {
                            int id = sc.nextInt();
                            sc.nextLine();
                            viagemService.finalizarViagem(id);
                            validacao = true;
                        } catch (InputMismatchException ex) {
                            System.err.println("Número inválido");
                        }
                    }
                }
                
                case 5 -> {
                    System.out.println("Listando viagens finalizadas: ");
                    viagemService.listarViagensFinalizadas();
                }

                case 0 -> {
                    System.out.println("Retornando ao Menu Principal");
                }
                default -> {
                    System.err.println("Opção inválida");
                }
            }
        }
    }
}
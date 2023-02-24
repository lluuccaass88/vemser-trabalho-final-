package src.logistica.view;

import src.logistica.model.Caminhao;
import src.logistica.model.EmViagem;
import src.logistica.service.CaminhaoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CaminhaoMenu {

    CaminhaoService caminhaoService = new CaminhaoService();
    Caminhao caminhao = new Caminhao();
    public void menuCaminhao() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    ===============Opções Caminhões===============
                    Cadastrar Caminhão:         [1]
                    Listar Caminhão:            [2]
                    Editar Caminhão:            [3]
                    Excluir Caminhão:           [4]
                    Retornar ao Menu Principal: [0]
                    Digite sua opção:\s""");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrando Caminhão...");
                    System.out.println("Digite o modelo do caminhão:");
                    caminhao.setModelo(sc.nextLine());

                    System.out.println("Digite a placa do caminhão:");
                    caminhao.setPlaca(sc.nextLine());

                    System.out.println("Informe de 0 a 100 a quantidade de gasolina do caminhão:"); // cabe aqui uma RegraDeNegocioExceptions
                    caminhao.setGasolina(sc.nextInt());
                    sc.nextLine();

                    System.out.println("Informe aqui 1 se o caminhão está em viagem ou 2 se está estacionado no pátio:");
                    caminhao.setEmViagem(EmViagem.getOpcaoEmViagem(sc.nextInt()));
                    sc.nextLine();

                    System.out.println(caminhao.getModelo());
                    caminhaoService.adicionarCaminhao(caminhao);
                    break;
                }
                case 2 -> {
                    System.out.println("Listando Caminhões...");
                    caminhaoService.listarCaminhoes();
                }
                case 3 -> {
                    System.out.println("Editando Caminhão...");
                    System.out.println("Digite o ID do caminhão que deseja editar:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o modelo do caminhão:");
                    caminhao.setModelo(sc.nextLine());
                    System.out.println("Digite a placa do caminhão:");
                    caminhao.setPlaca(sc.nextLine());
                    System.out.println("Informe de 0 a 100 a quantidade de gasolina do caminhão:"); // cabe aqui uma RegraDeNegocioExceptions
                    caminhao.setGasolina(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Informe aqui 1 se o caminhão está em viagem ou 2 se está estacionado no pátio:");
                    caminhao.setEmViagem(EmViagem.getOpcaoEmViagem(sc.nextInt()));
                    sc.nextLine();
                    caminhaoService.editarCaminhao(id, caminhao);
                    break;
                }
                case 4 -> {
                    System.out.println("Excluindo Caminhão...");
                    caminhaoService.listarCaminhoes();
                    System.out.println("Digite o ID do caminhão que deseja excluir:");
                    boolean validacao = false;
                    while (!validacao) {
                        try {
                            int id = sc.nextInt();
                            sc.nextLine();
                            caminhaoService.removerCaminhao(id);
                            validacao = true;
                        } catch (InputMismatchException ex) {
                            System.err.println("Número inválido");
                        }
                    }
                    break;
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
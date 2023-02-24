package src.logistica.view;

import src.logistica.model.Caminhao;
import src.logistica.service.CaminhaoService;

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
                    Cadastrar Caminhão: [1]
                    Ver Caminhão:       [2]
                    Editar Caminhão:    [3]
                    Excluir Caminhão:   [4]
                    Retornar ao Menu Principal:[0]
                    Digite sua opção:\s""");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrar Caminhão");
                    caminhaoService.adicionarCaminhao(caminhao);
                }
                case 2 -> {
                    System.out.println("Ver Caminhão");
                    caminhaoService.listarCaminhoes();
                }
                case 3 -> {
                    System.out.println("Editar Caminhão");
                    System.out.println("Digite o ID do caminhão que deseja editar:");
                    int id = sc.nextInt();
                    caminhaoService.editarCaminhao(id, caminhao);
                }
                case 4 -> {
                    System.out.println("Excluir Caminhão");
                    System.out.println("Digite o ID do caminhão que deseja excluir:");
                    int id = sc.nextInt();
                    caminhaoService.removerCaminhao(id);
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
package src.logistica.view;

import src.logistica.model.Rota;
import src.logistica.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RotaService rotaService = new RotaService();
        CaminhaoMenu caminhaoMenu = new CaminhaoMenu();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Digite 1 para criar rota");
            System.out.println("Digite 2 para listar rota");
            System.out.println("Digite 3 para editar um rota");
            System.out.println("Digite 4 para excluir um rota");
            System.out.println("Digite 5 para Menu de caminhão");
            System.out.println("Digite 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: { // adicionando - podemos fazer em outra classe para nao poluir tanto o MAIN
                    Rota rota = new Rota();
                    System.out.println("Digite a descrição da rota");
                    rota.setDescricao(scanner.nextLine());

                    System.out.println("Digite o local de partida");
                    rota.setLocalPartida(scanner.nextLine());

                    System.out.println("Digite o local de destino");
                    rota.setLocalDestino(scanner.nextLine());

                    rotaService.adicionaRota(rota);
                    break;
                }

                case 2: { // listando
                    rotaService.listarRotas();
                    break;
                }

                case 3: { // editando
                    break;
                }
                case 4: { // excluindo
                    break;
                }
                case 5: {
                    caminhaoMenu.menuCaminhao();
                    break;
                }
                case 0:
                    break;
                default:
                    System.err.println("opção inválida");
                    break;
            }
        }
        scanner.close();

    }
}
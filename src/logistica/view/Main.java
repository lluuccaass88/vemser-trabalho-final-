package src.logistica.view;

import src.logistica.model.*;
import src.logistica.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


//        ========================= ROTA ======================
        Scanner scanner = new Scanner(System.in);
        RotaService rotaService = new RotaService();

        PostoService postoService = new PostoService();

        CaminhaoMenu caminhaoMenu = new CaminhaoMenu();

        int opcao = -1;
        int opcIdPosto = -1;

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

                    System.out.println("Selecione os postos para cadastrar nesta rota digitando o seu id: \nPara sair digite 0");
                    postoService.listarPosto();

                    do {
                        System.out.println("Digite o id: ");
                        opcIdPosto = scanner.nextInt();
                        scanner.nextLine();

                        if(opcIdPosto != 0){

                            rota.setListaPostoCadastrado(postoService.buscarPostoId(opcIdPosto));
                        }

                    } while (opcIdPosto != 0);

                    rotaService.adicionaRota(rota);
                    rotaService.adicionaRota_X_Posto(rota);
                    break;
                }

                case 2: { // listando
                    rotaService.listarRotas();
                    break;
                }

                case 3: { // editando
                    Rota rota = new Rota("Nova descrição", "Cidreira", "Osorio"); //APENAS TESTANDO
                    rotaService.editarRota(1, rota);
                    break;
                }
                case 4: { // excluindo
                    rotaService.removerRota(2);
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
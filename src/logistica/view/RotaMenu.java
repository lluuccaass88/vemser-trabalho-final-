package src.logistica.view;

import src.logistica.model.Rota;
import src.logistica.service.PostoService;
import src.logistica.service.RotaService;

import java.util.Scanner;

public class RotaMenu {

    RotaService rotaService = new RotaService();
    PostoService postoService = new PostoService();
    Rota rota = new Rota();

    public void menuRota() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        int opcIdPosto = -1;
        while (opcao != 0) {
            System.out.println("""
                    ===============Menu Rotas===============
                    Cadastrar Rota:             [1]
                    Listar Rota:                [2]
                    Editar Rota:                [3]
                    Excluir Rota:               [4]
                    Retornar ao Menu Principal: [0]
                    Digite sua opção:\s""");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: { // adicionando - podemos fazer em outra classe para nao poluir tanto o MAIN
                    Rota rota = new Rota();
                    System.out.println("Digite a descrição da rota");
                    rota.setDescricao(sc.nextLine());

                    System.out.println("Digite o local de partida");
                    rota.setLocalPartida(sc.nextLine());

                    System.out.println("Digite o local de destino");
                    rota.setLocalDestino(sc.nextLine());

                    System.out.println("Selecione os postos para cadastrar nesta rota digitando o seu id: \nPara sair digite 0");
                    postoService.listarPosto();

                    do {
                        System.out.println("Digite o id: ");
                        opcIdPosto = sc.nextInt();
                        sc.nextLine();

                        if (opcIdPosto != 0) {

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
                case 0: {
                    System.out.println("Retornando ao Menu Principal");
                    break;
                }
                default: {
                    System.err.println("Opção inválida");
                    break;
                }
            }
        }
        sc.close();
    }
}
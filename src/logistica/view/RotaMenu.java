package src.logistica.view;

import src.logistica.model.Rota;
import src.logistica.service.PostoService;
import src.logistica.service.RotaService;

import java.util.InputMismatchException;
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
                case 1: { // cadastrando
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
                    rotaService.adicionaRotaXPosto(rota);
                    break;
                }

                case 2: { // listando
                    rotaService.listarRotas();
                    break;
                }

                case 3: { // editando
                    System.out.println("Digite o id da rota para editar: ");
                    int id = sc.nextInt();

                    System.out.println("Editar descrição:  ");
                    rota.setDescricao(sc.nextLine());

                    System.out.println("Editar local de partida: ");
                    rota.setLocalPartida(sc.nextLine());

                    System.out.println("Editar local de destino: ");
                    rota.setLocalDestino(sc.nextLine());

                    rotaService.editarRota(id, rota);

                    System.out.println("Rota editada com sucesso!");

                }
                case 4: { // excluindo
                    System.out.println("Digite o id da rota que deseja excluir: ");
                    boolean validacao = false;
                    while (!validacao) {
                        try {
                            int id = sc.nextInt();
                            sc.nextLine();
                            rotaService.removerRota(id);
                            validacao = true;
                        } catch (InputMismatchException ex) {
                            System.err.println("Número inválido");
                        }
                    }
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
    }
}
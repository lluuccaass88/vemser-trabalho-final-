package src.logistica.view;

<<<<<<< HEAD
import src.logistica.model.Perfil;
import src.logistica.model.Usuario;
import src.logistica.model.Viagem;
import src.logistica.service.CaminhaoService;
import src.logistica.service.RotaService;
import src.logistica.service.UsuarioService;
=======
import src.logistica.model.Viagem;
>>>>>>> 156e5935adddd445cd8589c8eef6d7adbc5438e8
import src.logistica.service.ViagemService;

import java.util.Scanner;

public class ViagemMenu {
    ViagemService viagemService = new ViagemService();
<<<<<<< HEAD
    RotaService rotaService = new RotaService();
    CaminhaoService caminhaoService = new CaminhaoService();
    Viagem viagem = new Viagem();
    private int id;

    public void menuUsuario(Usuario usuario) {
=======
    Viagem viagem = new Viagem();

    public void menuViagem() {
>>>>>>> 156e5935adddd445cd8589c8eef6d7adbc5438e8
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
<<<<<<< HEAD
                    ==========Menu Usuário==========
                    Cadastrar Viagem :          [1]
                    Listar Usuário:             [2]
                    Editar Usuário:             [3]
                    Excluir Usuário :           [4]
=======
                    ==========Menu Viagem==========
                    Cadastrar Viagem :          [1]
                    Listar Viagens:             [2]
                    Editar Viagem:              [3]
                    Excluir Viagem :            [4]
>>>>>>> 156e5935adddd445cd8589c8eef6d7adbc5438e8
                    Retornar ao Menu Principal: [0]
                    Digite sua opção:\s""");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Listando Caminhões Livres para Viagem..");
<<<<<<< HEAD
                    caminhaoService.listarCaminhoesLivres();
                    id = sc.nextInt();
                    sc.nextLine();
                    viagem.setCaminhao(caminhaoService.retornaPorId(id));
=======
                    viagemService.adicionar;
>>>>>>> 156e5935adddd445cd8589c8eef6d7adbc5438e8

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

                }
                case 4 -> {

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

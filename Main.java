import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void opcoesMotorista(ManipulaMotorista manipulaMotorista){
        String nome, cpf, cnh;
        int idade, opcMotorista, idMotorista;
        double salario;

        Scanner leitorUsuario = new Scanner(System.in);


        System.out.println("===============Opções Motorista===============\n" +
                "Cadastrar Motorista: [1]\n" +
                "Ver Motoristas:      [2]\n" +
                "Editar Motorista:    [3]\n" +
                "Excluir Motorista:   [4]\n" +
                "Digite sua opção: ");

        opcMotorista = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        switch (opcMotorista){
            case 1:
                System.out.println("============== Cadastro de motorista ==============");
                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ncpf: ");
                cpf = leitorUsuario.nextLine();
                System.out.println("\nCNH: ");
                cnh = leitorUsuario.nextLine();
                System.out.println("\nIdade: ");
                idade = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                System.out.println("\nSalario: ");
                salario = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Motorista motorista = new Motorista(nome, cpf, salario, idade, cnh);
                manipulaMotorista.adicionaMotorista(motorista);
                break;
            case 2:
                manipulaMotorista.listarMotoristas();
                break;
            case 3:
                System.out.println("Digite o id do motorista que deseja editar: ");
                idMotorista = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ncpf: ");
                cpf = leitorUsuario.nextLine();
                System.out.println("\nCNH: ");
                cnh = leitorUsuario.nextLine();
                System.out.println("\nIdade: ");
                idade = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                System.out.println("\nSalario: ");
                salario = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Motorista motoristaEditado = new Motorista(nome, cpf, salario, idade, cnh);

                manipulaMotorista.editarMotorista(idMotorista, motoristaEditado);
                break;
            case 4:
                System.out.println("Digite o id do motorista que deseja excluir");
                idMotorista = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaMotorista.removerMotoristaPorIndice(idMotorista);
        }
    }

    public static void opcoesCaminhao(ManipulaCaminhao manipulaCaminhao) {
        Scanner leitorUsuario = new Scanner(System.in);
        int opcCaminhao, gasolina, idCaminhao;
        String placa, modelo, marca;
        double capacidade, kmRodados;

        System.out.println("===============Opções Caminhões===============\n" +
                "Cadastrar Caminhão: [1]\n" +
                "Ver Caminhão:      [2]\n" +
                "Editar Caminhão:    [3]\n" +
                "Excluir Caminhão:   [4]\n" +
                "Digite sua opção: ");

        opcCaminhao = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        switch (opcCaminhao) {
            case 1:
                System.out.println("============== Cadastro de caminhão ==============");
                System.out.println("\nPlaca: ");
                placa = leitorUsuario.nextLine();
                System.out.println("\nModelo: ");
                modelo = leitorUsuario.nextLine();
                System.out.println("\nMarca: ");
                marca = leitorUsuario.nextLine();
                System.out.println("\nCapacidade: ");
                capacidade = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();
                System.out.println("\nQuilometros Rodados: ");
                kmRodados = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();
                System.out.println("\nQuantidade de gasolina: ");
                gasolina = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                Caminhao caminhao = new Caminhao(placa, modelo, marca, capacidade, kmRodados, gasolina);
                manipulaCaminhao.adicionaCaminhao(caminhao);

                break;
            case 2:
                manipulaCaminhao.listarCaminhao();
                break;
            case 3:
                System.out.println("Digite o id do caminhão que deseja editar: ");
                idCaminhao = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("\nPlaca: ");
                placa = leitorUsuario.nextLine();
                System.out.println("\nModelo: ");
                modelo = leitorUsuario.nextLine();
                System.out.println("\nMarca: ");
                marca = leitorUsuario.nextLine();
                System.out.println("\nCapacidade: ");
                capacidade = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();
                System.out.println("\nQuilometros Rodados: ");
                kmRodados = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();
                System.out.println("\nQuantidade de gasolina: ");
                gasolina = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                Caminhao caminhaoEditado = new Caminhao(placa, modelo, marca, capacidade, kmRodados, gasolina);

                manipulaCaminhao.editarCaminhao(idCaminhao, caminhaoEditado);

                break;
            case 4:
                System.out.println("Digite o id do motorista que deseja excluir");
                idCaminhao = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaCaminhao.removerCaminhaoroPorIndice(idCaminhao);
        }
    }

    public static void opcoesPosto(ManipulaPosto manipulaPosto) {
        Scanner leitorUsuario = new Scanner(System.in);
        int idPosto, opcPosto;
        String nome;
        double valorCombustível;


        System.out.println("===============Opções Posto===============\n" +
                "Cadastrar Posto: [1]\n" +
                "Ver Postos:      [2]\n" +
                "Editar Posto:    [3]\n" +
                "Excluir Posto:   [4]\n" +
                "Digite sua opção: ");

        opcPosto = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        switch (opcPosto) {
            case 1:
                System.out.println("============== Cadastro de caminhão ==============");
                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\nValor do Combustivel: ");
                valorCombustível = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Posto posto = new Posto(nome, valorCombustível);
                manipulaPosto.adicionaPosto(posto);

                break;
            case 2:
                manipulaPosto.listarPostosCredenciados();
                break;
            case 3:
                System.out.println("Digite o id do posto de gasolina que deseja editar: ");
                idPosto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\nValor do Combustivel: ");
                valorCombustível = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Posto postoEditado = new Posto(nome, valorCombustível);

                manipulaPosto.editarPosto(idPosto, postoEditado);

                break;
            case 4:
                System.out.println("Digite o id do posto de gasolina que deseja excluir");
                idPosto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaPosto.removerPostoPorIndice(idPosto);
                break;
        }
    }

    public static void opcoesRota(ManipulaRotas manipulaRotas) {
        Scanner leitorUsuario = new Scanner(System.in);
        int idPRota, opcRota;
        String nome,descricao, localPartida, destino;


        System.out.println("===============Opções Rotas===============\n" +
                "Cadastrar Rotas: [1]\n" +
                "Ver Rotas:      [2]\n" +
                "Editar Rota:    [3]\n" +
                "Excluir Rota:   [4]\n" +
                "Digite sua opção: ");

        opcRota = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        switch (opcRota) {
            case 1:
                System.out.println("============== Cadastro de Rota ==============");

                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ndescricao: ");
                descricao = leitorUsuario.nextLine();
                System.out.println("\nLocal Partida: ");
                localPartida = leitorUsuario.nextLine();
                System.out.println("\nDestino: ");
                destino = leitorUsuario.nextLine();;

                Rota rota = new Rota(nome,descricao, localPartida, destino);
                manipulaRotas.adicionaRota(rota);
                break;
            case 2:
                manipulaRotas.listarRotas();
                break;
            case 3:
                System.out.println("Digite o id da rota que deseja editar: ");
                idPRota = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ndescricao: ");
                descricao = leitorUsuario.nextLine();
                System.out.println("\nLocal Partida: ");
                localPartida = leitorUsuario.nextLine();
                System.out.println("\nDestino: ");
                destino = leitorUsuario.nextLine();;

                Rota rotaEditada = new Rota(nome,descricao, localPartida, destino);
                manipulaRotas.editarRota(idPRota, rotaEditada);
                break;
            case 4:
                System.out.println("Digite o id da rota que deseja excluir");
                idPRota = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaRotas.removerRotaPorIndice(idPRota);
                break;
        }
    }

    public static void opcoesViagem(ManipulaViagem manipulaViagem, ManipulaMotorista manipulaMotorista, ManipulaCaminhao manipulaCaminhao, ManipulaRotas manipulaRota, ManipulaPosto manipulaPosto) {
        Scanner leitorUsuario = new Scanner(System.in);
        int idViagem, opcViagem, idObjeto, quantidadeGasolina;
        Caminhao caminhao;
        Motorista motorista;
        Rota rota;

        System.out.println("===============Opções Viagens===============\n" +
                "Cadastrar Viagem: [1]\n" +
                "Ver Viagens:      [2]\n" +
                "Editar Viagem:    [3]\n" +
                "Excluir Viagem:   [4]\n" +
                "Abastecer:        [5]\n" +
                "Finalizar viagem: [6]\n" +
                "Finalizar viagem: [7]\n" +
                "Digite sua opção: ");

        opcViagem = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        switch (opcViagem) {
            case 1:
                System.out.println("============== Cadastro de Viagem ==============");



                System.out.println("\nDigite o id do caminhão disponivel: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaCaminhao.listarCaminhaoDisponivel();
                }else {
                    System.out.println("Não temos caminhões disponiveis no momento!");
                    break;
                }
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                caminhao = manipulaCaminhao.buscaCaminhaoPorId(idObjeto);


                System.out.println("\nDigite o id do motorista disponivel: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaMotorista.listarMotoristaDisponiveis();
                }else {
                    System.out.println("Não temos motoristas disponiveis no momento!");
                    break;
                }
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                motorista = manipulaMotorista.buscaMotoristaPorId(idObjeto);


                System.out.println("\nDigite o id da rota: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaRota.listarRotas();
                }else {
                    System.out.println("Não temos rotas cadastradas!");
                    break;
                }
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                rota = manipulaRota.buscaRotaoPorId(idObjeto);

                Viagem viagem = new Viagem(caminhao, motorista, rota, manipulaPosto.retornaPosto());
                caminhao.setEmViagem(true);
                motorista.setEmViagem(true);
                manipulaViagem.adicionaViagem(viagem);

            case 2:
                manipulaViagem.listarViagens();
                break;
            case 3:

                System.out.println("=========== Editar Viagem ===========");

                System.out.println("Digite o id da viagem que deseja editar (apenas viagens em andamento): ");
                manipulaViagem.listarViagensEmAndamento();
                idViagem = leitorUsuario.nextInt(); //Tem que verificar se a viagem é uma que esta em andamento, se sim ai continua a execuão, se não ele não continua.
                leitorUsuario.nextLine();

                System.out.println("\nDigite o id do caminhão disponivel: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaCaminhao.listarCaminhaoDisponivel();
                }else {
                    System.out.println("Não temos caminhões disponiveis no momento!");
                }
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                caminhao = manipulaCaminhao.buscaCaminhaoPorId(idObjeto);


                System.out.println("\nDigite o id do motorista disponivel: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaMotorista.listarMotoristaDisponiveis();
                }else {
                    System.out.println("Não temos motoristas disponiveis no momento!");
                }
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                motorista = manipulaMotorista.buscaMotoristaPorId(idObjeto);


                System.out.println("\nDigite o id da rota: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaRota.listarRotas();
                }else {
                    System.out.println("Não temos rotas cadastradas!");
                }
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                rota = manipulaRota.buscaRotaoPorId(idObjeto);


                Viagem viagemEditada = new Viagem(caminhao, motorista, rota, manipulaPosto.retornaPosto());
                caminhao.setEmViagem(true);
                motorista.setEmViagem(true);

                manipulaViagem.editarViagem(idViagem, viagemEditada);
                break;
            case 4:
                System.out.println("Digite o id da viagem que deseja excluir");
                idViagem = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaViagem.removerViagemPorIndice(idViagem);
                break;
            case 5:
                System.out.println("Digite o id da viagem: ");
                manipulaPosto.listarPostosCredenciados();
                idViagem = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("Digite o id do posto que deseja abastecer: ");
                manipulaPosto.listarPostosCredenciados();
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("Digita a quantidade que deseja abastecer (1 a 100): ");
                quantidadeGasolina = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                Viagem viagemBuscada = manipulaViagem.BuscaViagensId(idViagem);
                Posto postoBuscado = manipulaPosto.buscaPostosCredenciadosID(idObjeto);

                viagemBuscada.abastecer(postoBuscado, quantidadeGasolina);
                break;
            case 6:
                System.out.println("Digite o id da viagem: ");
                manipulaPosto.listarPostosCredenciados();
                idViagem = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                Viagem viagemBuscada2 = manipulaViagem.BuscaViagensId(idViagem);
                viagemBuscada2.finalizarViagem();
                break;
            case 7:
                manipulaViagem.listarViagensRealizadas();
                break;
        }
    }

        public static void main (String[]args){
            ManipulaMotorista manipulaMotorista = new ManipulaMotorista();
            ManipulaCaminhao manipulaCaminhao = new ManipulaCaminhao();
            ManipulaPosto manipulaPosto = new ManipulaPosto();
            ManipulaRotas manipulaRota = new ManipulaRotas();
            ManipulaViagem manipulaViagem = new ManipulaViagem();


            int opc = -1;
            Scanner leitorUsuario = new Scanner(System.in);

            while (opc != 0) {
                System.out.println("========== Escolha sua opção ==========");
                System.out.println("[1] Opções de motorista");
                System.out.println("[2] Opções do caminhão");
                System.out.println("[3] Opções de Posto de gasolina");
                System.out.println("[4] Opções de rotas");

                opc = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                switch (opc) {
                    case 1:
                        opcoesMotorista(manipulaMotorista);
                        break;
                    case  2:
                        opcoesCaminhao(manipulaCaminhao);
                        break;
                    case 3:
                        opcoesPosto(manipulaPosto);
                    case 4:
                        opcoesRota(manipulaRota);
                        break;
                    case 5:
                        opcoesViagem(manipulaViagem, manipulaMotorista, manipulaCaminhao, manipulaRota, manipulaPosto);
                }

            }


        }
    }


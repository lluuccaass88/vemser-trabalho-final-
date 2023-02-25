package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Usuario;
import src.logistica.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }

    public void adicionarUsuario(Usuario usuario) {
        try {
            if (usuario.getCpf().length() != 11) {
                throw new Exception("CPF inválido");
            }
            if (usuario.getCnh().length() != 11) {
                throw new Exception("CNH inválida");
            }
            Usuario usuarioAdicionado = usuarioRepository.adicionar(usuario);
            System.out.println("Usuário adicionado com sucesso: " + usuarioAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
    }

    public void listarUsuarios() {
        try {
            usuarioRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editarUsuarios(Integer id, Usuario usuario){
        try {
            boolean conseguiuEditar = usuarioRepository.editar(id, usuario);
            if (conseguiuEditar) {
                System.out.println("Usuário " + conseguiuEditar + "| com id= "
                        + id + " editado com sucesso");
            } else {
                System.out.println("Não foi possível editar o " + id + " do usuário");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void removerUsuarios(Integer id){
        try {
            boolean conseguiuRemover = usuarioRepository.remover(id);
            if (conseguiuRemover) {
                System.out.println("Usuário " + conseguiuRemover + "| com id= "
                        + id + " removido com sucesso");
            } else {
                System.out.println("Não foi possível remover o " + id + " do usuário");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
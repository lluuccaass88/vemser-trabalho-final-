package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.exception.RegraDeNegocioException;
import src.logistica.model.Usuario;
import src.logistica.repository.UsuarioRepository;

import java.util.HashMap;
import java.util.Map;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }

    public void adicionarUsuario(Usuario usuario) {
        try {
            if (usuario.getCpf().length() != 11) {
                throw new RegraDeNegocioException("CPF inválido, deve conter 11 digitos");
            }
            if (usuario.getCnh().length() != 11) {
                throw new RegraDeNegocioException("CNH inválida, deve conter 11 digitos");
            }
            Usuario usuarioAdicionado = usuarioRepository.adicionar(usuario);
//              System.out.println("Usuário adicionado com sucesso: " + usuarioAdicionado);
                System.out.println("Dados do usuario adicionado: " + usuarioAdicionado);

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

    public Usuario loginUsuario(String usurario, String senha){
        Usuario usuarioLogado = new Usuario();
        try {
            usuarioLogado = usuarioRepository.login(usurario, senha);
            if(usuarioLogado.getId() == null){
                throw new Exception("Erro ao fazer o login, verifique seu usuario ou senha");
            }else{
                System.out.println("Entrando...");
                return usuarioLogado;
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO LOGIN -> " + e.getMessage());
        }
        return usuarioLogado;
    }

    public void editarUsuarios(Integer id, Usuario usuario){
        try {
            boolean conseguiuEditar = usuarioRepository.editar(id, usuario);
            if (conseguiuEditar) {
                System.out.println("Edição de usuario: " + conseguiuEditar + "| Usuario com o id "
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
                System.out.println("Usuário removido: " + conseguiuRemover + "| Usuario com id= "
                        + id + " removido com sucesso");
            } else {
                System.out.println("Não foi possível remover o " + id + " do usuário");
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

}


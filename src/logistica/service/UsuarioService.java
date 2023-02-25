package src.logistica.service;

import src.logistica.exception.BancoDeDadosException;
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
            System.out.println("ERRO SQL-> " + e.getMessage());
        }
        return usuarioLogado;
    }
}
